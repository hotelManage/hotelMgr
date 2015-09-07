package com.hotel.dao.rcu;

import com.hotel.model.rcu.RCU;

public interface RCUMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RCU record);

    int insertSelective(RCU record);

    RCU selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RCU record);

    int updateByPrimaryKey(RCU record);
}