package com.example.appnotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import com.example.appnotes.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        }, 2000);

    }


    private void nextActivity(){

        SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(this);
        if(sf.getBoolean("islogged", false)){

            startActivity(new Intent(this,NotasList.class));

        }else{

            startActivity(new Intent(this,MainActivity.class));

        }
        finish();


    }


}
