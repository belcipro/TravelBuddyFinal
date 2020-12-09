package com.continental.travelbuddy.ui.slideshow;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.continental.travelbuddy.LeonardoNoTocarRadiactivo.ApiClient;
import com.continental.travelbuddy.LeonardoNoTocarRadiactivo.HeaderAdapter;
import com.continental.travelbuddy.LeonardoNoTocarRadiactivo.ListarLugarTuristicoActivity;
import com.continental.travelbuddy.LeonardoNoTocarRadiactivo.LugarModel;
import com.continental.travelbuddy.LeonardoNoTocarRadiactivo.LugarResponse;
import com.continental.travelbuddy.R;
import com.continental.travelbuddy.adapter.InfoAdapter;
import com.continental.travelbuddy.adapter.UsuariosAdapter;
import com.continental.travelbuddy.model.Info;
import com.continental.travelbuddy.model.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class InfoFragment extends Fragment {
    private HeaderAdapter headerAdapter;

    RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_info, container, false);
        recyclerView= (RecyclerView)root.findViewById(R.id.recyclerView);
        obtenerLugares();
        return root;
    }

    private void response(ArrayList<LugarModel> lugarModel) {


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<LugarModel> myDataset = new ArrayList<>();
        for (LugarModel c : lugarModel) {
            myDataset.add(new LugarModel(c.getID_Lugar_Turistico(), c.getLT_Nombre(), c.getLT_Descripcion(),c.getLT_Hora_Inicio(),c.getLT_Hora_Fin()));
        }

        headerAdapter = new HeaderAdapter(myDataset);
        recyclerView.setAdapter(headerAdapter);
    }

    private void obtenerLugares() {
        Call<LugarResponse> call = ApiClient.getLugar().getPark();
        call.enqueue(new Callback<LugarResponse>() {
            @Override
            public void onResponse(Call<LugarResponse> call, retrofit2.Response<LugarResponse> response) {
                if (response.isSuccessful()) {
                    LugarResponse parkResponse = response.body();
                    response(parkResponse.getRecords());
                } else {
                    String message = "Error al cargar información";
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LugarResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
