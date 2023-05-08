package EV3.C_20230217.EjercicioFigurasRedondasHerencia;

/**
 * Main de las clases Círculo, Circunferencia y Esfera.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(1);
        Circunferencia circunferencia = new Circunferencia(1);
        Esfera esfera = new Esfera(1);

        System.out.println();
        System.out.println(circulo);
        System.out.println(circunferencia);
        System.out.println(esfera);
    }
}
