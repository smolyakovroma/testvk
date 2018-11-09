package com.testvk.romansmolakov.testvk;

import android.app.Application;

import com.testvk.romansmolakov.testvk.di.component.ApplicationComponent;
import com.testvk.romansmolakov.testvk.di.component.DaggerApplicationComponent;
import com.testvk.romansmolakov.testvk.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);

        Realm.init(this);

        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private void initComponent() {

        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

    }

    public static ApplicationComponent getApplicationComponent() {

        return sApplicationComponent;

    }
}
