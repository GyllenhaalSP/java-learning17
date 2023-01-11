package EV1.P_5.P_5_0;

import java.util.Scanner;

public class P_5_0_3_minMaxArrayVariable {
    // Daniel Alonso Lázaro - 2022
    /*
    Modifica el ejercicio anterior declarando el vector como una variable.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] matrix = {0,0,0,0,0,0,0,0,0,0};

        System.out.print("Introduce un número: ");
        int menor = sc.nextInt();
        int mayor = menor;

        for(int i = 1; i < matrix.length; i++){
            System.out.print("Introduce un número: ");
            matrix[i] = sc.nextInt();
            if(matrix[i] > mayor){
                mayor = matrix[i];
            }else if(matrix[i] < menor){
                menor = matrix[i];
            }
        }
        System.out.println("El valor máximo es " + mayor + " y el valor mínimo es " + menor);
    }
}
