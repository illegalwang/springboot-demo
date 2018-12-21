package com.wj.bean.model;

public class SysUser {
    private String userId;

    private String username;

    private String password;

    private String trueName;

    private Integer indexTheme;

    public SysUser() {
    }

    public SysUser(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public Integer getIndexTheme() {
        return indexTheme;
    }

    public void setIndexTheme(Integer indexTheme) {
        this.indexTheme = indexTheme;
    }
}