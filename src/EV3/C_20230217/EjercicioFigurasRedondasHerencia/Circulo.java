package EV3.C_20230217.EjercicioFigurasRedondasHerencia;

/**
 * Clase que simula un círculo.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Circulo extends Figura{

    public Circulo(double radio) {
        super("Círculo", radio);
        System.out.println("Construyendo un "+this.getNombre()+" de radio "
                + (this.getRadio() % 1 == 0.0 ? (int)this.getRadio() : String.format("%.02f", this.getRadio()))
                + " ...");
    }
}
