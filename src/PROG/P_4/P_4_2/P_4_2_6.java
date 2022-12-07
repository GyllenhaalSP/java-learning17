package PROG.P_4.P_4_2;

import java.util.Scanner;

public class P_4_2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una palabra: ");
        String palabra = sc.nextLine();
        System.out.print("Introduce una sílaba: ");
        String silaba = sc.nextLine();

        if(palabra.toLowerCase().startsWith(silaba.toLowerCase())){
            System.out.println(palabra+" empieza por "+silaba);
        }else{
            System.out.println(palabra+" no empieza por "+silaba);
        }
    }
}
