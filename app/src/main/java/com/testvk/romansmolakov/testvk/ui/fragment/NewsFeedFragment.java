package com.testvk.romansmolakov.testvk.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.testvk.romansmolakov.testvk.MyApplication;
import com.testvk.romansmolakov.testvk.R;
import com.testvk.romansmolakov.testvk.common.BaseAdapter;
import com.testvk.romansmolakov.testvk.common.utils.VkListHelper;
import com.testvk.romansmolakov.testvk.consts.ApiConstants;
import com.testvk.romansmolakov.testvk.model.WallItem;
import com.testvk.romansmolakov.testvk.model.view.BaseViewModel;
import com.testvk.romansmolakov.testvk.model.view.NewsItemBodyViewModel;
import com.testvk.romansmolakov.testvk.model.view.NewsItemFooterViewModel;
import com.testvk.romansmolakov.testvk.model.view.NewsItemHeaderViewModel;
import com.testvk.romansmolakov.testvk.rest.api.WallApi;
import com.testvk.romansmolakov.testvk.rest.model.request.WallGetRequestModel;
import com.testvk.romansmolakov.testvk.rest.model.response.GetWallResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;



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

        mWallApi.get(new WallGetRequestModel(ApiConstants.YOUR_GROUP_ID).toMap()).enqueue(new Callback<GetWallResponse>() {
            @Override
            public void onResponse(Call<GetWallResponse> call, Response<GetWallResponse> response) {
                List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
                List<BaseViewModel> list = new ArrayList<>();

                for (WallItem item : wallItems) {
                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsItemBodyViewModel(item));
                    list.add(new NewsItemFooterViewModel(item));
                }
                mAdapter.addItems(list);
                Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<GetWallResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }





    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }
}
