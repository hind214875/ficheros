/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author hinda
 */
public class Ej3 {
    public static void main(String[] args) {
        /* Implementa un programa que guarde exactamente 75 líneas de texto en un fichero, 
        cuyo nombre se deja a tu elección. 
        En cada línea se irán generando letras aleatorias (entre la ‘a’ y la ‘Z’)
        y se irán separando por punto y coma (;)
        hasta que la letra que se vaya a escribir sea ‘g’ o ‘G’. 
        En este caso, se escribe y se saltará a la línea siguiente. 
        Posibles ejemplos de líneas generadas:
 
    a;C;T;B;D;s;u;i;w;g
    Q;w;e;r;t;y;S;H;J;K;G
         */
        String idFichero = "ej3.txt";
        Random rd = new Random();
        char letra;
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < 75; i++) {
                letra = (char) (rd.nextInt(90 - 65 + 1) + 65);
                flujo.write(letra + ";");
                if (letra == 'g' || letra == 'G') {
                    flujo.newLine();
                }              
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
         System.out.println("Termina!");

    }
}
