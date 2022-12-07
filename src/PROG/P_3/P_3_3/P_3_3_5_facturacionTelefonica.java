package PROG.P_3.P_3_3;

import java.util.Scanner;

public class P_3_3_5_facturacionTelefonica {
//    La política de cobro de una compañía telefónica es:
//        • Cuando se realiza una llamada, el cobro es por el tiempo que dura esta, de tal forma
//          que los primeros cinco minutos cuestan 1 euro, los siguientes tres, 80 céntimos; los
//          siguientes dos minutos, 70 céntimos; y a partir del décimo minuto, 50 céntimos.
//        • Además, se carga un impuesto de 3 % cuando es domingo, y si es otro día, en turno de
//          mañana, 15 %; y en turno de tarde, 10 %.
//    Haga un algoritmo para determinar cuánto debe pagar por cada concepto una persona
//    que efectúa una llamada, teniendo en cuenta la duración de esta, el día de la semana y el
//    turno. (Hora de la llamada hh:mm – Mañana antes de las 14:00, el resto tarde).
    public static void main(String[] args) {
        int duracionLlamada, horario;
        String diaDeLaSemana;
        double total, precio, impuestos;
        final double IMPUESTO_DIA = 0.15, IMPUESTO_TARDE = 0.10, IMPUESTO_GENERAL = 0.03,
                TRAMO = 1, TRAMO2 = 0.8, TRAMO3 = 0.70, TRAMO4 = 0.5;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la duración de la llamada en minutos: ");
        duracionLlamada = sc.nextInt();
        System.out.print("Introduzca el día de la semana: ");
        sc.nextLine();

        diaDeLaSemana = sc.nextLine();
        System.out.println(diaDeLaSemana);
        System.out.print("Introduzca el horario en formato HH:MM: ");
        horario = Integer.parseInt(sc.next().substring(0, 2));

        if (duracionLlamada > 10) precio = TRAMO+TRAMO2+TRAMO3+TRAMO4;
        else if (duracionLlamada > 8) precio = TRAMO+TRAMO2+TRAMO3;
        else if (duracionLlamada > 5) precio = TRAMO+TRAMO2;
        else precio = TRAMO;

        if (!diaDeLaSemana.equalsIgnoreCase("domingo")) {
            if (0 < horario & horario < 14) impuestos = precio * IMPUESTO_DIA;
            else impuestos = precio * IMPUESTO_TARDE;
        } else impuestos = precio * IMPUESTO_GENERAL;

        total = precio + impuestos;
        System.out.println("\nEl precio de la llamada es de "+ String.format("%.2f", total) +" euros, de los " +
                "cuales "+String.format("%.2f", impuestos)+" euros son impuestos.");
    }
}
