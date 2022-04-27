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
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

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
            System.out.println("No puedes borrar " + ruta + " porque no existe");
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
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //rellenar la lista de vehiculo depende de tipos
    public static void rellenarArrays(){
        
    }
    
    public static ArrayList<Vehiculo> leerFicheros(String idFichero) {
        System.out.println("Leyendo el fichero: " + idFichero);

        String[] tokens;
        String linea;
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        try ( Scanner datosFichero = new Scanner(new File(idFichero))) {
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(";");
                
                switch (idFichero) {                   
                    case "turismos.csv":
                        Turismo turismo = new Turismo();
                        turismo.setPuertas(Integer.parseInt(tokens[0]));
                        turismo.setMarchaAutomatica(Boolean.parseBoolean(tokens[1]));
                        turismo.setMatricula(tokens[2]);
                        turismo.setMarca(tokens[3]);
                        turismo.setModelo(tokens[4]);
                        turismo.setColor(tokens[5]);
                        turismo.setTarifa(Double.parseDouble(tokens[6]));
                        turismo.setDisponible(Boolean.parseBoolean(tokens[7]));

                        vehiculos.add(turismo);
                        break;
                        
                    case "deportivos.csv":
                        Deportivo deportivo = new Deportivo();
                        deportivo.setCilindrada(Integer.parseInt(tokens[0]));
                        deportivo.setMatricula(tokens[1]);
                        deportivo.setMarca(tokens[2]);
                        deportivo.setModelo(tokens[3]);
                        deportivo.setColor(tokens[4]);
                        deportivo.setTarifa(Double.parseDouble(tokens[5]));
                        deportivo.setDisponible(Boolean.valueOf(tokens[6]));

                        vehiculos.add(deportivo);
                        break;
                        
                    case "furgonitas.csv":
                        Furgoneta furgoneta = new Furgoneta();
                        furgoneta.setCarga(Integer.parseInt(tokens[0]));
                        furgoneta.setVolumen(Integer.parseInt(tokens[1]));
                        furgoneta.setMatricula(tokens[2]);
                        furgoneta.setMarca(tokens[3]);
                        furgoneta.setModelo(tokens[4]);
                        furgoneta.setColor(tokens[5]);
                        furgoneta.setTarifa(Double.parseDouble(tokens[6]));
                        furgoneta.setDisponible(Boolean.parseBoolean(tokens[7]));
                        vehiculos.add(furgoneta);
                        break;
                }

            }
            System.out.println("size" + vehiculos.size());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }

    public static void main(String[] args) {
        //Copiar los tres ficheros *.csv a un directorio previamente creado en “./copias”.
        crearDirectorio("copias");
        copiarFicherosEnDirectorio("deportivos.csv", "copias/deportivos.csv");
        copiarFicherosEnDirectorio("furgonitas.csv", "copias/furgonitas.csv");
        copiarFicherosEnDirectorio("turismos.csv", "copias/turismos.csv");

        //Leer los ficheros de la carpeta “copias” e ir guardando los objetos en una lista de vehículos
        ArrayList<Vehiculo> aux = new ArrayList<>();
        aux = leerFicheros("copias/furgonitas.csv");
        aux = leerFicheros("copias/deportivos.csv");
        aux = leerFicheros("copias/turismos.csv");
        //Imprimir la lista por pantalla. 
        aux.forEach(System.out::println);
        //Ordena la lista por bastidor.
        //leerFicheroBufferReader();

        //Borrar los ficheros *.csv originales.
        borrarArchivos("deportivos.csv");
        borrarArchivos("furgonitas.csv");
        borrarArchivos("turismos.csv");

    }
}
