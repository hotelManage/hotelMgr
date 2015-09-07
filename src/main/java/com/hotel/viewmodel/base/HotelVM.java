package com.hotel.viewmodel.base;

import com.hotel.model.base.Hotel;

public class HotelVM extends Hotel {
	private String regionName;

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
