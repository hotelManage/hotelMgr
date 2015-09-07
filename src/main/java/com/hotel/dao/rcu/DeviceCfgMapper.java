package com.hotel.dao.rcu;

import com.hotel.model.rcu.DeviceCfg;

public interface DeviceCfgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeviceCfg record);

    int insertSelective(DeviceCfg record);

    DeviceCfg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeviceCfg record);

    int updateByPrimaryKey(DeviceCfg record);
}