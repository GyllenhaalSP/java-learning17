package PROG.P_3.P_3_8;

import java.util.ArrayList;
import java.util.Scanner;

public class P_3_8_1_IRPF {
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
