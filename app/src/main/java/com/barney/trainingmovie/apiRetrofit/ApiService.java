package com.barney.trainingmovie.apiRetrofit;

import com.barney.trainingmovie.model.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie/upcoming")
    Call<ResponseMovie> getUpComingMovie(@Query("api_key") String apikey,
                                                            @Query("language") String language );

}
