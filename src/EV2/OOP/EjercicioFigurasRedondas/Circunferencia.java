package EV2.OOP.EjercicioFigurasRedondas;

public class Circunferencia {
    private final double RADIO;

    public Circunferencia(double radio) {
        this.RADIO = radio;
        System.out.println("Construyendo una circunferencia de radio "
                + (RADIO % 1 == 0.0 ? (int)RADIO : String.format("%.02f", RADIO))
                + " ...");
    }

    public double getPerimetro(){
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
