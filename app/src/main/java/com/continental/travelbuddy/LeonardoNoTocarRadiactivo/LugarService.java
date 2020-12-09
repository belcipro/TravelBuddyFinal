package com.continental.travelbuddy.LeonardoNoTocarRadiactivo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LugarService {

    @GET("Identidad_Cultural/Lista_Lugares.php")
    Call<LugarResponse> getPark();

}
