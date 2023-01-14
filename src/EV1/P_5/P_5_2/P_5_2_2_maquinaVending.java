package EV1.P_5.P_5_2;

import static ProgramasPruebas.Metodos.*;

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
    Al finalizar el programa nos debe dar el total del dinero disponible en la máquina, por unidad monetaria.
    */
    public static void main(String[] args) {
        int[] monedas = {200, 100, 50, 20, 10, 5};
        int[] cantidad = {20, 20, 20, 20, 20, 20};
        int precio, cambio;
        String producto, salida = "salir";
        do {
            Object[] menu = menuOpciones();
            precio = (int)menu[1];
            if(!(producto = (String)menu[0]).equalsIgnoreCase(salida)) {
                if((cambio = (calculoPrecios(precio, cantidad, monedas) - precio)) < 0) break;
                expendedor(producto, cambio);
                if(cambio != 0) returnChange(cambio, monedas, cantidad);
            }
        }while(!producto.equalsIgnoreCase(salida));
        cierreMaquina(cantidad, monedas);
    }
}