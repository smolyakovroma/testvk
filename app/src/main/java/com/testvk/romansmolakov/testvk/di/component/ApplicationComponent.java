package com.testvk.romansmolakov.testvk.di.component;

import com.testvk.romansmolakov.testvk.common.manager.NetworkManager;
import com.testvk.romansmolakov.testvk.di.module.ApplicationModule;
import com.testvk.romansmolakov.testvk.di.module.ManagerModule;
import com.testvk.romansmolakov.testvk.di.module.RestModule;
import com.testvk.romansmolakov.testvk.mvp.presenter.BaseFeedPresenter;
import com.testvk.romansmolakov.testvk.mvp.presenter.NewsFeedPresenter;
import com.testvk.romansmolakov.testvk.ui.activity.BaseActivity;
import com.testvk.romansmolakov.testvk.ui.activity.MainActivity;
import com.testvk.romansmolakov.testvk.ui.fragment.NewsFeedFragment;
import com.testvk.romansmolakov.testvk.ui.holder.NewsItemBodyHolder;
import com.testvk.romansmolakov.testvk.ui.holder.NewsItemFooterHolder;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})//
public interface ApplicationComponent {

    void inject(BaseActivity activity);
    void inject(MainActivity activity);
    void inject(NewsFeedFragment fragment);
    void inject(NewsItemBodyHolder holder);
    void inject(NewsItemFooterHolder holder);
    void inject(NewsFeedPresenter presenter);
    void inject(NetworkManager manager);

}