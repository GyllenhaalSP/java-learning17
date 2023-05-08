package EV3.C_20230309;

import java.util.GregorianCalendar;
import java.util.Locale;

public class AplicandoClaseGregorianCalendar {
    public static void main(String[] args) {
        System.out.println("-------- APLICANDO LA CLASE GregorianCalendar ---------\n");

        GregorianCalendar calendario = new GregorianCalendar();
        GregorianCalendar calendario2 = new GregorianCalendar(2023, GregorianCalendar.FEBRUARY, 9);
        System.out.println("Fecha 1: " + calendario.getTime().toLocaleString());
        System.out.println("Fecha 2: " + calendario2.getTime().toLocaleString());
        System.out.println("\nFecha 1: "
                + calendario.get(GregorianCalendar.DAY_OF_MONTH)
                + "/"
                + calendario.get(GregorianCalendar.MONTH)
                + "/"
                + calendario.get(GregorianCalendar.YEAR));

        System.out.println("Fecha 2: "
                + calendario2.get(GregorianCalendar.DAY_OF_MONTH)
                + " de "
                + calendario2.getDisplayName(
                    GregorianCalendar.MONTH,
                    GregorianCalendar.LONG,
                    new Locale("es", "ES"))
                + " de "
                + calendario2.get(GregorianCalendar.YEAR));

        final int MILISEGUNDOS_AL_DIA = 1000 * 60 * 60 * 24;

        System.out.println("Han pasado "
                + ((calendario.getTimeInMillis() - calendario2.getTimeInMillis()) / MILISEGUNDOS_AL_DIA)
                + " días desde la fecha 2 hasta la fecha 1.");

        System.out.println("\nSuma 2 días a la fecha 1: ");
        calendario.add(GregorianCalendar.DAY_OF_MONTH, 2);
        System.out.println("\tLa fecha 1 tras sumar 2 días es: "
                + calendario.getTime().toLocaleString() + "\n");
        System.out.println("Resta 2 días a la fecha 2: ");
        calendario2.add(GregorianCalendar.DAY_OF_MONTH, -2);
        System.out.println("\tLa fecha 2 tras restar 2 días es: "
                + calendario2.getTime().toLocaleString() + "\n");
    }
}
