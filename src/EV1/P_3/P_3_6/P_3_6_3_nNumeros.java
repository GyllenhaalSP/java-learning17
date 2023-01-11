package EV1.P_3.P_3_6;

import java.util.Scanner;

public class P_3_6_3_nNumeros {
//    Sumar N números introducidos por teclado y mostrar el resultado. El
//    valor de N se debe haber leído previamente.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos números vas a sumar? ");
        int n = sc.nextInt();
        System.out.print("Introduce el primer número: ");
        int total = sc.nextInt();

        for (int i = 0; i < n-1; i++){
            System.out.print("Introduce el siguiente número: ");
            int j = sc.nextInt();
            total += j;
        }
        System.out.println("El total introducido es "+total);
    }
}
