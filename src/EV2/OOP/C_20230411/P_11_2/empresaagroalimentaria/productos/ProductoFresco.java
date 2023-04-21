package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductoFresco extends Producto {



    // Constructor
    public ProductoFresco(String nombre, String paisOrigen, LocalDate fechaEnvasado) {
        super(nombre, paisOrigen, fechaEnvasado);
    }

    public static void guardarCSV(ProductoFresco p, String nombreArchivo){
        System.out.println("Escribiendo CSV de producto fresco...");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Producto.PATH + nombreArchivo + ".csv", true));
            BufferedReader br = new BufferedReader(new FileReader(Producto.PATH + nombreArchivo + ".csv"));
            if (br.readLine() == null) {
                bw.write("Nombre,Lote,PaisOrigen,FechaEnvasado,FechaCaducidad");
                bw.newLine();
            }

            bw.write(p.getNombre() + ";"
                    + p.getLote() + ";"
                    + p.getPaisOrigen() + ";"
                    + p.getFechaEnvasado().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";"
                    + p.getFechaCaducidad().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
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
}
