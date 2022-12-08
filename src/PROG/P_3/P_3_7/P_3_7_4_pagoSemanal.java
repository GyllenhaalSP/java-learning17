package PROG.P_3.P_3_7;

import java.util.Scanner;

public class P_3_7_4_pagoSemanal {
//    Una empresa paga a sus 100 operarios semanalmente, de acuerdo con el número de horas trabajadas,
//    a razón de P euros por hora y de 1.5 P euros por cada hora extra.
//    Las horas extras son las que exceden de 40 h.
//    Hacer el programa que dado el número de horas trabajadas y el valor de P calcule el salario que le corresponde.
//    Amplía el programa para que repita el proceso hasta que número de horas trabajadas sea 0.
    public static void main(String[] args) {
        int horasTrabajadas;
        Scanner sc = new Scanner(System.in);

        do{
            int horasIniciales, horasExtra = 0, precioHora, totalOrdinarias;
            double totalExtra = 0d, nomina, precioHoraExtra;
            System.out.print("Introduce el número de horas: ");
            horasIniciales = sc.nextInt();
            horasTrabajadas = horasIniciales;
            System.out.print("Introduce el precio por hora: ");
            precioHora = sc.nextInt();
            precioHoraExtra = precioHora * 1.5;

            if (horasIniciales > 40){
                horasExtra = horasIniciales - 40;
                totalExtra = horasExtra * precioHoraExtra;
            }

            horasTrabajadas -= horasExtra;
            totalOrdinarias = horasTrabajadas * precioHora;

            nomina = totalExtra + totalOrdinarias;

            System.out.println("La nómina del trabajador es de "+nomina+" euros por "+horasIniciales+
                    " horas: "+horasTrabajadas+" horas ordinarias a "+precioHora+"€ la hora y "+horasExtra+
                    " horas extra a "+(int)(precioHora*1.5)+"€ la hora.");
        }while(horasTrabajadas != 0);

    }
}
