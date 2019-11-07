package com.example.appnotes.repositories;

import com.example.appnotes.models.Nota;
import com.example.appnotes.models.User;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class UserRepository{
    private static List<User> users = new ArrayList<>();
    private static List<Nota> notas = new ArrayList<>();
    public static List<Nota> lista(){
        List<Nota> notas = SugarRecord.listAll(Nota.class);
        return notas;
    }
    public static List<User> list(){

        return users;
    }

static {
        users.add(new User("Jeff"," Llanos Orihuela","jeffllanos21@gmail.com", "jeffllanos"));
        }

public static User Login(String usuario, String contraseña){
        List<User> users = SugarRecord.listAll(User.class);
        for(User user : users){

        if(user.getUsuario().equalsIgnoreCase(usuario) && user.getContraseña().equals(contraseña)){

        return user;

        }

        }
        return null;
        }

public static void create(String usuario,String nombres, String correo,String contraseña){
        User user = new User(usuario, nombres, correo,contraseña);
        SugarRecord.save(user);
    }

    public static void createnota(String titulo,String contenido){
        Nota nota = new Nota(titulo,contenido);
        SugarRecord.save(nota);
    }

}
