package com.hotel.model.base;

public class MainFunction {
    private Integer id;

    private Integer functionType;

    private String iconUrl;

    private Integer itemTagId;

    private String sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFunctionType() {
        return functionType;
    }

    public void setFunctionType(Integer functionType) {
        this.functionType = functionType;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getItemTagId() {
        return itemTagId;
    }

    public void setItemTagId(Integer itemTagId) {
        this.itemTagId = itemTagId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}