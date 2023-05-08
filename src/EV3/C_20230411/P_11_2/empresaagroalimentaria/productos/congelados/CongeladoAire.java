package EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados;

import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.Producto;
import EV3.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoCongelado;

import java.time.LocalDate;

public class CongeladoAire extends ProductoCongelado {
    public static final String CSV_HEADER = "nombre" + Producto.SEPARADOR
            + "lote" + Producto.SEPARADOR
            + "paisOrigen" + Producto.SEPARADOR
            + "fechaEnvasado" + Producto.SEPARADOR
            + "fechaCaducidad" + Producto.SEPARADOR
            + "temperaturaRecomendada" + Producto.SEPARADOR
            + "porcentajeNitrogeno" + Producto.SEPARADOR
            + "porcentajeOxigeno" + Producto.SEPARADOR
            + "porcentajeDioxidoCarbono" + Producto.SEPARADOR
            + "porcentajeVaporAgua";
    public static final String CSV_NAME = "CongeladoAire.csv";
    float porcentajeNitrogeno;
    float porcentajeOxigeno;
    float porcentajeDioxidoCarbono;
    float porcentajeVaporAgua;

    public CongeladoAire(String nombre, String paisOrigen, LocalDate fechaEnvasado, int temperaturaRecomendada, float porcentajeNitrogeno, float porcentajeOxigeno, float porcentajeDioxidoCarbono, float porcentajeVaporAgua) {
        super(nombre, paisOrigen, fechaEnvasado, temperaturaRecomendada);
        this.porcentajeNitrogeno = porcentajeNitrogeno;
        this.porcentajeOxigeno = porcentajeOxigeno;
        this.porcentajeDioxidoCarbono = porcentajeDioxidoCarbono;
        this.porcentajeVaporAgua = porcentajeVaporAgua;
    }

    @Override
    public String classToCSV() {
        return this.getNombre() + Producto.SEPARADOR
                + this.getLote() + Producto.SEPARADOR
                + this.getPaisOrigen() + Producto.SEPARADOR
                + this.getFechaEnvasado() + Producto.SEPARADOR
                + this.getFechaCaducidad() + Producto.SEPARADOR
                + this.getTemperaturaRecomendada() + Producto.SEPARADOR
                + this.porcentajeNitrogeno + Producto.SEPARADOR
                + this.porcentajeOxigeno + Producto.SEPARADOR
                + this.porcentajeDioxidoCarbono + Producto.SEPARADOR
                + this.porcentajeVaporAgua + "\n";
    }

    @Override
    public float getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNitrógeno: " + porcentajeNitrogeno + "%" + " Oxigeno: " + porcentajeOxigeno + "%" + " Dióxido de Carbono: " + porcentajeDioxidoCarbono + "%" + " Vapor de Agua: " + porcentajeVaporAgua + "%";
    }
}