package PROG.P_5.P_5_0;

import java.util.Scanner;

public class P_5_0_2_minMaxArrayObjeto {
    // Daniel Alonso Lázaro - 2022
    /*
    Crea una matriz de 10 elementos de tipo entero, introduce 10 valores por teclado y
    almacénalos en los elementos de la matriz para posteriormente comprobar el valor máximo y
    mínimo almacenado.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] matrix = new int[10];
        int mayor, menor;

        System.out.print("Introduce un número: ");
        menor = sc.nextInt();
        mayor = menor;

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
