package com.hotel.model.base;

import java.util.Date;

public class Occupancy {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_occupancy.id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_occupancy.customer_id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    private Integer customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_occupancy.room_id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    private Integer roomId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_occupancy.certificates_key
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    private String certificatesKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_occupancy.checkin_time
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    private Date checkinTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_occupancy.checkout_time
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    private Date checkoutTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_occupancy.id
     *
     * @return the value of t_occupancy.id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_occupancy.id
     *
     * @param id the value for t_occupancy.id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_occupancy.customer_id
     *
     * @return the value of t_occupancy.customer_id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_occupancy.customer_id
     *
     * @param customerId the value for t_occupancy.customer_id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_occupancy.room_id
     *
     * @return the value of t_occupancy.room_id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_occupancy.room_id
     *
     * @param roomId the value for t_occupancy.room_id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_occupancy.certificates_key
     *
     * @return the value of t_occupancy.certificates_key
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public String getCertificatesKey() {
        return certificatesKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_occupancy.certificates_key
     *
     * @param certificatesKey the value for t_occupancy.certificates_key
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public void setCertificatesKey(String certificatesKey) {
        this.certificatesKey = certificatesKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_occupancy.checkin_time
     *
     * @return the value of t_occupancy.checkin_time
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public Date getCheckinTime() {
        return checkinTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_occupancy.checkin_time
     *
     * @param checkinTime the value for t_occupancy.checkin_time
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_occupancy.checkout_time
     *
     * @return the value of t_occupancy.checkout_time
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public Date getCheckoutTime() {
        return checkoutTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_occupancy.checkout_time
     *
     * @param checkoutTime the value for t_occupancy.checkout_time
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }
}