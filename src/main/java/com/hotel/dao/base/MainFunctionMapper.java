package com.hotel.dao.base;

import java.util.List;
import java.util.Map;

import com.hotel.core.MyBatisRepository;
import com.hotel.model.base.MainFunction;
import com.hotel.viewmodel.base.MainFunctionVM;

@MyBatisRepository
public interface MainFunctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MainFunction record);

    int insertSelective(MainFunction record);

    MainFunction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MainFunction record);

    int updateByPrimaryKey(MainFunction record);

	int countByMap(Map<String, Object> map);

	List<MainFunctionVM> loadFunctionList(Map<String, Object> map);
}