package com.example.examen2;

public class Clima {
    private String fecha, hora, estadoCielo, localidad, icono;
    private int tempMax, temMin, temp;

    public Clima(String fecha, String hora, String estadoCielo, int tempMax, int temMin, int temp, String icono) {
        this.fecha = fecha;
        this.hora = hora;
        this.estadoCielo = estadoCielo;
        this.tempMax = tempMax;
        this.temp = temp;
        this.temMin = temMin;
        this.icono = icono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstadoCielo() {
        return estadoCielo;
    }

    public void setEstadoCielo(String estadoCielo) {
        this.estadoCielo = estadoCielo;
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

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
