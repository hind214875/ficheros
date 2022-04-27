/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej9;

import ejercicios.ej4.Deportivo;
import ejercicios.ej4.Furgoneta;
import ejercicios.ej4.Turismo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hinda
 */
public class Ej9 {

    //metodos
     public static void escrituraFicheroFurgunetas(ArrayList<Furgoneta> lista) {
        // Ficheros a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "furgonitas.csv";

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            //flujo.newLine();
            //recorrer la lista de vehiculos generada y escribir en el fichero
            for (Furgoneta obj : lista) {
                flujo.write(obj.getCarga()+ ";"+obj.getVolumen()+";"+obj.getMatricula()+";"+obj.getMarca()+";"+obj.getModelo()+";"+obj.getColor()
                +";"+obj.getTarifa()+";"+obj.getDisponible());
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
             flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void escrituraFicheroTurismos(ArrayList<Turismo> lista) {
        // Ficheros a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "turismos.csv";

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            // flujo.newLine();
            //recorrer la lista de vehiculos generada y escribir en el fichero
            for (Turismo obj : lista) {
                flujo.write(obj.getPuertas()+";"+obj.isMarchaAutomatica()+";"+obj.getMatricula()+";"+obj.getMarca()+";"+obj.getModelo()+";"+obj.getColor()
                +";"+obj.getTarifa()+";"+obj.getDisponible());
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void escrituraFicheroDeportivos(ArrayList<Deportivo> lista) {
        // Ficheros a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "deportivos.csv";

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            // flujo.newLine();
            //recorrer la lista de vehiculos generada y escribir en el fichero
            for (Deportivo obj : lista) {
                flujo.write(obj.getCilindrada()+";"+obj.getMatricula()+";"+obj.getMarca()+";"+obj.getModelo()+";"+obj.getColor()
                +";"+obj.getTarifa()+";"+obj.getDisponible());
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
  
    public static void main(String[] args) {
        // Fichero a leer con datos de ejemplo
        ArrayList<Deportivo> deportivos = new ArrayList<>();
        ArrayList<Turismo> turismos = new ArrayList<>();
        ArrayList<Furgoneta> furgonetas = new ArrayList<>();
        
        String idFichero = "vehiculos.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero))) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                tokens = linea.split(":");

                switch (linea.charAt(0)) {
                    case '0':
                        Turismo turismo = new Turismo();
                        turismo.setPuertas(Integer.parseInt(tokens[0].substring(4)));
                        turismo.setMarchaAutomatica(Boolean.parseBoolean(tokens[1]));
                        turismo.setMatricula(tokens[2]);
                        turismo.setMarca(tokens[3]);
                        turismo.setModelo(tokens[4]);
                        turismo.setColor(tokens[5]);
                        turismo.setTarifa(Double.parseDouble(tokens[6]));
                        turismo.setDisponible(Boolean.parseBoolean(tokens[7]));

                        turismos.add(turismo);
                        break;
                    case '1':
                        Deportivo deportivo = new Deportivo();
                        deportivo.setCilindrada(Integer.parseInt(tokens[0].substring(4)));
                        deportivo.setMatricula(tokens[1]);
                        deportivo.setMarca(tokens[2]);
                        deportivo.setModelo(tokens[3]);
                        deportivo.setColor(tokens[4]);
                        deportivo.setTarifa(Double.parseDouble(tokens[5]));
                        deportivo.setDisponible(Boolean.parseBoolean(tokens[6]));
                        deportivos.add(deportivo);
                        break;
                    case '2':
                        Furgoneta furgoneta = new Furgoneta();
                        furgoneta.setCarga(Integer.parseInt(tokens[0].substring(4)));
                        furgoneta.setVolumen(Integer.parseInt(tokens[1]));
                        furgoneta.setMatricula(tokens[2]);
                        furgoneta.setMarca(tokens[3]);
                        furgoneta.setModelo(tokens[4]);
                        furgoneta.setColor(tokens[5]);
                        furgoneta.setTarifa(Double.parseDouble(tokens[6]));
                        furgoneta.setDisponible(Boolean.parseBoolean(tokens[7]));
                        furgonetas.add(furgoneta);
                        break;
                    default:
                        break;
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("furgonetas");
        furgonetas.forEach(System.out::println);
        System.out.println("turismos");
        turismos.forEach(System.out::println);
        System.out.println("deportivos");
        deportivos.forEach(System.out::println);
        
        //write the 3 ficheros
          escrituraFicheroFurgunetas(furgonetas);
          escrituraFicheroTurismos(turismos);
          escrituraFicheroDeportivos(deportivos);
    }

}
