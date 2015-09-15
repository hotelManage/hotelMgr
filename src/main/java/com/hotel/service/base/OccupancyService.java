package com.hotel.service.base;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.base.CustomerMapper;
import com.hotel.dao.base.DeviceStateMapper;
import com.hotel.dao.base.OccupancyMapper;
import com.hotel.dao.base.RoomMapper;
import com.hotel.model.base.Occupancy;
import com.hotel.viewmodel.base.RoomVM;

@Service
public class OccupancyService {
	
	@Autowired CustomerMapper customerMapper;
	@Autowired OccupancyMapper occupancyMapper;
	@Autowired DeviceStateMapper deviceStateMapper;
	@Autowired RoomMapper roomMapper;
	
	
	
	
	public RoomVM loadRoomVMByOccpancyInfo(Integer customerId,Date queryTime){
		
		Map<String,Object> opyMap=new HashMap<String,Object>();
		opyMap.put("customerId", customerId);
		opyMap.put("queryTime", queryTime);
		
		Occupancy opy =occupancyMapper.loadOccupancyByCustomerIdAndDate(opyMap);
		
		
		
		return null;
	}
}
