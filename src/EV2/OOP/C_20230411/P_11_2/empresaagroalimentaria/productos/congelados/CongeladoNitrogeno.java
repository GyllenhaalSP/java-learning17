package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados;

import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.Producto;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoCongelado;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CongeladoNitrogeno extends ProductoCongelado {
    private final int tiempoExposicionNitrogeno;
    private final String metodoCongelacion;

    public CongeladoNitrogeno(String nombre, String paisOrigen, LocalDate fechaEnvasado, int temperaturaRecomendada, String metodoCongelacion, int tiempoExposicionNitrogeno) {
        super(nombre, paisOrigen, fechaEnvasado, temperaturaRecomendada);
        this.metodoCongelacion = metodoCongelacion;
        this.tiempoExposicionNitrogeno = tiempoExposicionNitrogeno;
    }

    public String getMetodoCongelacion() {
        return metodoCongelacion;
    }

    public int getTiempoExposicionNitrogeno() {
        return tiempoExposicionNitrogeno;
    }

    @Override
    public int getTemperaturaRecomendada() {
        return this.temperaturaRecomendada;
    }

    public static void guardarCSV(CongeladoNitrogeno p, String nombreArchivo) {
        System.out.println("Escribiendo CSV de producto Congelado por Nitrógeno...");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Producto.PATH + nombreArchivo + ".csv", true));
            BufferedReader br = new BufferedReader(new FileReader(Producto.PATH + nombreArchivo + ".csv"));
            if (br.readLine() == null) {
                bw.write("Nombre,Lote,Pais de origen,Fecha de envasado,Fecha de caducidad,Temperatura de mantenimiento recomendada,Método de congelación,Tiempo de exposición al nitrógeno");
                bw.newLine();
            }

            bw.write(p.getNombre() + ";"
                    + p.getLote() + ";"
                    + p.getPaisOrigen() + ";"
                    + p.getFechaEnvasado().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";"
                    + p.getFechaCaducidad().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";"
                    + p.getTemperaturaRecomendada() + ";"
                    + p.getMetodoCongelacion() + ";"
                    + p.getTiempoExposicionNitrogeno());
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
        return super.toString() + "\nMétodo de congelación: " + metodoCongelacion + " Tiempo de exposición al nitrógeno: " + tiempoExposicionNitrogeno + " segundos.";
    }
}
