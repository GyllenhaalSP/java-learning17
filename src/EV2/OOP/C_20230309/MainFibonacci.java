package EV2.OOP.C_20230309;

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
