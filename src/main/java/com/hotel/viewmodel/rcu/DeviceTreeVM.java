package com.hotel.viewmodel.rcu;

import java.util.List;

public class DeviceTreeVM {
	private DeviceTreeVM parent;
	private List<DeviceTreeVM> children;
	private int level;
	private String path;
	private String name;
	private String number;
	private String type;
	private String note;
	
	private String expression;

	public DeviceTreeVM getParent() {
		return parent;
	}

	public void setParent(DeviceTreeVM parent) {
		this.parent = parent;
	}

	public List<DeviceTreeVM> getChildren() {
		return children;
	}

	public void setChildren(List<DeviceTreeVM> children) {
		this.children = children;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
	
}
