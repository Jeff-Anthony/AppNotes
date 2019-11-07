package com.example.appnotes.models;

import com.orm.dsl.Table;

@Table
public class User {

    private String usuario;
    private String nombres;
    private String correo;
    private String contraseña;

    public User(){



    }


    public User(String usuario, String nombres, String correo, String contraseña) {
        this.usuario = usuario;
        this.nombres = nombres;
        this.correo = correo;
        this.contraseña = contraseña;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    @Override
    public String toString() {
        return "User{" +
                "usuario='" + usuario + '\'' +
                ", nombres='" + nombres + '\'' +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
