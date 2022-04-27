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

    public Furgoneta() {
    }

    public int getCarga() {
        return carga;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }
    
    

    @Override
    public String toString() {
        return carga +":" + volumen+":"+super.toString() ;
    }

    
    
    
}
