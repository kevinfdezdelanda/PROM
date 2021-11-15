package com.example.examenkevin;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import java.util.Objects;

public class Localidad {
    private String ciudad, provinica, zona, enlace;
    private Drawable img;

    public Localidad(String ciudad, String provinica, String zona, Drawable img, String enlace) {
        this.ciudad = ciudad;
        this.provinica = provinica;
        this.zona = zona;
        this.enlace = enlace;
        this.img = img;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvinica() {
        return provinica;
    }

    public void setProvinica(String provinica) {
        this.provinica = provinica;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return ciudad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidad localidad = (Localidad) o;
        return provinica.equals(localidad.provinica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinica);
    }
}
