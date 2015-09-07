package com.hotel.service.base;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.base.UserMapper;
import com.hotel.model.base.User;

@Service
public class LoginService {


	@Autowired UserMapper userMapper;
	
	public User loadUserByNameAndPwd(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.loadUserByNameAndPwd(map);
	}

}
