package EV3.C_20230411.P_11_2.empresaagroalimentaria.productos;

import java.time.LocalDate;

public class ProductoRefrigerado extends Producto {
    // Atributos
    private final String organismoSupervision;
    private final int temperaturaRecomendada;
    public static final String CSV_HEADER = "Nombre"+ SEPARADOR
            +"Lote"+ SEPARADOR
            +"País de origen"+ SEPARADOR
            +"Fecha de envasado"+ SEPARADOR
            +"Fecha de caducidad"+ SEPARADOR
            +"Organismo de supervisión"+ SEPARADOR
            +"Temperatura de mantenimiento recomendada";
    public static final String CSV_NAME = "ProductoRefrigerado.csv";

    // Constructor
    public ProductoRefrigerado(String nombre, String paisOrigen, LocalDate fechaEnvasado, String organismoSupervision, int temperaturaRecomendada) {
        super(nombre, paisOrigen, fechaEnvasado);
        this.organismoSupervision = organismoSupervision;
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    // Métodos

    @Override
    public String classToCSV() {
        return this.getNombre() + SEPARADOR
                + this.getLote() + SEPARADOR
                + this.getPaisOrigen() + SEPARADOR
                + this.getFechaEnvasado() + SEPARADOR
                + this.getFechaCaducidad()+"\n";
    }

    @Override
    public String toString() {
        return super.toString() + "\nOrganismo de supervisión: " + organismoSupervision + " Temperatura de mantenimiento recomendada: " + temperaturaRecomendada + "ºC";
    }
}
