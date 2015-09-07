package com.hotel.viewmodel.base;

import com.hotel.model.base.RoomType;

public class RoomTypeVM extends RoomType {
	private String hotelName;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
}
