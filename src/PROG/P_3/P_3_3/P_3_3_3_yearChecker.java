package PROG.P_3.P_3_3;

import java.util.Scanner;

public class P_3_3_3_yearChecker {

    public static void main(String[] args) {
        int year, month, day;
        boolean flag = false;
        char userInput;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de comprobación de fechas®");
        do{
            do {
                if (flag) {
                    System.out.println("\nLa fecha es incorrecta.");
                }
                System.out.print("\nIntroduce un día: ");
                day = sc.nextInt();
                System.out.print("Introduce un mes: ");
                month = sc.nextInt();
                System.out.print("Introduce un año: ");
                year = sc.nextInt();
                flag = year < 1910 | year > 2022;
                flag = flag | month < 1 | month > 12;
                flag = flag | (P_3_3_2_bisiesto.bisiesto(year) ? (month == 2 && day < 1 | day > 29)
                        : (month == 2 && day < 1 | day > 28));
                flag = flag | day < 1 | day > 31;
            } while (flag);
            System.out.println("El "+((day<10)?"0"+day:day)+"/"+((month<10)?"0"+month:month)+"/"+year+
                    " es una fecha correcta.\n");
            System.out.print("¿Quieres continuar comprobando fechas? ");
            userInput = sc.next().charAt(0);
        } while (Character.toLowerCase(userInput) != 'n');
        System.out.print("\nGracias por usar nuestro comprobador de fechas® patentado.");
    }
}
