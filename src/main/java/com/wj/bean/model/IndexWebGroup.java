package com.wj.bean.model;

public class IndexWebGroup extends IndexWebGroupKey {
    private String title;

    private String littleTitle;

    private String image;

    private Integer theme;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLittleTitle() {
        return littleTitle;
    }

    public void setLittleTitle(String littleTitle) {
        this.littleTitle = littleTitle == null ? null : littleTitle.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getTheme() {
        return theme;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }
}