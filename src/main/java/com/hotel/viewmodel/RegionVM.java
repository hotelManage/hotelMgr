package com.hotel.viewmodel;

import java.util.List;

import com.hotel.model.Region;

public class RegionVM extends Region{
	private List<RegionVM> children;

	public List<RegionVM> getChildren() {
		return children;
	}

	public void setChildren(List<RegionVM> children) {
		this.children = children;
	}

}
