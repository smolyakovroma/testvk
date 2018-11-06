package com.testvk.romansmolakov.testvk.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.testvk.romansmolakov.testvk.CurrentUser;
import com.testvk.romansmolakov.testvk.mvp.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void chechAuth(){
        if(!CurrentUser.isAutorized()){
            getViewState().startSignIn();
        }else{
            getViewState().signedId();
        }
    }
}
