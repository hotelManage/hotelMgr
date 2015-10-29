package com.hotel.dao.base;

import java.util.List;
import java.util.Map;

import com.hotel.core.MyBatisRepository;
import com.hotel.model.base.HotelItem;
import com.hotel.model.base.ItemContent;
import com.hotel.viewmodel.base.HotelItemVM;

@MyBatisRepository
public interface HotelItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HotelItem record);

    int insertSelective(HotelItem record);

    HotelItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HotelItem record);

    int updateByPrimaryKey(HotelItem record);

	int countByMap(Map<String, Object> map);

	List<HotelItemVM> loadHotelItemList(Map<String, Object> map);

	HotelItemVM selectByName(String name);

}