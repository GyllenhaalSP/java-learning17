package EV2.OOP.C_20230217.EjercicioFigurasRedondasHerencia;

public class Figura {
    private final String nombre;
    private final double RADIO;

    public Figura(String nombre, double radio) {
        this.nombre = nombre;
        this.RADIO = radio;
    }

    protected double getArea(){
        final int MULTIPLICADOR_AREA = 4;
        final int EXPONENTE = 2;
        return MULTIPLICADOR_AREA * Math.PI * Math.pow(getRadio(), EXPONENTE);
    }

    protected double getPerimetro(){
        final int MULTIPLICADOR_PERIMETRO = 2;
        return this.getRadio() * MULTIPLICADOR_PERIMETRO * Math.PI;
    }

    protected double getVolumen(){
        if (this instanceof Circulo || this instanceof Circunferencia) {
            return 0;
        }
        final double MULTIPLICADOR_VOLUMEN = 4.0 / 3.0;
        final int EXPONENTE = 3;
        return MULTIPLICADOR_VOLUMEN * Math.PI * Math.pow(getRadio(), EXPONENTE);
    }

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