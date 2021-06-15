package com.example.model;

public class prestamoPelicula {
    private int idpelicula;
    private int idcliente;
    private int diasprestado;
    public prestamoPelicula(int idpelicula, int idcliente, int diasprestado) {
        this.idpelicula = idpelicula;
        this.idcliente = idcliente;
        this.diasprestado = diasprestado;
    }
    public int getIdpelicula() {
        return idpelicula;
    }
    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }
    public int getIdcliente() {
        return idcliente;
    }
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public int getDiasprestado() {
        return diasprestado;
    }
    public void setDiasprestado(int diasprestado) {
        this.diasprestado = diasprestado;
    }
    

    
}
