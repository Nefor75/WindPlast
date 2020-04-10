package com.glumy.windplast.connection;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("pubinfo?json&exchange&coursid=5")
    Call<List<Post>> getPosts();
}
