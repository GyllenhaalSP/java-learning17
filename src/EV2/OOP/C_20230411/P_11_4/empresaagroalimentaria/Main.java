package EV2.OOP.C_20230411.P_11_4.empresaagroalimentaria;

import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoFresco;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoRefrigerado;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoAgua;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoAire;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoNitrogeno;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creando 2 productos frescos...");
        ProductoFresco manzana = new ProductoFresco("Manzana", "España", new GregorianCalendar());
        ProductoFresco pera = new ProductoFresco("Pera", "España", new GregorianCalendar());

        System.out.println(manzana);
        System.out.println(pera);
        System.out.println();

        System.out.println("Creando 3 productos refrigerados...");
        ProductoRefrigerado leche = new ProductoRefrigerado("Leche", "España", new GregorianCalendar(), "Central Lechera Asturiana", 2);
        ProductoRefrigerado yogur = new ProductoRefrigerado("Yogur", "España", new GregorianCalendar(), "Danone", 2);
        ProductoRefrigerado carnePicada = new ProductoRefrigerado("Carne Picada", "España", new GregorianCalendar(), "Cárnicas Españolas", 1);

        System.out.println(leche);
        System.out.println(yogur);
        System.out.println(carnePicada);
        System.out.println();

        System.out.println("Creando 2 productos congelados por agua...");
        CongeladoAgua caldo = new CongeladoAgua("Caldo de pollo", "España", new GregorianCalendar(), -18, 0.43f);
        CongeladoAgua cocido = new CongeladoAgua("Cocido Madrileño", "España", new GregorianCalendar(), -18, 0.51f);

        System.out.println(caldo);
        System.out.println(cocido);
        System.out.println();

        System.out.println("Creando 2 productos congelados por aire...");
        CongeladoAire pan = new CongeladoAire("Pan blanco", "España", new GregorianCalendar(), -18, 78f, 21f, 0.04f, 3f);
        CongeladoAire croquetas = new CongeladoAire("Croquetas de pollo", "España", new GregorianCalendar(), -18, 78f, 21f, 0.04f, 3f);

        System.out.println(pan);
        System.out.println(croquetas);
        System.out.println();

        System.out.println("Creando 1 producto congelado por nitrógeno...");
        CongeladoNitrogeno pizza = new CongeladoNitrogeno("Pizza Carbonara", "España", new GregorianCalendar(), -18, "Inmersión en nitrógeno líquido", 27);

        System.out.println(pizza);
    }
}
