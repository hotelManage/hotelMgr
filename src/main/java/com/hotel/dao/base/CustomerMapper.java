package com.hotel.dao.base;

import java.util.List;
import java.util.Map;
 
import com.hotel.core.MyBatisRepository;
import com.hotel.model.base.Customer;
@MyBatisRepository
public interface CustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int insertSelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    Customer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    int updateByPrimaryKey(Customer record);

    /**
     * 获取所有客户资料列表
     * @param map
     * @return
     */
	List<Customer> loadCustomerList(Map<String, Object> map);

	/**
	 * 获取客户总记录数
	 * @param map
	 * @return
	 */
	int countByMap(Map<String, Object> map);
	
	/**
	 * 通过手机号码和密码读取一个用户
	 * @param map
	 * @return
	 */
	Customer loadByMobileAndPsd(Map<String, Object> map);
	
	
	
}
