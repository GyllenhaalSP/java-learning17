package EV2.OOP.C_20230217.EjercicioFigurasRedondas;

/**
 * Clase que simula una circunferencia.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Circunferencia {
    private final double RADIO;

    public Circunferencia(double radio) {
        this.RADIO = radio;
        System.out.println("Construyendo una circunferencia de radio "
                + (RADIO % 1 == 0.0 ? (int)RADIO : String.format("%.02f", RADIO))
                + " ...");
    }

    private double getPerimetro(){
        return 2 * Math.PI * RADIO;
    }

    @Override
    public String toString() {
        return "Soy una circunferencia de radio "
                + (RADIO % 1 == 0.0 ? (int)RADIO : String.format("%.02f", RADIO))
                + " y mi perímetro es "
                + String.format("%.02f",getPerimetro())
                + ".";
    }
}
