package EV1.P_3.P_3_3;

import java.util.Scanner;

import static ProgramasPruebas.Metodos.bisiesto;

public class P_3_3_2_bisiesto {
//    Escribir un programa que lea un año indicar si es bisiesto. Nota: un año es bisiesto si es un
//    número divisible por 4, pero no si es divisible por 100, excepto que también sea divisible por
//    400.
    public static void main(String[] args) {
        int year;
        char salir = 'n';
        System.out.println("Bienvenido al comprobador de años bisiestos®");
        while (Character.toLowerCase(salir) != 's') {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nIntroduce un año: ");
            year = sc.nextInt();
            System.out.println(bisiesto(year) ? year+" es bisiesto.": year+" no es bisiesto.");
            System.out.print("\n'S' para salir: ");
            salir = sc.next().charAt(0);
        }
        System.out.println("\nGracias por utilizar nuestro comprobador de años bisiestos® patentado.");
    }
}
