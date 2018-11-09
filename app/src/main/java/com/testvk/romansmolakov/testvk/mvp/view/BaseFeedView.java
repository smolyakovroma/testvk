package com.testvk.romansmolakov.testvk.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.testvk.romansmolakov.testvk.model.view.BaseViewModel;

import java.util.List;

public interface BaseFeedView extends MvpView {
    void showRefreshing();

    void hideRefreshing();


    void showListProgress();

    void hideListProgress();


    void showError(String message);


    void setItems(List<BaseViewModel> items);

    void addItems(List<BaseViewModel> items);
}