package PROG.P_3.P_3_5;

import java.util.Scanner;

public class P_3_5_5_combinaciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n, m, factorialM, factorialN, factorialMn, resultado;

        System.out.print("Introduzca el término N: ");
        n = sc.nextInt();

        System.out.print("Introduzca el término M: ");
        m = sc.nextInt();

        factorialM = factorial(m);
        factorialN = factorial(n);
        factorialMn = factorial(m-n);

        resultado = (factorialM / (factorialN * factorialMn));
        System.out.println(resultado);
    }

    public static long factorial(long num){
        long resFact = 1;
        for (long i=1; i<=num; i++) {
            resFact *= i;
        }
        return resFact;
    }
}
