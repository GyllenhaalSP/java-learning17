package EV1.P_5.P_5_3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static ProgramasPruebas.metodos.cargarArray;

public class P_5_3_6_notasBidimensionales {
    //Daniel Alonso Lázaro - 2023
    /*
    Cargar desde teclado un array con las notas de las 3 asignaturas de cada uno de los 15
    alumnos de una clase. Cada fila contendrá los datos de una asignatura y cada columna
    la nota de un alumno determinado. Visualizar la nota media de cada alumno, la nota
    media de cada asignatura y la nota media de la clase.
    */
    public static void main(String[] args) {
        int[][] notas = new int[15][3];
        double[] mediaAlumnos = new double[15];
        double[] mediaAsignaturas = new double[3];
        double mediaClase;
        int sumaNotas = 0, sumaAsignaturas = 0, cont = 1;

        cargarArray(notas, 0, 10);

        for(int[] nota : notas){
            System.out.print(Arrays.toString(nota)+" ");
        }

        System.out.println("\n");

        for(int i = 0; i < notas.length; i++){
            for(int j = 0; j < notas[i].length; j++){
                sumaNotas += notas[i][j];
            }
            mediaAlumnos[i] = new BigDecimal(sumaNotas/(double)notas[i].length)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            System.out.println("La nota media del alumno "+cont+" es: "+
                    (mediaAlumnos[i]%1==0
                            ?(int)mediaAlumnos[i]
                            :Double.toString(mediaAlumnos[i])));
            sumaNotas = 0;
            cont++;
        }

        cont = 1;
        System.out.println();

        for(int i = 0; i < notas[i].length; i++){
            for (int[] nota : notas) {
                sumaAsignaturas += nota[i];
            }
            mediaAsignaturas[i] = new BigDecimal(sumaAsignaturas/(double)notas.length)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            System.out.println("La nota media de la asignatura "+cont+" es: "+
                    (mediaAsignaturas[i]%1==0.0
                            ?(int)mediaAsignaturas[i]
                            :Double.toString(mediaAsignaturas[i])));
            sumaAsignaturas = 0;
            cont++;
        }

        System.out.println();

        for (double array : mediaAsignaturas) {
            sumaNotas += array;
        }

        mediaClase = new BigDecimal(sumaNotas/(double)mediaAsignaturas.length)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        System.out.println("La nota media de la clase es: "+
                (mediaClase%1==0.0
                        ?(int)mediaClase
                        :Double.toString(mediaClase)));
    }
}