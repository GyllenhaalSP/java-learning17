package EV3.C_20230217.EjercicioFigurasRedondas;

/**
 * Clase que simula una esfera.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Esfera {
    private final double RADIO;

    public Esfera(double radio) {
        this.RADIO = radio;
        System.out.println("Construyendo una esfera de radio "
                + (RADIO % 1 == 0.0 ? (int)RADIO : String.format("%.02f", RADIO))
                + " ...");
    }

    private double getVolumen(){
        final double MULTIPLICADOR_VOLUMEN = 4.0 / 3.0;
        final int EXPONENTE = 3;
        return MULTIPLICADOR_VOLUMEN * Math.PI * Math.pow(RADIO, EXPONENTE);
    }

    private double getArea(){
        final int MULTIPLICADOR_AREA = 4;
        final int EXPONENTE = 2;
        return MULTIPLICADOR_AREA * Math.PI * Math.pow(RADIO, EXPONENTE);
    }

    @Override
    public String toString() {
        return "Soy una esfera de radio "
                + (RADIO % 1 == 0.0 ? (int)RADIO : String.format("%.02f", RADIO))
                + " y mi volumen es "
                + String.format("%.02f", getVolumen())
                + " y además mi área es "
                + String.format("%.02f",getArea())
                + ".";
    }
}
