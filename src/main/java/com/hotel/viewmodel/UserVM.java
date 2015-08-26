package com.hotel.viewmodel;

import com.hotel.model.User;

public class UserVM extends User {
	private String hotelName;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	

}
