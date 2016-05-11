package com.pro.chang.beanmovie.entity.welfare;

import java.util.List;

/**
 * Created by chang on 2016/3/17.
 */
public class Welfare {

    private int code;
    private String msg;
    private List<WelfareDetail> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<WelfareDetail> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<WelfareDetail> newslist) {
        this.newslist = newslist;
    }
}
