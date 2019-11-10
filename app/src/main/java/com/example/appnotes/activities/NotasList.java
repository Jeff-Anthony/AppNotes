package com.example.appnotes.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.appnotes.R;
import com.example.appnotes.adapters.NotaAdapter;
import com.example.appnotes.fragments.fragment_archivado;
import com.example.appnotes.fragments.fragment_favorite;
import com.example.appnotes.fragments.fragment_home;
import com.example.appnotes.models.Nota;
import com.example.appnotes.repositories.NotaRepository;
import com.example.appnotes.repositories.UserRepository;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class NotasList extends AppCompatActivity {

    private static final String TAG = NotasList.class.getSimpleName();

    private static final int REGISTER_FORM_REQUEST = 100;


    private BottomNavigationView menu_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_list);


        menu_items = findViewById(R.id.menu_items);
        menu_items.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_home:
                        fragment_home();
                        break;

                    case R.id.item_favorite:
                        fragment_favorite();
                        break;

                    case R.id.item_archivados:
                        fragment_archivados();
                        break;
                }
                return;
            }
        });


    }
    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, NotaRegistro.class), REGISTER_FORM_REQUEST);
    }




    public void fragment_home(){
        FragmentManager frag= getSupportFragmentManager();
        Fragment fragment1=new fragment_home();
        frag.beginTransaction().replace(R.id.content, fragment1).commit();

    }

    public  void fragment_favorite(){

        FragmentManager frag= getSupportFragmentManager();
        Fragment fragment2=new fragment_favorite();
        frag.beginTransaction().replace(R.id.content, fragment2).commit();

    }

    public void fragment_archivados(){

        FragmentManager frag= getSupportFragmentManager();
        Fragment fragment3=new fragment_archivado();
        frag.beginTransaction().replace(R.id.content, fragment3).commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =  item.getItemId();
        switch (id){

            case R.id.logout_item:
                callLogout();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    private void callLogout(){

        SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(this);
        sf.edit().remove("islogged").commit();
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }




}
