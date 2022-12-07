package PROG.P_REF1EV.P_REF_1;

import java.util.Scanner;

public class P_REF_1_2 {
    public static void main(String[] args) {
        double sueldoBruto, sueldoNeto, descuentoSeguridadSocial, descuentoIRPF;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el sueldo bruto: ");
        sueldoBruto = Double.parseDouble(sc.nextLine());
        descuentoSeguridadSocial = sueldoBruto * 0.05;
        descuentoIRPF = sueldoBruto * 0.14;
        sueldoNeto = sueldoBruto - descuentoSeguridadSocial - descuentoIRPF;
        System.out.println("El sueldo bruto es: " + sueldoBruto + "€" +
                "\nEl descuento de Seguridad Social es: " + descuentoSeguridadSocial + "€" +
                "\nEl descuento de IRPF es: " + descuentoIRPF + "€" +
                "\nEl sueldo neto es: " + sueldoNeto + "€");
    }
}
