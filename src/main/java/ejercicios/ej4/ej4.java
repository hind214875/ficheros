/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.ej4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author hinda
 */
public class ej4 {
    public static void main(String[] args) {
      //Crea 30 vehículos (10 Turismos, 10 Deportivos y 10 Furgonetas)
      //con valores de tu elección y guárdalos en una lista de objetos tipo Vehiculo.
      Vehiculo t1 = new Turismo("345674", "4060 TUR", "Skoda", "Fabia", 90.00, false, 2, true);
      Vehiculo t2 = new Turismo("563214", "3020 TUR", "HYUNDAI", "Fabia", 90.00, false, 2, true);
      Vehiculo t3 = new Turismo("123456", "2010 TUR", "Nissan", "Fabia", 90.00, false, 2, true);
      Vehiculo t4 = new Turismo("654321", "7852 TUR", "SUZUKI", "Fabia", 90.00, false, 2, true);
      Vehiculo t5 = new Turismo("456789", "3652 TUR", "Mercedes", "Fabia", 90.00, false, 2, true);
      Vehiculo t6 = new Turismo("987654", "4785 TUR", "Audi", "Fabia", 90.00, false, 2, true);
      Vehiculo t7 = new Turismo("159874", "2365 TUR", "Skoda", "Fabia", 90.00, false, 2, true);
      Vehiculo t8 = new Turismo("357896", "9563 TUR", "Audi", "Fabia", 90.00, false, 2, true);
      Vehiculo t9 = new Turismo("147852", "4562 TUR", "Clio", "Fabia", 90.00, false, 2, true);
      Vehiculo t10 = new Turismo("369852", "7452 TUR", "Skoda", "Fabia", 90.00, false, 2, true);
      
      Vehiculo d1 = new Deportivo(2, "HG4568", "Mercedes", "wv", "blue", 100.00, true);
      Vehiculo d2 = new Deportivo(2, "JH2531", "Audi", "wv", "Rojo", 100.00, true);
      Vehiculo d3 = new Deportivo(2, "LK58635", "Dacia", "wv", "Blanco", 100.00, true);
      Vehiculo d4 = new Deportivo(2, "NB52314", "Mercedes", "wv", "blue", 100.00, true);
      Vehiculo d5 = new Deportivo(2, "HN2132", "Dacia", "wv", "Rojo", 100.00, true);
      Vehiculo d6 = new Deportivo(2, "AB2531", "Mercedes", "wv", "blue", 100.00, true);
      Vehiculo d7 = new Deportivo(2, "WE5321", "Clio", "wv", "Blanco", 100.00, true);
      Vehiculo d8 = new Deportivo(2, "RT5656", "Audi", "wv", "Negro", 100.00, true);
      Vehiculo d9 = new Deportivo(2, "AS1234", "Clio", "wv", "blue", 100.00, true);
      Vehiculo d10 = new Deportivo(2, "CV5321", "Audi", "wv", "Negro", 100.00, true);
      
      Furgoneta f1 = new Furgoneta(10, 20,"JH5234", "furgoneta", "dgd" ,"Rojo", 500, false);
      Furgoneta f2 = new Furgoneta(10, 20,"JK15489", "furgoneta", "dgd" ,"verde", 500, false);
      Furgoneta f3 = new Furgoneta(10, 20,"LM2135", "furgoneta", "dgd" ,"Blanco", 500, false);
      Furgoneta f4 = new Furgoneta(10, 20,"FG5897", "furgoneta", "dgd" ,"Negro", 500, false);
      Furgoneta f5 = new Furgoneta(10, 20,"AS1234", "furgoneta", "dgd" ,"verde", 500, false);
      Furgoneta f6 = new Furgoneta(10, 20,"FG2541", "furgoneta", "dgd" ,"Rojo", 500, false);
      Furgoneta f7 = new Furgoneta(10, 20,"HN2132", "furgoneta", "dgd" ,"Blanco", 500, false);
      Furgoneta f8 = new Furgoneta(10, 20,"JK15489", "furgoneta", "dgd" ,"Rojo", 500, false);
      Furgoneta f9 = new Furgoneta(10, 20,"EF2534", "furgoneta", "dgd" ,"Blanco", 500, false);
      Furgoneta f10 = new Furgoneta(10, 20,"DF4521", "furgoneta", "dgd" ,"verde", 500, false);
      
      ArrayList<Vehiculo> lista=new ArrayList<>();
      Collections.addAll(lista,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10);
      
      /*Guarda los vehículos en un fichero de texto llamado “vehículos.txt”, haciendo uso del método polimórfico toString(), 
      teniendo en cuenta que el string devuelto lleve separados los campos del objeto por el carácter dos puntos (:).*/
      
      String idFichero="vehiculos.txt";
      
      /*
      Cada línea del fichero estará compuesta por un número, un espacio, un guión, un espacio y los datos del vehículo en cuestión. El número de cada línea será 0, 1 o 2 si el objeto es un Turismo, un Deportivo o una Furgoneta, respectivamente. 
       Cada vehículo irá en una línea distinta del fichero.

      */
      
       try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
           int cnt=0;
           for (Vehiculo obj : lista) {
               flujo.write(cnt+" - "+obj.toString());
               flujo.newLine();
               cnt++;
           }
           // Metodo fluh()
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
           
       }catch(IOException e){
           System.out.println(e.getMessage());
       }
      
    }
}
