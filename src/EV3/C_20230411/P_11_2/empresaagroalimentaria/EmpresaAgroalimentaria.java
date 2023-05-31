package EV3.C_20230411.P_11_2.empresaagroalimentaria;

import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.Producto;
import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoCongelado;
import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoFresco;
import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoRefrigerado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class EmpresaAgroalimentaria {
    // Atributos
    String nombre;
    String cif;
    String direccion;
    String telefono;
    List<Producto> listaDeProductos = new LinkedList<>();
    List<ProductoFresco> listaDeFrescos = new LinkedList<>();
    List<ProductoRefrigerado> listaDeRefrigerados = new LinkedList<>();
    List<ProductoCongelado> listaDeCongelados = new LinkedList<>();
    public static final String PATH = "src/EV2/OOP/C_20230411/P_11_2/empresaagroalimentaria/";

    // Constructor
    public EmpresaAgroalimentaria(String nombre, String cif, String direccion, String telefono) {
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Métodos
    public void addProducto(Producto producto) {
        if (producto == null) {
            System.out.println("No se puede añadir un nulo");
            return;
        }
        if (producto instanceof ProductoFresco) {
            if(!listaDeFrescos.contains(producto)) {
                listaDeFrescos.add((ProductoFresco) producto);
            }else{
                System.out.println("El producto ya existe");
            }
        } else if (producto instanceof ProductoRefrigerado) {
            if(!listaDeRefrigerados.contains(producto)) {
                listaDeRefrigerados.add((ProductoRefrigerado) producto);
            }else{
                System.out.println("El producto ya existe");
            }
        } else if (producto instanceof ProductoCongelado) {
            if(!listaDeCongelados.contains(producto)) {
                listaDeCongelados.add((ProductoCongelado) producto);
            }else{
                System.out.println("El producto ya existe");
            }
        }
        if (!listaDeProductos.contains(producto)){
            listaDeProductos.add(producto);
        }else{
            System.out.println("El producto ya existe");
        }
    }

    public void guardarCSV(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH + "productos.csv"));
            for (Producto producto : listaDeProductos) {
                bw.write(producto.classToCSV());
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo");
        }

    }

    @Override
    public String toString() {
        String cadena = "### Empresa Agroalimentaria ### " + "\n" + "Nombre: " + nombre + "\n" + "CIF: " + cif + "\n" + "Dirección: " + direccion + "\n" + "Teléfono: " + telefono + "\n";
        cadena += "### Lista de productos ###" + "\n";
        cadena += "### Productos totales: " + listaDeProductos.size() + " ###" + "\n";

        return cadena;
    }

}
