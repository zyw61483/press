package org.evr.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie cookies[] = request.getCookies();
		if (cookies == null || name == null || name.length() == 0) {
		  return null;
		}
		for (int i = 0; i < cookies.length; i++) {
			String cookieName = cookies[i].getName();
		  if (name.equals(cookieName)){
		    return cookies[i];
		  }
		}
		return null;
	}
	  
	public static void deleteCookie(HttpServletResponse response, Cookie cookie) {
		if (cookie != null) {
			//cookie.setPath("/");
			cookie.setValue("");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
	  
	public static String getName(HttpServletRequest request, String c_info){
		String returnStr = "";
		Cookie cookie = getCookie(request, c_info);
		if(null!=cookie){
			String strMi = cookie.getValue();
			//String strCookie = DESCoding_CTP.Decoding(strMi,"CCOSD");
			try {
				strMi = URLDecoder.decode(strMi, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			strMi = strMi.replace(" ", "");
			String [] info = strMi.split("&&");
			if(info.length>0){
				returnStr = info[0];
			}
		}
		return returnStr;
	}
	
	public static String getRealname(HttpServletRequest request, String c_info){
		String returnStr = "";
		Cookie cookie = getCookie(request, c_info);
		if(null!=cookie){
			String strMi = cookie.getValue();
			//String strCookie = DESCoding_CTP.Decoding(strMi,"CCOSD");
			try {
				strMi = URLDecoder.decode(strMi, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			strMi = strMi.replace(" ", "");
			String [] info = strMi.split("&&");
			if(info.length>1){
				if(!info[1].equals("-"))
					returnStr = info[1];
			}
		}
		return returnStr;
	}
	
	public static String getType(HttpServletRequest request, String c_info){
		String returnStr = "";
		Cookie cookie = getCookie(request, c_info);
		if(null!=cookie){
			String strMi = cookie.getValue();
			//String strCookie = DESCoding_CTP.Decoding(strMi,"CCOSD");
			try {
				strMi = URLDecoder.decode(strMi, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			strMi = strMi.replace(" ", "");
			String [] info = strMi.split("&&");
			if(info.length>2){
				if(!info[2].equals("-"))
					returnStr = info[2];
			}
		}
		return returnStr;
	}
	
	public static String getProvince(HttpServletRequest request, String c_info){
		String returnStr = "";
		Cookie cookie = getCookie(request, c_info);
		if(null!=cookie){
			String strMi = cookie.getValue();
			//String strCookie = DESCoding_CTP.Decoding(strMi,"CCOSD");
			try {
				strMi = URLDecoder.decode(strMi, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			strMi = strMi.replace(" ", "");
			String [] info = strMi.split("&&");
			if(info.length>3){
				if(!info[3].equals("-"))
					returnStr = info[3];
			}
		}
		return returnStr;
	}
	
	public static String getCity(HttpServletRequest request, String c_info){
		String returnStr = "";
		Cookie cookie = getCookie(request, c_info);
		if(null!=cookie){
			String strMi = cookie.getValue();
			//String strCookie = DESCoding_CTP.Decoding(strMi,"CCOSD");
			try {
				strMi = URLDecoder.decode(strMi, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			strMi = strMi.replace(" ", "");
			String [] info = strMi.split("&&");
			if(info.length>4){
				if(!info[4].equals("-"))
					returnStr = info[4];
			}
		}
		return returnStr;
	}
	
	public static String getArea(HttpServletRequest request, String c_info){
		String returnStr = "";
		Cookie cookie = getCookie(request, c_info);
		if(null!=cookie){
			String strMi = cookie.getValue();
			//String strCookie = DESCoding_CTP.Decoding(strMi,"CCOSD");
			try {
				strMi = URLDecoder.decode(strMi, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			strMi = strMi.replace(" ", "");
			String [] info = strMi.split("&&");
			if(info.length>5){
				if(!info[5].equals("-"))
					returnStr = info[5];
			}
		}
		return returnStr;
	}
}