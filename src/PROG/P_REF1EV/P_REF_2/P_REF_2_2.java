package PROG.P_REF1EV.P_REF_2;

import java.util.Scanner;

import static ProgramasPruebas.metodos.normalizador;

public class P_REF_2_2 {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos frases por teclado y deseamos saber el número de vocales que
    tiene cada frase.
    Al final del programa indicaremos cuantas vocales en total tenían todas las frases capturadas
    y el número total de frases.
    El programa acaba cuando al pedir la nueva frase no se introduzca nada, la entrada quede vacía.
    */

    public static void main(String[] args) {
        String frase;
        int totalVocales = 0;
        int totalFrases = 0;
        int vocales = 0;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce una frase: ");
            frase = sc.nextLine();
            frase = normalizador(frase);
            if (!frase.equals("")) {
                totalFrases++;
                for (int i = 0; i < frase.length(); i++) {
                    if (frase.charAt(i) == 'a'
                            || frase.charAt(i) == 'e'
                            || frase.charAt(i) == 'i'
                            || frase.charAt(i) == 'o'
                            || frase.charAt(i) == 'u') {
                        vocales++;
                    }
                }
                System.out.println("La frase tiene " + vocales + " vocales.");
                totalVocales += vocales;
                vocales = 0;
            }
        } while (!frase.equals(""));

        System.out.println("En total se han introducido " + totalFrases + " frases y " + totalVocales + " vocales.");
    }
}
