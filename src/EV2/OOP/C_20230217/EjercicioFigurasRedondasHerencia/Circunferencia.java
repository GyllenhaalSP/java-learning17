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
}
