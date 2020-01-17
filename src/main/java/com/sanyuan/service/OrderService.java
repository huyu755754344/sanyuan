package com.sanyuan.service;



public interface OrderService {
	boolean checkPay(Integer carId,Integer userNum);
	String createPay(Integer carId,Integer userNum);
}
