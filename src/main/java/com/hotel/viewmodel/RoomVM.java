package com.hotel.viewmodel;

import com.hotel.model.Room;

public class RoomVM extends Room {
	private String hotelName;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
}
