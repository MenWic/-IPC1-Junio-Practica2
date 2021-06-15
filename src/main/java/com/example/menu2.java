package com.example;
import java.util.Random;
import java.util.Scanner;

import com.example.model.categoria;
import com.example.model.cliente;
import com.example.model.pelicula;
import com.example.model.prestamo;
public class menu2 {
    final int TAMAÑO=30;
    Scanner scanner=new Scanner(System.in);
    cliente[] clientes=new cliente[TAMAÑO];
    pelicula[] peliculas=new pelicula[TAMAÑO];
    prestamo[] prestamos=new prestamo[TAMAÑO];
    categoria[] categorias=new categoria[TAMAÑO];
    int contador_clientes=0;
    int contador_peliculas=0;
    int contador_categoria=0;
    int contador_prestamos=0;
    public menu2() {
    }

    public void menu_usuario(){
        int opcion=0;

        while (true) {
            System.out.println("\n************ Menu ************\n");
            System.out.println(" 1. Ingresar Clientes nuevos ");
            System.out.println(" 2. Mostrar Clientes  ");
            System.out.println(" 3. Ingreso de Peliculas ");
            System.out.println(" 4. Mostrar Peliculas ");
            System.out.println(" 5. Prestamo de Peliculas ");
            System.out.println(" 6. Devolucion de Peliculas ");
            System.out.println(" 7. Ordenar Peliculas ascendentemente");
            System.out.println(" 8. Reportes ");
            System.out.println(" 9. Nueva Categoria ");
            System.out.println(" 10. Mostrar Categorias ");
            System.out.println("\n   ************ ************   \n");
          try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Se esperaba un numero");
            }

            switch (opcion) {
                case 1:
                    ingresoNewCliente();
                    break;
                case 2:
                    mostrarCliente();
                    break;
                case 3:
                    ingresoPelis();
                    break;    
                case 4:
                    mostrarPelis();
                    break;    
                case 5:
                    prestamoPelis();
                    break;
                case 6:
                    devolucionPelis();
                    break;
                case 7:
                    System.out.println("Esta opcion no esta disponible");
                    break; 
                case 8:
                    reportes();
                    break;
                case 9:
                    ingresoCategoria();
                    break;
                case 10:
                    mostrarCategorias();
                    break;
                default:
                    prestamos();
                    break;    
            }
        }
    }

    public void ingresoNewCliente(){
        System.out.println("\n************ Nuevo cliente ************\n");
        Random r = new Random();
        int sid=r.nextInt(11);
        // System.out.println(sid);
        String nombre;
        int telefono;
        double id=Math.random();
        try {
            System.out.println("Ingrese el nombre del cliente");
            nombre = scanner.next();
            System.out.println("Ingrese el telefono del cliente");
            telefono= scanner.nextInt();
            try {
                clientes[contador_clientes]=new cliente(nombre, id, telefono,false);
                contador_clientes++;
                System.out.println("Usuario ingresado correctamente");
            } catch (Exception e) {
                System.out.println("Ya no se puede registrar ningun cliente, buffer lleno");
            }

        } catch (Exception e) {
            System.out.println("datos incorrectos");
        }
        System.out.println("\n   ************ ************   \n"); 
    }

    public void ingresoCategoria(){
        System.out.println("\n************ Nueva categoria ************\n");
        Random r = new Random();
        String nombre;
        int id=r.nextInt(11);
        try {
            System.out.println("Ingrese el nombre del la categoria");
            nombre = scanner.next();
            try {
                categorias[contador_categoria]=new categoria(id,nombre);
                contador_categoria++;
                System.out.println("Categoria ingresada exitosamente");
            } catch (Exception e) {
                System.out.println("Ya no se puede registrar ninguna categoria, buffer lleno");
            }

        } catch (Exception e) {
            System.out.println("datos incorrectos");
        }
        System.out.println("\n   ************ ************   \n"); 
    }

    public void mostrarCliente(){
        System.out.println("\n************ Lista de clientes ************\n");
        System.out.println("ID - NOMBRE - TELEFONO - TIENE PELICULAS PRESTADAS");
        try {
            for(int i=0; i<clientes.length;i++)
            {
                System.out.println(clientes[i].getId()+" - "+clientes[i].getNombre()+" - "+clientes[i].getTelefono()+" - "+clientes[i].isTienePeliculasPrestado());
            }
        } catch (Exception e) {
            System.out.println("Ya no hay mas clientes");
        }
        System.out.println("\n   ************ ************   \n"); 
    }

    public void mostrarCategorias(){
        System.out.println("\n************ Lista de categorias ************\n");
        System.out.println("INDEX - ID - NOMBRE");
        try {
            for(int i=0; i<categorias.length;i++)
            {
                System.out.println(i+" - "+categorias[i].getId()+" - "+categorias[i].getNombre());
            }
        } catch (Exception e) {
            System.out.println("Ya no hay mas categorias");
        }
        System.out.println("\n   ************ ************   \n"); 
    }

    public void ingresoPelis(){
        System.out.println("\n************ Ingreso de peliculas ************\n");
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
            boolean existe=false;
            try {
                for (int i = 0; i < categorias.length; i++) {
                    if(categorias[i].getNombre().equals(categoria)){
                        existe=true;
                    }
                } 
            } catch (Exception e) {
                // System.out.println("Categoria no existe");
            }
            if(existe){
                System.out.println("Ingrese disponibilidad de la pelicula");
                try {
                    disponible= scanner.nextBoolean();
                    try {
                        peliculas[contador_peliculas]=new pelicula(id,nombre, año, categoria,disponible);
                        contador_peliculas++;
                        System.out.println("Pelicula ingresada correctamente");
                    } catch (Exception e) {
                        System.out.println("Ya no se puede alquila ninguna pelicula, buffer lleno");
                    }
                } catch (Exception e) {
                    System.out.println("Se esperaba true o false"); 
                }
            }
        } catch (Exception e) {
            System.out.println("Datos incorrectos");
            System.out.println("hubo un error al agregar nueva pelicula");
        }
        System.out.println("\n   ************ ************   \n");    
    }

    public void mostrarPelis(){
        System.out.println("\n************ Lista de peliculas ************\n");
        System.out.println("INDEX - ID - NOMBRE - AÑO - CATEGORIA - DISPONIBILIDAD");
        try {
            for(int i=0; i<peliculas.length;i++)
            {
                System.out.println(i+" - "+peliculas[i].getId()+" - "+peliculas[i].getNombre()+" - "+peliculas[i].getAño()+" - "+peliculas[i].getCategoria()+" - "+peliculas[i].isDisponible());
            }
        } catch (Exception e) {
            System.out.println("Ya no hay mas peliculas");
        }
        System.out.println("\n   ************ ************   \n");        
    }

    public void prestamoPelis(){
        System.out.println("\n************ Prestar peliculas ************\n");
        String peliculaprestada="";
        String nombrecliente="";
        int dias;
        mostrarPelis();
        try {
            System.out.println("Ingrese el nombre de la pelicula");
            peliculaprestada = scanner.next();
        } catch (Exception e) {
            System.out.println("datos incorrectos");
        }

        try {
            for(int i=0; i<peliculas.length;i++)
            {
                if(peliculas[i].getNombre().equals(peliculaprestada)){
                    if(peliculas[i].isDisponible()){
                        try {
                            System.out.println("Ingrese el nombre del cliente que va a prestar la pelicula");
                            nombrecliente = scanner.next();
                        } catch (Exception e) {
                            System.out.println("datos incorrectos se esperaban caracteres no enteros");
                        }
                        try {
                            for(int j=0; j<clientes.length;j++)
                            {
                                
                                if(clientes[j].getNombre().equals(nombrecliente)){
                                    try {
                                        System.out.println("Ingrese el numero de dias que se va alquilar la pelicula");
                                        dias = scanner.nextInt();
                                        prestamos[contador_prestamos]=new prestamo(clientes[j].getId(), peliculas[i].getId(), dias);
                                        contador_prestamos++;
                                        clientes[j].setTienePeliculasPrestado(true);
                                        peliculas[i].setDisponible(false);
                                        System.out.println("Pelicula alquilada exitosamente");
                                    } catch (Exception e) {
                                        System.out.println("datos incorrectos se esperaba un numero y no caracteres");
                                    }

                                }else{
                                    System.out.println("cliente no encontrado");
                                }
                            }
                        } catch (Exception e) {
                            // System.out.println("Ya no hay mas clientes");
                        }
                    }else{
                        System.out.println("la pelicula no se encuentra disponible para alquilar");
                    }    
                }else{
                    // System.out.println("pelicula no encontrada");
                }
            }
        } catch (Exception e) {
            // System.out.println("Ya no hay mas peliculas");
        }
        System.out.println("\n   ************ ************   \n");
    }

    public void devolucionPelis() {
        System.out.println("\n************ Devolucion de pelicula ************\n");
        String peliculaprestada="";
        String nombrecliente="";
        mostrarPelis();
        try {
            System.out.println("Ingrese el nombre de la pelicula a devolver");
            peliculaprestada = scanner.next();
        } catch (Exception e) {
            System.out.println("datos incorrectos");
        }

        try {
            for(int i=0; i<peliculas.length;i++)
            {
                if(peliculas[i].getNombre().equals(peliculaprestada)){
                    if(!peliculas[i].isDisponible()){
                        try {
                            System.out.println("Ingrese el nombre del cliente que va a devolver la pelicula");
                            nombrecliente = scanner.next();
                        } catch (Exception e) {
                            System.out.println("datos incorrectos se esperaban caracteres no enteros");
                        }
                        try {
                            for(int j=0; j<clientes.length;j++)
                            {
                                if(clientes[j].getNombre().equals(nombrecliente)){
                                    clientes[j].setTienePeliculasPrestado(false);
                                    peliculas[i].setDisponible(true);
                                    System.out.println("Pelicula devuelta exitosamente");
                                }else{
                                    System.out.println("cliente no encontrado");
                                }
                            }
                        } catch (Exception e) {
                            // System.out.println("Ya no hay mas clientes");
                        }
                    }else{
                        System.out.println("la pelicula se encuntra ya disponible para alquilar");
                    }    
                }else{
                    // System.out.println("pelicula no encontrada");
                }
            }
        } catch (Exception e) {
            System.out.println("Ya no hay mas peliculas");
        }
        System.out.println("\n   ************ ************   \n");
    }

    public void ordenAscendentePelis() {
        System.out.println("\n************ Ordenar las peliculas ascendentemente ************\n");
        System.out.println("ID - NOMBRE - AÑO - CATEGORIA - DISPONIBILIDAD");
        // pelicula[] peliculasordenadas=new pelicula[TAMAÑO];
        try {
            for(int i=0; i<peliculas.length;i++)
            {   
                // if(peliculas[i].getNombre().charAt(0)){
                    
                // }
                System.out.println(peliculas[i].getId()+" - "+peliculas[i].getNombre()+" - "+peliculas[i].getAño()+" - "+peliculas[i].getCategoria()+" - "+peliculas[i].isDisponible());
            }
        } catch (Exception e) {
            System.out.println("Ya no hay mas peliculas");
        }
        System.out.println("\n   ************ ************   \n"); 
    }


    public void reportes() {
        int opcion=0;
        System.out.println("\n************ Repotes Menu ************\n");
        System.out.println(" 1. Cantidad de películas por categoría ");
        System.out.println(" 2. Las películas de una categoría en específico  ");
        System.out.println(" 3. Reporte de las películas y la cantidad de veces que se presta ");
        System.out.println(" 4. Reporte de la película más prestada ");
        System.out.println(" 5. Reporte de la película menos prestada ");
        System.out.println(" 6. Menu principal ");
        System.out.println("\n   ************ ************   \n");
      try {
            opcion = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Se esperaba un numero");
        }

        switch (opcion) {
            case 1:
                cantidadPeliculasxCategoria();
                break;
            case 2:
                cantidadPeliculasxCategoriaEnEspecifico();
                break;
            case 3:
                cantidadVeces();
                break;    
            case 4:
                peliculaMasPrestada();
                break;    
            case 5:
                peliculaMenosPrestada();
                break;
            case 6:
                break;
        }
    }

    public void cantidadPeliculasxCategoria() {
        System.out.println("\n************ Cantidad de peliculas por categoria ************\n");
        System.out.println("ID - NOMBRE - NO PELICULAS");

            try {
                for (int i = 0; i < categorias.length; i++) {
                    int cantidad_libros=0;
                    try {
                        for (int j = 0; j < peliculas.length; j++) {
                            if(categorias[i].getNombre().equals(peliculas[j].getCategoria())){
                                cantidad_libros++;
                            }
                        } 
                    } catch (Exception e) {
                        System.out.println(categorias[i].getId()+" - "+categorias[i].getNombre()+" - "+cantidad_libros);    
                    }                
                }
            } catch (Exception e) {
            System.out.println("ya no hay mas categorias");
        }
        System.out.println("\n   ************ ************   \n"); 
    }

    public void cantidadPeliculasxCategoriaEnEspecifico() {
        System.out.println("\n************ Cantidad de peliculas de una categoria en especifico ************\n");
        System.out.println("Ingrese nombre de la categoria");
        String categoria="";
            try {
                categoria=scanner.next();
            } catch (Exception e) {
                System.out.println("Error se esperaba texto");
            }
            System.out.println("ID - NOMBRE - NO PELICULAS");
            try {
                for (int i = 0; i < categorias.length; i++) {
                    if(categorias[i].getNombre().equals(categoria)){
                        int cantidad_libros=0;
                        try {
                            for (int j = 0; j < peliculas.length; j++) {
                                if(categorias[i].getNombre().equals(peliculas[j].getCategoria())){
                                    cantidad_libros++;
                                }
                            } 
                        } catch (Exception e) {
                            System.out.println(categorias[i].getId()+" - "+categorias[i].getNombre()+" - "+cantidad_libros);    
                        }
                    }                
                }
            } catch (Exception e) {
            System.out.println("ya no hay mas categorias");
        }
        System.out.println("\n   ************ ************   \n"); 
    }

    public void prestamos() {
        System.out.println("\n************ Prestamos ************\n");
        System.out.println("INDEX - ID USUARIO - ID PELICULA - TIEMPO");
        try {
            for(int i=0; i<prestamos.length;i++)
            {
                      System.out.println(i+" - "+prestamos[i].getId_usuario()+" - "+prestamos[i].getId_pelicula()+" - "+prestamos[i].getDias());
            }
        } catch (Exception e) {
            System.out.println("Ya no hay mas prestamos");
        } 
        System.out.println("\n   ************ ************   \n");        
    }

    public void cantidadVeces() {
        System.out.println("\n************ Reporte de las películas y la cantidad de veces que se presta ************\n");
        System.out.println("NOMBRE - AÑO - CATEGORIA - CANTIDAD PRESTADA");
        try {
            for(int i=0; i<peliculas.length;i++)
            {
                int cantidad=0;
                try {
                    for (int j = 0; j < prestamos.length; j++) {
                        if(prestamos[j].getId_pelicula()==peliculas[i].getId())
                        {
                            cantidad++;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(peliculas[i].getNombre()+" - "+peliculas[i].getAño()+" - "+peliculas[i].getCategoria()+" - "+cantidad);
                }  
            }
        } catch (Exception e) {
            System.out.println("Ya no hay mas peliculas");
        }
        System.out.println("\n   ************ ************   \n");    
    }

    public void peliculaMasPrestada() {
        System.out.println("\n************ Reporte de la película más prestada ************\n");
        System.out.println("NOMBRE - AÑO - CATEGORIA");
        int index=0;
        int cantidadmaxima=0;
        try {
            for(int i=0; i<peliculas.length;i++)
            { 
                peliculas[i].getNombre();
                int cantidad=0;
                try {
                    for (int j = 0; j < prestamos.length; j++) {
                        if(prestamos[j].getId_pelicula()==peliculas[i].getId())
                        {
                            cantidad++;
                        }
                    }
                } catch (Exception e) {
                    if(cantidad>=cantidadmaxima){
                        index=i;
                        cantidadmaxima=cantidad;
                    }
                }  
            }
        } catch (Exception e) {
            // System.out.println("Ya no hay mas peliculas");
            System.out.println(peliculas[index].getNombre()+" - "+peliculas[index].getAño()+" - "+peliculas[index].getCategoria());
        }
        System.out.println("\n   ************ ************   \n");    
    }

    public void peliculaMenosPrestada() {
        System.out.println("\n************ Reporte de la película menos prestada ************\n");
        System.out.println("NOMBRE - AÑO - CATEGORIA");
        int index=0;
        int cantidadmaxima=0;
        try {
            for(int i=0; i<peliculas.length;i++)
            {
                peliculas[i].getNombre(); 
                int cantidad=0;
                try {
                    for (int j = 0; j < prestamos.length; j++) {
                        if(prestamos[j].getId_pelicula()==peliculas[i].getId())
                        {
                            cantidad++;
                        }
                    }
                } catch (Exception e) {
                    if(cantidad<=cantidadmaxima){
                        index=i;
                        cantidadmaxima=cantidad;
                    }
                }  
            }
        } catch (Exception e) {
            // System.out.println("Ya no hay mas peliculas");
            System.out.println(peliculas[index].getNombre()+" - "+peliculas[index].getAño()+" - "+peliculas[index].getCategoria());
        }
        System.out.println("\n   ************ ************   \n");    
    }
    
}
