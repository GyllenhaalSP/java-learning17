package PROG.P_4.P_4_3;

import java.util.Scanner;

public class P_4_3_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        double base, exp;
        do{
            System.out.print("Introduce una base: ");
            base = sc.nextDouble();
            System.out.print("Introduce un exponente: ");
            exp = sc.nextDouble();
            sc.nextLine();
            System.out.println("El resultado es: "+Math.pow(base, exp));
            System.out.print("¿Quieres continuar? (S/FIN) ");
            respuesta = sc.nextLine().toUpperCase();
        }while(!respuesta.equals("FIN"));
    }
}
