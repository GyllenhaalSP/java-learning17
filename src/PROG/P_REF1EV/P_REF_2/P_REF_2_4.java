package PROG.P_REF1EV.P_REF_2;

import java.util.Scanner;

public class P_REF_2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = 1, num = 0, primerDigito;
        long factorial;

        do {
            if (casos < 1) System.out.println("El número de casos debe ser mayor que 0.\n");
            System.out.print("Introduzca el número de casos de prueba: ");
            casos = Integer.parseInt(sc.nextLine());
        } while (casos < 1);

        for (int i = 0; i < casos; i++) {
            do {
                if (num < 0) System.out.println("Número introducido inválido.");
                System.out.print("\nIntroduzca el número para calcular su factorial: ");
                num = Integer.parseInt(sc.nextLine());
            } while (num < 0);

            factorial = num;
            for (int j = num - 1; j > 0; j--) {
                factorial *= j;
            }

            primerDigito = Integer.parseInt(Long.toString(factorial).substring(0, 1));
            System.out.println("El primer dígito de "+num+"! es "+primerDigito+".");
        }
    }
}
