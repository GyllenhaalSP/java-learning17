package PROG.P_5.P_5_3;

public class P_5_3_3_transposicion {
    // Daniel Alonso Lázaro - 2022
    /*
    Visualizar la matriz transpuesta de la anterior. Si la matriz es cuadrada (tiene igual
    número de filas y de columnas) visualice también los elementos de la diagonal
    principal.
    */
    public static void main(String[] args) {
        int[][] matriz = {{3, 2, 5, 0, 9}, {9, 10, 2, 3, 1}, {-3, 2, 3, 43, 1}};
        int[][] matrizTranspuesta = new int[matriz[0].length][matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrizTranspuesta[j][i] = matriz[i][j];
            }
        }

        for(int[] matrix : matriz){
            for(int i : matrix) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        System.out.println();
        for (int[] ies : matrizTranspuesta) {
            for (int jotas : ies) {
                System.out.print(jotas + "\t");
            }
            System.out.println();
        }
    }
}