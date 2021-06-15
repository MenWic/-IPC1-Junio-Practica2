package com.example.model;

public class cliente {
    private String nombre;
    private double id;
    private int telefono;
    private boolean tienePeliculasPrestado;
    public cliente(String nombre, double id, int telefono, boolean tienePeliculasPrestado) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.tienePeliculasPrestado = tienePeliculasPrestado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public boolean isTienePeliculasPrestado() {
        return tienePeliculasPrestado;
    }
    public void setTienePeliculasPrestado(boolean tienePeliculasPrestado) {
        this.tienePeliculasPrestado = tienePeliculasPrestado;
    }

    
    

}
