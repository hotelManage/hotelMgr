package com.hotel.viewmodel.base;

import java.util.ArrayList;
import java.util.List;

import com.hotel.model.base.Room;
import com.hotel.model.rcu.DeviceCfg;
import com.hotel.model.rcu.Rcu;

public class RoomVM extends Room {
	private String hotelName;
	private List<Rcu> rcus = new ArrayList<Rcu>();
	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
}
