package com.hotel.dao.base;

import java.util.List;

import com.hotel.core.MyBatisRepository;
import com.hotel.model.base.ItemTagAssociation;

@MyBatisRepository
public interface ItemTagAssociationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemTagAssociation record);

    int insertSelective(ItemTagAssociation record);

    ItemTagAssociation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemTagAssociation record);

    int updateByPrimaryKey(ItemTagAssociation record);

	void insert(Object obj);

	List<ItemTagAssociation> loadItemTagAssociationList(Integer itemId);
}