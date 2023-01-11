package EV1.P_3.P_3_3;

import java.util.Scanner;

public class P_3_3_7_numDiasMes {
//    Escribe un programa que pida un número entero entre uno y doce e imprima el número de días que
//    tiene el mes correspondiente.
    public static void main(String[] args) {
        int num;
        char ch;
        Scanner sc = new Scanner(System.in);
        do {
            do {
                System.out.print("Introduce un número del 1 al 12: ");
                num = sc.nextInt();
            } while (0 < num & num > 12);
            switch (num) {
                case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("El mes tiene 31 días.\n");
                case 4, 6, 9, 11 -> System.out.println("El mes tiene 30 días.\n");
                default -> System.out.println("El mes tiene 28 días o 29 días si el año es bisiesto.\n");
            }
            System.out.print("'S' para salir, 'C' para continuar: ");
            ch = sc.next().charAt(0);
            System.out.println();
        }while(!"s".equalsIgnoreCase(Character.toString(ch)));
        System.out.println("Ciao!");
    }
}
