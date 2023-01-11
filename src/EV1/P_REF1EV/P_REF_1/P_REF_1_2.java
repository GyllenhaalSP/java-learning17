package EV1.P_REF1EV.P_REF_1;

import java.util.Scanner;

public class P_REF_1_2 {
    // Daniel Alonso Lázaro - 2022
    /*
    Se introduce por teclado el sueldo bruto de un trabajador. Queremos calcular
    su sueldo neto. Sabiendo que debemos descontarle un 5% en concepto de
    Seguridad Social y un 14 % de I.R.P.F. Ver los descuentos de cada concepto y
    el sueldo final.
    */
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
