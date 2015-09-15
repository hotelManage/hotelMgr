package com.hotel.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.service.base.RoomService;
import com.hotel.viewmodel.base.RoomVM;

public class RoomLoader {

	@Autowired RoomService roomService;
	
	@Test
	public void main(){
		loadRoom();
	}
	
	@Test
	public void loadRoom(){
		
		int m=100;
		
		RoomVM room = roomService.loadByOccupancyInfo(1, new Date());
		
		int x=m;
		

	}
}
