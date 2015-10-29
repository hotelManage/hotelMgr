package com.hotel.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.base.HotelItemMapper;
import com.hotel.dao.base.HotelMapper;
import com.hotel.dao.base.ItemContentMapper;
import com.hotel.dao.base.ItemTagAssociationMapper;
import com.hotel.dao.base.ItemTagMapper;
import com.hotel.dao.base.OccupancyMapper;
import com.hotel.dao.base.RoomMapper;
import com.hotel.dao.base.RoomTypeMapper;
import com.hotel.model.base.HotelItem;
import com.hotel.model.base.ItemContent;
import com.hotel.model.base.ItemTagAssociation;
import com.hotel.viewmodel.base.HotelItemVM;


@Service
public class TestServiceImp implements TestService{
	@Autowired HotelMapper hotelMapper;
	@Autowired RoomMapper roomMapper;
	@Autowired RoomTypeMapper roomTypeMapper;
	@Autowired OccupancyMapper occupancyMapper;
	@Autowired HotelItemMapper hotelItemMapper;
	@Autowired ItemTagMapper itemTagMapper;
	@Autowired ItemTagAssociationMapper itemTagAssociationMapper;
	@Autowired ItemContentMapper itemContentMapper;
	
	
	public void insertTest(HotelItemVM item, ItemContent ic) {
		HotelItem i = new HotelItem();
		i.setHotelId(item.getHotelId());
		i.setId(item.getId());
		i.setIsUsed(item.getIsUsed());
		i.setName(item.getName());
		i.setNote(item.getNote());
		i.setTel(item.getTel());
		hotelItemMapper.insert(i);
		int x=9/0;
		ItemContent itemContent = new ItemContent();
		itemContent.setFileName(ic.getFileName());
		itemContent.sethPix(ic.gethPix());
		itemContent.setwPix(ic.getwPix());
		itemContent.setIndex(ic.getIndex());
		itemContent.setItemId(i.getId());
		itemContent.setId(0);
		itemContent.setUrl(item.getUrl());
		itemContentMapper.insert(itemContent);
		
		ItemTagAssociation ita = new ItemTagAssociation();
		List tagIds = item.getTagIds();
//		for(ItemTagAssociation ita:tagId){
//			itemTagAssociationMapper.insert(ita);
//		}
		for(int m=0;m<tagIds.size();m++){
			Object tagId=tagIds.get(m);
			ita.setId(0);
		    ita.setItemId(i.getId());
		    ita.setTagId(Integer.valueOf(tagId.toString()));
			itemTagAssociationMapper.insert(ita);
		}
		
	}
}
