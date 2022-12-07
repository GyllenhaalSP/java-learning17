package PROG.P_5.P_5_0;

import java.util.Scanner;

public class P_5_0_5 {
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
