package com.hotel.viewmodel.rcu;

import java.util.List;

import com.hotel.model.rcu.Device;
import com.hotel.model.rcu.DeviceCfg;

public class DeviceCfgVM extends DeviceCfg{
	
	private  List<Device> devices;

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
}
