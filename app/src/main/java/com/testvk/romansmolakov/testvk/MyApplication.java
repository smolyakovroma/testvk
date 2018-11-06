package com.testvk.romansmolakov.testvk;

import android.app.Application;

import com.testvk.romansmolakov.testvk.di.component.ApplicationComponent;
import com.testvk.romansmolakov.testvk.di.component.DaggerApplicationComponent;
import com.testvk.romansmolakov.testvk.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;

public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);
    }

    private void initComponent() {

        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

    }

    public static ApplicationComponent getApplicationComponent() {

        return sApplicationComponent;

    }
}
