package EV1.P_4.P_4_2;

import java.util.Scanner;

public class P_4_2_9_eliminaUltimaPalabra {
    // Daniel Alonso Lázaro - 2022
    /*
    Haz un programa que, a partir de una frase introducida por teclado, elimine la última palabra y
    nos muestre el resultado.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine().trim();

        System.out.println("La frase es: \""+frase.substring(0,
                (frase.lastIndexOf(" ") == -1 ? 0 : frase.lastIndexOf(" ")))+"\"");
    }
}