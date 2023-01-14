package EV1.P_3.P_3_3;

import java.util.Scanner;

import static ProgramasPruebas.Metodos.bisiesto;

public class P_3_3_3_yearChecker {
//    Pedir el día, mes y año de una fecha e indicar si es correcta.
//    Una fecha es correcta si:
//        • El día es mayor que 0 y menor que el nª de días que tenga el mes
//        • El mes debe estar comprendido entre 1 y 12
//        • Si el año es bisiesto, febrero tiene 29 días
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
                flag = flag | (bisiesto(year) ? (month == 2 && day < 1 | day > 29)
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
