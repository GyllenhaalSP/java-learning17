package PROG.P_5.P_5_3;

import static ProgramasPruebas.metodos.cargarArray;
import static ProgramasPruebas.metodos.mostrarArray;

public class P_5_3_7_notasClaseBidimensionales {
    //Daniel Alonso Lázaro - 2023
    /*
    Realizar un programa Java que:
        a. Llene un array bidimensional con las notas numéricas de cada estudiante en las
           clases de un profesor, se supone que el profesor tiene 3 clases diferentes y un
           máximo de 30 alumnos por clase.
        b. Visualice el array.
        c. Calcule la nota máxima y mínima visualizando a qué alumno y grupo pertenece, en
           caso de que estas notas se repitan se visualizan todas.
    */
    public static void main(String[] args) {
        int[][] notas = new int[3][30];
        int[] notasClase1 = notas[0];
        int[] notasClase2 = notas[1];
        int[] notasClase3 = notas[2];
        int notaMaxima = 0, notaMinima = 10;

        cargarArray(notasClase1, 10);
        cargarArray(notasClase2, 10);
        cargarArray(notasClase3, 10);

        mostrarArray("Las notas son: ", notas);

        for(int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] == notaMaxima) {
                    System.out.println("La nota máxima es: " + notaMaxima + ", alumno " + (j + 1) +
                            ", clase " + (i + 1));
                } else if (notas[i][j] == notaMinima) {
                    System.out.println("La nota mínima es: " + notaMinima + ", alumno " + (j + 1) +
                            ", clase " + (i + 1));
                }
            }
        }
    }
}
