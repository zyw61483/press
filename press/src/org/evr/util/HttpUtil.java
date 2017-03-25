package org.evr.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class HttpUtil {
	
	public static void main(String[] args) throws Exception {
		String string = get("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=15312309658");
//		System.out.println(string);
//		string = string.substring(string.indexOf("province")+10);
//		System.out.println(string);
//		System.out.println(string.indexOf("\ncatName"));
//		string = string.substring(0,string.indexOf("catName")-8);
//		System.out.println(string);
		JSONObject json = new JSONObject(string.substring(string.indexOf("{")));
		String province = (String) json.get("province");
		String phoneNum = (String) json.get("telString");
		System.out.println(province);
	}

	public static String get(String url) {
		CloseableHttpResponse response1 = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(1000).build();
			HttpGet httpget1 = new HttpGet(url);
			httpget1.setConfig(requestConfig);
			response1 = httpclient.execute(httpget1);
			HttpEntity entity = response1.getEntity();
			return EntityUtils.toString(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				response1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String[] threadPost(List<Map<String, Object>> reqList) {
		System.out.println("post共执行" + reqList.size() + "个请求");
		String[] results = new String[reqList.size()];
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		// 设置线程数最大100,如果超过100为请求个数
		cm.setMaxTotal(reqList.size() > 100 ? reqList.size() : 100);
		CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(cm).build();
		try {
			PostThread[] postThreads = new PostThread[reqList.size()];
			for (int i = 0; i < reqList.size(); i++) {
				Map<String, Object> req = reqList.get(i);
				HttpPost post = new HttpPost((String) req.get("url"));
				postThreads[i] = new PostThread(httpclient, post, (Map<String, Object>) req.get("params"),
						(String) req.get("encode"), i + 1);
			}
			// 执行线程
			for (PostThread pt : postThreads) {
				pt.start();
			}
			// 设置所有线程执行完毕之后再执行后续代码
			for (PostThread pt : postThreads) {
				pt.join();
			}
			for (int i = 0; i < reqList.size(); i++) {
				results[i] = postThreads[i].call();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(reqList.size() + "个线程的结果为:" + results.length + "个，明细:::" + results);
		return results;
	}

	public static String[] threadGet(List<Map<String, Object>> reqList) {
		System.out.println("get共执行" + reqList.size() + "个请求");
		String[] results = new String[reqList.size()];
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		// 设置线程数最大100,如果超过100为请求个数
		cm.setMaxTotal(reqList.size() > 100 ? reqList.size() : 100);
		CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(cm).build();
		try {
			GetThread[] getThreads = new GetThread[reqList.size()];
			for (int i = 0; i < reqList.size(); i++) {
				Map<String, Object> req = reqList.get(i);
				HttpGet get = new HttpGet((String) req.get("url"));
				getThreads[i] = new GetThread(httpclient, get, i + 1);
			}
			// 执行线程
			for (GetThread gt : getThreads) {
				gt.start();
			}
			// 设置所有线程执行完毕之后再执行后续代码
			for (GetThread gt : getThreads) {
				gt.join();
			}
			for (int i = 0; i < reqList.size(); i++) {
				results[i] = getThreads[i].call();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return results;
	}

	/**
	 * 实现Callable回调接口
	 */
	static class PostThread extends Thread implements Callable<String> {

		private final CloseableHttpClient httpClient;
		private final HttpContext context;
		private final HttpPost httppost;
		private final int id;
		private String result = null;

		public PostThread(CloseableHttpClient httpClient, HttpPost httppost, Map<String, Object> params, String encode,
				int id) throws UnsupportedEncodingException {
			// 设置超时时间
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(60000)
					.setConnectTimeout(60000).setSocketTimeout(60000).build();
			httppost.setConfig(requestConfig);
			List<NameValuePair> pairs = null;
			if (params != null && !params.isEmpty()) {
				pairs = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, Object> entry : params.entrySet()) {
					Object value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value.toString()));
					}
				}
			}
			if (pairs != null && pairs.size() > 0) {
				encode = encode == null ? "UTF-8" : encode;
				httppost.setEntity(new UrlEncodedFormEntity(pairs, encode));
			}
			this.httpClient = httpClient;
			this.context = new BasicHttpContext();
			this.httppost = httppost;
			this.id = id;
		}

		@Override
		public void run() {
			try {
				CloseableHttpResponse response = httpClient.execute(httppost, context);
				try {
					// get the response body as an array of bytes
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						result = EntityUtils.toString(entity);
						System.out.println(id + "：：：执行结果：：：" + result);
					}
				} finally {
					response.close();
				}
			} catch (Exception e) {
			}
		}

		public String call() throws Exception {
			return result;
		}
	}

	/**
	 * A thread that performs a GET.
	 */
	static class GetThread extends Thread implements Callable<String> {

		private final CloseableHttpClient httpClient;
		private final HttpContext context;
		private final HttpGet httpget;
		private final int id;
		private String result = null;

		public GetThread(CloseableHttpClient httpClient, HttpGet httpget, int id) {
			this.httpClient = httpClient;
			this.context = new BasicHttpContext();
			this.httpget = httpget;
			this.id = id;
		}

		/**
		 * Executes the GetMethod and prints some status information.
		 */
		@Override
		public void run() {
			try {
				System.out.println(id + " - about to get something from " + httpget.getURI());
				CloseableHttpResponse response = httpClient.execute(httpget, context);
				try {
					System.out.println(id + " - get executed");
					// get the response body as an array of bytes
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						result = EntityUtils.toString(entity);
					}
				} finally {
					response.close();
				}
			} catch (Exception e) {
				System.out.println(id + " - error: " + e);
			}
		}

		public String call() throws Exception {
			return result;
		}
	}

}
