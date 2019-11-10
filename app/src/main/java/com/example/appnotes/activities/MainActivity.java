package com.example.appnotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appnotes.R;
import com.example.appnotes.models.User;
import com.example.appnotes.repositories.UserRepository;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, contraseña;
    private Button ingresar, registrar;
    private TextView bienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);
        ingresar = findViewById(R.id.ingresar);
        registrar = findViewById(R.id.registrarse);

        bienvenido = findViewById(R.id.bienvenido_usuario);

        SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sf.getString("username", null);
        User user= UserRepository.findByUsername(username);
        if(user != null){

            bienvenido.setText("Bienvenido " + user.getNombres());

        }



        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showIngreso();
            }
        });


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegistro();
            }
        });


        loadLastUsername();
    }



    public void showIngreso(){

        String usuario_inicio= usuario.getText().toString();
        String contraseña_inicio=contraseña.getText().toString();

        if(usuario_inicio.isEmpty()){
            usuario.setError("Ingrese su Correo");
            Toast.makeText(this,"Ingrese su Usuario", Toast.LENGTH_SHORT);
            return;
        }
        if(contraseña_inicio.isEmpty()){
            contraseña.setError("Ingrese su Contaseña");
            Toast.makeText(this, "Ingrese su Contraseña",Toast.LENGTH_SHORT);
            return;
        }

        User usuario = UserRepository.Login(usuario_inicio,contraseña_inicio);

        if(usuario == null ){

            Toast.makeText(this,"Correo y/o cotraseña Invalida", Toast.LENGTH_SHORT).show();
            return;
        }


        SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(this);
        sf.edit()
                .putBoolean("islogged", true)
                .putString("usuario",usuario_inicio)
                .commit();



        startActivity(new Intent(this, NotasList.class));
        finish();

    }


    public void showRegistro(){

        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);

    }



    private  void  loadLastUsername(){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sp.getString("usuario", null);

        if(username != null){

            usuario.setText(username);
            contraseña.requestFocus();

        }

    }



}
