package com.continental.travelbuddy.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.continental.travelbuddy.LeonardoNoTocarRadioactivo2.ApiClient;
import com.continental.travelbuddy.LeonardoNoTocarRadioactivo2.LoginResponse;
import com.continental.travelbuddy.LeonardoNoTocarRadioactivo2.PerfilActivity;
import com.continental.travelbuddy.LeonardoNoTocarRadioactivo2.PerfilRequest;
import com.continental.travelbuddy.LeonardoNoTocarRadioactivo2.PerfilResponse;
import com.continental.travelbuddy.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfigFragment extends Fragment {
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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_config, container, false);
        edtNombre = root.findViewById(R.id.edtNombre);
        edtApellidos = root.findViewById(R.id.edtApellidos);
        edtDireccion = root.findViewById(R.id.edtDireccion);
        edtFechaNacimiento = root.findViewById(R.id.edtFechaNacimiento);
        edtNacionalidad = root.findViewById(R.id.edtNacionalidad);
        edtTelefono = root.findViewById(R.id.edtTelefono);
        edtEmail = root.findViewById(R.id.edtEmail);
        btnActualizar = root.findViewById(R.id.btnActualizar);

        id_usuario_login = getActivity().getIntent().getStringExtra("id");

        Toast.makeText(getContext(),  id_usuario_login , Toast.LENGTH_SHORT).show();

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
        return root;
    }
    public void updateUser(PerfilRequest perfilRequest){

        Call<PerfilResponse> perfilResponseCall = ApiClient.getService().updateUser(perfilRequest);
        perfilResponseCall.enqueue(new Callback<PerfilResponse>() {
            @Override
            public void onResponse(Call<PerfilResponse> call, Response<PerfilResponse> response) {
                if (response.isSuccessful()){
                    String message = "Se actualizo correctamente";
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                }else{
                    String message = "Error al actualizar";
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PerfilResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

    }
}