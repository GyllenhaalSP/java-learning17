package EV1.P_4.P_4_2;

import java.util.Scanner;

public class P_4_2_4_buscadorInfinitivos {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos palabras por teclado y queremos saber si son infinitivos (acaban en ar-er-ir). (endsWith(String))
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una palabra para saber si es un infinitivo: ");
        String palabra = sc.nextLine();

        if(palabra.endsWith("ar") || palabra.endsWith("er") || palabra.endsWith("ir")) {
            if (Character.isUpperCase(palabra.charAt(0))){
                System.out.println(palabra+ " es un infinitivo");
            }else{
                System.out.println(palabra.replaceFirst(Character.toString(palabra.charAt(0)),
                        Character.toString(Character.toUpperCase(palabra.charAt(0))))+ " es un infinitivo");
            }
        } else {
            System.out.println(palabra+ " no es un infinitivo");
        }
    }
}
