/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author hinda
 */
public class Ej1 {

    public static void main(String[] args) throws IOException {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "amatriz.txt";
        String tmp;
        // Array a escribir
        int matrizNumeros[][] ={{100, 101, 102, 103, 104}, {200, 201, 202, 203, 204},
        {300, 301, 302, 303, 304}, {400, 401, 402, 403, 404},{500, 501, 502, 503, 504}};

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < matrizNumeros.length; i++) {
                for (int j = 0; j < matrizNumeros[i].length; j++) {
                    tmp = String.valueOf(matrizNumeros[i][j]);
                    if (j == matrizNumeros[i].length - 1) {
                        flujo.write(tmp);
                    } else {
                        flujo.write(tmp + " ");
                    }
                }

                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
