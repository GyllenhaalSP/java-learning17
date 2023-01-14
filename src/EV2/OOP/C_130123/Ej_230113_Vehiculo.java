package EV2.OOP.C_130123;

import EV2.OOP.C_120123.Vehiculo;

public class Ej_230113_Vehiculo {
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setCapacidadCombustible(57);
        System.out.println("Tengo "+vehiculo.getCapacidadCombustible()+" litros de combustible.");
    }
}
