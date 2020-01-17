package com.sanyuan.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sanyuan.mapper.SanyuanUserMapper;
import com.sanyuan.pojo.Result;
import com.sanyuan.pojo.SanyuanUser;
import com.sanyuan.pojo.YiyuanUser;
import com.sanyuan.utils.CookieUtils;
import com.sanyuan.utils.GlobalConst;
import com.sanyuan.utils.JsonUtils;
import com.sanyuan.utils.RedisUtils;




public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private SanyuanUserMapper userMapper;
	
	@Autowired
	private RedisUtils redisUtils;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = "/toLogin";
		String ticket = CookieUtils.getCookieValue(request, GlobalConst.YY_COOKIE_NAME);
		System.out.println(ticket);
		//cookie数据中未找到信息
		if(ticket==null||"".equals(ticket)||" ".equals(ticket)||"null".equals(ticket)) {
			if(isAjax(request, response)){
				return false;
			}else {
				response.sendRedirect(url);
				return false;
			}
		//cookie中有信息 redis中没有登录
		}else {
			 String result = redisUtils.get(ticket);
			if(result==null) {
				if(isAjax(request, response)){
					return false;
				}else {
					response.sendRedirect(url);
					return false;
				}
				//未填写信息的白号
			}else {
				
				return true;
			}
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	public boolean isAjax(HttpServletRequest request,HttpServletResponse response) throws IOException {
		if(request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
			PrintWriter out = response.getWriter();  
			out.print(JsonUtils.objectToJson(new Result(203,"未登录",null)));
			out.close();
			return true;
		}
		return false;
	}
}
