package com.pro.chang.beanmovie.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.pro.chang.beanmovie.R;
import com.pro.chang.beanmovie.api.DoubanFactory;
import com.pro.chang.beanmovie.api.MovieService;
import com.pro.chang.beanmovie.entity.DoubanMovie;
import com.pro.chang.beanmovie.entity.MovieData;
import com.pro.chang.changpro.cache.adapter.recyclerview.BaseAdapterHelper;
import com.pro.chang.changpro.cache.adapter.recyclerview.QuickAdapter;
import com.pro.chang.changpro.cache.divider.HorizontalDividerItemDecoration;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class BeShowingActivity extends BaseToolbarActivity {
    private static final String TAG = "BeShowingActivity";
    private RecyclerView recyclerView;
    QuickAdapter<MovieData> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_showing);

        recyclerView = (RecyclerView) findViewById(R.id.be_showing_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .colorResId(android.R.color.transparent)
                .sizeResId(R.dimen.activity_horizontal_margin)
                .showLastDivider().build());

        adapter = new QuickAdapter<MovieData>(BeShowingActivity.this,
                R.layout.item_movie) {
            @Override
            protected void convert(BaseAdapterHelper helper, MovieData item) {
                helper.setImageWithUrl(BeShowingActivity.this, R.id.be_showing_item_poster, item.getImages().getMedium());
                helper.setText(R.id.be_showing_item_movie_name, item.getTitle());
                helper.setText(R.id.be_showing_item_director,item.getDirectors().get(0).getName());
                helper.setText(R.id.be_showing_item_tips,item.getMovieTips());
            }
        };



        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(DoubanFactory.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        MovieService service = retrofit.create(MovieService.class);
        Call<DoubanMovie> call = service.getBeShowing(0, 10);
        call.enqueue(new Callback<DoubanMovie>() {
            @Override
            public void onResponse(Response<DoubanMovie> response, Retrofit retrofit) {
                if (response.isSuccess()){
                   DoubanMovie movie =  response.body();
                    if (movie!=null){
                        adapter.addAll(movie.getSubjects());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage() );
            }
        });
    }


}
