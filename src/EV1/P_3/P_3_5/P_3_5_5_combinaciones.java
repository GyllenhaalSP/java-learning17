package EV1.P_3.P_3_5;

import java.util.Scanner;

import static ProgramasPruebas.metodos.factorial;

public class P_3_5_5_combinaciones {
//    Nos piden que calculemos cuantas combinaciones podemos hacer de m elementos tomados de n en n.
//    Pediremos que se introduzca por teclado m y n.
//    La fórmula a aplicar de las combinaciones de m elementos tomados de n en n es la siguiente:
//    C(m,n) = m! / (n! * (m-n)!)
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
}
