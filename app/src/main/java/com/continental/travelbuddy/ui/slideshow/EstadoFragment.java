package com.continental.travelbuddy.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.continental.travelbuddy.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EstadoFragment extends Fragment {


    private EditText edtCiudad;
    private Button btnBuscar;
    private TextView txtClima1;
    private TextView txtClima2;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_estado, container, false);
        edtCiudad = root.findViewById(R.id.edtCiudad);
        btnBuscar = root.findViewById(R.id.btnBuscar);
        txtClima1 = root.findViewById(R.id.txtClima1);
        txtClima2 = root.findViewById(R.id.txtClima2);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerClima("http://api.openweathermap.org/data/2.5/weather?q="+edtCiudad.getText()+",pe&APPID=f493663e55a2e77ad50f0a84b8c117ed");
            }
        });
        return root;
    }
    public void obtenerClima (String url){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        //Toast.makeText(MainActivity.this, "Response: " + response, Toast.LENGTH_SHORT).show();

                        try {
                            JSONArray jsonArray = response.getJSONArray("weather");
                            JSONObject jsonObject = jsonArray.getJSONObject(0); //0 indica el primer objeto dentro del array.

                            txtClima1.setText("Clima: "+ jsonObject.getString("main"));
                            txtClima2.setText("Estado: "+ jsonObject.getString("description"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);
    }
}