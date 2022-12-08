package PROG.P_3.P_3_4;

import java.util.Scanner;

public class P_3_4_3_valorByte {
//    Declara dos variables del tipo byte. Captura valores para dichos números
//    comprobando que valores máximos y mínimos son posibles.
    public static void main(String[] args) {
        byte byte1, byte2;
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el mayor valor de byte: ");
        byte1 = sc.nextByte();

        System.out.print("Introduce el menor valor de byte: ");
        byte2 = sc.nextByte();

        System.out.println("Byte1 vale "+byte1+"\nByte2 vale "+byte2+".");
    }
}
