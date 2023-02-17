package EV2.OOP.C_20230217.EjercicioFigurasRedondas;

public class Esfera {
    private final double RADIO;

    public Esfera(double radio) {
        this.RADIO = radio;
        System.out.println("Construyendo una esfera de radio "
                + (RADIO % 1 == 0.0 ? (int)RADIO : String.format("%.02f", RADIO))
                + " ...");
    }

    public double getVolumen(){
        final double MULTIPLICADOR_VOLUMEN = 4.0 / 3.0;
        final int EXPONENTE = 3;
        return (MULTIPLICADOR_VOLUMEN) * Math.PI * Math.pow(RADIO, EXPONENTE);
    }

    public double getArea(){
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
