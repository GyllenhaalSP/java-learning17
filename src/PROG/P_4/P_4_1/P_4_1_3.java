package PROG.P_4.P_4_1;

import java.util.Scanner;

public class P_4_1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contadorPalabras = 1;
        String palabra2;
        System.out.print("Introduce una palabra: ");
        String palabra = sc.nextLine();

        do {
            System.out.print("Introduce más palabras: ");
            palabra2 = sc.nextLine();
            contadorPalabras++;
        } while (!palabra2.equalsIgnoreCase(palabra));
        System.out.println("El número de palabras distintas introducidas es: "+(contadorPalabras-1)+".");

    }
}
