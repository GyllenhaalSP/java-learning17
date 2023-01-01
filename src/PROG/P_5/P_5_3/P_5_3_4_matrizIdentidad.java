package PROG.P_5.P_5_3;

import java.util.Scanner;

public class P_5_3_4_matrizIdentidad {
    // Daniel Alonso Lázaro - 2022
    /*
    Se captura por teclado los valores de una matriz de 4 x 4. Deseamos saber si es una
    matriz identidad. Es aquella que en la diagonal posee el valor 1 y en el resto de las
    posiciones tiene el valor 0.
    */
    public static void main(String[] args) {
        int[][] matriz = new int[4][4];
        boolean esIdentidad = false;
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.print("Introduce el valor de la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

       for(int i = 0; i < matriz.length;i++){
           for(int j = 0; j < matriz[i].length; j++){
               esIdentidad = i == j && matriz[i][j] == 1;
           }
       }
       System.out.println(esIdentidad ? "Es una matriz identidad" : "No es una matriz identidad");
    }
}
