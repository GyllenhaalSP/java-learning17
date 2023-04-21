package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria;

import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoFresco;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoRefrigerado;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoAgua;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoAire;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoNitrogeno;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmpresaAgroalimentaria empresa = new EmpresaAgroalimentaria("Alimentación Chen", "88278890R", "Calle Falsa 123", "618182368");

        int salir = 1;

        while (salir != 0) {
            salir = menu(empresa);
        }
    }

    public static int menu(EmpresaAgroalimentaria empresa) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Añadir producto");
        System.out.println("2. Mostrar lista de productos");
        System.out.println("3. Guardar lista de productos en disco");
        System.out.println("4. Cargar lista de productos desde disco");
        System.out.println("5. Salir");

        String choice = sc.nextLine();

        switch (choice) {
            case "1" -> {
                addProducto(empresa);
                System.out.println("Producto añadido correctamente.\n");
                return 1;
            }
            case "2" -> {
                empresa.getListaDeProductos().forEach(System.out::println);
                System.out.println();
                return 1;
            }
            case "3" -> {
                empresa.guardarCSV(empresa.getListaDeProductos(), "productos");
                return 1;
            }
            case "4" -> {
                //empresa.cargarCSV(empresa.getListaDeProductos(), "productos");
                return 1;
            }
            case "5" -> {
                return 0;
            }
            default -> System.out.println("Opción no válida");
        }
        return 1;
    }

    public static void addProducto(EmpresaAgroalimentaria empresa) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué tipo de producto quieres añadir?");
        System.out.println("1. Fresco");
        System.out.println("2. Refrigerado");
        System.out.println("3. Congelado");
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> {
                System.out.print("Introduce el nombre del producto: ");
                String nombre = sc.nextLine();
                System.out.print("Introduce el país de origen: ");
                String pais = sc.nextLine();
                ProductoFresco producto = new ProductoFresco(nombre, pais, LocalDate.now());
                empresa.addProducto(producto);
            }
            case "2" -> {
                System.out.print("Introduce el nombre del producto: ");
                String nombre = sc.nextLine();
                System.out.print("Introduce el país de origen: ");
                String pais = sc.nextLine();
                System.out.print("Introduce el organismo de supervisión: ");
                String organismoSupervision = sc.nextLine();
                System.out.print("Introduce el número de temperatura de refrigeración: ");
                int temperatura = Integer.parseInt(sc.nextLine());
                ProductoRefrigerado producto = new ProductoRefrigerado(nombre, pais, LocalDate.now(), organismoSupervision, temperatura);
                empresa.addProducto(producto);
            }
            case "3" -> {
                System.out.println("¿Qué tipo de producto congelado es?");
                System.out.println("1. Por agua");
                System.out.println("2. Por aire");
                System.out.println("3. Por nitrógeno");
                String subChoice = sc.nextLine();
                switch (subChoice) {
                    case "1" -> {
                        System.out.print("Introduce el nombre del producto: ");
                        String nombre = sc.nextLine();
                        System.out.print("Introduce el país de origen: ");
                        String pais = sc.nextLine();
                        System.out.print("Introduce la temperatura de refrigeración: ");
                        int temperatura = Integer.parseInt(sc.nextLine());
                        System.out.println("Introduce el % de sal: ");
                        float porcentajeSal = Float.parseFloat(sc.nextLine());
                        CongeladoAgua producto = new CongeladoAgua(nombre, pais, LocalDate.now(), temperatura, porcentajeSal);
                        empresa.addProducto(producto);
                    }
                    case "2" -> {
                        System.out.print("Introduce el nombre del producto: ");
                        String nombre = sc.nextLine();
                        System.out.print("Introduce el país de origen: ");
                        String pais = sc.nextLine();
                        System.out.print("Introduce la temperatura de refrigeración: ");
                        int temperatura = Integer.parseInt(sc.nextLine());
                        System.out.println("Introduce el % de nitrógeno: ");
                        float porcentajeNitrogeno = Float.parseFloat(sc.nextLine());
                        System.out.println("Introduce el % de oxígeno: ");
                        float porcentajeOxigeno = Float.parseFloat(sc.nextLine());
                        System.out.println("Introduce el % de dioxido de carbono: ");
                        float porcentajeDioxidoCarbono = Float.parseFloat(sc.nextLine());
                        System.out.println("Introduce el % de vapor de agua: ");
                        float porcentajeVaporAgua = Float.parseFloat(sc.nextLine());
                        CongeladoAire producto = new CongeladoAire(nombre, pais, LocalDate.now(), temperatura, porcentajeNitrogeno, porcentajeOxigeno, porcentajeDioxidoCarbono, porcentajeVaporAgua);
                        empresa.addProducto(producto);
                    }
                    case "3" -> {
                        System.out.print("Introduce el nombre del producto: ");
                        String nombre = sc.nextLine();
                        System.out.print("Introduce el país de origen: ");
                        String pais = sc.nextLine();
                        System.out.print("Introduce la temperatura de refrigeración: ");
                        int temperatura = Integer.parseInt(sc.nextLine());
                        System.out.println("Introduce el método de congelación: ");
                        String metodoCongelacion = sc.nextLine();
                        System.out.println("Introduce el tiempo de exposición al nitrógeno: ");
                        int tiempoExposicionNitrogeno = Integer.parseInt(sc.nextLine());
                        CongeladoNitrogeno producto = new CongeladoNitrogeno(nombre, pais, LocalDate.now(), temperatura, metodoCongelacion, tiempoExposicionNitrogeno);
                        empresa.addProducto(producto);
                    }
                    default -> System.out.println("Opción no válida");
                }
            }
            default -> System.out.println("Opción no válida");
        }
    }
}
