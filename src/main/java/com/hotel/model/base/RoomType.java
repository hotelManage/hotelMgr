package com.hotel.model.base;

public class RoomType {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_room_type.id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_room_type.hotel_id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    private Integer hotelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_room_type.name
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_room_type.note
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_room_type.id
     *
     * @return the value of t_room_type.id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_room_type.id
     *
     * @param id the value for t_room_type.id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_room_type.hotel_id
     *
     * @return the value of t_room_type.hotel_id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public Integer getHotelId() {
        return hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_room_type.hotel_id
     *
     * @param hotelId the value for t_room_type.hotel_id
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_room_type.name
     *
     * @return the value of t_room_type.name
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_room_type.name
     *
     * @param name the value for t_room_type.name
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_room_type.note
     *
     * @return the value of t_room_type.note
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_room_type.note
     *
     * @param note the value for t_room_type.note
     *
     * @mbggenerated Mon Aug 24 23:10:28 CST 2015
     */
    public void setNote(String note) {
        this.note = note;
    }
}