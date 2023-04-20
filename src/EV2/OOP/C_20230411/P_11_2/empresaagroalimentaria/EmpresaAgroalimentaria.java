package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria;

import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.Producto;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoCongelado;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoFresco;
import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoRefrigerado;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class EmpresaAgroalimentaria {
    private String nombre;
    private String cif;
    private String direccion;
    private String telefono;
    private List<Producto> listaDeProductos = new LinkedList<>();
    private List<ProductoFresco> listaDeProductosFrescos = new LinkedList<>();
    private List<ProductoRefrigerado> listaDeProductosRefrigerados = new LinkedList<>();
    private List<ProductoCongelado> listaDeProductosCongelados = new LinkedList<>();
    private String path = "src/EV2/OOP/C_20230411/P_11_2/empresaagroalimentaria/";

    public EmpresaAgroalimentaria(String nombre, String cif, String direccion, String telefono) {
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public List<Producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public List<ProductoFresco> getListaDeProductosFrescos() {
        return listaDeProductosFrescos;
    }

    public List<ProductoRefrigerado> getListaDeProductosRefrigerados() {
        return listaDeProductosRefrigerados;
    }

    public List<ProductoCongelado> getListaDeProductosCongelados() {
        return listaDeProductosCongelados;
    }

    public void addProducto(Producto producto) {
        if (producto == null) {
            System.out.println("No se puede añadir un producto nulo");
            return;
        }
        if (producto instanceof ProductoFresco) {
            if(!listaDeProductosFrescos.contains(producto)) {
                listaDeProductosFrescos.add((ProductoFresco) producto);
            }
        } else if (producto instanceof ProductoRefrigerado) {
            if(!listaDeProductosRefrigerados.contains(producto)) {
                listaDeProductosRefrigerados.add((ProductoRefrigerado) producto);
            }
        } else if (producto instanceof ProductoCongelado) {
            if(!listaDeProductosCongelados.contains(producto)) {
                listaDeProductosCongelados.add((ProductoCongelado) producto);
            }
        }
        listaDeProductos.add(producto);
    }

    public Producto leerCSV() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path+"productos.csv"));

            String encabezado = br.readLine();
            String linea = br.readLine();

            String[] datos = linea.split(";");

            String nombre = datos[0];
            String paisOrigen = datos[1];
            String [] fecha = datos[2].split(" ");

            br.close();

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void escribirCSV(List<Producto> productos) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path+"productos.csv"));

            bw.write("Nombre,Lote,PaisOrigen,FechaEnvasado,FechaCaducidad");
            bw.newLine();

            for (Producto p : productos) {
                bw.write(p.getNombre() + ","
                        + p.getLote() + ","
                        + p.getPaisOrigen() + ","
                        + p.getFechaEnvasado().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ","
                        + p.getFechaCaducidad().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                bw.newLine();
            }
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
    public String toString(){
        return "Nombre: " + nombre + "\n" +
                "CIF: " + cif + "\n" +
                "Dirección: " + direccion + "\n" +
                "Teléfono: " + telefono + "\n";
    }

}
