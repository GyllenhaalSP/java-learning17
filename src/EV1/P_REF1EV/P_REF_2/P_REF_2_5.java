package EV1.P_REF1EV.P_REF_2;

import java.util.Scanner;

public class P_REF_2_5 {
    // Daniel Alonso Lázaro - 2022
    /*
    Se introduce por teclado un valor numérico de tipo entero. Dicho valor debe ser positivo e inferior al valor 20.
    Hacer un programa que a partir del valor introducido, produzca una salida siguiendo el patrón que
    se especifica a continuación.
    Si se captura el valor 4 veríamos en pantalla lo siguiente:
            1               1
            1 2           2 1
            1 2 3       3 2 1
            1 2 3 4   4 3 2 1
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int num = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            for (int j = i * 2; j <= num * 2; j++) {
                System.out.print("  ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
