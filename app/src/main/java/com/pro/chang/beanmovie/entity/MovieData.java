package com.pro.chang.beanmovie.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 *  电影数据
 * Created by chang on 2016/3/4.
 */
public class MovieData implements Serializable{

    private MovieRating rating;// 评分
    private String genres[];// 分类标签
    private String title;// 电影名
    private List<Actor> casts;// 演员们
    @SerializedName("collect_count")
    private int collectCount;// 收藏数
    @SerializedName("original_title")
    private String original_title;//原名
    private String subtype;// 子类型

    private List<Actor> directors;//导演
    private String year;// 上映年代

    private Avatar images;// 电影海报
    private String alt;// 电影主页
    private String id;// 电影ID

    public MovieRating getRating() {
        return rating;
    }

    public void setRating(MovieRating rating) {
        this.rating = rating;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getCasts() {
        return casts;
    }

    public void setCasts(List<Actor> casts) {
        this.casts = casts;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public List<Actor> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Actor> directors) {
        this.directors = directors;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Avatar getImages() {
        return images;
    }

    public void setImages(Avatar images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieTips(){
        StringBuilder sb  = new StringBuilder();
        for (String tip: getGenres()
                ) {
            sb.append(tip+"  ");
        }
        return sb.toString();
    }

}
