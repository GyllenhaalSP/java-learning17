package PROG.P_4.P_4_1;

import java.util.Scanner;

public class P_4_1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

