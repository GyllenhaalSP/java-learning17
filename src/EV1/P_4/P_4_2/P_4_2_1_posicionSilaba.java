package EV1.P_4.P_4_2;

import java.util.Scanner;

public class P_4_2_1_posicionSilaba {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos por teclado una palabra y una sílaba, y queremos saber en qué
    posición empieza la sílaba en la palabra. Tras cada solicitud de entrada de datos
    preguntar si quiere continuar S o N. (indexOf(string))
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabra, silaba;
        int pos = 0;

        System.out.print("Introduce una palabra: ");
        palabra = sc.nextLine();
        System.out.print("Introduce una silaba: ");
        silaba = sc.nextLine();

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == silaba.charAt(0)) {
                for (int j = 0; j < silaba.length(); j++) {
                    if (palabra.charAt(i + j) == silaba.charAt(j)) {
                        if (j == silaba.length() - 1) {
                            pos = i;
                        }
                    }
                }
            }
        }
        System.out.println("La sílaba '"+silaba+
                "' empieza en la posición "+(pos+1)+" de la palabra '"+palabra+"'.");
    }
}
