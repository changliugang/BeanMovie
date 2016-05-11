package com.pro.chang.beanmovie.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.pro.chang.beanmovie.R;
import com.pro.chang.changpro.cache.divider.HorizontalDividerItemDecoration;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by chang on 2016/4/28.
 */
public abstract class BaseMovieListFragment extends Fragment {

    @InjectView(R.id.base_movie_list)
    SuperRecyclerView baseMovieList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_movie_list, container);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 配置RecyclerView的相关样式
        baseMovieList.setLayoutManager(new LinearLayoutManager(getActivity()));
        baseMovieList.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getActivity())
                .colorResId(android.R.color.transparent)
                .sizeResId(R.dimen.activity_horizontal_margin)
                .showLastDivider().build());
        baseMovieList.setAdapter(setAdapter());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    // adapter交由子类实现
    protected abstract RecyclerView.Adapter setAdapter();
    // 加载网络数据
    protected abstract void loadData(boolean isFirst);

}
