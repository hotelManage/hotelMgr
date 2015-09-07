package com.hotel.service.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.core.ListResult;
import com.hotel.dao.base.UserMapper;
import com.hotel.viewmodel.base.UserVM;

@Service
public class UserService {

	@Autowired UserMapper userMapper;
	public ListResult<UserVM> loadUserlist(Map<String, Object> map) {
		int count=userMapper.countByMap(map);
		List<UserVM> ls=userMapper.loadUserlistWithPage(map);

		ListResult<UserVM> result=new ListResult<UserVM>(count,ls);

		return result;
	}

}
