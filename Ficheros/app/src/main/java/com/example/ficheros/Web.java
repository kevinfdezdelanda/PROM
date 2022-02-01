package com.example.ficheros;

import android.widget.ImageView;

public class Web {
    private String nombre, url, id;
    private ImageView imagen;

    public Web(String nombre, String url, String id, ImageView imagen ){
        this.nombre = nombre;
        this.url = url;
        this.id = id;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }
}
