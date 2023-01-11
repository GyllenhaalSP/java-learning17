package EV1.P_3.P_3_6;

import java.util.Scanner;

public class P_3_6_2_progresionGeometrica {
//    Sumar los N primeros términos de una progresión geométrica de primer término A y razón R (dados por teclado).
//    Se debe realizar la suma sin emplear la fórmula que existe para ello.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        do {
            if (n<=0){
                System.out.println("El valor de términos debe ser mayor que 0");
            }
            System.out.print("Introduce cuántos términos quieres sumar: ");
            n = sc.nextInt();
        }while(n<=0);
        System.out.print("Introduce el término: ");
        int a = sc.nextInt();
        System.out.print("Introduce la razón: ");
        int r = sc.nextInt();
        long suma = 0, termino = a;

        for(int i=0; i<n; i++){
            termino *= r;
            suma += termino;
        }

        System.out.println("La suma de los "+n+" primeros términos de la progresión geométrica con término "+a+" y razón "+r+" es "+suma+".");
    }
}
