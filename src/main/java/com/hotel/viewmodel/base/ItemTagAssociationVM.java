package com.hotel.viewmodel.base;

import java.util.List;

import com.hotel.model.base.ItemTagAssociation;

public class ItemTagAssociationVM extends ItemTagAssociation {
	private List tagIds;
	private List ids;

	public List getIds() {
		return ids;
	}

	public void setIds(List ids) {
		this.ids = ids;
	}

	public List getTagIds() {
		return tagIds;
	}

	public void setTagIds(List tagIds) {
		this.tagIds = tagIds;
	}
	
 
}
