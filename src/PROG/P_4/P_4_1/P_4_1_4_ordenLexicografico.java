package PROG.P_4.P_4_1;

import java.util.Scanner;

public class P_4_1_4_ordenLexicografico {
    // Daniel Alonso Lázaro - 2022
    /*
    Captura tres palabras por teclado y ordénalas de menor a mayor según el diccionario. (compareTo(String))
    */
    public static void main(String[] args) {
        String palabra1, palabra2, palabra3, palabraMenor, palabraMediana, palabraMayor;

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una palabra: ");
        palabra1 = sc.nextLine();

        System.out.print("Introduce otra palabra: ");
        palabra2 = sc.nextLine();

        System.out.print("Introduce otra palabra: ");
        palabra3 = sc.nextLine();

        if (palabra1.compareToIgnoreCase(palabra2) < 0 && palabra1.compareToIgnoreCase(palabra3) < 0) {
            palabraMenor = palabra1;
            if (palabra2.compareToIgnoreCase(palabra3) < 0) {
                palabraMediana = palabra2;
                palabraMayor = palabra3;
            } else {
                palabraMediana = palabra3;
                palabraMayor = palabra2;
            }
        } else if (palabra2.compareToIgnoreCase(palabra1) < 0 && palabra2.compareToIgnoreCase(palabra3) < 0) {
            palabraMenor = palabra2;
            if (palabra1.compareToIgnoreCase(palabra3) < 0) {
                palabraMediana = palabra1;
                palabraMayor = palabra3;
            } else {
                palabraMediana = palabra3;
                palabraMayor = palabra1;
            }
        } else {
            palabraMenor = palabra3;
            if (palabra1.compareToIgnoreCase(palabra2) < 0) {
                palabraMediana = palabra1;
                palabraMayor = palabra2;
            } else {
                palabraMediana = palabra2;
                palabraMayor = palabra1;
            }
        }
        System.out.println("Las palabras ordenadas de menor a mayor son: " + palabraMenor + ", " + palabraMediana + ", " + palabraMayor + ".");
    }
}
