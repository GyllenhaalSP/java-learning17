package EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados;

import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.Producto;
import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoCongelado;

import java.time.LocalDate;

public class CongeladoAgua extends ProductoCongelado {
    float salinidad;
    public static final String CSV_HEADER = "nombre"+ Producto.SEPARADOR
            +"lote"+Producto.SEPARADOR
            +"paisOrigen"+Producto.SEPARADOR
            +"fechaEnvasado"+Producto.SEPARADOR
            +"fechaCaducidad"+Producto.SEPARADOR
            +"temperaturaRecomendada"+Producto.SEPARADOR
            +"salinidad";
    public static final String CSV_NAME = "CongeladoAgua.csv";

    // Constructor
    public CongeladoAgua(String nombre, String paisOrigen, LocalDate fechaEnvasado, int temperaturaRecomendada, float salinidad) {
        super(nombre, paisOrigen, fechaEnvasado, temperaturaRecomendada);
        this.salinidad = salinidad;
    }

    @Override
    public float getTemperaturaRecomendada() {
        return this.temperaturaRecomendada;
    }

    @Override
    public String classToCSV() {
        return this.getNombre() + Producto.SEPARADOR
                + this.getLote() + Producto.SEPARADOR
                + this.getPaisOrigen() + Producto.SEPARADOR
                + this.getFechaEnvasado() + Producto.SEPARADOR
                + this.getFechaCaducidad() + Producto.SEPARADOR
                + this.getTemperaturaRecomendada() + Producto.SEPARADOR
                + this.salinidad+"\n";
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalinidad: " + salinidad + "g/L";
    }
}
