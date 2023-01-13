package EV2.ARRAYS_OBLIGATORIOS;

import java.util.Arrays;
import java.util.Random;

public class EJ1 {
    // Daniel Alonso Lázaro - 2023
    /*
    Define tres arrays de 20 números enteros cada uno, con nombres número, cuadrado
    y cubo. Carga el array número con valores aleatorios entre 0 y 100. En el array
    cuadrado se deben almacenar los cuadrados de los valores que hay en el array
    número. En el array cubo se deben almacenar los cubos de los valores que hay en
    número. A continuación, muestra el contenido de los tres arrays dispuesto en tres
    columnas.
    */
    public static void main(String[] args) {
        int[] numero = new int[20];
        int[] cuadrado = new int[20];
        int[] cubo = new int[20];

        cargarArray(numero, 100);
        Arrays.sort(numero);

        for (int i = 0; i < numero.length; i++) {
            cuadrado[i] = (int)Math.pow(numero[i], 2);
            cubo[i] = (int)Math.pow(numero[i], 3);
        }

        for (int i = 0; i < numero.length; i++) {
            System.out.printf("Número: %7d | Cuadrado: %7d | Cubo: %7d%n", numero[i], cuadrado[i], cubo[i]);
        }
    }

    public static void cargarArray(int[] v, int bound){
        //Carga un array de enteros con números aleatorios entre 0 y bound.
        Random rand = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = rand.nextInt(bound+1);
        }
    }
}
