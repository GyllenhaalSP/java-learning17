package EV2.OOP.C_20230309;

//Compilar con 'javac -encoding utf8 MainFibonacci.java' para mostrar acentos.

import java.util.HashMap;
import java.util.Map;

/**
 * Clase contenedora del método recursivo para obtener el número de fibonacci de n iteraciones.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class MainFibonacciHashMap {
    static int longitud = 0;

    public static void main(String[] args) {
        int numero = Integer.parseInt(args[longitud]);
        Map<Integer, Long> map = new HashMap<>();
        System.out.println("El número de iteraciones Fibonacci encontrado en 'args[" + longitud + "]' es: " + numero + ".\n");

        for (int i = 1; i < numero; i++) {
            System.out.println("El número Fibonacci es: " + fibonacciRecursivo(i, map) + " en la iteración " + (i) + ".");
        }
        System.out.println("El número Fibonacci es: "
                + fibonacciRecursivo(numero, map) + " en la iteración " + (numero) + ".\n");

        longitud++;
        if (longitud < args.length){
            main(args);
        }
    }

    public static long fibonacciRecursivo(int numero, Map<Integer, Long> map){
        if(map.get(numero) != null){
            return map.get(numero);
        }
        if (numero == 0) {
            return 0;
        }else if (numero == 1) {
            return 1;
        }else{
            long fibonacci = fibonacciRecursivo(numero - 1, map) + fibonacciRecursivo(numero - 2, map);
            map.put(numero, fibonacci);
            return fibonacci;
        }
    }
}