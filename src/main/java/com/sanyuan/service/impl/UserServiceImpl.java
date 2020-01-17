package com.sanyuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanyuan.mapper.SanyuanUserMapper;
import com.sanyuan.pojo.SanyuanUser;
import com.sanyuan.pojo.SanyuanUserExample;
import com.sanyuan.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SanyuanUserMapper userMapper;
	
	@Override
	public SanyuanUser login(String phone) {
		SanyuanUserExample example = new SanyuanUserExample();
		example.or().andPhoneEqualTo(phone).andStatusEqualTo(1);
		List<SanyuanUser> list = userMapper.selectByExample(example);
		if(list.size()>0&&list!=null)
			return list.get(0);
		return null;
	}

	@Override
	public int register(SanyuanUser user) {
		
		return userMapper.updateByPrimaryKey(user);
	}

}
