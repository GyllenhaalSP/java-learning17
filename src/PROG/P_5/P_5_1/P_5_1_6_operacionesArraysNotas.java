package PROG.P_5.P_5_1;

import java.util.stream.IntStream;

public class P_5_1_6_operacionesArraysNotas {
    // Daniel Alonso Lázaro - 2022
    /*
    Realizar un programa Java que cargue un vector con las notas de los 40 alumnos de una clase
    y visualice el número de alumnos aprobados, el número de alumnos suspensos y la nota media
    de la clase, y el número de calificaciones superiores a la media.
    */
    public static void main(String[] args) {
        int[] notas = {5, 4, 3, 6, 8, 9, 10, 10, 2, 1, 5, 4, 8, 5, 10, 9, 8, 6, 4, 5, 6, 3, 4, 3, 8, 9,
        7, 8, 6, 7, 6, 5, 6, 6, 5, 7, 4, 5, 3, 6};
        int aprobados = 0, suspensos = 0, sumaNotas = IntStream.of(notas).sum(), contNotaMedia = 0;
        double notaMedia;
        notaMedia = (double)sumaNotas/notas.length;
        for (int nota : notas) {
            if (nota >= 5) aprobados++;
            else suspensos++;
            if (nota >= notaMedia) contNotaMedia++;
        }
        System.out.println("La nota media es: "+notaMedia
                +".\nHay "+aprobados
                +" aprobados y "+suspensos
                +" suspensos.\nHay "+contNotaMedia
                +" alumnos que han aprobado con una nota por encima de la media.");
    }
}
