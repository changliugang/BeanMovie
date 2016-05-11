package com.pro.chang.beanmovie.api;

/**
 * 对外生成单例GankApi实例，确保DoubanApi实例只生成一次。
 * Created by chang on 2016/4/27.
 */
public class DoubanFactory {

    protected static final Object monitor = new Object();
    static MovieApi movieApiSingleTon = null;

    public static final String BASE_URL = "https://api.douban.com";

    public static final String BASE_URL_WELFARE = "http://apis.baidu.com";
    public static final String APIKEY = "4195da7754448a5997e31db7c848e6b1";

    public static final int PAGE_SIZE = 10;


    public static MovieApi getMovieApiSingleTon(){
        synchronized (monitor){
            if (movieApiSingleTon ==null){
                movieApiSingleTon = new DoubanRetrofit().getDoubanApi();
            }
            return movieApiSingleTon;
        }
    }
}
