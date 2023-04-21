package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados;

import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.Producto;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoCongelado;

import java.io.*;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class CongeladoAire extends ProductoCongelado {
    private final float porcentajeNitrogeno;
    private final float porcentajeOxigeno;
    private final float porcentajeDioxidoCarbono;
    private final float porcentajeVaporAgua;

    public CongeladoAire(String nombre, String paisOrigen, LocalDate fechaEnvasado, int temperaturaRecomendada, float porcentajeNitrogeno, float porcentajeOxigeno, float porcentajeDioxidoCarbono, float porcentajeVaporAgua) {
        super(nombre, paisOrigen, fechaEnvasado, temperaturaRecomendada);
        this.porcentajeNitrogeno = porcentajeNitrogeno;
        this.porcentajeOxigeno = porcentajeOxigeno;
        this.porcentajeDioxidoCarbono = porcentajeDioxidoCarbono;
        this.porcentajeVaporAgua = porcentajeVaporAgua;
    }

    public float getPorcentajeNitrogeno() {
        return porcentajeNitrogeno;
    }

    public float getPorcentajeOxigeno() {
        return porcentajeOxigeno;
    }

    public float getPorcentajeDioxidoCarbono() {
        return porcentajeDioxidoCarbono;
    }

    public float getPorcentajeVaporAgua() {
        return porcentajeVaporAgua;
    }

    @Override
    public int getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    public static void guardarCSV(CongeladoAire p, String nombreArchivo) {
        System.out.println("Escribiendo CSV de producto Congelado por Aire...");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Producto.PATH + nombreArchivo + ".csv", true));
            BufferedReader br = new BufferedReader(new FileReader(Producto.PATH + nombreArchivo + ".csv"));
            if (br.readLine() == null) {
                bw.write("Nombre,Lote,Pais de origen,Fecha de envasado,Fecha de caducidad, Temperatura de mantenimiento recomendada, Porcentaje de Nitrógeno, Porcentaje de Oxígeno, Porcentaje de Dióxido de Carbono, Porcentaje de Vapor de Agua");
                bw.newLine();
            }

            bw.write(p.getNombre() + ";"
                    + p.getLote() + ";"
                    + p.getPaisOrigen() + ";"
                    + p.getFechaEnvasado().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";"
                    + p.getFechaCaducidad().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";"
                    + p.getTemperaturaRecomendada() + ";"
                    + p.getPorcentajeNitrogeno() + ";"
                    + p.getPorcentajeOxigeno() + ";"
                    + p.getPorcentajeDioxidoCarbono() + ";"
                    + p.getPorcentajeVaporAgua());
            bw.newLine();

            Thread.sleep(2500);
            System.out.println("Archivo guardado correctamente.");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fallo al escribir el archivo...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return super.toString() + "\nNitrógeno: " + porcentajeNitrogeno + "%" + " Oxigeno: " + porcentajeOxigeno + "%" + " Dióxido de Carbono: " + porcentajeDioxidoCarbono + "%" + " Vapor de Agua: " + porcentajeVaporAgua + "%";
    }
}