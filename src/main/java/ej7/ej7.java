/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7;

import ejercicios.ej4.Deportivo;
import ejercicios.ej4.Furgoneta;
import ejercicios.ej4.Turismo;
import ejercicios.ej4.Vehiculo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author hinda
 */
public class ej7 {

    /*
     Realiza un programa que lea los datos del ejercicio 4. 
    Para ello creará una lista de objetos de tipo Vehículo. 
    El programa irá almacenando en la lista los objetos leídos desde el archivo de texto “vehículos.txt”.
    Una vez cargados todos los datos en la lista, ordena los vehículos por Marca y muestra el resultado por consola.

     */

    public static void main(String[] args) {
        // Fichero a leer con datos de ejemplo
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
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
                        turismo.setMatricula(tokens[0].substring(4));
                        turismo.setMarca(tokens[1]);
                        turismo.setModelo(tokens[2]);
                        turismo.setColor(tokens[3]);
                        turismo.setTarifa(Double.parseDouble(tokens[4]));
                        turismo.setDisponible(Boolean.parseBoolean(tokens[5]));
                        turismo.setPuertas(Integer.parseInt(tokens[6]));
                        turismo.setMarchaAutomatica(Boolean.parseBoolean(tokens[7]));
                        vehiculos.add(turismo);
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
                        vehiculos.add(deportivo);
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
                        vehiculos.add(furgoneta);
                        break;
                    default:
                        break;
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
         Collections.sort(vehiculos, (Vehiculo v1,Vehiculo v2)->v1.getMarca().compareTo(v2.getMarca()));
         vehiculos.forEach(System.out::println);
    }

}
