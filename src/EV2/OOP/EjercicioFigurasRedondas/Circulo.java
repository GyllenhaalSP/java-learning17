package EV2.OOP.EjercicioFigurasRedondas;

public class Circulo {
    private final double RADIO;

    public Circulo(double radio) {
        this.RADIO = radio;
        System.out.println("Construyendo un círculo de radio "
                + (RADIO % 1 == 0.0 ? (int)RADIO : String.format("%.02f", RADIO))
                + " ...");
    }

    public double getArea(){
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
