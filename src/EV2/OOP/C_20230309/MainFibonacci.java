package EV2.OOP.C_20230309;

//Compilar con 'javac -encoding utf8 MainFibonacci.java' para mostrar acentos.

/**
 * Clase contenedora del método recursivo para obtener el número de fibonacci de n iteraciones.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class MainFibonacci {
    public static void main(String[] args) {
        int numero = Integer.parseInt(args[0]);
        System.out.print("El número de iteraciones Fibonacci encontrado en 'args[0]' es: "+numero);
        for (int i = 1; i < numero; i++) {
            System.out.println("El número Fibonacci es: " + fibonacciRecursivo(i) + " en la iteración " + (i) + ".");
        }
        System.out.println("El número Fibonacci es: "
                + fibonacciRecursivo(numero) + " en la iteración " + (numero) + ".");
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
