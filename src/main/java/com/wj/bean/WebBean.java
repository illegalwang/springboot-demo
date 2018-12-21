package com.wj.bean;

import java.util.List;

/**
 * 展示在首页上的数据
 * Created by wj on 2018/12/20.
 */
public class WebBean {
    private Integer theme;

    private List<WebGroup> group;

    public Integer getTheme() {
        return theme;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }

    public List<WebGroup> getGroup() {
        return group;
    }

    public void setGroup(List<WebGroup> group) {
        this.group = group;
    }
}
