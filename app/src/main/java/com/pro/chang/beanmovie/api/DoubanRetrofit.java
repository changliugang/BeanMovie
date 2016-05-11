package com.pro.chang.beanmovie.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by chang on 2016/4/26.
 */
public class DoubanRetrofit {

    private Retrofit retrofit;

    final static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .serializeNulls()
            .create();

    DoubanRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(DoubanFactory.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public MovieApi getDoubanApi() {
        return retrofit.create(MovieApi.class);
    }

}
