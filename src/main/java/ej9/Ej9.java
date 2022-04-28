/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej9;

import ejercicios.ej4.Deportivo;
import ejercicios.ej4.Furgoneta;
import ejercicios.ej4.Turismo;
import ejercicios.ej4.Vehiculo;
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
    public static void escrituraFichero(String idFichero,ArrayList<Vehiculo> lista){
        
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            // flujo.newLine();
            //recorrer la lista de vehiculos generada y escribir en el fichero
            for (Vehiculo obj : lista) {
                flujo.write(obj.toString());
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
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        ArrayList<Vehiculo> deportivos = new ArrayList<>();
        ArrayList<Vehiculo> turismos = new ArrayList<>();
        ArrayList<Vehiculo> furgonetas = new ArrayList<>();
        
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

      
        vehiculos.forEach(obj -> {
            if(obj instanceof Turismo){
                turismos.add((Turismo) obj);
                
            }else if(obj instanceof Deportivo){
                deportivos.add((Deportivo) obj);
            }else{
                furgonetas.add((Furgoneta) obj);            
            }
        });
          
           escrituraFichero("furgonetas.csv",furgonetas);
           escrituraFichero("turismos.csv",turismos);
           escrituraFichero("deportivos.csv",deportivos);
          
          
          
    }

}
