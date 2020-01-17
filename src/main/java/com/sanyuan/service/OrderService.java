package com.sanyuan.service;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {
	boolean checkPay(Integer carId,Long userId);
	String createPay(Integer carId,Long userId);
}
