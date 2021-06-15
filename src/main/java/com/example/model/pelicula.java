package com.example.model;

public class pelicula {
    private double id;
    private String nombre;
    private int año;
    private String categoria;
    private boolean disponible;
    public pelicula(double id, String nombre, int año, String categoria, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.año = año;
        this.categoria = categoria;
        this.disponible = disponible;
    }
    public double getId() {
        return id;
    }
    public void setId(double id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    } 

    
}
