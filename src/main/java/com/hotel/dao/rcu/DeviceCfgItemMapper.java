package com.hotel.dao.rcu;

import com.hotel.model.rcu.DeviceCfgItem;

public interface DeviceCfgItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeviceCfgItem record);

    int insertSelective(DeviceCfgItem record);

    DeviceCfgItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeviceCfgItem record);

    int updateByPrimaryKey(DeviceCfgItem record);
}