package EV2.ARRAYS_OBLIGATORIOS;

import static ProgramasPruebas.metodos.cargarArray;

public class EJ2 {
    // Daniel Alonso Lázaro - 2023
    /*
    Escribe un programa que genere 20 números aleatorios entre 1 y 100. Estos
    números se deben introducir en un array de dos dimensiones, de 4 filas por
    5 columnas. El programa mostrará las sumas parciales de filas y columnas
    igual que si de una hoja de cálculo se tratara. La suma total debe aparecer
    en la esquina inferior derecha.
    */
    public static void main(String[] args) {
        int[][] numeros = new int[4][5];
        int[] sumaFilas = new int[4];
        int[] sumaColumnas = new int[5];
        int sumaTotal = 0;

        cargarArray(numeros, 100);

        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[i].length; j++){
                sumaFilas[i] += numeros[i][j];
                sumaColumnas[j] += numeros[i][j];
                sumaTotal += numeros[i][j];
            }
        }

        for(int i = 0; i < numeros.length+1; i++){
            if(i != numeros.length){
                for(int j = 0; j < numeros[i].length; j++){
                    System.out.printf("%4d", numeros[i][j]);
                }
                System.out.printf(" | %4d%n", sumaFilas[i]);
            } else {
                for(int j = 0; j < numeros[i-1].length; j++){
                    System.out.print("----");
                }
                System.out.println(" | ----");
                for (int sumaColumna:sumaColumnas) {
                    System.out.printf("%4d", sumaColumna);
                }
                System.out.printf(" | %4d", sumaTotal);
            }
        }
        System.out.println();
    }
}
