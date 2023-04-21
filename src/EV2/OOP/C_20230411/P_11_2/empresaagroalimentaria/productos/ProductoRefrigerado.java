package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductoRefrigerado extends Producto {
    // Atributos
    private final String organismoSupervision;
    private final int temperaturaRecomendada;

    // Constructor
    public ProductoRefrigerado(String nombre, String paisOrigen, LocalDate fechaEnvasado, String organismoSupervision, int temperaturaRecomendada) {
        super(nombre, paisOrigen, fechaEnvasado);
        this.organismoSupervision = organismoSupervision;
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    public String getOrganismoSupervision() {
        return organismoSupervision;
    }

    public int getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    public static void guardarCSV(ProductoRefrigerado p, String nombreArchivo) {
        System.out.println("Escribiendo CSV de producto Refrigerado...");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Producto.PATH + nombreArchivo + ".csv", true));
            BufferedReader br = new BufferedReader(new FileReader(Producto.PATH + nombreArchivo + ".csv"));
            if (br.readLine() == null) {
                bw.write("Nombre,Lote,Pais de origen,Fecha de envasado,Fecha de caducidad, Organismo de supervisión, Temperatura de mantenimiento recomendada");
                bw.newLine();
            }

            bw.write(p.getNombre() + ";"
                    + p.getLote() + ";"
                    + p.getPaisOrigen() + ";"
                    + p.getFechaEnvasado().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";"
                    + p.getFechaCaducidad().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";"
                    + p.getOrganismoSupervision() + ";"
                    + p.getTemperaturaRecomendada());
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
        return super.toString() + "\nOrganismo de supervisión: " + organismoSupervision + " Temperatura de mantenimiento recomendada: " + temperaturaRecomendada + "ºC";
    }
}
