package com.barney.trainingmovie.apiRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InstanceRetrofit {
//    private static final String Weburl = "https://api.themoviedb.org/3/movie/";
//
//    private static Retrofit setInit() {
//        return new  Retrofit.Builder()
//                .baseUrl(Weburl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//    public static ApiService getInstance() {
//        return setInit() .create(ApiService.class);}

    public static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(CONSTANT.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
