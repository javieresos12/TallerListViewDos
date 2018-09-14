package com.example.android.tallerlistviewdos;

public class Celular {
    private String marca;
    private String color;
    private String sistema_operativo;
    private int capacidad;
    private double precio;

    public Celular(String marca, String color, String sistema_operativo, int capacidad, double precio) {
        this.marca = marca;
        this.color = color;
        this.sistema_operativo = sistema_operativo;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSistema_operativo() {
        return sistema_operativo;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void guardar(){
       Datos.guardar(this);
    }
}
