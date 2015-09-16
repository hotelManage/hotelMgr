package com.hotel.viewmodel.base;

import java.util.List;

import com.hotel.model.base.Customer;
import com.hotel.viewmodel.rcu.RcuVM;

public class CustomerRoomInfo  {
	private Customer customer;
	private RoomVM room ;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public RoomVM getRoom() {
		return room;
	}
	public void setRoom(RoomVM room) {
		this.room = room;
	}

	
}
