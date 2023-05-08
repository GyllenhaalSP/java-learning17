package EV3.C_20230309;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
/*
1. Instancia 2 objetos de la clase utilizando distintos constructores. Comprueba.
2. Utilizando el método get para obtener los valores de los distintos FIELD, muestra la información de alguna
    de las fechas instanciadas.
3. Utilizando lo anterior visualiza la primera fecha con el formato dd/mm/yyy y la segunda con el día de la semana,
   dd de <nombre del mes> de yyyy
4. Calcular el tiempo transcurrido entre las dos fechas.
5. Comprobar si el año de una fecha es bisiesto
6. Sumar y restar valores al día, mes o año de una fecha.
 */

public class ClaseGregorianCalendar {
    public static void main(String[] args) {
        System.out.println("Año actual: ");
        GregorianCalendar calendario = new GregorianCalendar();
        int currentYear = calendario.get(Calendar.YEAR);
        System.out.println("\tEl año actual es: " + currentYear + "\n");
        System.out.println("Mes actual: ");
        GregorianCalendar calendario2 = new GregorianCalendar();
        calendario2.set(Calendar.MONTH, 3);
        System.out.println("\tEl mes actual es: " + calendario2.get(Calendar.MONTH) + "\n");
        System.out.println("Sumar 3 meses a la fecha actual: ");
        GregorianCalendar calendario3 = new GregorianCalendar();
        calendario3.add(Calendar.MONTH, 3);
        System.out.println("\tLa fecha actual tras agregar 3 meses es: "
                + calendario3.getTime().toLocaleString() + "\n");
        calendario3.add(Calendar.MONTH, -7);
        System.out.println("Restar 7 meses a la fecha anterior: ");
        System.out.println("\tLa fecha anterior tras restar 7 meses es: "
                + calendario3.getTime().toLocaleString() + "\n");
        System.out.println("Imprime años random desde 1896 hasta 2023 y dice si son bisiestos: ");
        GregorianCalendar calendario4 = new GregorianCalendar();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int year = rand.nextInt(1896, 2023);
            System.out.println("\t¿Es el año " + year + " bisiesto? " + calendario4.isLeapYear(year));
        }
        GregorianCalendar calendario5 = new GregorianCalendar(1990, GregorianCalendar.JANUARY, 30);
        GregorianCalendar calendario6 = new GregorianCalendar(1967, GregorianCalendar.MARCH, 28);
        System.out.println("\nFecha 1: " + calendario5.getTime().toLocaleString());
        System.out.println("Fecha 2: " + calendario6.getTime().toLocaleString());
        System.out.println("Fecha 3: " + calendario.getTime().toLocaleString());
        System.out.println("\n¿La fecha 1 es igual a la fecha 2? " + calendario5.equals(calendario6));
        System.out.println("¿La fecha 1 es anterior a la fecha 3? " + calendario5.before(calendario));
        System.out.println("¿La fecha 3 es posterior a la fecha 2? " + calendario6.after(calendario));
    }
}
