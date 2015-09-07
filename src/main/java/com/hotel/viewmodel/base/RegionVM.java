package com.hotel.viewmodel.base;

import java.util.List;

import com.hotel.model.base.Region;

public class RegionVM extends Region{
	private List<RegionVM> children;

	public List<RegionVM> getChildren() {
		return children;
	}

	public void setChildren(List<RegionVM> children) {
		this.children = children;
	}

}
