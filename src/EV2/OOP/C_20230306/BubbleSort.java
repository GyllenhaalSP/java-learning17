package EV2.OOP.C_20230306;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Clase contenedora de los diferentes métodos para implementar el algoritmo de ordenación por burbuja.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        final int MAX_NUMEROS = 10_000;
        // 100.000 = 18secs+-
        // 1.000.000 = 1814+- secs = 30 mins
        // 10.000.000  = 180.000+- secs = 50 horas
        final int MIN_RANGO = -1000;
        final int MAX_RANGO = 1000;
        final int SEPARADOR = 1000;
        int[] masterArray = cargarArray(new int[MAX_NUMEROS], MIN_RANGO, MAX_RANGO);
        long inicio = System.nanoTime();
        boolean longitudImpresion = masterArray.length <= 10000;

        int[] array = masterArray.clone();
        if(longitudImpresion) mostrarArray("Array desordenado: ", masterArray, SEPARADOR);
        bubbleSort(array);
        tiempoToString(inicio);

        inicio = System.nanoTime();
        int[] array2 = masterArray.clone();
        if(longitudImpresion) mostrarArray("Array2 desordenado: ", masterArray, SEPARADOR);
        bubbleSortMejorado(array2);
        tiempoToString(inicio);

        inicio = System.nanoTime();
        int[] array3 = masterArray.clone();
        if(longitudImpresion) mostrarArray("Array3 desordenado: ", masterArray, SEPARADOR);
        bubbleSortMasMejorado(array3);
        tiempoToString(inicio);

        if(longitudImpresion){
            mostrarArray("Array ordenado: ", array, SEPARADOR);
            mostrarArray("Array2 ordenado: ", array2, SEPARADOR);
            mostrarArray("Array3 ordenado: ", array3, SEPARADOR);
        }
    }

    /**
     * Implementación del algoritmo Bubble Sort.
     * @param array Array unidimensional que se va a ordenar.
     */
    public static void bubbleSort(int[] array) {
        int aux;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    /**
     * Segunda mejora del algoritmo Bubble Sort.
     * @param array Array unidimensional que se va a ordenar.
     */
    public static void bubbleSortMejorado(int[] array){
        int aux;
        boolean ordenado = false;
        for (int i = 0; i < array.length && !ordenado; i++) {
            ordenado = true;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    ordenado = false;
                }
            }
        }
    }

    /**
     * Tercera mejora del algoritmo Bubble Sort.
     * @param array Array unidimensional que se va a ordenar.
     */
    public static void bubbleSortMasMejorado(int[] array){
        int aux;
        boolean ordenado = false;
        for (int i = 0; i < array.length && !ordenado; i++) {
            ordenado = true;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    ordenado = false;
                    i = j;
                }
            }
        }
    }

    /**
     * Carga un array unidimensional de enteros con números aleatorios entre min inclusive y max inclusive.
     * @param v Array unidimensional que recibe.
     * @param min Mínimo inclusive del rango de números que se generarán.
     * @param max Máximo inclusive del rango de números que se generarán.
     * @return Array unidimensional cargado con números enteros aleatorios entre min inclusive y max inclusive.
     */
    public static int[] cargarArray(int[] v, int min, int max){
        return new Random().ints(v.length, min, max + 1).toArray();
    }

    /**
     * Imprime el array unidimensional de enteros que recibe y un mensaje junto con él.
     * @param mensaje Mensaje que se imprime antes de la impresión del array.
     * @param v Array unidimensional que se va a imprimir.
     * @param separador Indica cada cuántos elementos se imprime un salto de línea.
     */
    public static void mostrarArray(String mensaje, int[] v, int separador){
        System.out.println(mensaje);
        for(int i = 0, j = 1; i < v.length; i++, j++){
            System.out.printf("%5d ", v[i]);
            if(j%separador==0)System.out.println();
        }
        System.out.println();
    }

    /**
     * Imprime el tiempo transcurrido entre dos momentos en segundos, milisegundos, microsegundos y nanosegundos.
     * @param inicio variable que contiene el inicio del contador en nanosegundos.
     */
    public static void tiempoToString(long inicio){
        System.out.println("Ha tardado: " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - inicio) + " segundos");
        System.out.println("O bien: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - inicio) + " milisegundos");
        System.out.println("O bien: " + TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - inicio) + " microsegundos");
        System.out.println("O bien: " + (System.nanoTime() - inicio) + " nanosegundos\n");
    }
}
