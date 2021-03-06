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
public class RoomService {
	
	
	@Autowired CustomerMapper customerMapper;
	@Autowired OccupancyMapper occupancyMapper;
	@Autowired DeviceStateMapper deviceStateMapper;
	@Autowired RoomMapper roomMapper;
	
	/**
	 * 根据客户id和入住时间获取一个房间信息
	 * @param customerId
	 * @param begin
	 * @param end
	 * @return
	 */
	public RoomVM loadByOccupancyInfo(Integer customerId,Date queryTime){
		
		RoomVM room=null;
		
		try{
			Map<String,Object> opyMap=new HashMap<String,Object>();
			
			opyMap.put("customerId", customerId);
			opyMap.put("queryTime", queryTime);
			
			Occupancy opy=occupancyMapper.loadOccupancyByCustomerIdAndDate(opyMap);
			
			if(opy !=null && opy.getRoomId()!=null){
				room=roomMapper.loadVMById(opy.getRoomId());

			}else {
				room= null;
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return room;
	}
}
