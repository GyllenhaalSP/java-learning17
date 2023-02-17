package EV2.OOP.C_20230202;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main de la Pizzería.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class MainPizzeria {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Bienvenido al servicio de gestión de pizzerías.");
        System.out.print("Introduzca el nombre de la pizzería: ");
        String nombrePizzeria = sc.nextLine();
        System.out.print("Introduzca el número máximo de clientes: ");
        int maxClientes = sc.nextInt();
        System.out.print("Introduzca el número máximo de pedidos: ");
        int maxPedidos = sc.nextInt();
        cls();
        Pizzeria pizzeria = new Pizzeria(nombrePizzeria, maxClientes, maxPedidos);

        int opcion = 0;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("\t1. Imprimir detalles.");
            System.out.println("\t2. Añadir cliente.");
            System.out.println("\t3. Añadir pedido.");
            System.out.println("\t4. Servir pedidos.");
            System.out.println("\t5. Salir.");
            System.out.print("Introduzca una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    cls();
                    System.out.println(pizzeria);
                    break;
                case 2:
                    System.out.print("Introduzca el nombre del cliente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Introduzca los apellidos del cliente: ");
                    String apellidos = sc.nextLine();
                    System.out.print("Introduzca la dirección del cliente: ");
                    String dir = sc.nextLine();
                    System.out.print("Introduzca el teléfono del cliente: ");
                    String tel = sc.nextLine();
                    pizzeria.addCliente(nombre, apellidos, dir, tel);
                    break;
                case 3:
                    System.out.print("Introduzca la posición del cliente: ");
                    int posicionCliente = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduzca el tamaño de la pizza: ");
                    String size = sc.nextLine();
                    System.out.print("Introduzca el tipo de la pizza: ");
                    String type = sc.nextLine();
                    pizzeria.addPedido(posicionCliente, size, type);
                    break;
                case 4:
                    System.out.println("Introduzca la posición del pedido: ");
                    int posicionPedido = sc.nextInt();
                    sc.nextLine();
                    pizzeria.pedidoServido(posicionPedido);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Error: Opción no válida.");
                    break;
            }
        } while (opcion != 6);
    }

    public static void cls() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
