package com.hotel.viewmodel.base;

import java.util.ArrayList;
import java.util.List;

import com.hotel.model.base.Room;
import com.hotel.viewmodel.rcu.RcuVM;

public class RoomVM extends Room {
	private String hotelName;
	private String text;
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private List<RcuVM> rcus = new ArrayList<RcuVM>();
	
	public List<RcuVM> getRcus() {
		return rcus;
	}

	public void setRcus(List<RcuVM> rcus) {
		this.rcus = rcus;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
}
