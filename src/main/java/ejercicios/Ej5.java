/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hinda
 */
public class Ej5 {
    public static void main(String[] args) {
        /* 5.- Implementa un programa para leer los datos del fichero del ejercicio 1. 
         El programa, al finalizar de leer la matriz debe mostrar la suma de todos los valores.*/

        // Fichero a leer con datos de ejemplo
        String idFichero = "amatriz.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        int sum = 0;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(" ");
                for (String obj : tokens) {
                    System.out.print(obj + "\t");
                    sum+=Integer.valueOf(obj);
                }
                System.out.println();
               
            }
             System.out.println("la suma es: "+sum);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
     
}
