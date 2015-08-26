package com.hotel.dao;

import java.util.List;
import java.util.Map;
import com.hotel.core.MyBatisRepository;
import com.hotel.model.Occupancy;
import com.hotel.viewmodel.OccupancyVM;

@MyBatisRepository
public interface OccupancyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_occupancy
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_occupancy
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int insert(Occupancy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_occupancy
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int insertSelective(Occupancy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_occupancy
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    Occupancy selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_occupancy
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int updateByPrimaryKeySelective(Occupancy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_occupancy
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int updateByPrimaryKey(Occupancy record);

    /**
     * 获取入住信息总记录数
     * @param map
     * @return
     */
	int countByMap(Map<String, Object> map);

	/**
	 * 获取入住记录，分页显示
	 * @param map
	 * @return
	 */
	List<OccupancyVM> loadOccupancyVMList(Map<String, Object> map);
}
