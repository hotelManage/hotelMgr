package com.hotel.model.base;

public class ItemContent {
    private Integer id;

    private String fileName;

    private String url;

    private Integer wPix;

    private Integer hPix;
    
    private Integer itemId;

    private Integer index;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getwPix() {
        return wPix;
    }

    public void setwPix(Integer wPix) {
        this.wPix = wPix;
    }

    public Integer gethPix() {
        return hPix;
    }

    public void sethPix(Integer hPix) {
        this.hPix = hPix;
    }

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
    
}