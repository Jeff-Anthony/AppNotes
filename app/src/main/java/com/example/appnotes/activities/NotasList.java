package com.example.appnotes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appnotes.R;
import com.example.appnotes.adapters.NotaAdapter;
import com.example.appnotes.models.Nota;
import com.example.appnotes.repositories.UserRepository;

import java.util.List;

public class NotasList extends AppCompatActivity {

    private static final String TAG = NotasList.class.getSimpleName();

    private static final int REGISTER_FORM_REQUEST = 100;

    private RecyclerView notasList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_list);

        notasList = findViewById(R.id.RecycleView);
        notasList.setLayoutManager(new LinearLayoutManager(this));
        List<Nota> notas = UserRepository.lista();
        notasList.setAdapter(new NotaAdapter(notas));

        NotaAdapter notaAdapter = (NotaAdapter) notasList.getAdapter();
        List<Nota> nota = UserRepository.lista();
        notaAdapter.setNotas(nota);
        notaAdapter.notifyDataSetChanged();

    }



}
