package EV3.C_20230217.EjercicioFigurasRedondas;

/**
 * Clase que simula un círculo.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Circulo {
    private final double RADIO;

    public Circulo(double radio) {
        this.RADIO = radio;
        System.out.println("Construyendo un círculo de radio "
                + (RADIO % 1 == 0.0 ? (int)RADIO : String.format("%.02f", RADIO))
                + " ...");
    }

    private double getArea(){
        return Math.PI * Math.pow(RADIO, 2);
    }

    @Override
    public String toString() {
        return "Soy un círculo de radio "
                + (RADIO % 1 == 0.0 ? (int)RADIO : String.format("%.02f", RADIO))
                + " y mi superficie es "
                + String.format("%.02f", getArea())
                + ".";
    }
}
