package PROG.P_REF1EV.P_REF_1;

import java.util.Scanner;

public class P_REF_1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un valor: ");
        double valor = Double.parseDouble(sc.nextLine());
        if (valor > 1500) {
            double descuento = valor * 0.12;
            valor = valor - descuento;
            System.out.println("El valor con descuento es " + valor);
        } else {
            System.out.println("El valor introducido es " + valor);
        }
    }
}
