/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author hinda
 */
public class Ej2 {

    public static void main(String[] args) {
        /*2.- Implementa un programa que vaya escribiendo líneas de texto en un archivo.
            El archivo se llamará “teclado.txt” y se creará en la raíz del proyecto.
            El programa irá solicitando líneas de texto al usuario
            (cada línea termina con un salto de línea , ‘\n’) y las irá escribiendo en el fichero. 
            Cuando en una nueva línea el usuario introduzca el texto “EOF”,
            el programa terminará y esa línea no se escribirá en el fichero.
            Controla las posibles excepciones que pudieran ocurrir.*/

        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "teclado.txt";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            String txt=" ";
            do {
                System.out.println("Escribe que quieres");
                Scanner sc = new Scanner(System.in);
                txt = sc.nextLine();
                if((!txt.equals("EOF"))){
                   flujo.write(txt); 
                }    
                flujo.newLine();
            } while ((!txt.equals("EOF")));

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Termina!");
    }
}
