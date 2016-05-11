package com.pro.chang.beanmovie.api;

import com.pro.chang.beanmovie.entity.welfare.Welfare;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;

/**
 * Created by chang on 2016/3/17.
 */
public interface WelfareService {
    /*
    num	int	是	urlParam	指定返回数量，最大50	10
rand	int	否	urlParam	参数值为1则随机获取	1
word	string	否	urlParam	检索关键词	上海
page	int	否	urlParam	翻页，每页输出数量跟随num参数	1
     */

    @GET("/txapi/mvtp/meinv")
    Call<Welfare> getWelfare(@Header("apikey") String apikey,@Query("num") int num);

    @GET("/txapi/mvtp/meinv")
    Call<Welfare> getWelfare(@Header("apikey") String apikey,@Query("num") int num,@Query("rand") int rand);

    @GET("/txapi/mvtp/meinv")
    Call<Welfare> getWelfare(@Header("apikey") String apikey,@Query("num") int num,@Query("word") String word);
}
