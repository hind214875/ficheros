/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.ej4;

/**
 *
 * @author hinda
 */
public class Furgoneta extends Vehiculo {

    //atributos
    private int carga;
    private int volumen;

    //constrector

    public Furgoneta(int carga, int volumen, String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        super(matricula, marca, modelo, color, tarifa, disponible);
        this.carga = carga;
        this.volumen = volumen;
    }

    public int getCarga() {
        return carga;
    }

    public int getVolumen() {
        return volumen;
    }

    @Override
    public String toString() {
        return super.toString()+" Furgoneta" + " :"+ carga + " :" + volumen ;
    }

    
    
    
}
