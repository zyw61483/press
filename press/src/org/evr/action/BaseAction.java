/** BaseAction
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.evr.service.IService;
import org.evr.util.CookieUtil;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 7417353348902267651L;
	
	protected HttpServletRequest request; // request 对象
	protected HttpServletResponse response; // response 对象
	protected String pageStr = ""; // 页面分页信息显示字符串
	protected int currentPage = 1; // 当前页
	protected int pageCount = 1;
	protected int pageSize = 5; // 页面大小
	protected String sqlString = ""; // 查询语句
	protected String sortStr = ""; // 排序方式
	protected String[] dir; //用于保存上传文件的目录
	
	//1.用于AJAX使用的token；2.用于查看数据更新是否成功，0失败，1成功

	protected String random_token;
	public String getRandom_token() {
		return random_token;
	}

	public void setRandom_token(String random_token) {
		this.random_token = random_token;
	}

	public String[] getDir() {
		return dir;
	}

	public void setDir(String[] dir) {
		this.dir = dir;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public String getPageStr() {
		return pageStr;
	}
	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSqlString() {
		return sqlString;
	}
	public void setSqlString(String sqlString) {
		this.sqlString = sqlString;
	}

	public String getSortStr() {
		return sortStr;
	}
	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}
	
	/**
	 * 统一设置参数值在request中
	 * C_PAGE_INFO 分页信息
	 * C_PAGE_NO 页码
	 * C_PAGE_SIZE 页面大小
	 * C_PAGE_SQL 页面上的查询语句
	 * C_PAGE_SORT 页面上的排序方式
	 */
	protected void setRequestPageInfo() {
		request.setAttribute("C_PAGE_INFO", pageStr);
		request.setAttribute("C_PAGE_NO", currentPage);
		request.setAttribute("C_PAGE_SIZE", pageSize);
//		try {
//			sqlString = URLEncoder.encode(sqlString, "UTF-8");
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		//System.out.println("DYS DEBUG INFO:sqlString="+sqlString);
		request.setAttribute("C_PAGE_SQL", sqlString);
		request.setAttribute("C_PAGE_SORT", sortStr);		
	}
	/**
	 * 将相关数据移交至服务层
	 * @param str 主键名
	 * @param iService 服务层接口
	 */
	protected void saveParameter(String str, IService iService) {
		try{
			if ((sortStr == null) || sortStr.equals(""))
				sortStr = str;
			iService.setCurrentPage(currentPage);
			iService.setPageSize(pageSize);
			iService.setSortStr(sortStr);
			sqlString = URLDecoder.decode(sqlString , "UTF-8");
			iService.setSqlString(sqlString);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 根据验证结果来写入子页面是否需要调整大小的值
	 * @param needResize 
	 */
	protected void setRequestTokenInfo(boolean needResize){
		if(!needResize){
			if(random_token == null || random_token.equals("") || random_token.equals("null"))
				request.setAttribute("C_PAGE_TOKEN", "HasError0");
			else request.setAttribute("C_PAGE_TOKEN", "HasError1");
		}		
	}

	/**
	 * 添加错误信息
	 * 
	 * @param key
	 * @param info
	 * @return
	 */
	protected boolean addFieldErrorInfo(String key, String info) {
		addFieldError(key, info);
		return false;
	}	

	public String getThisMonth() {
		int m = Calendar.getInstance().get(Calendar.MONTH) + 1;
		if(m == 1)
			return "1月";
		if(m == 2)
			return "2月";
		if(m == 3)
			return "3月";
		if(m == 4)
			return "4月";
		if(m == 5)
			return "5月";
		if(m == 6)
			return "6月";
		if(m == 7)
			return "7月";
		if(m == 8)
			return "8月";
		if(m == 9)
			return "9月";
		if(m == 10)
			return "10月";
		if(m == 11)
			return "11月";
		if(m == 12)
			return "12月";
		return "";
	}
	
	public String getNextMonth() {
		int m = Calendar.getInstance().get(Calendar.MONTH) + 1;
		if(m == 1)
			return "2月";
		if(m == 2)
			return "3月";
		if(m == 3)
			return "4月";
		if(m == 4)
			return "5月";
		if(m == 5)
			return "6月";
		if(m == 6)
			return "7月";
		if(m == 7)
			return "8月";
		if(m == 8)
			return "9月";
		if(m == 9)
			return "10月";
		if(m == 10)
			return "11月";
		if(m == 11)
			return "12月";
		if(m == 12)
			return "1月";
		return "";
	}
	
//	public void client(Map map) {
//		Gson gson = new Gson();
//		response.setContentType("text/html;charset=utf-8");
//        response.setCharacterEncoding("UTF-8");
//        try {
//        	response.getWriter().write(request.getParameter("callback") + "(" + gson.toJson(map) + ")");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void client(Map map) {
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        try {
        	response.getWriter().write(gson.toJson(map));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***************************************************************************
	 * 注入对象，每增加一个实体服务类则增加相应的set/get方法 并注意在配置文件applicationContext.xml中添加其注入配置
	 * 添加新的Action后注意在struts.xml进行相应的配置
	 **************************************************************************/
	/**
	 * 信息对话框
	 * @return
	 */
	public String alert(){
		if(msg == null) msg = "[空]";
		else if(msg.equals("undefined")){
			if((request.getSession().getAttribute("WW_TRANS_I18N_LOCALE").toString()).equals("zh_CN")){
				msg = "系统开发中...";
			}
			if((request.getSession().getAttribute("WW_TRANS_I18N_LOCALE").toString()).equals("en_US")){
				msg = "SYSTEM IS EXPLOITING...";
			}
		}		
		try {
			msg = java.net.URLDecoder.decode(msg , "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "_alert";
	}
	/**
	 * 信息确认对话框
	 * @return
	 */
	public String confirm(){
		if(msg == null) msg = "[空]";
		else if(msg.equals("undefined")){
			if((request.getSession().getAttribute("WW_TRANS_I18N_LOCALE").toString()).equals("zh_CN")){
				msg = "undefined";
			}
			if((request.getSession().getAttribute("WW_TRANS_I18N_LOCALE").toString()).equals("en_US")){
				msg = "undefined";
			}
		}
		try {
			msg = java.net.URLDecoder.decode(msg , "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "_confirm";
	}
	
	public void setCookie(String user_info) {
		Cookie cookie = new Cookie("USER_INFO", user_info);
		cookie.setMaxAge(7*24*60*60);
		response.addCookie(cookie);
	}
	
	public String getCookieName() {
		String cookieName = CookieUtil.getName(request, "USER_INFO");
		return cookieName;
	}
	
	public String getCookieRealname() {
		String cookieRealname = CookieUtil.getRealname(request, "USER_INFO");
		return cookieRealname;
	}
	
	public String getCookieType() {
		String cookieType = CookieUtil.getType(request, "USER_INFO");
		return cookieType;
	}
	
	public String getCookieProvince() {
		String cookieProvince = CookieUtil.getProvince(request, "USER_INFO");
		return cookieProvince;
	}
	
	public String getCookieCity() {
		String cookieCity = CookieUtil.getCity(request, "USER_INFO");
		return cookieCity;
	}
	
	public String getCookieArea() {
		String cookieArea = CookieUtil.getArea(request, "USER_INFO");
		return cookieArea;
	}
	
	private String msg;
	private String okscript;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getOkscript() {
		return okscript;
	}
	public void setOkscript(String okscript) {
		this.okscript = okscript;
	}
}
