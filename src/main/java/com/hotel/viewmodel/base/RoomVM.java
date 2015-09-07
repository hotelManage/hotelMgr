package com.hotel.viewmodel.base;

import com.hotel.model.base.Room;

public class RoomVM extends Room {
	private String hotelName;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
}
