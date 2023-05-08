package EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados;

import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.Producto;
import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoCongelado;

import java.time.LocalDate;

public class CongeladoNitrogeno extends ProductoCongelado {
    private final int tiempoExposicionNitrogeno;
    private final String metodoCongelacion;
    public static final String CSV_HEADER = "nombre"+ Producto.SEPARADOR
            +"lote"+Producto.SEPARADOR
            +"paisOrigen"+Producto.SEPARADOR
            +"fechaEnvasado"+Producto.SEPARADOR
            +"fechaCaducidad"+Producto.SEPARADOR
            +"temperaturaRecomendada"+Producto.SEPARADOR
            +"tiempoExposicionNitrogeno"+Producto.SEPARADOR
            +"metodoCongelacion";
    public static final String CSV_NAME = "CongeladoNitrogeno.csv";

    public CongeladoNitrogeno(String nombre, String paisOrigen, LocalDate fechaEnvasado, int temperaturaRecomendada, String metodoCongelacion, int tiempoExposicionNitrogeno) {
        super(nombre, paisOrigen, fechaEnvasado, temperaturaRecomendada);
        this.metodoCongelacion = metodoCongelacion;
        this.tiempoExposicionNitrogeno = tiempoExposicionNitrogeno;
    }

    @Override
    public String classToCSV() {
        return this.getNombre() + Producto.SEPARADOR
                + this.getLote() + Producto.SEPARADOR
                + this.getPaisOrigen() + Producto.SEPARADOR
                + this.getFechaEnvasado() + Producto.SEPARADOR
                + this.getFechaCaducidad() + Producto.SEPARADOR
                + this.getTemperaturaRecomendada() + Producto.SEPARADOR
                + this.metodoCongelacion + Producto.SEPARADOR
                + this.tiempoExposicionNitrogeno+"\n";
    }

    @Override
    public float getTemperaturaRecomendada() {
        return this.temperaturaRecomendada;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMétodo de congelación: " + metodoCongelacion + " Tiempo de exposición al nitrógeno: " + tiempoExposicionNitrogeno + " segundos.";
    }
}
