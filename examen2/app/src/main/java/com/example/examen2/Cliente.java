package com.example.examen2;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int dni;
    private String nombre;
    private String direccion;
    private String tfno;

    public Cliente() {
    }

    public Cliente(int dni, String nombre, String direccion, String tfno) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tfno = tfno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTfno() {
        return tfno;
    }

    public void setTfno(String tfno) {
        this.tfno = tfno;
    }

    @Override
    public String toString() {
        return dni + "-" + nombre+"-"+direccion+"-"+tfno ;
    }
}
