package EV2.ARRAYS.EjerciciosArrays;

import java.util.Arrays;

public class Ej1 {
    public static void main(String[] args) {
        //Realiza un programa que rellene un array de 6 filas por 10 columnas con números enteros positivos comprendidos entre 0 y 1000 (ambos incluidos). A continuación, el programa deberá dar la posición tanto del máximo como del mínimo.

        int[][] array = new int[6][10];
        int max = 0;
        int min = 1000;
        int posMax = 0;
        int posMin = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 1001);
                if (array[i][j] > max) {
                    max = array[i][j];
                    posMax = i;
                }
                if (array[i][j] < min) {
                    min = array[i][j];
                    posMin = i;
                }
            }
        }
        System.out.println(Arrays.deepToString(array));
        System.out.println("El máximo es " + max + " y está en la posición " + posMax);
        System.out.println("El mínimo es " + min + " y está en la posición " + posMin);
    }
}
