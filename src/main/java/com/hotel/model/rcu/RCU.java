package com.hotel.model.rcu;

public class RCU {
    private Integer id;

    private Integer roomId;

    private String name;

    private String sid;

    private Integer deviceCfgId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getDeviceCfgId() {
        return deviceCfgId;
    }

    public void setDeviceCfgId(Integer deviceCfgId) {
        this.deviceCfgId = deviceCfgId;
    }
}