package EV2.OOP.C_20230217.EjercicioFigurasRedondasHerencia;

public abstract class Figura {
    private final String nombre;
    private final double RADIO;

    public Figura(String nombre, double radio) {
        this.nombre = nombre;
        this.RADIO = radio;
    }

    abstract public double getArea();

    abstract public double getPerimetro();

    abstract public double getVolumen();

    protected double getRadio() {
        return RADIO;
    }

    protected String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Soy una " + getNombre() + " de radio "
                + (RADIO % 1 == 0.0 ? (int) RADIO : String.format("%.02f", RADIO))
                + " mi área es "
                + String.format("%.02f", getArea())
                + ", mi perímetro es "
                + String.format("%.02f", getPerimetro())
                + " y mi volumen es "
                + String.format("%.02f", getVolumen())
                + ".";
    }
}