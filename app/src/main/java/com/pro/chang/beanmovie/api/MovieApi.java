package com.pro.chang.beanmovie.api;

import com.pro.chang.beanmovie.entity.DoubanMovie;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * 接口控制网络请求
 * Created by chang on 2016/4/26.
 */
public interface MovieApi {

    @GET("/v2/movie/in_theaters")
    Observable<DoubanMovie> getBeShowing(@Query("start")int start, @Query("count")int count);

    @GET("/v2/movie/coming_soon")
    Observable<DoubanMovie> getComingSoon(@Query("start")int start, @Query("count")int count);

}
