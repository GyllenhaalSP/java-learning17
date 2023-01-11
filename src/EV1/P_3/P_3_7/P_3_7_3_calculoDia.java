package EV1.P_3.P_3_7;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static ProgramasPruebas.metodos.bisiesto;

public class P_3_7_3_calculoDia {
//    Hacer un organigrama que dados un día D, un mes M y un año A, calcule
//    cuál es el día siguiente. Se debe tener en cuenta que en los años bisiestos febrero tiene 29 días
//    y en los no bisiestos 28.
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

            System.out.println("\nEl "+((day<10)?"0"+day:day)+"/"+((month<10)?"0"+month:month)+"/"+year+
                    " es una fecha correcta.");

            LocalDate fecha = LocalDate.of(year, month, day).plusDays(1);
            System.out.println("Un día más es el: "+fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            
            System.out.print("\n¿Quieres continuar comprobando fechas? ");
            userInput = sc.next().charAt(0);
        } while (Character.toLowerCase(userInput) != 'n');

        System.out.print("\nGracias por usar nuestro comprobador de fechas® patentado.");
    }
}
