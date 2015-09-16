package com.hotel.viewmodel.base;

import com.hotel.model.base.Hotel;

public class HotelVM extends Hotel {
	private String regionName;

	private String text;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
