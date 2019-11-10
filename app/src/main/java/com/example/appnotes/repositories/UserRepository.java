package com.example.appnotes.repositories;

import com.example.appnotes.models.Nota;
import com.example.appnotes.models.User;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class UserRepository{


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

public  static User findByUsername(String username){
        List<User> users = SugarRecord.listAll(User.class);
        for(User user : users){

                if(user.getUsuario().equalsIgnoreCase(username)){

                        return user;

}
        }
        return null;
}

}
