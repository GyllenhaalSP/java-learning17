package EV3.C_20230309;

//Compilar con 'javac -encoding utf8 MainFibonacci.java' para mostrar acentos.

/**
 * Clase contenedora del método recursivo para obtener el número de fibonacci de n iteraciones.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class MainFibonacci {
    static int longitud = 0;

    public static void main(String[] args) {
        int numero = Integer.parseInt(args[longitud]);
        System.out.println("El número de iteraciones Fibonacci encontrado en 'args[" + longitud + "]' es: " + numero + ".\n");

        for (int i = 1; i < numero; i++) {
            System.out.println("El número Fibonacci es: " + fibonacciRecursivo(i) + " en la iteración " + (i) + ".");
        }
        System.out.println("El número Fibonacci es: "
                + fibonacciRecursivo(numero) + " en la iteración " + (numero) + ".\n");

        longitud++;
        if (longitud < args.length){
            main(args);
        }
    }

    public static int fibonacciRecursivo(int numero){
        if (numero == 0) {
            return 0;
        }else if (numero == 1) {
            return 1;
        }else{
            return fibonacciRecursivo(numero - 1) + fibonacciRecursivo(numero - 2);
        }
    }
}
