package EV3.PreparacionExamen3EV.POOII;

import java.util.ArrayList;
import java.util.Iterator;

public class Producto {

    public static void main(String[] args) {
        Producto producto1 = new Producto("Manzana", 20);
        Producto producto2 = new Producto("Pera", 20);
        Producto producto3 = new Producto("Salchichas", 10);
        Producto producto4 = new Producto("Pizzas", 15);
        Producto producto5 = new Producto("Cocacola", 0);

        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        Iterator<Producto> iter = productos.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        productos.remove(producto2);
        productos.remove(producto3);

        Producto producto6 = new Producto("NewSalchichas", 11);

        productos.add(2, producto6);

        System.out.println("Productos está vacío? "+productos.isEmpty());

        iter = productos.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        productos.clear();

        System.out.println("Productos está vacío? "+productos.isEmpty());

    }
    String nombre;
    int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
