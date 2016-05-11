package com.pro.chang.beanmovie.entity;

import java.io.Serializable;

/**
 * 头像
 * Created by chang on 2016/3/4.
 */
public class Avatar implements Serializable {
    /*
     * 影人头像，分别提供420px x 600px(大)，140px x 200px(中) 70px x 100px(小)尺寸
     */
    private String small;
    private String large;
    private String medium;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
