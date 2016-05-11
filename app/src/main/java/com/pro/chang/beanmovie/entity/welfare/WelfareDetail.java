package com.pro.chang.beanmovie.entity.welfare;

/**
 * 福利详情
 * Created by chang on 2016/3/17.
 */
public class WelfareDetail {

    private String ctime;//创建时间
    private String title;// 标题
    private String description;//描述，写死的没啥用
    private String picUrl;//图片url
    private String url;// 源网址

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
