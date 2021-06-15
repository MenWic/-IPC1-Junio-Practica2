package com.example.model;

public class prestamo {
    private double id_usuario;
    private double id_pelicula;
    private int dias;
    public prestamo(double id_usuario, double id_pelicula, int dias) {
        this.id_usuario = id_usuario;
        this.id_pelicula = id_pelicula;
        this.dias = dias;
    }
    public double getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(double id_usuario) {
        this.id_usuario = id_usuario;
    }
    public double getId_pelicula() {
        return id_pelicula;
    }
    public void setId_pelicula(double id_pelicula) {
        this.id_pelicula = id_pelicula;
    }
    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }

    
}
