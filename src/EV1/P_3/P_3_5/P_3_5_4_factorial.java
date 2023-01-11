package EV1.P_3.P_3_5;

import java.util.Scanner;

public class P_3_5_4_factorial {
//    Calcular el factorial de un número introducido por teclado. Te recuerdo que
//    no existen factoriales de números negativos y que el factorial de 0 es 1.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long userInput = 0, factorial = 1;

        do {
            if (userInput < 0)
                System.out.println("ERROR: Número negativo.");
            System.out.print("Introduce un número entero positivo: ");
            userInput = sc.nextInt();
        }while(userInput < 0);

        for (int i=1; i<=userInput; i++) {
            factorial *= i;
        }
        System.out.println("El factorial de "+userInput+" es "+factorial+".");
    }
}
