package com.hotel.viewmodel.base;

import java.util.List;

import com.hotel.model.base.HotelItem;

public class HotelItemVM extends HotelItem{
	private String hotelName;
	private String url;
	private List tagIds;
	private List itaIds;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List getTagIds() {
		return tagIds;
	}

	public void setTagIds(List tagIds) {
		this.tagIds = tagIds;
	}

	public List getItaIds() {
		return itaIds;
	}

	public void setItaIds(List itaIds) {
		this.itaIds = itaIds;
	}
	

}
