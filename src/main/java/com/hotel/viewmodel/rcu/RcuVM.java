package com.hotel.viewmodel.rcu;

import com.hotel.model.rcu.DeviceCfg;
import com.hotel.model.rcu.Rcu;


public class RcuVM extends Rcu{
	private DeviceCfg deviceCfg;

	public DeviceCfg getDeviceCfg() {
		return deviceCfg;
	}

	public void setDeviceCfg(DeviceCfg deviceCfg) {
		this.deviceCfg = deviceCfg;
	}
	
}
