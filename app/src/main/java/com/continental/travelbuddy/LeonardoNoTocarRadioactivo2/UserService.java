package com.continental.travelbuddy.LeonardoNoTocarRadioactivo2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("Usuario/Update_Usuario.php/")
    Call<PerfilResponse> updateUser(@Body PerfilRequest perfilRequest);
}
