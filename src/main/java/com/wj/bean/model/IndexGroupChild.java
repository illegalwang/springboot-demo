package com.wj.bean.model;

public class IndexGroupChild {
    private Integer webId;

    private Integer groupId;

    private String webUrl;

    private String webName;

    private String webIcon;

    private Integer ifDes;

    public Integer getWebId() {
        return webId;
    }

    public void setWebId(Integer webId) {
        this.webId = webId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl == null ? null : webUrl.trim();
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName == null ? null : webName.trim();
    }

    public String getWebIcon() {
        return webIcon;
    }

    public void setWebIcon(String webIcon) {
        this.webIcon = webIcon == null ? null : webIcon.trim();
    }

    public Integer getIfDes() {
        return ifDes;
    }

    public void setIfDes(Integer ifDes) {
        this.ifDes = ifDes;
    }
}