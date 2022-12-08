package PROG.P_3.P_3_6;

import java.util.Scanner;

public class P_3_6_4_sumaNnumeros {
//    Sumar los N primeros impares. Amplíalo después para que haga lo mismo con los pares
//    y, otro, con los múltiplos de 3.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la cantidad de números a imprimir: ");
        int n = sc.nextInt(), contPar = 0, contImpar = 0, contMult = 0, par = 0, impar = 0, mult3 = 0;

        for(int i = 1; contMult < n; i++){
            if(i % 2 == 0){
                if (contPar != n) {
                    par += i;
                    contPar++;
                }
            }
            if(!(i % 2 == 0)){
                if (contImpar != n){
                    impar += i;
                    contImpar++;
                }
            }
            if (i % 3 == 0) {
                mult3 += i;
                contMult++;
            }
        }

        System.out.println("La suma de los "+n+" primeros impares es "+impar);
        System.out.println("La suma de los "+n+" primeros pares es "+par);
        System.out.println("La suma de los "+n+" primeros múltiplos de 3 es "+mult3);
    }
}
