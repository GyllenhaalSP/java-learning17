package PROG.P_REF1EV.P_REF_2;

import java.util.Scanner;

public class P_REF_2_4 {
    // Daniel Alonso Lázaro - 2022
    /*
    Tu primo Luis, de 12 años, está aprendiendo a usar la calculadora. Su
    profesor le ha dicho que calcule el factorial de varios números. Pero, para
    evitar que le tengan que copiar números muy largos en el cuaderno, les ha
    pedido únicamente el primer dígito, el de más a la izquierda.
    Recordando que el factorial es la multiplicación de todos los números entre
    el número y el uno (por ejemplo, el factorial de 8, escrito 8!, es
    8 · 7 · 6 · 5 · 4 · 3 · 2 · 1), demuestra a tu primo Luis que tú eres capaz de
    hacerlo mucho más rápido que él.

    Entrada:
        El programa recibirá en la primera línea de la entrada el número de casos
        de prueba. A continuación, cada caso de prueba estará compuesto de una
        única línea que contendrá un número (positivo). Se terminara al introducir
        un número negativo o nulo.
    Salida:
        Por cada caso de prueba n, se mostrará el último dígito (el de la izquierda) de su factorial, n!.
    */
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
