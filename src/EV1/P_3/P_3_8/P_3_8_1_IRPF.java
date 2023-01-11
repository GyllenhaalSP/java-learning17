package EV1.P_3.P_3_8;

import java.util.ArrayList;
import java.util.Scanner;

public class P_3_8_1_IRPF {
//    Hacer un programa que sea capaz de calcular el impuesto sobre la renta a partir del salario
//    anual de una persona y el número de hijos.
//    Tras cada solicitud de datos y de mostrar el importe del impuesto se pedirá si se quiere
//    continuar con otro caso (S/N) y el programa terminará al pulsar `N`.
//    El tipo impositivo será del 15% del salario anual de cada persona si los ingresos son
//    inferiores a 20.000 euros, del 18% si son superiores o iguales a 20.000 e inferiores a 30.000 y
//    25% si son superiores a 30.000.
//    Al salario bruto anual antes de aplicar los porcentajes anteriores se debe realizar una
//    deducción en función del número de hijos, que es del 0% si tiene 0, del 5% si tiene 1 o 2
//    y del 15% si tiene más de 2.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double hijos, deduccion = 0d, tipoInf = 0.15, tipoMed = 0.18, tipoSup = 0.25;
        String continuar;
        ArrayList<Double> salario = new ArrayList<>();
        ArrayList<Double> total = new ArrayList<>();

        do{
            System.out.print("Salario bruto: ");
            salario.add(sc.nextDouble());
            sc.nextLine();
            System.out.print("Número de hijos: ");
            hijos = sc.nextInt();
            sc.nextLine();
            System.out.println("¿Quieres continuar con otro caso? s/n");
            continuar = sc.nextLine();
        }while(!continuar.equalsIgnoreCase("n"));

        if (hijos > 2){
            deduccion = 0.15;
        } else if (hijos > 0){
            deduccion = 0.05;
        }

        for (double bruto : salario) {
            if (bruto > 30000){
                total.add((bruto - (deduccion != 0d ? bruto * deduccion : 0)) - (bruto * tipoSup));
            }
            else if (bruto > 20000) total.add((bruto - (deduccion != 0d ? bruto * deduccion : 0) - (bruto * tipoMed)));
            else total.add((bruto - (deduccion != 0d ? bruto * deduccion : 0) - (bruto * tipoInf)));
        }

        for (int i = 0; i < total.size(); i++){
            double x = salario.get(i);
            double y = total.get(i);
            double z = x-y;
            System.out.println("Caso "+(i+1)+": ");
            System.out.print("\tSalario bruto: "+(x%1==0.0 ? (int)x : String.format("%.2f", x))+
                    "€\n\tNúmero de hijos: "+(int)hijos+
                    "\n\tNeto anual: "+(y%1==0.0 ? (int)y : String.format("%.2f", y))+
                    "€\n\tRetenciones: "+(z%1==0.0 ? (int)z : String.format("%.2f", z))+
                    "€\n\n");
        }

        System.out.println("Gracias.");
    }
}
