package com.sanyuan.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sanyuan.pojo.Result;
import com.sanyuan.pojo.SanyuanUser;
import com.sanyuan.pojo.YiyuanUser;
import com.sanyuan.service.UserService;
import com.sanyuan.utils.CookieUtils;
import com.sanyuan.utils.CreateCodeUtils;
import com.sanyuan.utils.CreateIdUtils;
import com.sanyuan.utils.GlobalConst;
import com.sanyuan.utils.IdCardUtils;
import com.sanyuan.utils.JsonUtils;
import com.sanyuan.utils.RedisUtils;
import com.sanyuan.utils.SendCodeUtils;


@RestController
public class UserController {

	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private UserService  userService;
	
	
//	@RequestMapping("/login")
//	public ModelAndView login(String phone,String sendCode,HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView view = new ModelAndView("redirect:/sellCar");
//		//通过手机号码查找用户
//		SanyuanUser user = userService.login(phone);
//		if(user!=null) {
//			//用户存在
//			//查询缓存是否登陆
//			String code = redisUtils.get(phone);
//			if(sendCode!=null&&!"".equals(sendCode)&&!"null".equals(sendCode)&&sendCode.equals(code)) {
//				//未登录
//				user.setUserId(null);
//				//写入缓存
//				saveUser(request, response, JsonUtils.objectToJson(user));
//			}else
//				view.addObject("result", 1);
//		}else
//			view.addObject("result", 0);
//		return view;
//	}
	

	@RequestMapping("/toLogin")
	public ModelAndView toLogin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView view = new ModelAndView("redirect:http://192.168.1.188:84/toLogin");
		return view;
	}
	
	
//	@RequestMapping("/toLogin")
//	public ModelAndView toLogin(HttpServletRequest request) {
//		ModelAndView view = new ModelAndView("login");
//		if(redisUtils.get(CookieUtils.getCookieValue(request, GlobalConst.SY_COOKIE_NAME))!=null) {
//			view.setViewName("index");
//			return view;
//		};
//		
//		return view;
//	}
	@RequestMapping("/sendCode")
	public void sendCode(String phone) {
		String code = CreateCodeUtils.createCode();
		SendCodeUtils.sendSms(phone, code);
		redisUtils.set(phone, code,3*60);
	}
	
	@RequestMapping("/sendLCode")
	public void sendLCode(String phone) {
		String code = CreateCodeUtils.createCode();
		SendCodeUtils.forgetSendCode(phone, code);
		redisUtils.set(phone, code,3*60);
	}
	
	@RequestMapping("/verfiyCode")
	public Result verfiyCode(String code,String phone) {
		String sendCode = redisUtils.get(phone);
		if(sendCode!=null&&!"".equals(sendCode)&&!"null".equals(sendCode)&&sendCode.equals(code))
			return Result.ok();
		else
			return new Result(500,"",null);
	}
	
	@RequestMapping("/verfiyIdCard")
	public Result verfiyIdCard(String name,String idCard,HttpServletRequest request,HttpServletResponse response) {
		return JsonUtils.jsonToPojo(IdCardUtils.verfiyIdCard(name, idCard), Result.class);
	}
	
	private void saveUser(HttpServletRequest request,HttpServletResponse response,String userInfo) {
		String uuid = UUID.randomUUID().toString();
		CookieUtils.setCookie(request, response, GlobalConst.SY_COOKIE_NAME, uuid);
		redisUtils.set(uuid, userInfo);
	}
	@RequestMapping("/register")
	public ModelAndView register(SanyuanUser user,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("redirect:/sellCar");
		YiyuanUser yuser=JsonUtils.jsonToPojo(redisUtils.get(CookieUtils.getCookieValue(request, GlobalConst.YY_COOKIE_NAME)),YiyuanUser.class);
		user.setUserNum(yuser.getUserNum());
		user.setUserId(yuser.getUserId());
		user.setStatus(1);
		int i = userService.register(user);
		if(i>0) {
			user.setUserId(null);
			//saveUser(request, response, JsonUtils.objectToJson(user));
			redisUtils.del(user.getPhone());
		}
		
		return view;
	}
	@RequestMapping("userInfo")
	public ModelAndView userInfo() {
		ModelAndView view = new ModelAndView("userInfo");
		return view;
	}
}
