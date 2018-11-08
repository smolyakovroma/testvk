package com.testvk.romansmolakov.testvk.rest.api;

import com.testvk.romansmolakov.testvk.rest.model.response.GetWallResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Call<GetWallResponse> get(@QueryMap Map<String, String> map);
}
