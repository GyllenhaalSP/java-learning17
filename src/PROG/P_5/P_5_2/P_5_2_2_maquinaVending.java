package PROG.P_5.P_5_2;

import java.util.Scanner;

public class P_5_2_2_maquinaVending {
//    Daniel Alonso Lázaro - 2022

//    Al comienzo del día, la máquina dispone de 20 monedas de todas las cantidades
//    necesarias para el cambio.
//    Se debe dar el cambio correcto, con el menor número de monedas posibles. Quiero
//    que aparezca en pantalla un mensaje de “INTRODUZCA IMPORTE EXACTO” si
//    la máquina no dispone de monedas en 2 tipos de estas o más o si no dispone de
//    monedas de un solo tipo y este es el de 5 cts., y que solo acepte este dinero.


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int precio, dineroCents = 0;
        double cambio;
        String producto;
        int[] monedas = {5, 10, 20, 50, 100, 200};
        int[] cantidad = {20, 20, 20, 20, 20, 20};
        do {
            do {
                System.out.print("""
                        -Agua
                        -Refresco
                        -Zumo
                        -Salir
                        Elegir un producto:\040""");
                switch (producto = sc.nextLine().trim().toLowerCase()) {
                    case "agua" -> {
                        precio = 50;
                        printOptions(precio, producto);
                    }
                    case "refresco" -> {
                        precio = 75;
                        printOptions(precio, producto);
                    }
                    case "zumo" -> {
                        precio = 95;
                        printOptions(precio, producto);
                    }
                    default -> {
                        System.out.println("\nProducto no disponible");
                        precio = 0;
                    }
                }
            } while (!producto.equalsIgnoreCase("agua") &&
                    !producto.equalsIgnoreCase("refresco") &&
                    !producto.equalsIgnoreCase("zumo"));
            do {
                System.out.print("""
                        
                        -2€
                        -1€
                        -50cts
                        -20cts
                        -10cts
                        -5cts
                        -2cts
                        -1ct
                        Introducir moneda:\040""");
                switch (sc.nextLine().trim().toLowerCase()) {
                    case "2" -> dineroCents += 200;
                    case "1" -> dineroCents += 100;
                    case "50" -> dineroCents += 50;
                    case "20" -> dineroCents += 20;
                    case "10" -> dineroCents += 10;
                    case "5" -> dineroCents += 5;
                    default -> System.out.println("\nMoneda no aceptada");
                }
                if (dineroCents < precio)
                    System.out.printf("Dinero insuficiente, faltan %.2f euros\n", ((precio - dineroCents)/100.0));
            } while (dineroCents < precio);

            cambio = (dineroCents - precio) / 100.0;

            if (cambio > 0) {
                System.out.printf("Su cambio es de %2.2f euros.\n", cambio);
            }
            System.out.print("Introduzca otro producto o 'salir' para terminar: ");
            producto = sc.nextLine().trim().toLowerCase();
        }while(!producto.equalsIgnoreCase("salir"));
    }

    public static void printOptions(int precio, String producto) {
        System.out.printf("El precio del %s es %.2f€\n", producto, precio/100.0);
    }

}

