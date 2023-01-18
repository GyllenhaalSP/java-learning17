package EV2.OOP.C_230113;

import EV2.OOP.C_230112.Vehiculo;

public class Ej_230113_Vehiculo {
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setCapacidadCombustible(57);
        System.out.println("Tengo "+vehiculo.getCapacidadCombustible()+" litros de combustible.");
    }
}
