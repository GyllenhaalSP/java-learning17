package EV2.ARRAYS.EjerciciosArrays;

import java.util.Arrays;

import static utilities.StaticUtilities.rand;

public class Ej1 {
    public static void main(String[] args) {
        //Realiza un programa que rellene un array de 6 filas por 10 columnas con números enteros positivos comprendidos entre 0 y 1000 (ambos incluidos). A continuación, el programa deberá dar la posición tanto del máximo como del mínimo.

        int[][] array = new int[6][10];
        int max = 0;
        int min = 1000;
        int[] posMax = new int[2];
        int[] posMin = new int[2];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rand.nextInt(50, 1001);
                if (array[i][j] > max) {
                    max = array[i][j];
                    posMax[0] = i;
                    posMax[1] = j;
                }
                if (array[i][j] < min) {
                    min = array[i][j];
                    posMin[0] = i;
                    posMin[1] = j;
                }
            }
        }
        System.out.println(Arrays.deepToString(array));
        System.out.println("El máximo es " + max + " y está en la posición " + posMax[0] + ", " + posMax[1]);
        System.out.println("El mínimo es " + min + " y está en la posición " + posMin[0] + ", " + posMin[1]);
    }
}
