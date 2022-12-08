package PROG.P_4.P_4_3;

import java.util.Scanner;

public class P_4_3_4_truncar {
    // Daniel Alonso Lázaro - 2022
    /*
    Se capturan números reales por teclado y queremos truncar el
    número introducido. Vamos a realizarlo con método existente y sin
    método. Ver si tenemos alguna diferencia.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        double num;

        do{
            System.out.print("Introduce un número: ");
            num = sc.nextDouble();
            sc.nextLine();

            System.out.println("El número "+num+" truncado con rint() es "+Math.rint(num));
            System.out.println("El número "+num+" truncado con (int) es "+(int)num);
            System.out.println("El número "+num+" truncado con round() es "+Math.round(num));
            System.out.println("El número "+num+" truncado con floor() es "+Math.floor(num));
            System.out.println("El número "+num+" truncado con ceil() es "+Math.ceil(num));

            System.out.print("¿Quieres continuar? (S/N) ");
            respuesta = sc.nextLine().toUpperCase();
        }while(respuesta.equals("S"));
    }
}
