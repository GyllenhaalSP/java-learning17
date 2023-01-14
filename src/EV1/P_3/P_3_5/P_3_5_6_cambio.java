package EV1.P_3.P_3_5;

import java.util.Scanner;

import static ProgramasPruebas.Metodos.returnChange;
import static ProgramasPruebas.Metodos.resto;

public class P_3_5_6_cambio {
//    Diseñar un programa que a partir de una venta y del pago de un producto por parte del comprador,
//    nos calcule el cambio se tiene que dar utilizando el menor número de monedas o billetes posibles.
//    Vamos a trabajar con:
//        ➢ Valor máximo del producto a comprar serán 50 euros.
//        ➢ Monedas y/o billetes con los que vamos a trabajar son: 50, 20, 10, 5, 2, 1,
//                                                                  0.50, 0.20, 0.10, 0.05, 0.02 y 0.01.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el precio: ");
        double precio = sc.nextDouble() * 100;
        System.out.print("Introduce la cantidad pagada: ");
        double pago = sc.nextDouble() * 100;
        int cambio = (int) pago - (int) precio;
        final int b20 = 2000, b10 = 1000, b5 = 500,
                m2 = 200, m1 = 100, m50 = 50, m20 = 20, m10 = 10, m05 = 5, m02 = 2, m01 = 1;

        int contb20 = returnChange(cambio, b20);
        int resto = resto(cambio, b20);

        int contb10 = returnChange(resto, b10);
        resto = resto(resto, b10);

        int contb5 = returnChange(resto, b5);
        resto = resto(resto, b5);

        int contm2 = returnChange(resto, m2);
        resto = resto(resto, m2);

        int contm1 = returnChange(resto, m1);
        resto = resto(resto, m1);

        int contm50 = returnChange(resto, m50);
        resto = resto(resto, m50);

        int contm20 = returnChange(resto, m20);
        resto = resto(resto, m20);

        int contm10 = returnChange(resto, m10);
        resto = resto(resto, m10);

        int contm05 = returnChange(resto, m05);
        resto = resto(resto, m05);

        int contm02 = returnChange(resto, m02);
        resto = resto(resto, m02);

        int contm01 = returnChange(resto, m01);

        if (cambio <= 0) System.out.println("\n¡Abre el puño y suelta los duros!");
        else if (precio == 0 | precio >= 5100) System.out.println("\nQue si quiere bolsa, señora.");
        else {
            if (contb20 > 0 ) {
                System.out.println((contb20 == 1) ? (contb20 + " billete de 20 euros") : (contb20 + " billetes de 20 euros"));
            }if (contb10 > 0 ) {
                System.out.println((contb10 == 1) ? (contb10 + " billete de 10 euros") : (contb10 + " billetes de 10 euros"));
            }if (contb5 > 0 ) {
                System.out.println((contb5 == 1) ? (contb5 + " billete de 5 euros") : (contb5 + " billetes de 5 euros"));
            }if (contm2 > 0 ) {
                System.out.println((contm2 == 1) ? (contm2 + " moneda de 2 euros") : (contm2 + " monedas de 2 euros"));
            }if (contm1 > 0 ) {
                System.out.println((contm1 == 1) ? (contm1 + " moneda de 1 euro") : (contm1 + " monedas de 1 euro"));
            }if (contm50 > 0 ) {
                System.out.println((contm50 == 1) ? (contm50 + " moneda de 50 céntimos") : (contm50 + " monedas de 50 céntimos"));
            }if (contm20 > 0 ) {
                System.out.println((contm20 == 1) ? (contm20 + " moneda de 20 céntimos") : (contm20 + " monedas de 20 céntimos"));
            }if (contm10 > 0 ) {
                System.out.println((contm10 == 1) ? (contm10 + " moneda de 10 céntimos") : (contm10 + " monedas de 10 céntimos"));
            }if (contm05 > 0 ) {
                System.out.println((contm05 == 1) ? (contm05 + " moneda de 5 céntimos") : (contm05 + " monedas de 5 céntimos"));
            }if (contm02 > 0 ) {
                System.out.println((contm02 == 1) ? (contm02 + " moneda de 2 céntimos") : (contm02 + " monedas de 2 céntimos"));
            }if (contm01 > 0 ) {
                System.out.println((contm01 == 1) ? (contm01 + " moneda de 1 céntimos") : (contm01 + " monedas de 1 céntimos"));
            }
        }
    }
}