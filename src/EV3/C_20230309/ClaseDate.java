package EV3.C_20230309;

import java.util.Calendar;
import java.util.Date;

public class ClaseDate {
    /*
    1.- Instanciar un objeto de la clase con el constructor por defecto.
    Muestra por pantalla la fecha que se ha instanciado.
    2.- Instancia una segunda fecha utilizando el constructor al que le pasas los parámetros año, mes y día.
    Comprueba y visualiza el resultado.
    3.- ¿Cuál es la fecha inicial utilizada por la clase Date?
    4.- Visualiza las fechas instanciadas utilizando métodos para mostrar formatos distintos.
    Usa el método para visualizar el método de formato local.
    5.- Utiliza algún método para visualizar cuál de las fechas es anterior a la otra.
    */

    public static void main(String[] args) {
        Date fecha1 = new Date();
        System.out.println("Fecha 1: " + fecha1);
        System.out.println("---------");
        Date fecha2 = new Date(2023, Calendar.MARCH, 9);
        System.out.println("Fecha 2: " + fecha2);
        System.out.println("---------");
        Date fecha2Corregida = new Date((2023-1900), Calendar.MARCH, 9);
        System.out.println("Fecha 2 corregida: " + fecha2Corregida);
        System.out.println("---------");
        System.out.println("Fecha 1: " + fecha1.toLocaleString());
        System.out.println("Fecha 2: " + fecha2.toLocaleString());
        System.out.println("Fecha 2 corregida: " + fecha2Corregida.toLocaleString());
        System.out.println("---------");
        System.out.println("Fecha 1 es anterior a Fecha 2: " + fecha1.before(fecha2));
        System.out.println("Fecha 2 es anterior a Fecha 1: " + fecha2.before(fecha1));
    }
}
