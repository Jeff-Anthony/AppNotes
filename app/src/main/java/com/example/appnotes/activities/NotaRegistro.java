package com.example.appnotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appnotes.R;
import com.example.appnotes.repositories.NotaRepository;
import com.example.appnotes.repositories.UserRepository;

public class NotaRegistro extends AppCompatActivity {

    private EditText titulo;
    private EditText contenido;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_registro);

       titulo = findViewById(R.id.titulo_nota);
       contenido = findViewById(R.id.contenido_nota);



    }


    public void callRegisterNotas(View view){

        String  titulo_registro = titulo.getText().toString();
        String contenido_registro = contenido.getText().toString();


        if(titulo_registro.isEmpty() || contenido_registro.isEmpty()){
            Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show();
            return;
        }else{

            Toast.makeText(this, "Registro de Nota Realizado", Toast.LENGTH_SHORT).show();

        }

        NotaRepository.createnota(titulo_registro, contenido_registro);
        finish();

    }

}
