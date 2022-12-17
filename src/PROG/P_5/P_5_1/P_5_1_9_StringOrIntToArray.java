package PROG.P_5.P_5_1;

import java.util.Arrays;
import java.util.Scanner;

public class P_5_1_9_StringOrIntToArray {
    // Daniel Alonso Lázaro - 2022
    /*
    Crear un programa que lea por teclado un número entero y que almacene el mismo en un
    array de modo que cada cifra ocupe un elemento del array.
    Ejemplo: si leo el número 23451, se generará el array [[2], [3], [4], [5], [1]].
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        String num = sc.nextLine();
        int[] array = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            array[i] = Character.getNumericValue(num.charAt(i));
        }
        System.out.println("El array es: "+ Arrays.toString(array));

    }
}
