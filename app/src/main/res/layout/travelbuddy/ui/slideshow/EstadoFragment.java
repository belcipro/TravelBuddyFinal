package com.continental.travelbuddy.ui.slideshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.continental.travelbuddy.LeonardoNoTocarRadiactivo.ApiClient;
import com.continental.travelbuddy.LeonardoNoTocarRadiactivo.HeaderAdapter;
import com.continental.travelbuddy.LeonardoNoTocarRadiactivo.LugarModel;
import com.continental.travelbuddy.LeonardoNoTocarRadiactivo.LugarResponse;
import com.continental.travelbuddy.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EstadoFragment extends AppCompatActivity {

    private HeaderAdapter headerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar_turistico_listar);

        obtenerLugares();
    }

    private void response(ArrayList<LugarModel> lugarModel){

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<LugarModel> myDataset = new ArrayList<>();
        for (LugarModel c: lugarModel) {
            myDataset.add(new LugarModel(c.getID_Lugar_Turistico(),c.getLT_Nombre(),c.getLT_Descripcion()));
        }

        headerAdapter = new HeaderAdapter(myDataset);
        recyclerView.setAdapter(headerAdapter);
    }

    private void obtenerLugares(){
        Call<LugarResponse> call = ApiClient.getLugar().getPark();
        call.enqueue(new Callback<LugarResponse>() {
            @Override
            public void onResponse(Call<LugarResponse> call, Response<LugarResponse> response) {
                if (response.isSuccessful()){
                    LugarResponse parkResponse= response.body();
                    response(parkResponse.getRecords());
                }else{
                    String message = "Error al cargar información";
                    Toast.makeText(EstadoFragment.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LugarResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(EstadoFragment.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

}