package com.example.appnotes.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appnotes.R;
import com.example.appnotes.adapters.NotaAdapter;
import com.example.appnotes.models.Nota;
import com.example.appnotes.repositories.NotaRepository;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_home extends Fragment {

    private RecyclerView notasList;
    ArrayList<Nota> Listado;

    public fragment_home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home, container, false);

        Listado = new ArrayList<>();

        notasList=view.findViewById(R.id.RecycleView);
        notasList.setLayoutManager(new LinearLayoutManager(getContext()));


        NotaAdapter notaAdapter= new NotaAdapter(Listado);
        notasList.setAdapter(notaAdapter);

        llenarLista();
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        NotaAdapter adapter = (NotaAdapter)notasList.getAdapter();

        List<Nota> notas = NotaRepository.listar();
        adapter.setNotas(notas);
        adapter.notifyDataSetChanged();

    }




    private void llenarLista() {

        NotaAdapter notaAdapter = (NotaAdapter) notasList.getAdapter();
        List<Nota> nota = NotaRepository.listar();
        notaAdapter.setNotas(nota);
        notaAdapter.notifyDataSetChanged();
    }


}
