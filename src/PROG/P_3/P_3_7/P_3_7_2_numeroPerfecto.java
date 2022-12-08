package PROG.P_3.P_3_7;

import java.util.Scanner;

public class P_3_7_2_numeroPerfecto {
//    Dados dos números enteros positivos N y D, se dice que D es un divisor
//    de N si el resto de dividir N entre D es 0. Se dice que un número N es
//    perfecto si la suma de sus divisores (excluido el propio N) es N. Por
//    ejemplo 28 es perfecto, pues sus divisores (excluido el 28) son: 1, 2, 4, 7
//    y 14 y su suma es 1+2+4+7+14=28.
//    Hacer un programa que dado un número N nos diga si es o no perfecto.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n = sc.nextInt(), suma = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                suma += i;
            }
        }
        if (suma == n) {
            System.out.println("El "+n+" es un número perfecto.");
        } else {
            System.out.println("El "+n+" no es un número perfecto.");
        }
    }
}
