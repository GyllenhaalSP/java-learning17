package EV1.P_3.P_3_6;

import java.util.Locale;
import java.util.Scanner;

public class P_3_6_6_facturacion {
//    Hacer un programa que calcule el total de una factura, partiendo de una
//    lista de parejas de valores, importe e iva, que se introducirán por teclado.
//        ▪ La lista finaliza cuando se introduzca el importe 0.
//        ▪ El iva puede ser el 4%, el 7% o el 16%, en cualquier otro caso se rechazan importe e iva y
//          se deben introducir de nuevo.
//        ▪ Finalmente hay que realizar un descuento, en función de la suma de los importes, dicho descuento es
//          del 0% si es menor que 1000, es del 5% si es mayor o igual que 1000 y menor que 10000 y es de un 10%
//          si es mayor o igual que 10000.
//        ▪ El descuento se debe aplicar a la suma de los importes y a la suma de los ivas.
//    Para acabar se debe imprimir el importe y el iva resultantes (total menos descuento) y la suma de ambos.
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
