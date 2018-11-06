package com.testvk.romansmolakov.testvk.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.testvk.romansmolakov.testvk.MyApplication;
import com.testvk.romansmolakov.testvk.R;
import com.testvk.romansmolakov.testvk.common.BaseAdapter;
import com.testvk.romansmolakov.testvk.model.WallItem;
import com.testvk.romansmolakov.testvk.model.view.NewsItemBodyViewModel;
import com.testvk.romansmolakov.testvk.rest.api.WallApi;
import com.testvk.romansmolakov.testvk.rest.model.request.WallGetRequestModel;
import com.testvk.romansmolakov.testvk.rest.model.response.WallGetResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFeedFragment extends BaseFragment {

    @Inject
    WallApi mWallApi;

    RecyclerView mRecyclerView;

    BaseAdapter mABasedapter;


    public NewsFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get(new WallGetRequestModel(-86529522).toMap()).enqueue(new Callback<WallGetResponse>() {
            @Override
            public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {
                List<NewsItemBodyViewModel> list = new ArrayList<>();

                for (WallItem item : response.body().response.getItems()) {

                    list.add(new NewsItemBodyViewModel(item));

                }

                mABasedapter.addItems(list);
            }

            @Override
            public void onFailure(Call<WallGetResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }


    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

    private void setUpRecyclerView(View rootView) {

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }

    protected void setUpAdapter(RecyclerView rv) {

        mABasedapter = new BaseAdapter();

        rv.setAdapter(mABasedapter);

    }

}
