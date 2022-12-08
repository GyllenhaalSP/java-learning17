package PROG.P_REF1EV.P_REF_1;

import java.util.Scanner;

public class P_REF_1_1 {
    // Daniel Alonso Lázaro - 2022
    /*
    Queremos calcular la longitud de una circunferencia capturando su radio por
    teclado y el área y volumen de una esfera.
    */
    public static void main(String[] args) {
        java.util.Locale.setDefault(java.util.Locale.US);
        final double PI = Math.PI;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el radio: ");
        double radio = sc.nextDouble();
        double longitud = 2 * PI * radio;
        double area = 4 * PI * Math.pow(radio, 2);
        double volumen = 4 * PI * Math.pow(radio, 3) / 3;
        System.out.println("La longitud de la circunferencia es: " + String.format("%.2f", longitud) + " cm²" +
                "\nEl area de la esfera es: " + String.format("%.2f", area) + " cm²" +
                "\nEl volumen de la esfera es: " + String.format("%.2f", volumen) + " cm³");
    }
}
