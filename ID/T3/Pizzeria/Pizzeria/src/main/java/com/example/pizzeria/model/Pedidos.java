package com.example.pizzeria.model;

import java.util.ArrayList;

public class Pedidos {
    private int id;
    private String nombre;
    private String telefono;
    private Pizza pizzaPedido;

    public Pedidos() {
    }

    public Pedidos(int id, String nombre, String telefono, Pizza pizzaPedido) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pizzaPedido = pizzaPedido;
    }

    @Override
    public String toString() {
        return id +"\n"+ nombre +"\n" + telefono +"\n" + pizzaPedido+ "\n" ;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Pizza getPizzaPedido() {
        return pizzaPedido;
    }

    public void setPizzaPedido(Pizza pizzaPedido) {
        this.pizzaPedido = pizzaPedido;
    }
}
