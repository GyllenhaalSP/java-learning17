package PROG.P_5.P_5_1;

import java.util.Arrays;
import java.util.Scanner;

public class P_5_1_10 {
    // Daniel Alonso Lázaro - 2022
    /*
    Realizar un programa Java que pida un número entero positivo de 10 cifras, y que compruebe si el número es capicúa.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numArray = new int[10];
        int[] numArrayInvertido = new int[10];
        boolean capTrue = false;
        String num;

        do{
            System.out.print("Introduce un número de 10 cifras: ");
            num = sc.nextLine();
        }while(num.length() != 10);

        int j = num.length() - 1;

        for(int i = 0; i < num.length(); i++) {
            numArray[i] = Integer.parseInt(num.substring(i, i + 1));
            numArrayInvertido[j] = numArray[i];
            j--;
            capTrue = capicuas(numArray, numArrayInvertido);
        }

        if(capTrue) System.out.println("El número es capicúa.");
        else System.out.println("El número no es capicúa.");
        System.out.println(capTrue);
        System.out.println(Arrays.toString(numArray));
        System.out.println(Arrays.toString(numArrayInvertido));
    }

    public static boolean capicuas(int[] numArray, int[] numArrayInvertido) {
        for(int i = 0; i < numArray.length; i++) {
            if (numArray[i] != numArrayInvertido[i]) {
                return false;
            }
        }
        return true;
    }
}
