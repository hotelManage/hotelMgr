package com.hotel.dao.rcu;

import com.hotel.model.rcu.Rcu;

public interface RcuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rcu record);

    int insertSelective(Rcu record);

    Rcu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rcu record);

    int updateByPrimaryKey(Rcu record);
}