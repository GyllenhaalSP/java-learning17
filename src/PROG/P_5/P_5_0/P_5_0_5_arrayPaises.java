package PROG.P_5.P_5_0;

import java.util.Scanner;

public class P_5_0_5_arrayPaises {
    // Daniel Alonso Lázaro - 2022
    /*
    Crea un vector de tamaño 5, al que llamaras países. En él guardarás los nombres de 5 países que se introduzcan
    por teclado. En un bucle posterior al de la inicialización del vector, muestra su contenido.
    */
    public static void main(String[] args) {
        String[] matrix = new String[5];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < matrix.length; i++){
            System.out.print("Introduce un país: ");
            matrix[i] = sc.nextLine();
        }
        int index = 0;
        for (String str : matrix) {
            System.out.println("El país en la posición "+(index+1)+" de la matriz es: "+str+".");
            index++;
        }
    }
}
