package com.testvk.romansmolakov.testvk.di.module;

import com.testvk.romansmolakov.testvk.rest.RestClient;
import com.testvk.romansmolakov.testvk.rest.api.WallApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RestModule {
    private RestClient mRestClient;


    public RestModule() {
        mRestClient = new RestClient();
    }


    @Provides
    @Singleton
    public RestClient provideRestClient() {
        return mRestClient;
    }

    @Provides

    @Singleton

    public WallApi provideWallApi() {

        return mRestClient.createService(WallApi.class);

    }
}