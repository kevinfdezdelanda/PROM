package com.example.examen2;

public class Factura {
    private int num;
    private String concepto;
    private double valor;
    private Cliente c;

    public Factura(int num, String concepto, double valor, Cliente c) {
        this.num = num;
        this.concepto = concepto;
        this.valor = valor;
        this.c = c;
    }

    public Factura() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Factura "+num+"";
    }
}
