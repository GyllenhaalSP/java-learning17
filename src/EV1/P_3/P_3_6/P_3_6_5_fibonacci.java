package EV1.P_3.P_3_6;

import java.util.Scanner;

import static ProgramasPruebas.Metodos.fibonacci;

public class P_3_6_5_fibonacci {
//    La sucesión de Fibonacci se define de la siguiente forma: a1=1, a2=1 y an=an-1+an-2 para n>2, es decir,
//    los dos primeros son 1 y el resto, cada uno es la suma de los dos anteriores, los primeros son:
//            1, 1, 2, 3, 5, 8, 13, 21...
//    Hacer un programa para mostrar la sucesión hasta el N-ésimo término de la sucesión. N se introducirá desde teclado.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el enésimo número: ");
        int n = sc.nextInt(), primero = 1, segundo = 1, desplazable=0;

        while(n < 1) {
            System.out.print("Introduce un enésimo número mayor que 0: ");
            n = sc.nextInt();
        }

        System.out.print("\n"+primero+" ");

        if (n >= 2) {
            System.out.print(segundo);
        }

        for(int i = 0; i < n-2; i++){
            desplazable = primero+segundo;
            primero = segundo;
            segundo = desplazable;
            System.out.print(" "+desplazable);
        }

        if (n==1 || n==2){
            desplazable = 1;
        }

        System.out.println("\n\nEl "+n+"º número de la secuencia de fibonacci es "+desplazable);
        System.out.println("El "+n+"º número recursivo de la secuencia de fibonacci es "+fibonacci(n));
    }
}
