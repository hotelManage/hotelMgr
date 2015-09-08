package com.hotel.service.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.core.ListResult;
import com.hotel.dao.base.HotelMapper;
import com.hotel.dao.base.RoomMapper;
import com.hotel.dao.base.RoomTypeMapper;
import com.hotel.viewmodel.base.HotelVM;
import com.hotel.viewmodel.base.RoomTypeVM;
import com.hotel.viewmodel.base.RoomVM;

@Service
public class HotelService {

	@Autowired HotelMapper hotelMapper;
	@Autowired RoomMapper roomMapper;
	@Autowired RoomTypeMapper roomTypeMapper;
	
	
	public ListResult<RoomVM> loadRoomList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count=roomMapper.countByMap(map);
		List<RoomVM> ls = roomMapper.loadRoomList(map);
		ListResult<RoomVM> result=new ListResult<RoomVM>(count,ls);
		return result; 
	}

	public ListResult<RoomTypeVM> loadRoomTypeList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count=roomTypeMapper.countByMap(map);
		List<RoomTypeVM> ls = roomTypeMapper.loadRoomTypeList(map);
		ListResult<RoomTypeVM> result=new ListResult<RoomTypeVM>(count,ls);
		return result; 
	}

	public ListResult<HotelVM> loadHotelList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count=hotelMapper.countByMap(map);
		List<HotelVM> ls = hotelMapper.loadHotelList(map);
		ListResult<HotelVM> result=new ListResult<HotelVM>(count,ls);
		return result; 
	}

}