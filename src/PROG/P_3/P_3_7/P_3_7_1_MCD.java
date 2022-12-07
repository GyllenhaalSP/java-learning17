package PROG.P_3.P_3_7;

import java.util.Scanner;

public class P_3_7_1_MCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero positivo: ");
        int n = sc.nextInt(), r, mcd;
        while (n < 1){
            System.out.print("El número debe ser positivo: ");
            n = sc.nextInt();
        }

        System.out.print("Introduce un segundo número entero positivo: ");
        int m = sc.nextInt();
        while (m < 1) {
            System.out.print("El número debe ser positivo: ");
            m = sc.nextInt();
        }

        do {
            r = n % m;
            if (r != 0){
                n = m;
                m = r;
            }
        }while (r != 0);

        mcd = m;

        System.out.println("El MCD es "+mcd);

    }
}
