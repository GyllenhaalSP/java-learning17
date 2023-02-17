package EV2.OOP.C_20230113;

import EV2.OOP.C_20230112.Vehiculo;

/**
 * Ejercicio de la clase Vehículo
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */

public class Ej_230113_Vehiculo {
    // Daniel Alonso Lázaro - 2023
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setCapacidadCombustible(57);
        System.out.println("Tengo "+vehiculo.getCapacidadCombustible()+" litros de combustible.");
    }
}
