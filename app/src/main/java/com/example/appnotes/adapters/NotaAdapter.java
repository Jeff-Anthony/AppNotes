package com.example.appnotes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnotes.R;
import com.example.appnotes.models.Nota;

import java.security.PublicKey;
import java.util.List;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {

    private Button button_favorite, button_archivado;

    private List<Nota> notas;
    public NotaAdapter(List<Nota> notas){
        this.notas = notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titulo;
        public TextView contenido;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.nota_titulo);
            contenido = itemView.findViewById(R.id.nota_informacion);

        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Nota nota = this.notas.get(position);
        viewHolder.titulo.setText(nota.getTitulo());
        viewHolder.contenido.setText(nota.getContenido());



    }

    @Override
    public int getItemCount() {
        return this.notas.size();
    }



}
