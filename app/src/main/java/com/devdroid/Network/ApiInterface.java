package com.devdroid.Network;

import com.devdroid.abp.ModelClass.mainNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String BASE_URL="https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<mainNews> getNews(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<mainNews> getCategoryNews(
            @Query("q") String country,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<mainNews> getEverything(
            @Query("q") String country,
            @Query("apiKey") String apiKey
    );

}
