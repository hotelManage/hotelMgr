package com.hotel.dao;

import java.util.List;

import com.hotel.core.MyBatisRepository;
import com.hotel.model.Region;
import com.hotel.viewmodel.RegionVM;

@MyBatisRepository
public interface RegionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_region
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_region
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int insert(Region record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_region
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int insertSelective(Region record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_region
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    Region selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_region
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int updateByPrimaryKeySelective(Region record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_region
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int updateByPrimaryKey(Region record);

	List<RegionVM> getRegionList(Integer pid);
}