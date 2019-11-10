package com.example.appnotes.repositories;

import com.example.appnotes.models.Nota;
import com.orm.SugarRecord;

import java.util.List;

public class NotaRepository{

    public static List<Nota> listar(){
        List<Nota> notas = SugarRecord.listAll(Nota.class);
        return notas;
    }



    public static void createnota(String titulo,String contenido){
        Nota nota = new Nota(titulo,contenido);
        SugarRecord.save(nota);
    }

}
