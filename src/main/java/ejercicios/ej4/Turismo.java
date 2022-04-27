
package ejercicios.ej4;

/**
 *
 * @author hinda
 */
public class Turismo extends Vehiculo {
    //atributos

    private int puertas;
    private boolean marchaAutomatica;

    //constrectores
    public Turismo(int puertas, boolean marchaAutomatica,String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        super(matricula, marca, modelo, color, tarifa, disponible);
        this.puertas = puertas;
        this.marchaAutomatica = marchaAutomatica;
    }

    public Turismo() {
    }

    public int getPuertas() {
        return puertas;
    }

    //getters
    public boolean isMarchaAutomatica() {
        return marchaAutomatica;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public void setMarchaAutomatica(boolean marchaAutomatica) {
        this.marchaAutomatica = marchaAutomatica;
    }
    
    

    @Override
    public String toString() {
        return puertas + ":" + marchaAutomatica+":"+super.toString() ;
    }

   
}
