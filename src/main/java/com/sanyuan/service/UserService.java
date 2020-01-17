package com.sanyuan.service;

import com.sanyuan.pojo.SanyuanUser;

public interface UserService {

	public SanyuanUser login(String phone);
	
	public int register(SanyuanUser user);
	
}
