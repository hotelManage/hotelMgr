package com.hotel.viewmodel;

import com.hotel.model.RoomType;

public class RoomTypeVM extends RoomType {
	private String hotelName;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
}
