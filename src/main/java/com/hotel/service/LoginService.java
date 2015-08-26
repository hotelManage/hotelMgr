package com.hotel.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.UserMapper;
import com.hotel.model.User; 

@Service
public class LoginService {


	@Autowired UserMapper userMapper;
	
	public User loadUserByNameAndPwd(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.loadUserByNameAndPwd(map);
	}

}
