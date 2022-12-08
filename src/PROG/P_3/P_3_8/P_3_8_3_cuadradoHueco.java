package PROG.P_3.P_3_8;

import java.util.Random;
import java.util.Scanner;

public class P_3_8_3_cuadradoHueco {
//    Nos piden dibujar un cuadrado hueco en pantalla.
//    Por teclado se captura la longitud del lado del cuadrado.
//    Para la representación del cuadrado, utilizaremos los símbolos de la tabla ASCII (del 169 al 223 ),
//    a elegir por el programador.
    public static void main(String[] args) {
        Random r = new Random();
        int random = r.nextInt((223-169)+1) + 169;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el lado A: ");
        int ladoA = sc.nextInt();
        System.out.print("Introduce el lado B: ");
        int ladoB = sc.nextInt();

        for (int i = 1; i <= ladoA; i++){
            for (int j = 1; j <= ladoB; j++){
                if (i == 1 || i == ladoA || j == 1 || j == ladoB){
                    System.out.print((char)random+" ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}