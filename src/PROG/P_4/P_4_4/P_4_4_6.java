package PROG.P_4.P_4_4;

import java.util.Scanner;

public class P_4_4_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inicio, fin;

        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine();

        do{
            inicio = (int)(Math.random()*frase.length());
            fin = (int)(Math.random()*frase.length());
        }while(fin <= inicio);

        System.out.println(frase.substring(inicio, fin));
    }
}

