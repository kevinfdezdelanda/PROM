package com.example.ej_ud02_dialogos;

import android.graphics.drawable.Drawable;

public class Kebab {
    private String nombre, ingredientes;
    private int img;

    public Kebab(String nombre, String ingredientes, int img) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
