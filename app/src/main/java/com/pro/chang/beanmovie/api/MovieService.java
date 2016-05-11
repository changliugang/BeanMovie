package com.pro.chang.beanmovie.api;

import com.pro.chang.beanmovie.entity.DoubanMovie;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * 
 * Created by chang on 2016/3/11.
 */
public interface MovieService {

    @GET("/v2/movie/in_theaters")
    Call<DoubanMovie> getBeShowing(@Query("start")int start, @Query("count")int count);

    @GET("/v2/movie/coming_soon")
    Call<DoubanMovie> getComingSoon(@Query("start")int start, @Query("count")int count);

}
