package PROG.P_REF1EV.P_REF_2;

import java.util.Scanner;

public class P_REF_2_1 {
    // Daniel Alonso Lázaro - 2022
    /*
    Una empresa tiene tres tipos de empleados de categorías 1, 2 y 3.
    El salario de un empleado se calcula como salario=salario base+extras.
    La empresa establece el salario de acuerdo a las siguientes reglas:
        ➢ Empleado tipo 1: tiene un incremento del 2% sobre el salario base si el salario es menor de 3.000 euros.
        ➢ Empleado tipo 2: tiene un incremento del 5% en los extras si el salario resultante después del incremento
                            no es superior a 2000.
        ➢ Empleado tipo 3: tiene un incremento del 7% en el salario base si este es menor que 1.500.
        ➢ En otro caso el incremento sobre el salario base es del 5%.

    Haz un programa que, dados el tipo de empleado, el salario base y el importe
    de los complementos muestre el valor final de su salario.
    El programa debe validar las distintas entradas de datos para que, el salario
    base y el importe de los complementos sea un número mayor que 0.
    Después de mostrar el salario de cada empleado el programa debe preguntar si queremos introducir más datos o no.
    En el caso de que la respuesta sea S, se repetirá el proceso en cualquier otro caso el programa acaba.
    El programa debe mostrar al final, el número de empleados introducidos y el importe de sus salarios de cada tipo
    de empleados y el importe total de los salarios tramitados.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tipoEmpleado, contadorTipo1 = 0, contadorTipo2 = 0, contadorTipo3 = 0, contadorOtros = 0;
        double salarioBase, complementos, salarioFinal, totalSalarios,
                totalTipo1 = 0d, totalTipo2 = 0d, totalTipo3 = 0d, totalOtros = 0d;
        char respuesta;

        do {
            System.out.print("Introduce el tipo de empleado (1, 2 o 3): ");
            tipoEmpleado = Integer.parseInt(sc.nextLine());

            do {
                System.out.print("Introduce el salario base: ");
                salarioBase = Double.parseDouble(sc.nextLine());
            }while(salarioBase < 1);

            do {
                System.out.print("Introduce el importe de los complementos: ");
                complementos = Double.parseDouble(sc.nextLine());
            }while(complementos < 1);

            switch (tipoEmpleado) {
                case 1 -> {
                    if (salarioBase < 3000) salarioBase += (salarioBase * 0.02);
                    salarioFinal = calculoSalarios(salarioBase, complementos);
                    contadorTipo1++;
                    totalTipo1 += salarioFinal;
                }
                case 2 -> {
                    salarioFinal = salarioBase + complementos;
                    if (salarioFinal < 2000) complementos += (complementos * 0.05);
                    salarioFinal = calculoSalarios(salarioBase, complementos);
                    contadorTipo2++;
                    totalTipo2 += salarioFinal;
                }
                case 3 -> {
                    if (salarioBase < 1500) salarioBase += (salarioBase * 0.07);
                    salarioFinal = calculoSalarios(salarioBase, complementos);
                    contadorTipo3++;
                    totalTipo3 += salarioFinal;
                }
                default -> {
                    salarioBase = salarioBase + (salarioBase * 0.05);
                    salarioFinal = salarioBase + complementos;
                    contadorOtros++;
                    totalOtros += salarioFinal;
                }
            }
            System.out.println("El salario final del empleado es: "
                    +(salarioFinal%1==0?(int)salarioFinal:String.format("%.2f", salarioFinal))+"€");
            System.out.print("¿Quieres introducir más datos? (S/N): ");
            respuesta = sc.next().charAt(0);
            sc.nextLine();
        }while(Character.toLowerCase(respuesta) == 's');

        totalSalarios = totalTipo1 + totalTipo2 + totalTipo3 + totalOtros;

        System.out.println("El número de empleados de tipo 1 es: "
                +contadorTipo1+" y el total de sus salarios es: "
                +(totalTipo1 % 1 == 0 ? (int)totalTipo1 : String.format("%.2f", totalTipo1))+"€");
        System.out.println("El número de empleados de tipo 2 es: "
                +contadorTipo2+" y el total de sus salarios es: "
                +(totalTipo2 % 1 == 0 ? (int)totalTipo2 : String.format("%.2f", totalTipo2))+"€");
        System.out.println("El número de empleados de tipo 3 es: "
                +contadorTipo3+" y el total de sus salarios es: "
                +(totalTipo3 % 1 == 0 ? (int)totalTipo3 : String.format("%.2f", totalTipo3))+"€");
        System.out.println("El número de empleados de otro tipo es: "
                +contadorOtros+" y el total de sus salarios es: "
                +(totalOtros % 1 == 0 ? (int)totalOtros : String.format("%.2f", totalOtros))+"€");
        System.out.println("El total de salarios es: "
                +(totalSalarios % 1 == 0 ? (int)totalSalarios : String.format("%.2f", totalSalarios))+"€");
    }

    public static double calculoSalarios(double base, double complementos){
        return base + complementos;
    }
}