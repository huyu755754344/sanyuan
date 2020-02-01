package com.sanyuan.service.impl;

import java.math.BigDecimal;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sanyuan.mapper.SanyuanOrderMapper;
import com.sanyuan.pojo.SanyuanOrder;

import com.sanyuan.service.OrderService;
import com.sanyuan.service.WXPayService;

import com.sanyuan.utils.CreateIdUtils;
import com.sanyuan.utils.GlobalConst;

import com.sanyuan.utils.RedisUtils;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private SanyuanOrderMapper orderMapper;
	
	@Override
	public boolean checkPay(Integer carId,Integer userNum) {
		
				//查询是否有相关的订单
				SanyuanOrder order =orderMapper.chackOrderByUserIdCarIdOK(userNum, carId);
				if(order!=null) {
					return true;
				}
				return false;
				
					
	}

	@Override
	public String createPay(Integer carId,Integer userNum) {
		
		SanyuanOrder order= orderMapper.findOrderByUserIdCarIdING(userNum, carId);
		Long orderId = null;
		if(order!=null&&order.getStatus()==1) {
			orderId= order.getOrderId();
			System.out.println("已存在订单"+orderId);
		}else {
			//生成新订单
			orderId = CreateIdUtils.getId();
			order = new SanyuanOrder();
			order.setOrderId(orderId);
			order.setAmount(new BigDecimal(3.0));
			order.setCarId(carId);
			order.setUserNum(userNum);
			order.setProid(1);
			Byte a = 1;
			order.setStatus(a);
			orderMapper.insert(order);
		}	
		try {
			order = orderMapper.selectByPrimaryKey(orderId);
			System.out.println("订单信息"+order);
			WXPayService x = WXPayService.getInstance(GlobalConst.CERTPATH, GlobalConst.NOTIFYURL);
			String url = x.doUnifiedOrder(order.getOrderId().toString(), "服务", order.getAmount().doubleValue(), order.getProid().toString(),"sanyuan");
			return url;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
