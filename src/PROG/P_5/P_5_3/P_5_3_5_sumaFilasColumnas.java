package PROG.P_5.P_5_3;

import java.util.Arrays;

import static ProgramasPruebas.metodos.cargarArray;

public class P_5_3_5_sumaFilasColumnas {
    //Daniel Alonso Lázaro - 2023
    /*
    Diseñar programa Java que:
        a) Crea una tabla bidimensional de longitud 5x5 y nombre 'matriz'.
        b) Carga la tabla con valores numéricos enteros.
        c) Suma todos los elementos de cada fila y todos los elementos de cada columna
           visualizando los resultados en pantalla.
    */
    public static void main(String[] args) {
        int sumaFilas = 0, sumaColumnas = 0, cont = 1;
        int[][] matriz = new int[5][5];

        cargarArray(matriz, 101, "int");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFilas += matriz[i][j];
                sumaColumnas += matriz[j][i];
            }
            System.out.println("La "+cont+" fila suma un total de: "+sumaFilas);
            System.out.println("La "+cont+" columna suma un total de: "+sumaColumnas);
            sumaFilas = 0;
            sumaColumnas = 0;
        }

        for(int[] array : matriz) {
            System.out.println(Arrays.toString(array));
        }

    }
}
