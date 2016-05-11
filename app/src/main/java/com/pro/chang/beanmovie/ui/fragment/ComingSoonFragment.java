package com.pro.chang.beanmovie.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pro.chang.beanmovie.R;
import com.pro.chang.beanmovie.entity.MovieData;
import com.pro.chang.changpro.cache.adapter.recyclerview.BaseAdapterHelper;
import com.pro.chang.changpro.cache.adapter.recyclerview.QuickAdapter;

/**
 * Created by chang on 2016/4/28.
 */
public class ComingSoonFragment extends BaseMovieListFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    protected RecyclerView.Adapter setAdapter() {
        return new QuickAdapter<MovieData>(getActivity(),
                R.layout.item_movie) {
            @Override
            protected void convert(BaseAdapterHelper helper, MovieData item) {
                helper.setImageWithUrl(getActivity(), R.id.be_showing_item_poster, item.getImages().getMedium());
                helper.setText(R.id.be_showing_item_movie_name, item.getTitle());
                helper.setText(R.id.be_showing_item_director,item.getDirectors().get(0).getName());
                helper.setText(R.id.be_showing_item_tips,item.getMovieTips());
            }
        };
    }

    @Override
    protected void loadData(boolean isFirst) {

    }
}
