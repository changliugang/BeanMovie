package com.pro.chang.beanmovie.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 豆瓣电影
 * Created by chang on 2016/3/4.
 */
public class DoubanMovie implements Serializable{

    private int count;// 一页数据跨度
    private int start;// 本页起始条数
    private int total;// 总条目数
    private List<MovieData> subjects;// 电影数据

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MovieData> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieData> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "DoubanMovie{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", subjects=" + subjects +
                '}';
    }
}
