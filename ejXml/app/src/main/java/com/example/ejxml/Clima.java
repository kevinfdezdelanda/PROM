package com.example.ejxml;

public class Clima {

    private String fecha;
    private int tempMax, temMin;

    public Clima(String fecha, int tempMax, int temMin) {
        this.fecha = fecha;
        this.tempMax = tempMax;
        this.temMin = temMin;
    }

    public Clima() {}

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTemMin() {
        return temMin;
    }

    public void setTemMin(int temMin) {
        this.temMin = temMin;
    }
}
