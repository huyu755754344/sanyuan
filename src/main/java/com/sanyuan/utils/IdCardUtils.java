package com.sanyuan.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;



public class IdCardUtils {
	public static String HOST = "https://idcert.market.alicloudapi.com";
	public static String PATH = "/idcard";
	public static String METHOD = "GET";
	public static String APPCODE = "324b2e2a1b8d43d391989b286c3218aa";
	
	public static String verfiyIdCard(String name,String idCard) {
		Map<String, String> querys = new HashMap<String, String>();
	    querys.put("idCard", idCard);
	    querys.put("name", name);
	    Map<String, String> headers  = new HashMap<String, String>();
	    headers .put("Authorization", "APPCODE " + IdCardUtils.APPCODE);
	    try {
	    	HttpResponse response = HttpUtils.doGet(HOST, PATH, METHOD, headers , querys);
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
	    	return EntityUtils.toString(response.getEntity());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return null;
	}
	
}
