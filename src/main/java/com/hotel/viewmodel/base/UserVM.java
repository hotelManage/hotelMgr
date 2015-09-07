package com.hotel.viewmodel.base;

import com.hotel.model.base.User;

public class UserVM extends User {
	private String hotelName;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	

}
