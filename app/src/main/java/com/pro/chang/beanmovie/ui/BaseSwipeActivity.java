package com.pro.chang.beanmovie.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.pro.chang.beanmovie.R;
import com.pro.chang.changpro.cache.divider.HorizontalDividerItemDecoration;

/**
 * Created by chang on 2016/3/15.
 */
public abstract class BaseSwipeActivity extends BaseToolbarActivity implements SwipeRefreshLayout.OnRefreshListener, OnMoreListener {

    protected SuperRecyclerView mRecycler;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mRecycler = (SuperRecyclerView) findViewById(R.id.list);
        mLayoutManager = getLayoutManager();
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .colorResId(android.R.color.transparent)
                .sizeResId(R.dimen.activity_horizontal_margin)
                .showLastDivider().build());

        if (isNeedRefresh())
        mRecycler.setRefreshListener(this);

        mRecycler.setRefreshingColorResources(android.R.color.holo_orange_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_red_light);
        mRecycler.setupMoreListener(this, 1);

    }

    protected boolean isNeedRefresh(){
        return false;
    }

    protected abstract int getLayoutId();

//    protected abstract boolean isSwipeToDismissEnabled();

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract void onLoadMore(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition);

    protected abstract void onPullRefresh();

    @Override
    public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {
        Log.d("chang", "overallItemsCount: "+overallItemsCount+"itemsBeforeMore:"
                +itemsBeforeMore+"maxLastVisiblePosition:"+maxLastVisiblePosition);
        onLoadMore(overallItemsCount,itemsBeforeMore,maxLastVisiblePosition);
    }

    @Override
    public void onRefresh() {
        onPullRefresh();
    }
}
