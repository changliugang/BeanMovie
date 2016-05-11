package com.pro.chang.beanmovie.entity;

import java.io.Serializable;

/**
 * 电影评分
 * Created by chang on 2016/3/4.
 */
public class MovieRating implements Serializable{

    private int max;// 最高分
    private float average; //平均分
    private int stars;//评星数
    private int min;// 最低分

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
