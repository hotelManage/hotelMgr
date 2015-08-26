package com.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.core.ListResult;
import com.hotel.dao.CustomerMapper; 
import com.hotel.dao.DeviceStateMapper;
import com.hotel.dao.OccupancyMapper;
import com.hotel.model.Customer;
import com.hotel.viewmodel.OccupancyVM; 
import com.hotel.viewmodel.OperationVM;

@Service
public class CustomerService {

	@Autowired CustomerMapper customerMapper;
	@Autowired OccupancyMapper occupancyMapper;
	@Autowired DeviceStateMapper deviceStateMapper;
	
	public ListResult<Customer> loadCustomerList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count=customerMapper.countByMap(map);
		List<Customer> ls = customerMapper.loadCustomerList(map);
		ListResult<Customer> result=new ListResult<Customer>(count,ls);
		return result; 
	}

	public ListResult<OccupancyVM> loadOccupancyVMList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count=occupancyMapper.countByMap(map);
		List<OccupancyVM> ls = occupancyMapper.loadOccupancyVMList(map);
		ListResult<OccupancyVM> result=new ListResult<OccupancyVM>(count,ls);
		return result; 
	}

	public ListResult<OperationVM> loadOperationVMList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count=deviceStateMapper.countByMap(map);
		List<OperationVM> ls = deviceStateMapper.loadOperationVMList(map);
		ListResult<OperationVM> result=new ListResult<OperationVM>(count,ls);
		return result; 
	}

}
