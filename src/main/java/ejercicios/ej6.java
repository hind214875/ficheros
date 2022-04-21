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
public class ej6 {

    /*6.- Implementa un programa que lea el fichero del ejercicio 3 y muestre el contenido del fichero.
 Además buscará la primera ocurrencia, en cada línea, de las letras seguidas 
‘w’, ‘e’, ‘b’, informando de la posición que ocupan en la línea, si es que existe esa ocurrencia.*/
    public static void main(String[] args) {
        //fichero a leer
        String idFichero = "ej3.txt";

        // Variables para guardar los datos que se van leyendo
        String linea;
        String[] tokens;

        System.out.println("Leyendo el fichero: " + idFichero);
   
        try (Scanner sc = new Scanner(new File(idFichero), "UTF-8")) {
            //while there is line for read
            while (sc.hasNextLine()) {
                //save the line in a String
                linea = sc.nextLine();
                //take every caracter and save it in a array of String
                tokens = linea.split(";");
                //recorrer el token and show the strings
                for (int i=0;i<tokens.length;i++) {
                    System.out.print(tokens[i] + " ");
                    //matches("regex") return true
                    if (tokens[i].matches("w e| W E")) {
                        System.out.println("la posicion es: "+i);
                    }
                }
                System.out.println();
                

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int buscarPattern(String[] lista) {
        int posicion = -1;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].contentEquals("w g")) {
                posicion = i;
                return posicion;
            }
        }
        return posicion;
    }

}
