package PROG.P_3.P_3_2;

import java.util.Scanner;

public class P_3_2_15_numPrimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, loop, cont;
        cont = 0;
        loop = 1;
        boolean flag = true;

        do{
            System.out.print("Escribe un número para determinar si es primo: ");
            num = sc.nextInt();
            if (num<0)
                System.out.println("El número es negativo, introduce un número positivo.");
            else
                flag = false;
        }while(flag);

        while(loop <= num){
            if(num%loop == 0){
                cont+=1;
            }
            loop+=1;
        }
        if (cont == 2){
            System.out.println(num+" es primo.");
        }else{
            System.out.println(num+" no es primo.");
        }
    }
}
