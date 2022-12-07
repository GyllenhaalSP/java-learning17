package PROG.P_3.P_3_7;

import java.util.Scanner;

public class P_3_7_2_numeroPerfecto {
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
