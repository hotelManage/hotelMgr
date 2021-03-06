package com.hotel.dao.base;

import java.util.List;
import java.util.Map;
import com.hotel.core.MyBatisRepository;
import com.hotel.model.base.Room;
import com.hotel.viewmodel.base.RoomVM;

@MyBatisRepository
public interface RoomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_room
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_room
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int insert(Room record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_room
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int insertSelective(Room record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_room
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    Room selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_room
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int updateByPrimaryKeySelective(Room record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_room
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int updateByPrimaryKey(Room record);

    /**
     * 获取房间记录总数
     * @param map
     * @return
     */
	int countByMap(Map<String, Object> map);

	/**
	 * 获取房间记录列表，分页显示
	 * @param map
	 * @return
	 */
	List<RoomVM> loadRoomList(Map<String, Object> map);
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	RoomVM loadVMById(Integer id);

	List<RoomVM> loadRoomComboList(Integer id);
	
}
