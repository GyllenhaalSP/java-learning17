package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria;

import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.Producto;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoCongelado;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoFresco;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoRefrigerado;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoAgua;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoAire;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados.CongeladoNitrogeno;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class EmpresaAgroalimentaria {
    private final String nombre;
    private final String cif;
    private final String direccion;
    private final String telefono;
    private final List<Producto> listaDeProductos = new LinkedList<>();
    private static final String path = "src/EV2/OOP/C_20230411/P_11_2/empresaagroalimentaria/";

    public EmpresaAgroalimentaria(String nombre, String cif, String direccion, String telefono) {
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public List<Producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public void addProducto(Producto producto) {
        if (producto == null) {
            System.out.println("No se puede añadir un producto nulo");
            return;
        }
        if (!listaDeProductos.contains(producto)){
            listaDeProductos.add(producto);
        }else{
            System.out.println("El producto ya existe");
        }
    }

    public Producto leerCSV() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path + "productos.csv"));

            br.readLine();
            String linea = br.readLine();

            String[] datos = linea.split(";");

            String nombre = datos[0];
            String paisOrigen = datos[1];
            String[] fecha = datos[2].split(" ");

            br.close();

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void guardarCSV(List<Producto> productos, String nombreArchivo) {
        for (Producto p : productos) {
            if (p instanceof ProductoFresco){
                ProductoFresco.guardarCSV((ProductoFresco) p, "ProductoFresco");
            }else if(p instanceof ProductoRefrigerado){
                ProductoRefrigerado.guardarCSV((ProductoRefrigerado) p, "ProductoRefrigerado");
            }else if(p instanceof ProductoCongelado){
                if (p instanceof CongeladoAgua){
                    CongeladoAgua.guardarCSV((CongeladoAgua) p, "CongeladoAgua");
                }else if (p instanceof CongeladoAire){
                    CongeladoAire.guardarCSV((CongeladoAire) p, "CongeladoAire");
                }else if (p instanceof CongeladoNitrogeno){
                    CongeladoNitrogeno.guardarCSV((CongeladoNitrogeno) p, "CongeladoNitrogeno");
                }
            }
            System.out.println("Escribiendo CSV de Productos...");
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(Producto.PATH + nombreArchivo + ".csv", true));
                BufferedReader br = new BufferedReader(new FileReader(Producto.PATH + nombreArchivo + ".csv"));
                if (br.readLine() == null) {
                    bw.write("Nombre,Lote,Pais de origen,Fecha de envasado,Fecha de caducidad");
                    bw.newLine();
                }

                bw.write(p.getNombre() + ";"
                        + p.getLote() + ";"
                        + p.getPaisOrigen() + ";"
                        + p.getFechaEnvasado().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";"
                        + p.getFechaCaducidad().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";");
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

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" + "CIF: " + cif + "\n" + "Dirección: " + direccion + "\n" + "Teléfono: " + telefono + "\n";
    }

}
