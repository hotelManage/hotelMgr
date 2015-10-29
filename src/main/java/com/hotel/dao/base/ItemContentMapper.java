package com.hotel.dao.base;

import com.hotel.core.MyBatisRepository;
import com.hotel.model.base.ItemContent;

@MyBatisRepository
public interface ItemContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemContent record);

    int insertSelective(ItemContent record);

    ItemContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemContent record);

    int updateByPrimaryKey(ItemContent record);

	void updateByItemId(ItemContent itemContent);
}