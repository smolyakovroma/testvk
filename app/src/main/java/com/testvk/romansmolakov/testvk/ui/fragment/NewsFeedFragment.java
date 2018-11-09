package com.testvk.romansmolakov.testvk.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
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
import com.testvk.romansmolakov.testvk.mvp.presenter.BaseFeedPresenter;
import com.testvk.romansmolakov.testvk.mvp.presenter.NewsFeedPresenter;
import com.testvk.romansmolakov.testvk.rest.api.WallApi;
import com.testvk.romansmolakov.testvk.rest.model.request.WallGetRequestModel;
import com.testvk.romansmolakov.testvk.rest.model.response.GetWallResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;

    @InjectPresenter
    NewsFeedPresenter mPresenter;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mPresenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }





    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }
}
