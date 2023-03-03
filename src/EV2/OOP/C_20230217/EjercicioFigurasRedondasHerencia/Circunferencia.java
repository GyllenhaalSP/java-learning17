package EV2.OOP.C_20230217.EjercicioFigurasRedondasHerencia;

/**
 * Clase que simula una circunferencia.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Circunferencia extends Figura{

    public Circunferencia(double radio) {
        super("Circunferencia", radio);
        System.out.println("Construyendo una "+ getNombre() +" de radio "
                + (getRadio() % 1 == 0.0 ? (int)getRadio() : String.format("%.02f", getRadio()))
                + " ...");
    }

    @Override
    public double getArea() {
        final int MULTIPLICADOR_AREA = 4;
        final int EXPONENTE = 2;
        return MULTIPLICADOR_AREA * Math.PI * Math.pow(getRadio(), EXPONENTE);
    }

    @Override
    public double getPerimetro() {
        final int MULTIPLICADOR_PERIMETRO = 2;
        return this.getRadio() * MULTIPLICADOR_PERIMETRO * Math.PI;
    }

    @Override
    public double getVolumen() {
        return 0;
    }
}
