package com.continental.travelbuddy.LeonardoNoTocarRadiactivo;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://smartcityhyo.tk/api/")
                .build();
        return retrofit;
    }

    public static LugarService getLugar(){
        LugarService lugarService = getRetrofit().create(LugarService.class);

        return lugarService;
    }

}
