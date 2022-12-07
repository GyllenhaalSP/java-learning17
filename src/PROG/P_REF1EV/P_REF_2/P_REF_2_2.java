package PROG.P_REF1EV.P_REF_2;

import java.util.Scanner;

public class P_REF_2_2 {
    public static void main(String[] args) {
        String frase;
        int totalVocales = 0;
        int totalFrases = 0;
        int vocales = 0;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce una frase: ");
            frase = sc.nextLine();
            frase = PROG.P_4.P_4_2.P_4_2_7.normalizador(frase);
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
