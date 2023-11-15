package com.example.pizzeria.model;


import java.util.ArrayList;

public class Pizza {
    private String nombre;
    private String tamanio;
    private int precio;
    private ArrayList<String> ingredientes;

    public Pizza() {
    }

    public Pizza(String nombre) {
        this.nombre = nombre;
    }

    public Pizza(String nombre, String tamanio, int precio, ArrayList<String> ingredientes) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.precio = precio;
        this.ingredientes = ingredientes;
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

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
