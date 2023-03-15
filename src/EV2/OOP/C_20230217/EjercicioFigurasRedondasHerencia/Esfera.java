package EV2.OOP.C_20230217.EjercicioFigurasRedondasHerencia;

/**
 * Clase que simula una esfera.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Esfera extends Figura{

    public Esfera(double radio) {
        super("Esfera", radio);
        System.out.println("Construyendo una "+getNombre()+" de radio "
                + (getRadio() % 1 == 0.0 ? (int)getRadio() : String.format("%.02f", getRadio()))
                + " ...");
    }
}
