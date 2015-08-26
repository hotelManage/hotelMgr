package com.hotel.viewmodel;

import com.hotel.model.Hotel;

public class HotelVM extends Hotel {
	private String regionName;

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
