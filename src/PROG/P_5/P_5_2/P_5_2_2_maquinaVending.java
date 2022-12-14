package PROG.P_5.P_5_2;

import java.util.Scanner;

import static ProgramasPruebas.metodos.menuVending;
import static ProgramasPruebas.metodos.printOptions;

public class P_5_2_2_maquinaVending {
    //    Daniel Alonso Lázaro - 2022
    /*
    Disponemos de una máquina automática de venta de bebidas. Disponemos de tres productos:
    agua cuyo precio es 0,50, refresco con precio de 0,75 y zumo cuyo precio es de 0,95 cts.
    El programa emitirá un menú que mostrará los productos y sus precios, así como la opción de salir.
    El programa pedirá la opción elegida y el dinero que se introduce para pagar.
    La forma de introducir el dinero para pagar en el programa es introducir el valor de cada moneda que ponemos
    en la máquina expresada en céntimos. El programa aceptará monedas hasta que se llegue al importe solicitado o se
    sobrepase la primera vez.
    Nuestra máquina acepta todas las monedas de euro a excepción de los 2 cts. y 1 cts.
    Al comienzo del día, la máquina dispone de 20 monedas de todas las cantidades necesarias para el cambio.
    Se debe dar el cambio correcto, con el menor número de monedas posibles. Quiero que aparezca en pantalla un
    mensaje de “INTRODUZCA IMPORTE EXACTO” si la máquina no dispone de monedas en 2 tipos de estas o más o si no
    dispone de monedas de un solo tipo y este es el de 5 cts., y que solo acepte este dinero.
    Al finalizar el programa nos debe dar el total del dinero disponible en la máquina, por unidad monetaria
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int precio, dineroCents, cambio;
        String producto;
        int[] monedas = {200, 100, 50, 20, 10, 5};
        int[] cantidad = {20, 5, 5, 20, 20, 1};
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
            }while(!producto.equalsIgnoreCase("agua") &&
                    !producto.equalsIgnoreCase("refresco") &&
                    !producto.equalsIgnoreCase("zumo"));

            int contadorCambio = 0;

            if(cantidad[5] < 1) {
                contadorCambio = 3;
            }else if (cantidad[0] < 1 || cantidad[1] < 1 || cantidad[2] < 1 || cantidad[3] < 1 || cantidad[4] < 1) {
                contadorCambio = 3;
            }

            dineroCents = menuVending(precio, contadorCambio);

            cambio = (dineroCents - precio);

            System.out.println("\nExpendiendo producto y cambio");
            System.out.println("\tProducto: "+producto.toUpperCase()+".");
            System.out.println("\tCambio: "+cambio/100.0+"€");
            for(int i = 0; i < monedas.length; i++){
                if(monedas[i] > 99){
                    if(cambio >= monedas[i]){
                        System.out.println("\t\tMonedas de "
                                +((monedas[i]/100.0)%1==0.0
                                ? (int)(monedas[i]/100.0)
                                : String.format("%.2f", (monedas[i]/100.0)))
                                +" euro: "+cambio/monedas[i]);
                        cambio%=monedas[i];
                        cantidad[i]-=1;
                    }
                }else{
                    if(cambio >= monedas[i]){
                        System.out.println("\t\tMonedas de "+(monedas[i]/100.0)+" céntimos: "+cambio/monedas[i]);
                        cambio %= monedas[i];
                        cantidad[i]-=1;
                    }
                }
            }

            System.out.print("\nIntroduzca 'salir' para terminar o pulse 'enter' para continuar: ");
            producto = sc.nextLine().trim().toLowerCase();
            System.out.println();
        }while(!producto.equalsIgnoreCase("salir"));
    }
}

