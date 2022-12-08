package PROG.P_REF1EV.P_REF_1;

import java.util.Scanner;

public class P_REF_1_4 {
    // Daniel Alonso Lázaro - 2022
    /*
    Introducimos dos números por teclado y queremos guardar el valor mayor en
    la variable MAYOR y el número menor en la variable MENOR.
    */
    public static void main(String[] args) {
        int mayor, menor;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Introduce otro número: ");
        int num2 = Integer.parseInt(sc.nextLine());

        if (num1 > num2) {
            mayor = num1;
            menor = num2;
        } else {
            mayor = num2;
            menor = num1;
        }
        System.out.println("\nEl número mayor es " + mayor);
        System.out.println("El número menor es " + menor);
    }
}
