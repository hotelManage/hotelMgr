package com.hotel.dao.base;

import java.util.List;
import java.util.Map;

import com.hotel.core.MyBatisRepository;
import com.hotel.model.base.ItemTag;

@MyBatisRepository
public interface ItemTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemTag record);

    int insertSelective(ItemTag record);

    ItemTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemTag record);

    int updateByPrimaryKey(ItemTag record);

	int countByMap(Map<String, Object> map);

	List<ItemTag> loadItemTagList(Map<String, Object> map);

	ItemTag selectByName(String name);

	List<ItemTag> loadItemTagComboList();
}