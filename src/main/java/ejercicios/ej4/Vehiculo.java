/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejercicios.ej4;

import java.util.Objects;

/**
 *
 * @author hinda
 */
public class Vehiculo {

    String matricula;
    String marca;
    String modelo;
    String color;
    double tarifa;
    boolean disponible;

    // el método constructor con parametro de la clase Vehiculo 
    public Vehiculo(String matricula,
            String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = false;
    }
    
    public Vehiculo(){
        
    }
    
// los métodos ‘get’ y ‘set’ de la clase Vehiculo 

    public String getMatricula() {
        return this.matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getColor() {
        return this.color;
    }

    public double getTarifa() {
        return this.tarifa;
    }

    public boolean getDisponible() {
        return this.disponible;

    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void aplicarDescuentoTarifa(double descuento) {
        this.tarifa -= descuento;
    }

    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (Double.doubleToLongBits(this.tarifa) != Double.doubleToLongBits(other.tarifa)) {
            return false;
        }
        if (this.disponible != other.disponible) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return Objects.equals(this.color, other.color);
    }

    @Override
    public String toString() {
        return  matricula + " :" + marca + " :" + modelo + " :" + color + " :" + tarifa + " :" + disponible;
    }
    
    

    
     

}
