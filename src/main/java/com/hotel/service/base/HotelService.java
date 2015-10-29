package com.hotel.service.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.core.ListResult;
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
import com.hotel.model.base.ItemTag;
import com.hotel.model.base.ItemTagAssociation;
import com.hotel.model.base.Occupancy;
import com.hotel.viewmodel.base.HotelItemVM;
import com.hotel.viewmodel.base.HotelVM;
import com.hotel.viewmodel.base.RoomTypeVM;
import com.hotel.viewmodel.base.RoomVM;

@Service
@Transactional
public class HotelService {

	@Autowired HotelMapper hotelMapper;
	@Autowired RoomMapper roomMapper;
	@Autowired RoomTypeMapper roomTypeMapper;
	@Autowired OccupancyMapper occupancyMapper;
	@Autowired HotelItemMapper hotelItemMapper;
	@Autowired ItemTagMapper itemTagMapper;
	@Autowired ItemTagAssociationMapper itemTagAssociationMapper;
	@Autowired ItemContentMapper itemContentMapper;
	
	
	public ListResult<RoomVM> loadRoomList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count=roomMapper.countByMap(map);
		List<RoomVM> ls = roomMapper.loadRoomList(map);
		ListResult<RoomVM> result=new ListResult<RoomVM>(count,ls);
		return result; 
	}

	public ListResult<RoomTypeVM> loadRoomTypeList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count=roomTypeMapper.countByMap(map);
		List<RoomTypeVM> ls = roomTypeMapper.loadRoomTypeList(map);
		ListResult<RoomTypeVM> result=new ListResult<RoomTypeVM>(count,ls);
		return result; 
	}

	public ListResult<HotelVM> loadHotelList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count=hotelMapper.countByMap(map);
		List<HotelVM> ls = hotelMapper.loadHotelList(map);
		ListResult<HotelVM> result=new ListResult<HotelVM>(count,ls);
		return result; 
	}

	public List<HotelVM> loadHotelComboList() {
		// TODO Auto-generated method stub
		List<HotelVM> ls = hotelMapper.loadHotelComboList();
		return ls;
	}

	public List<RoomVM> loadRoomComboList(Integer id) {
		// TODO Auto-generated method stub
		List<RoomVM> ls = roomMapper.loadRoomComboList(id);
		return ls;
	}

	public int insertOccupancy(Occupancy occupancy) {
		// TODO Auto-generated method stub
		return occupancyMapper.insert(occupancy);
	}
	/**
	 * 加载酒店对应服务
	 * @param map
	 * @return
	 */
	public ListResult<HotelItemVM> loadHotelItemList(Map<String, Object> map) {
		int count=hotelItemMapper.countByMap(map);
		List<HotelItemVM> ls = hotelItemMapper.loadHotelItemList(map);
		ListResult<HotelItemVM> result=new ListResult<HotelItemVM>(count,ls);
		return result; 
	}
/**
 * 加载所有服务项目
 * @param map
 * @return
 */
	public ListResult<ItemTag> loadItemTagList(Map<String, Object> map) {
		int count=itemTagMapper.countByMap(map);
		List<ItemTag> ls = itemTagMapper.loadItemTagList(map);
		ListResult<ItemTag> result=new ListResult<ItemTag>(count,ls);
		return result; 
	}

public ItemTag selectItemTagByName(String name) {
	// TODO Auto-generated method stub
	ItemTag itemTag = itemTagMapper.selectByName(name);
	return itemTag;
}

public void updateItemTag(ItemTag item) {
	// TODO Auto-generated method stub
	itemTagMapper.updateByPrimaryKeySelective(item);
}

public void insertItemTag(ItemTag item) {
	// TODO Auto-generated method stub
	itemTagMapper.insert(item);
}

public void deleteItemTag(Integer id) {
	// TODO Auto-generated method stub
	itemTagMapper.deleteByPrimaryKey(id);
}

public List<ItemTag> loadItemTagComboList() {
	List<ItemTag> ls = itemTagMapper.loadItemTagComboList();
	return ls;
}

public HotelItemVM selectHotelItemByName(String name) {
	HotelItemVM hotelItem = hotelItemMapper.selectByName(name);
	return hotelItem;
}
/**
 * insert HotelItem、ItemContent、ItemTagAssociation
 * @param item
 * @param ic 
 */
