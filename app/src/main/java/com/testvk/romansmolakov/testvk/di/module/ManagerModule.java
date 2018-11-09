package com.testvk.romansmolakov.testvk.di.module;

import com.testvk.romansmolakov.testvk.common.manager.MyFragmentManager;
import com.testvk.romansmolakov.testvk.common.manager.NetworkManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagerModule {
    @Provides
    @Singleton
    MyFragmentManager provideMyFragmentManager() {
        return new MyFragmentManager();
    }

    @Provides
    @Singleton
    NetworkManager provideNetworkManager() {
        return new NetworkManager();
    }
}