package com.example.listas_e_intents;

import android.widget.ImageView;

public class Contacto {
    private String nombre, correo_telf;
    private boolean esCorreo;

    public Contacto(String nombre, String correo_telf, boolean esCorreo) {
        this.nombre = nombre;
        this.correo_telf = correo_telf;
        this.esCorreo = esCorreo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo_telf() {
        return correo_telf;
    }

    public void setCorreo_telf(String correo_telf) {
        this.correo_telf = correo_telf;
    }

    public boolean isEsCorreo() {
        return esCorreo;
    }

    public void setEsCorreo(boolean esCorreo) {
        this.esCorreo = esCorreo;
    }
}
