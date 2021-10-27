package com.example.whatsapp;

import android.widget.ImageView;

public class Contacto {
    private ImageView imagen;
    private String nombre, estado, ultMsg, fechaMsg, fechaLlamada, tipoUltimaLlamada;
    private int numMsg;

    public Contacto(ImageView imagen, String nombre, String estado, String ultMsg, String fechaMsg, String fechaLlamada, String tipoUltimaLlamada, int numMsg) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.estado = estado;
        this.ultMsg = ultMsg;
        this.fechaMsg = fechaMsg;
        this.fechaLlamada = fechaLlamada;
        this.tipoUltimaLlamada = tipoUltimaLlamada;
        this.numMsg = numMsg;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUltMsg() {
        return ultMsg;
    }

    public void setUltMsg(String ultMsg) {
        this.ultMsg = ultMsg;
    }

    public String getFechaMsg() {
        return fechaMsg;
    }

    public void setFechaMsg(String fechaMsg) {
        this.fechaMsg = fechaMsg;
    }

    public String getFechaLlamada() {
        return fechaLlamada;
    }

    public void setFechaLlamada(String fechaLlamada) {
        this.fechaLlamada = fechaLlamada;
    }

    public String getTipoUltimaLlamada() {
        return tipoUltimaLlamada;
    }

    public void setTipoUltimaLlamada(String tipoUltimaLlamada) {
        this.tipoUltimaLlamada = tipoUltimaLlamada;
    }

    public int getNumMsg() {
        return numMsg;
    }

    public void setNumMsg(int numMsg) {
        this.numMsg = numMsg;
    }
}
