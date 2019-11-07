package com.example.appnotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appnotes.R;
import com.example.appnotes.repositories.UserRepository;

public class RegistroActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText nombres;
    private EditText correo;
    private EditText contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        usuario = findViewById(R.id.registro_usuario);
        nombres = findViewById(R.id.registro_nombre);
        correo = findViewById(R.id.registro_correo);
        contraseña = findViewById(R.id.registro_contraseña);

    }



    public void callRegister(View view){
        String usuario_registro = usuario.getText().toString();
        String nombre_registro = nombres.getText().toString();
        String correo_registro = correo.getText().toString();
        String contraseña_registro = contraseña.getText().toString();

        if(usuario_registro.isEmpty() || nombre_registro.isEmpty() || correo_registro.isEmpty()|| contraseña_registro.isEmpty()){
            Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show();
            return;
        }else{

            Toast.makeText(this, "Registro realizado con Exito !!", Toast.LENGTH_SHORT).show();

        }

        UserRepository.create(usuario_registro, nombre_registro, correo_registro, contraseña_registro);

        finish();

    }

}
