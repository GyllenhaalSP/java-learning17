package EV3.C_20230411.P_11_2.empresaagroalimentaria;

import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoFresco;
import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoRefrigerado;
import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoAgua;
import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoAire;
import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoNitrogeno;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        EmpresaAgroalimentaria empresa = new EmpresaAgroalimentaria("Alimentación Chen", "88278890R", "Calle Falsa 123", "618182368");

        int salir = 1;

        while (salir != 0) {
            salir = menu(empresa);
        }
    }

    public static int menu(EmpresaAgroalimentaria empresa) {
        System.out.println("1. Añadir producto");
        System.out.println("2. Mostrar lista de productos");
        System.out.println("3. Guardar lista de productos en disco");
        System.out.println("4. Cargar lista de productos desde disco");
        System.out.println("5. Salir");

        String choice = sc.nextLine();

        switch (choice) {
            case "1" -> {
                ProductoFresco fresco = new ProductoFresco("Manzana", "España", LocalDate.of(2021, 5, 1));
                empresa.addProducto(fresco);
                System.out.println("Producto Fresco añadido correctamente");
                ProductoRefrigerado refrigerado = new ProductoRefrigerado("Leche", "España", LocalDate.of(2021, 5, 1), "Central Lechera Asturiana", 2);
                empresa.addProducto(refrigerado);
                System.out.println("Producto Refrigerado añadido correctamente");
                CongeladoAgua congeladoAgua = new CongeladoAgua("Pescado", "España", LocalDate.of(2021, 5, 1), -18, 2);
                empresa.addProducto(congeladoAgua);
                System.out.println("Producto Congelado por Agua añadido correctamente");
                CongeladoAire congeladoAire = new CongeladoAire("Pollo", "España", LocalDate.of(2021, 5, 1), -18, 78f, 20f, 0.5f, 0.1f);
                empresa.addProducto(congeladoAire);
                System.out.println("Producto Congelado por Aire añadido correctamente");
                CongeladoNitrogeno congeladoNitrogeno = new CongeladoNitrogeno("Carne", "España", LocalDate.of(2021, 5, 1), -18, "Vacío", 20);
                empresa.addProducto(congeladoNitrogeno);
                System.out.println("Producto Congelado por Nitrogeno añadido correctamente\n");
                return 1;
            }
            case "2" -> {
                System.out.println(empresa.toString());
                return 1;
            }
            case "3" -> {
                empresa.guardarCSV();
                return 1;
            }
            case "4" -> {
                return 1;
            }
            case "5" -> {
                return 0;
            }
            default -> System.out.println("Opción no válida");
        }
        return 1;
    }
}
