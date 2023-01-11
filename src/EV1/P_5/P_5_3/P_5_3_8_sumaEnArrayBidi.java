package EV1.P_5.P_5_3;

import static ProgramasPruebas.metodos.cargarArray;
import static ProgramasPruebas.metodos.mostrarArray;

public class P_5_3_8_sumaEnArrayBidi {
    //Daniel Alonso Lázaro - 2023
    /*
    Una vez cargado un array numérico de dos dimensiones (10X15), obtener un array
    unidimensional o vector cuyo primer elemento contenga la suma de los elementos de
    la primera fila del array bidimensional, el segundo la suma de los elementos de la
    segunda fila del array bidimensional, y así sucesivamente.
    */
    public static void main(String[] args) {
        int[][] array = new int[10][15];
        int[] array2 = new int[10];
        cargarArray(array, 101);
        mostrarArray("El array es ", array, 15);

        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array[i].length; j++)
                array2[i] += array[i][j];

        for (int i = 0; i < array2.length; i++) {
            System.out.println("La suma de la fila "+i+" es: "+array2[i]);
        }

    }
}
