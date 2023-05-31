package EV1.P_4.P_4_2;

import static utilities.StaticUtilities.sc;

public class P_4_2_5_posicionSubcadena {
    // Daniel Alonso Lázaro - 2022
    /*
    Escribimos una frase y una palabra por teclado y deseamos saber en qué posición
    se encuentra la palabra (subcadena) dentro de la frase. (lastIndexOf(String))
    */
    public static void main(String[] args) {
        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine();
        System.out.print("Introduce una palabra: ");
        String palabra = sc.nextLine();

        System.out.println("La palabra " + palabra + " se encuentra en la posición "
                + (frase.indexOf(palabra) + 1) + " dentro de la frase introducida.");
    }
}
