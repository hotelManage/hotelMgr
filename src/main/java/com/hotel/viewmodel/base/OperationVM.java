package com.hotel.viewmodel.base;

import com.hotel.model.base.DeviceState;

public class OperationVM extends DeviceState {
	private String customerName;
	private String roomName;
	private String rcuNo;
	private String hotelName;
	private Integer floor;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRcuNo() {
		return rcuNo;
	}
	public void setRcuNo(String rcuNo) {
		this.rcuNo = rcuNo;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
}