public void insert(HotelItemVM item, ItemContent ic) {
	HotelItem i = new HotelItem();
	i.setHotelId(item.getHotelId());
	i.setId(item.getId());
	i.setIsUsed(item.getIsUsed());
	i.setName(item.getName());
	i.setNote(item.getNote());
	i.setTel(item.getTel());
	hotelItemMapper.insert(i);
	
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
//	for(ItemTagAssociation ita:tagId){
//		itemTagAssociationMapper.insert(ita);
//	}
	for(int m=0;m<tagIds.size();m++){
		Object tagId=tagIds.get(m);
		ita.setId(0);
	    ita.setItemId(i.getId());
	    ita.setTagId(Integer.valueOf(tagId.toString()));
		itemTagAssociationMapper.insert(ita);
	}
	
}
/**
 * 更新 HotelItem、ItemContent、ItemTagAssociation
 * @param item
 * @param ic 
 */
public void update(HotelItemVM item, ItemContent ic) {
	HotelItem i = new HotelItem();
	i.setHotelId(item.getHotelId());
	i.setId(item.getId());
	i.setIsUsed(item.getIsUsed());
	i.setName(item.getName());
	i.setNote(item.getNote());
	i.setTel(item.getTel());
	hotelItemMapper.updateByPrimaryKeySelective(i);
	
	ItemContent itemContent = new ItemContent();
	itemContent.setFileName(ic.getFileName());
	itemContent.sethPix(ic.gethPix());
	itemContent.setwPix(ic.getwPix());
	itemContent.setIndex(ic.getIndex());
	itemContent.setItemId(item.getId());
	itemContent.setUrl(item.getUrl());
	itemContentMapper.updateByItemId(itemContent);
	
	ItemTagAssociation ita = new ItemTagAssociation();
	List tagIds = item.getTagIds();
	List itaIds = item.getItaIds();
	if(tagIds.size()==itaIds.size()){//仅更改tag并未添加或减少
		for(int m=0;m<tagIds.size();m++){
			Object tagId=tagIds.get(m);
			Object itaId=itaIds.get(m);
			ita.setId(Integer.valueOf(itaId.toString()));
		    ita.setItemId(item.getId());
		    ita.setTagId(Integer.valueOf(tagId.toString()));
			itemTagAssociationMapper.updateByPrimaryKey(ita);
		}
	}
	if(tagIds.size()>itaIds.size()){//增加了tag
		int m = 0;
		for(m=0;m<itaIds.size();m++){
			Object tagId=tagIds.get(m);
			Object itaId=itaIds.get(m);
			ita.setId(Integer.valueOf(itaId.toString()));
		    ita.setItemId(item.getId());
		    ita.setTagId(Integer.valueOf(tagId.toString()));
			itemTagAssociationMapper.updateByPrimaryKey(ita);
		}
		for(int n=m;n<tagIds.size();n++){
			Object tagId=tagIds.get(n);
			ita.setId(0);
		    ita.setItemId(item.getId());
		    ita.setTagId(Integer.valueOf(tagId.toString()));
			itemTagAssociationMapper.insert(ita);
		}
	}
	if(tagIds.size()<itaIds.size()){//移除了tag
		int m =0;
		for(m=0;m<tagIds.size();m++){
			Object tagId=tagIds.get(m);
			Object itaId=itaIds.get(m);
			ita.setId(Integer.valueOf(itaId.toString()));
		    ita.setItemId(item.getId());
		    ita.setTagId(Integer.valueOf(tagId.toString()));
			itemTagAssociationMapper.updateByPrimaryKey(ita);
		}
		for(int n=m;n<itaIds.size();n++){
			Object itaId=itaIds.get(m);
			int id = Integer.valueOf(itaId.toString());
			itemTagAssociationMapper.deleteByPrimaryKey(id);
		}
	}
	
}

public List<ItemTagAssociation> loadItemTagAssociationList(Integer itemId) {
	List<ItemTagAssociation> ls = itemTagAssociationMapper.loadItemTagAssociationList(itemId);
	return ls;
}

public void updateHotelItem(HotelItem item) {
	// TODO Auto-generated method stub
	hotelItemMapper.updateByPrimaryKeySelective(item);
}

}
