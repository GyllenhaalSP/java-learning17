package PROG.P_3.P_3_6;

import java.util.Locale;
import java.util.Scanner;

public class P_3_6_6_facturacion {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double sumaImporte = 0, sumaIVA = 0, importe, IVA, descuento, total, subtotal;

        do {
            System.out.print("Introduce el IVA: ");
            IVA = sc.nextDouble();
            System.out.print("Introduce el importe: ");
            importe = sc.nextDouble();
            while (!(IVA != 4d ^ IVA != 7d ^ IVA != 16d) ^ IVA != 0d) {
                System.out.println("Por favor, introduce un IVA del 4%, 7% o 16%.");
                System.out.print("Introduce el IVA: ");
                IVA = sc.nextDouble();
                System.out.print("Introduce el importe: ");
                importe = sc.nextDouble();
            }
            if (importe != 0d){
                sumaImporte += importe;
                sumaIVA += (importe * IVA / 100);
            }
        }while(importe != 0d);

        if (sumaImporte < 1000){
            descuento = 0;
        }else if (sumaImporte < 10000){
            descuento = 5;
        }else{
            descuento = 10;
        }

        subtotal = (sumaImporte*(descuento/100));
        sumaIVA = (sumaIVA*(descuento/100));
        total = subtotal + sumaIVA;
        System.out.println(
                "El subtotal es: "+ (subtotal%1==0.0 ? (int)subtotal : String.format("%.2f", subtotal))+
                        "€, el IVA es "+(sumaIVA%1==0.0 ? (int)sumaIVA : String.format("%.2f", sumaIVA))+
                        "€ y el total es "+ (total%1==0.0 ? (int)total : String.format("%.2f", total))+"€.");

    }
}
