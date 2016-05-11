package com.pro.chang.beanmovie.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.orhanobut.logger.Logger;
import com.pro.chang.beanmovie.R;
import com.pro.chang.beanmovie.api.MovieApi;
import com.pro.chang.beanmovie.api.DoubanFactory;
import com.pro.chang.beanmovie.entity.DoubanMovie;
import com.pro.chang.beanmovie.entity.MovieData;
import com.pro.chang.changpro.cache.adapter.recyclerview.BaseAdapterHelper;
import com.pro.chang.changpro.cache.adapter.recyclerview.QuickAdapter;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 即将上映
 */
public class ComingSoonActivity extends BaseSwipeActivity {

    private static final String TAG = "ComingSoonActivity";
    private QuickAdapter<MovieData> adapter;
    private int index = 0;
    private int totalCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new QuickAdapter<MovieData>(ComingSoonActivity.this,
                R.layout.item_movie) {
            @Override
            protected void convert(BaseAdapterHelper helper, MovieData item) {
                helper.setImageWithUrl(ComingSoonActivity.this, R.id.be_showing_item_poster, item.getImages().getMedium());
                helper.setText(R.id.be_showing_item_movie_name, item.getTitle());
                helper.setText(R.id.be_showing_item_director, item.getDirectors().isEmpty() ? "daoyan" : item.getDirectors().get(0).getName());
                helper.setText(R.id.be_showing_item_tips, item.getMovieTips());
                helper.setText(R.id.be_showing_item_score, helper.getAdapterPosition() + "");
            }
        };
        mRecycler.setAdapter(adapter);
        loadData();
    }

    private void loadData() {
        MovieApi movieApi = DoubanFactory.getMovieApiSingleTon();
        movieApi.getComingSoon(index * DoubanFactory.PAGE_SIZE, DoubanFactory.PAGE_SIZE)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<DoubanMovie>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Logger.e(e.getMessage());
            }

            @Override
            public void onNext(DoubanMovie doubanMovie) {
                if (doubanMovie != null) {
                    totalCount = doubanMovie.getTotal();
                    adapter.addAll(doubanMovie.getSubjects());
                    index++;
                }
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vertical_sample;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected void onLoadMore(final int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {

        if ((maxLastVisiblePosition + 1) == totalCount) {
            mRecycler.hideMoreProgress();
            return;
        }

        loadData();
    }

    @Override
    protected void onPullRefresh() {
    }

}
