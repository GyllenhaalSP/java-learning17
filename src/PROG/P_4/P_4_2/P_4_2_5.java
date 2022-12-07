package PROG.P_4.P_4_2;

import java.util.Scanner;

public class P_4_2_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine();
        System.out.print("Introduce una palabra: ");
        String palabra = sc.nextLine();

        System.out.println("La palabra "+palabra+" se encuentra en la posición "
                +(frase.indexOf(palabra)+1)+" dentro de la frase introducida.");
    }
}
