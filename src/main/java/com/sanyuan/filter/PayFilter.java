package com.sanyuan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import javax.swing.text.GapContent;

import org.springframework.beans.factory.annotation.Autowired;

import com.sanyuan.pojo.YiyuanUser;
import com.sanyuan.service.OrderService;
import com.sanyuan.utils.CookieUtils;
import com.sanyuan.utils.GlobalConst;
import com.sanyuan.utils.JsonUtils;
import com.sanyuan.utils.RedisUtils;
public class PayFilter implements Filter {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RedisUtils redisUtils;
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;
		//获取查看的汽车id
		Integer carId = Integer.parseInt(request.getParameter("carId"));
		//获取 当前登陆的用户id
		Long userId = JsonUtils.jsonToPojo(redisUtils.get(CookieUtils.getCookieValue(request, GlobalConst.YY_COOKIE_NAME)),YiyuanUser.class).getUserId();
		//已支付 放行
		if(orderService.checkPay(carId,userId)) {
			chain.doFilter(request, response);
		}else {
			//发起交易 生成付款链接
			String url = orderService.createPay(carId, userId);
			response.setHeader("payUrl", url);
			
		}
		
		
	}

}
