package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria;

import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoCongelado;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoFresco;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoRefrigerado;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoAgua;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoAire;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoNitrogeno;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Creando empresa agroalimentaria...\n");
        EmpresaAgroalimentaria empresa = new EmpresaAgroalimentaria("Agroalimentación Gyllenhaal", "12345678A", "Calle Falsa 123", "618182368");
        System.out.println(empresa);

        System.out.print("Creando 2 productos frescos...");
        ProductoFresco manzana = new ProductoFresco("Manzana", "España", LocalDate.now());
        empresa.addProducto(manzana);
        ProductoFresco pera = new ProductoFresco("Pera", "España", LocalDate.now());
        empresa.addProducto(pera);

        System.out.println("\nImprimiendo la lista de productos frescos...");
        empresa.getListaDeProductosFrescos().forEach(System.out::println);

        System.out.print("\nCreando 3 productos refrigerados...");
        ProductoRefrigerado leche = new ProductoRefrigerado("Leche", "España", LocalDate.now(), "Central Lechera Asturiana", 2);
        empresa.addProducto(leche);
        ProductoRefrigerado yogur = new ProductoRefrigerado("Yogur", "España", LocalDate.now(), "Danone", 2);
        empresa.addProducto(yogur);
        ProductoRefrigerado carnePicada = new ProductoRefrigerado("Carne Picada", "España", LocalDate.now(), "Cárnicas Españolas", 1);
        empresa.addProducto(carnePicada);

        System.out.println("\nImprimiendo la lista de productos refrigerados...");
        empresa.getListaDeProductosRefrigerados().forEach(System.out::println);

        System.out.print("\nCreando 2 productos congelados por agua...");
        CongeladoAgua caldo = new CongeladoAgua("Caldo de pollo", "España", LocalDate.now(), -18, 0.43f);
        empresa.addProducto(caldo);
        CongeladoAgua cocido = new CongeladoAgua("Cocido Madrileño", "España", LocalDate.now(), -18, 0.51f);
        empresa.addProducto(cocido);

        System.out.println("\nImprimiendo la lista de productos congelados por agua...");

        for(ProductoCongelado producto : empresa.getListaDeProductosCongelados()){
            if(producto instanceof CongeladoAgua){
                System.out.println(producto);
            }
        }

        System.out.print("\nCreando 2 productos congelados por aire...");
        CongeladoAire pan = new CongeladoAire("Pan blanco", "España", LocalDate.now(), -18, 78f, 21f, 0.04f, 3f);
        empresa.addProducto(pan);
        CongeladoAire croquetas = new CongeladoAire("Croquetas de pollo", "España", LocalDate.now(), -18, 78f, 21f, 0.04f, 3f);
        empresa.addProducto(croquetas);

        System.out.println("\nImprimiendo la lista de productos congelados por aire...");
        for(ProductoCongelado producto : empresa.getListaDeProductosCongelados()){
            if(producto instanceof CongeladoAire){
                System.out.println(producto);
            }
        }

        System.out.print("\nCreando 1 producto congelado por nitrógeno...");
        CongeladoNitrogeno pizza = new CongeladoNitrogeno("Pizza Carbonara", "España", LocalDate.now(), -18, "Inmersión en nitrógeno líquido.", 27);
        empresa.addProducto(pizza);

        System.out.println("\nImprimiendo la lista de productos congelados por nitrógeno...");
        for(ProductoCongelado producto : empresa.getListaDeProductosCongelados()){
            if(producto instanceof CongeladoNitrogeno){
                System.out.println(producto);
            }
        }

        System.out.println("\nImprimiendo la lista de productos...");
        empresa.getListaDeProductos().forEach(System.out::println);

        System.out.println("\nGuardando en disco...");
        empresa.escribirCSV(empresa.getListaDeProductos());


    }
}
