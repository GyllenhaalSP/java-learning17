package EV1.P_4.P_4_1;

import static utilities.StaticUtilities.sc;

public class P_4_1_5_charAChar {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos una frase por teclado y queremos visualizarla carácter a carácter.
    Deben estar separados las letras por un guion. (charAt(int))
    */
    public static void main(String[] args) {
        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine();

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                System.out.print("");
            } else {
                System.out.print((frase.charAt(i)) + "-");
            }
        }
    }
}

