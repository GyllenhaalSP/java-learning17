package PROG.P_5.P_5_3;

import java.util.Arrays;

public class P_5_3_2_diagonal {
    // Daniel Alonso Lázaro - 2022

    /*
       Diseñar programa Java, que:
          a) Crea una tabla bidimensional de longitud 5x5 y nombre 'diagonal'.
          b) Carga la tabla de forma que los componentes pertenecientes a la diagonal principal de la matriz
             tomen el valor 1 y el resto el valor 0.
          c) Muestra el contenido de la tabla en pantalla.
    */
    public static void main(String[] args) {
        int[][] matriz = new int[5][5];
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                if(i == j){
                    matriz[i][j] = 1;
                }else{
                    matriz[i][j] = 0;
                }
            }
        }
        System.out.println("Matriz diagonal: \n");
        for(int[] ints:matriz){
            System.out.println(Arrays.toString(ints));
        }
    }
}
