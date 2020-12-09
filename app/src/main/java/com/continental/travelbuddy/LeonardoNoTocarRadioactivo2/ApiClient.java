package com.continental.travelbuddy.LeonardoNoTocarRadioactivo2;

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

    public static UserService getService(){
        UserService userService = getRetrofit().create(UserService.class);

        return userService;
    }


}

