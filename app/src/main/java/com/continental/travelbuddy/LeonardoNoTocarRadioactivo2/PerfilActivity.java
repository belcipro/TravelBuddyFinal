package com.continental.travelbuddy.LeonardoNoTocarRadioactivo2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.continental.travelbuddy.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilActivity extends AppCompatActivity {

    LoginResponse loginResponse;

    private EditText edtNombre;
    private EditText edtApellidos;
    private EditText edtDireccion;
    private EditText edtFechaNacimiento;
    private EditText edtNacionalidad;
    private EditText edtTelefono;
    private EditText edtEmail;

    private Button btnActualizar;

    String id_usuario_login = "No hay ID de usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity___perfil);

        edtNombre = findViewById(R.id.edtNombre);
        edtApellidos = findViewById(R.id.edtApellidos);
        edtDireccion = findViewById(R.id.edtDireccion);
        edtFechaNacimiento = findViewById(R.id.edtFechaNacimiento);
        edtNacionalidad = findViewById(R.id.edtNacionalidad);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtEmail = findViewById(R.id.edtEmail);
        btnActualizar = findViewById(R.id.btnActualizar);

        id_usuario_login = getIntent().getStringExtra("id");

        Toast.makeText(this,  id_usuario_login , Toast.LENGTH_SHORT).show();

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerfilRequest perfilRequest = new PerfilRequest();
                perfilRequest.setID_Usuario(id_usuario_login);
                perfilRequest.setUS_Nombres(edtNombre.getText().toString());
                perfilRequest.setUS_Apellidos(edtApellidos.getText().toString());
                perfilRequest.setUS_Direccion(edtDireccion.getText().toString());
                perfilRequest.setUS_Fecha_Nacimiento(edtFechaNacimiento.getText().toString());
                perfilRequest.setUS_Nacionalidad(edtNacionalidad.getText().toString());
                perfilRequest.setUS_Telefono(edtTelefono.getText().toString());
                perfilRequest.setUS_Email(edtEmail.getText().toString());
                updateUser(perfilRequest);
            }
        });

    }

    public void updateUser(PerfilRequest perfilRequest){

        Call<PerfilResponse> perfilResponseCall = ApiClient.getService().updateUser(perfilRequest);
        perfilResponseCall.enqueue(new Callback<PerfilResponse>() {
            @Override
            public void onResponse(Call<PerfilResponse> call, Response<PerfilResponse> response) {
                if (response.isSuccessful()){
                    String message = "Se actualizo correctamente";
                    Toast.makeText(PerfilActivity.this, message, Toast.LENGTH_SHORT).show();
                }else{
                    String message = "Error al actualizar";
                    Toast.makeText(PerfilActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PerfilResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(PerfilActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });


    }
}