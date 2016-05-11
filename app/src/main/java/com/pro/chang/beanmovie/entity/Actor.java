package com.pro.chang.beanmovie.entity;

import java.io.Serializable;

/**
 * 演员
 * Created by chang on 2016/3/4.
 */
public class Actor implements Serializable{

    private String alt;// 演员的豆瓣主页
    private Avatar avatars;// 头像
    private String name;// 演员名
    private String id;// ID

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Avatar getAvatars() {
        return avatars;
    }

    public void setAvatars(Avatar avatars) {
        this.avatars = avatars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
