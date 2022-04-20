
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
    public Turismo(String matricula, String marca, String modelo, String color, double tarifa, boolean disponible, int puertas, boolean marchaAutomatica) {
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

    @Override
    public String toString() {
        return super.toString()+" Turismo" + " :" + puertas + " :" + marchaAutomatica ;
    }

   
}
