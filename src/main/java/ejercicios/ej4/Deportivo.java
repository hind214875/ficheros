/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.ej4;

/**
 *
 * @author hinda
 */
public class Deportivo extends Vehiculo{
    private int cilindrada; // Atributo específico para Deportivo
    
    //constrector

    public Deportivo(int cilindrada, String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        super(matricula, marca, modelo, color, tarifa, disponible);
        this.cilindrada = cilindrada;
    }

    public Deportivo() {
    }

    
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return super.toString()+":" + cilindrada  ;
    }
    
    
}
