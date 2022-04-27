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
      Vehiculo t1 = new Turismo(2,true,"345674","4060TUR","Clio","Fabia",90,false);
      Vehiculo t2 = new Turismo(2,true,"563214","3020TUR","HYUNDAI","Fabia",90,false);
      Vehiculo t3 = new Turismo(2,true,"123456","2010TUR","Nissan","Fabia",90,false);
      Vehiculo t4 = new Turismo(2,true,"654321","7852TUR","SUZUKI","Fabia",90,false);
      Vehiculo t5 = new Turismo(2,true,"456789","3652TUR","Mercedes","Fabia",90,false);
      Vehiculo t6 = new Turismo(2,true,"987654","4785TUR","Audi","Fabia",90,false);
      Vehiculo t7 = new Turismo(2,true,"159874","2365TUR","Clio","Fabia",90,false);
      Vehiculo t8 = new Turismo(2,true,"357896","9563TUR","Audi","Fabia",9,false);
      Vehiculo t9 = new Turismo(2,true,"147852","4562TUR","Clio","Fabia",90,false);
      Vehiculo t10 = new Turismo(2,true,"369852","7452TUR","Clio","Fabia",90,false);
      
      Vehiculo d1 = new Deportivo(2,"563214","Mercedes","wv","blue",100,true);
      Vehiculo d2 = new Deportivo(2,"369852","Audi","wv","Rojo",100,true);
      Vehiculo d3 = new Deportivo(2,"159874","Dacia","wv","Blanco",100,true);
      Vehiculo d4 = new Deportivo(2,"654321","Mercedes","wv","blue",100,true);
      Vehiculo d5 = new Deportivo(2,"563214","Dacia","wv","Rojo",100,true);
      Vehiculo d6 = new Deportivo(2,"369852","Mercedes","wv","blue",100,true);
      Vehiculo d7 = new Deportivo(2,"345674","Clio","wv","Blanco",100,true);
      Vehiculo d8 = new Deportivo(2,"987654","Audi","wv","Negro",100,true);
      Vehiculo d9 = new Deportivo(2,"159874","Clio","wv","blue",100,true);
      Vehiculo d10 = new Deportivo(2,"357896","Audi","wv","Negro",100,true);
      
      
      Furgoneta f1 = new Furgoneta(10,20,"JH5234","furgoneta","dgd","Rojo",500,false);
      Furgoneta f2 = new Furgoneta(10,20,"JK15489","furgoneta","dgd","verde",500,false);
      Furgoneta f3 = new Furgoneta(10,20,"LM2135","furgoneta","dgd","Blanco",500,false);
      Furgoneta f4 = new Furgoneta(10,20,"FG5897","furgoneta","dgd","Negro",500,false);
      Furgoneta f5 = new Furgoneta(10,20,"AS1234","furgoneta","dgd","verde",500,false);
      Furgoneta f6 = new Furgoneta(10,20,"FG2541","furgoneta","dgd","Rojo",500,false);
      Furgoneta f7 = new Furgoneta(10,20,"HN2132","furgoneta","dgd","Blanco",500,false);
      Furgoneta f8 = new Furgoneta(10,20,"JK15489","furgoneta","dgd","Rojo",500,false);
      Furgoneta f9 = new Furgoneta(10,20,"EF2534","furgoneta","dgd","Blanco",500,false);
      Furgoneta f10 = new Furgoneta(10,20,"DF4521","furgoneta","dgd","verde",500,false);
      
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
           for (Vehiculo obj : lista) {
               if(obj instanceof Turismo){
                 flujo.write("0 - "+obj.toString());
               }else if(obj instanceof Deportivo){
                   flujo.write("1 - "+obj.toString());
               }else{
                   flujo.write("2 - "+obj.toString()); 
               }
               flujo.newLine();
           }
           // Metodo fluh()
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
           
       }catch(IOException e){
           System.out.println(e.getMessage());
       }
      
    }
}
