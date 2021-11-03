package com.example.actividadfragments;

import android.widget.ImageView;

public class Pelicula {
    private String titulo, sinopsis , director;
    private int imagen, nota;

    public Pelicula(String titulo, String sinopsis, String director, int imagen, int nota) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.director = director;
        this.imagen = imagen;
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        director = director;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
