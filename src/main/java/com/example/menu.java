package com.example;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.example.model.cliente;
import com.example.model.pelicula;


public class menu {

    Scanner scanner=new Scanner(System.in);
    ArrayList<cliente> clientes=new ArrayList<cliente>();
    ArrayList<pelicula> peliculas=new ArrayList<pelicula>();
    public menu() {
        
    }

    public void menu_usuario(){
        int opcion=0;

        while (true) {
            System.out.println("\n************ Menu ************\n");
            System.out.println(" 1. Prestamo de Peliculas ");
            System.out.println(" 2. Devolucion de Peliculas ");
            System.out.println(" 3. Mostrar Peliculas ");
            System.out.println(" 4. Ingreso de Peliculas ");
            System.out.println(" 5. Ordenar Peliculas ascendentemente ");
            System.out.println(" 6. Ingresar Clientes nuevos ");
            System.out.println(" 7. Mostrar Clientes ");
            System.out.println(" 8. Reportes ");
            System.out.println(" 9. Salir\n ");
            System.out.println("\n   ************ ************   \n");
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Se esperaba un numero");
            }

            switch (opcion) {
                case 1:
                    prestamoPelis();
                    break;
                // case 2:
                //     devolucionPelis();
                //     break;
                case 3:
                    mostrarPelis();
                    break;    
                case 4:
                     ingresoPelis();
                    break;    
                // case 5:
                    // ordenAscendentePelis();
                    // break;
                case 6:
                    ingresoNewCliente();
                    break;
                case 7:
                    mostrarCliente(); 
                    break; 
                // case 8:
                //     reportes();
                //     break;
            }
        }
    }

    public void ingresoNewCliente(){
        String nombre;
        int telefono;
        double id=Math.random();
        try {
            System.out.println("Ingrese el nombre del cliente");
            nombre = scanner.next();
            System.out.println("Ingrese el telefono del cliente");
            telefono= scanner.nextInt();
            clientes.add(new cliente(nombre, id, telefono,false));
        } catch (Exception e) {
            System.out.println("datos incorrectos");
        }
    }

    public void mostrarCliente(){
        System.out.println("Lista de clientes");
        Iterator<cliente> iterator=clientes.iterator();
        while (iterator.hasNext()) {
            cliente cliente=iterator.next();
            System.out.println(cliente.getNombre());
            System.out.println(cliente.getTelefono());
        }

    }

    public void ingresoPelis(){
        double id=Math.random();
        String nombre;
        int año;
        String categoria;
        boolean disponible;
        try {
            System.out.println("Ingrese el nombre de la pelicula");
            nombre = scanner.next();
            System.out.println("Ingrese año de la pelicula");
            año= scanner.nextInt();
            System.out.println("Ingrese categoria de la pelicula");
            categoria= scanner.next();
            System.out.println("Ingrese disponibilidad de la pelicula");
            disponible= scanner.nextBoolean();
            peliculas.add(new pelicula(id,nombre, año, categoria,disponible));
        } catch (Exception e) {
            System.out.println("datos incorrectos");
        }
    }

    public void mostrarPelis(){
        System.out.println("Lista de peliculas");
        Iterator<pelicula> iterator=peliculas.iterator();
        while (iterator.hasNext()) {
            pelicula pelicula=iterator.next();
            System.out.println(pelicula.getNombre());
            System.out.println(pelicula.getAño());
            System.out.println(pelicula.getCategoria());
            System.out.println(pelicula.isDisponible());
        }

    }

    public void prestamoPelis(){
        String peliculaprestada="";
        String nombrecliente="";
        mostrarPelis();
        try {
            System.out.println("Ingrese el nombre de la pelicula");
            peliculaprestada = scanner.next();
        } catch (Exception e) {
            System.out.println("datos incorrectos");
        }
        Iterator<pelicula> iterator=peliculas.iterator();
        while (iterator.hasNext()) {
            pelicula pelicula=iterator.next();
            if(pelicula.getNombre().equals(peliculaprestada)){
                try {
                    System.out.println("Ingrese el nombre del cliente que va a prestar la pelicula");
                    nombrecliente = scanner.next();
                } catch (Exception e) {
                    System.out.println("datos incorrectos");
                }
                Iterator<cliente> iteratorcliente=clientes.iterator();
                while (iteratorcliente.hasNext()) {
                    cliente cliente=iteratorcliente.next();
                    if(cliente.getNombre().equals(nombrecliente)){
                        cliente.setTienePeliculasPrestado(true);
                        clientes.set(clientes.indexOf(iteratorcliente.next()), cliente);
                        pelicula.setDisponible(false);
                        peliculas.set(peliculas.indexOf(iterator.next()), pelicula);  
                    }else{
                        System.out.println("cliente no match");
                    }
                }
                System.out.println("no se encontro a ningun cliente con ese nombre");
            }else{
                System.out.println("pelicula no match");
            }
        }
    }


    
}
