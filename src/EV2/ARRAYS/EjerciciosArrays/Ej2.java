package EV2.ARRAYS.EjerciciosArrays;

import static utilities.Metodos.cargarArray;
import static utilities.Metodos.mostrarArray;

public class Ej2 {
    /*
    Realiza un programa que muestre por pantalla un array de 10 filas por 10 columnas relleno con números enteros aleatorios comprendidos entre 50 y 300, ambos incluidos. Los números deben estar correctamente alineados al mostrarlos por pantalla usando el formato de printf() o de String.format() que hemos visto en clase.
    A continuación, el programa debe mostrar todos los números de la diagonal que va desde la esquina superior izquierda a la esquina inferior derecha. También debe mostrar el número máximo, mínimo y la media de los números que hay en esa diagonal.
     */

    public static void main(String[] args) {
        int[][] array = new int[10][10];
        cargarArray(array, 50, 301);

        mostrarArray("Soy un array", array, 10);

        System.out.println("Diagonal 1");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i][i] + " ");
        }

        System.out.println("\nDiagonal 2");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i][array.length - 1 - i] + " ");
        }
    }
}
