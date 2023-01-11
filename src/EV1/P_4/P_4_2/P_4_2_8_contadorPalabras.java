package EV1.P_4.P_4_2;

import java.util.Scanner;

public class P_4_2_8_contadorPalabras {
    // Daniel Alonso Lázaro - 2022
    /*
    Haz un programa que a partir de una frase introducida por teclado nos diga cuántas palabras contiene.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine().trim();
        int esEspacio = 0;

        for(int i = 0; i < frase.length(); i++){
            if (Character.isWhitespace(frase.charAt(i))) esEspacio++;
        }
        System.out.println("La frase tiene "+(esEspacio+1)+" palabras.");
    }
}
