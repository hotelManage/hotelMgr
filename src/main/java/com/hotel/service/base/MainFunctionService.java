package com.hotel.service.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.core.ListResult;
import com.hotel.dao.base.MainFunctionMapper;
import com.hotel.model.base.MainFunction;
import com.hotel.viewmodel.base.MainFunctionVM;

@Service
public class MainFunctionService {
	@Autowired MainFunctionMapper mainFunctionMapper;

	public ListResult<MainFunctionVM> loadFunctionList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count=mainFunctionMapper.countByMap(map);
		List<MainFunctionVM> ls = mainFunctionMapper.loadFunctionList(map);
		ListResult<MainFunctionVM> result=new ListResult<MainFunctionVM>(count,ls);
		return result; 
	}

	public void updateFunction(MainFunction function) {
		// TODO Auto-generated method stub
		mainFunctionMapper.updateByPrimaryKeySelective(function);
	}

	public void insertFuncton(MainFunction function) {
		// TODO Auto-generated method stub
		mainFunctionMapper.insert(function);
	}

	public void deleteFunction(Integer id) {
		// TODO Auto-generated method stub
		mainFunctionMapper.deleteByPrimaryKey(id);
	}

}
