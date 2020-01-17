package com.sanyuan.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.sanyuan.mapper.SanyuanOrderMapper;
import com.sanyuan.pojo.SanyuanOrder;
import com.sanyuan.pojo.SanyuanUserExample;
import com.sanyuan.pojo.YiyuanUser;
import com.sanyuan.service.OrderService;
import com.sanyuan.utils.CookieUtils;
import com.sanyuan.utils.CreateIdUtils;
import com.sanyuan.utils.GlobalConst;
import com.sanyuan.utils.JsonUtils;
import com.sanyuan.utils.RedisUtils;

public class OrderServiceImpl implements OrderService {

	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private SanyuanOrderMapper orderMapper;
	
	@Override
	public boolean checkPay(Integer carId,Long userId) {
		
				//查询是否有相关的订单
				SanyuanOrder order =orderMapper.chackOrderByUserIdCarIdOK(userId, carId);
				if(order!=null) {
					return true;
				}
				return false;
				//1）没有或失败  -- 生成订单 发起交易
				
				//2) 有正在支付的订单 --获取订单号 发起交易
					
	}

	@Override
	public String createPay(Integer carId,Long userId) {
		SanyuanOrder order= orderMapper.findOrderByUserIdCarIdING(userId, carId);
		Long orderId = null;
		if(order!=null&&order.getStatus()==0) {
			orderId= order.getOrderId();
		}else {
			//生成新订单
			orderId = CreateIdUtils.getId();
			SanyuanOrder newOrder = new SanyuanOrder();
			
		}
		return null;
	}

}
