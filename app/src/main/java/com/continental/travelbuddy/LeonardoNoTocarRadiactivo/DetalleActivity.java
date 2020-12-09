package com.continental.travelbuddy.LeonardoNoTocarRadiactivo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

public class DetalleActivity extends AppCompatActivity {
    private TextView txtId;
    private TextView txtNombre,txtInicio,txtFin,txtDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity___lugar_turistico_detalles);

        String id = getIntent().getStringExtra("ID_Lugar_Turistico");

        txtId= findViewById(R.id.txtId);
        txtNombre= findViewById(R.id.txtNombre);
        txtDesc= findViewById(R.id.txtDesc);

        Toast.makeText(this, id , Toast.LENGTH_SHORT).show();
        obtenerDetalles("http://smartcityhyo.tk/api/Identidad_Cultural/Lista_Lugares_Id.php?id="+id);

    }

    public void obtenerDetalles(String url){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                                JSONArray jsonArray = response.getJSONArray("place");
                                JSONObject jsonObject = jsonArray.getJSONObject(0); //0 indica el primer objeto dentro del array.

                                final String url = jsonObject.getString("FG_URL");
                                txtId.setText("ID: " + jsonObject.getString("ID_Lugar_Turistico"));
                                txtNombre.setText(" " + jsonObject.getString("LT_Nombre"));
                            txtDesc.setText(" " + jsonObject.getString("LT_Descripcion"));


                            Button btnImage360;
                            btnImage360 = findViewById(R.id.btnImagen360);

                            btnImage360.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(DetalleActivity.this, Vista360Activity.class).putExtra("url", url));
                                    finish();
                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetalleActivity.this, "Error: " + error, Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

}