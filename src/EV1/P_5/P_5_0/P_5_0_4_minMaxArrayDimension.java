package EV1.P_5.P_5_0;

import java.util.Scanner;

public class P_5_0_4_minMaxArrayDimension {
    // Daniel Alonso Lázaro - 2022
    /*
    Modifica el ejercicio 2 para que al principio del programa nos pida cuántas posiciones
    queremos que tenga el vector y sea este dato el que utilicemos para darle dimensión.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mayor, menor;

        System.out.print("Introduce el número de elementos de la matriz: ");
        int n = sc.nextInt();
        int [] matrix = new int[n];

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
        System.out.println("El valor máximo es " + mayor + " y el valor mínimo es " + menor+".");
    }
}