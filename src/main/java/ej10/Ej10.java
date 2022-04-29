/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej10;

import ejercicios.ej4.Deportivo;
import ejercicios.ej4.Furgoneta;
import ejercicios.ej4.Turismo;
import ejercicios.ej4.Vehiculo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author hinda
 */
public class Ej10 {

    //metodos
    public static void crearDirectorio(String ruta) {
        Path file = Paths.get(ruta);
        try {
            if (!Files.exists(file)) {
                Files.createDirectory(file);
                System.out.println("el directorio se crea correctamente");
            }
        } catch (FileAlreadyExistsException faee) {
            System.out.println("no puede crear porque existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tienes permisos");
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    public static void borrarArchivos(String ruta) {
        Path file = Paths.get(ruta);
        try {
            Files.delete(file);
            System.out.println("deleted files");
        } catch (NoSuchFileException nsfe) {
            System.out.println("No puedes borrar el archivo porque no existe");
        } catch (DirectoryNotEmptyException dnee) {
            System.out.println("No puedes borrar el directorio porque es vacio");
        } catch (IOException e) {
            System.out.println("Error" + ruta + " " + e.getMessage());
        }
    }

    //añadir los catch necessarios
    public static void copiarFicherosEnDirectorio(String rutaOrigen, String rutaDestino) {
        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);

        try {
            Files.copy(origen, destino);
            System.out.println("archivos copiandos");
        } catch (DirectoryNotEmptyException dne) {
            System.out.println("no puede replace el fichero porque el directorio not empty");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //method check in directory exist and give you the name
    public static void listarDirectorio(String ruta) {
        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }

    public static ArrayList<Vehiculo> leerFicheros(String idFichero) {
        System.out.println("Leyendo el fichero: " + idFichero);

        String[] tokens;
        String linea;
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        try (Scanner datosFichero = new Scanner(new File(idFichero))) {
            //datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(";");
                Vehiculo v = null;

                switch (idFichero) {
                    case "copias/turismos.csv":
                        v = new Turismo();
                        break;

                    case "copias/deportivos.csv":
                        v = new Deportivo();
                        break;

                    case "copias/furgonetas.csv":
                        v = new Furgoneta();
                        break;
                    default:
                        break;
                }

                if (v instanceof Turismo) {
                    ((Turismo) v).setPuertas(Integer.parseInt(tokens[0]));
                    ((Turismo) v).setMarchaAutomatica(Boolean.parseBoolean(tokens[1]));
                    v.setMatricula(tokens[2]);
                    v.setMarca(tokens[3]);
                    v.setModelo(tokens[4]);
                    v.setColor(tokens[5]);
                    v.setTarifa(Double.parseDouble(tokens[6]));
                    v.setDisponible(Boolean.parseBoolean(tokens[7]));
                    vehiculos.add(v);
                } else if (v instanceof Deportivo) {
                    ((Deportivo) v).setCilindrada(Integer.parseInt(tokens[0]));
                    v.setMatricula(tokens[1]);
                    v.setMarca(tokens[2]);
                    v.setModelo(tokens[3]);
                    v.setColor(tokens[4]);
                    v.setTarifa(Double.parseDouble(tokens[5]));
                    v.setDisponible(Boolean.valueOf(tokens[6]));
                    vehiculos.add(v);
                } else if (v instanceof Furgoneta) {
                    ((Furgoneta) v).setCarga(Integer.parseInt(tokens[0]));
                    ((Furgoneta) v).setVolumen(Integer.parseInt(tokens[1]));
                    v.setMatricula(tokens[2]);
                    v.setMarca(tokens[3]);
                    v.setModelo(tokens[4]);
                    v.setColor(tokens[5]);
                    v.setTarifa(Double.parseDouble(tokens[6]));
                    v.setDisponible(Boolean.parseBoolean(tokens[7]));
                    vehiculos.add(v);
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }

    public static void main(String[] args) {
        // Creo el directorio
        crearDirectorio("copias");

        //Copiar los tres ficheros *.csv a un directorio previamente creado en “./copias”.
        copiarFicherosEnDirectorio("deportivos.csv", "copias/deportivos.csv");
        copiarFicherosEnDirectorio("furgonetas.csv", "copias/furgonetas.csv");
        copiarFicherosEnDirectorio("turismos.csv", "copias/turismos.csv");

        //Mostrar los ficheros contenidos en “copias”.
        System.out.println("\nlistar los ficheros de carpeta copias");
        listarDirectorio("copias");

        //Leer los ficheros de la carpeta “copias” e ir guardando los objetos en una lista de vehículos
        ArrayList<Vehiculo> listaFurgonetas = leerFicheros("copias/furgonetas.csv");
        ArrayList<Vehiculo> listaDeportivo = leerFicheros("copias/deportivos.csv");
        ArrayList<Vehiculo> listaTurismos = leerFicheros("copias/turismos.csv");

        ArrayList<Vehiculo> v = new ArrayList<>();
        v.addAll(listaFurgonetas);
        v.addAll(listaDeportivo);
        v.addAll(listaTurismos);

        //Imprimir la lista por pantalla.
        System.out.println("\nmostrar");
        v.forEach(System.out::println);

        //Ordena la lista por bastidor.
        System.out.println("\nordenar la lista segun matricula");
        Collections.sort(v, (v1, v2) -> v1.getMatricula().compareTo(v2.getMatricula()));
        v.forEach(System.out::println);

        //Borrar los ficheros *.csv originales.
        borrarArchivos("deportivos.csv");
        borrarArchivos("furgonetas.csv");
        borrarArchivos("turismos.csv");

        //Mostrar el contenido de la carpeta donde estaban los *.csv originales.
        listarDirectorio(".");

        //parte stream
        /*Usando Streams, realiza las siguientes acciones sobre la lista de vehículos:
          Imprime por pantalla todos los coches blancos, distintos, ordenador por matrícula.*/
         
        System.out.println("**********Parte Stream************");
        System.out.println("\nmostrar vehiculos blancos distintos ordenados con stream");
        v.stream()
                .filter(v1 -> v1.getColor().equalsIgnoreCase("blanco"))
                .distinct()
                .sorted((v1, v2) -> v1.getMatricula().compareTo(v2.getMatricula()))
                .forEach(System.out::println);
     

        //Imprime por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles. 
        System.out.println("list marcas");
           v.stream()
            .filter(coche-> coche.getDisponible())
            .map(v1 ->v1.getMarca())
            .distinct()
            .forEach(System.out::println);
                      

        // Saber la cantidad de vehículos Citroen.
        long cnt = v.stream()
                .filter(vl -> vl.getMarca().equalsIgnoreCase("citroen"))
                .count();
        System.out.println("\ncantidad:" + cnt);
        
        //Comprueba si hay algún Peugeot negro disponible en la lista.
        System.out.println("Hay Peugeot negro disponible?");
         boolean b=v.stream()
                    .filter(coche->coche.getDisponible())
                    .allMatch(vl->vl.getMarca().equalsIgnoreCase("Peugeot")&&vl.getColor().equalsIgnoreCase("negro")) ;
         System.out.println(b);
        
   
         
    }
}
