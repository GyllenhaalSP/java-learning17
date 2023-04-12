package EV2.OOP.C_20230411.P_11_4.empresaagroalimentaria.productos;

import java.util.GregorianCalendar;

public class ProductoRefrigerado extends Producto {

    // Atributos
    private final String organismoSupervision;
    private final int temperaturaRecomendada;

    // Constructor
    public ProductoRefrigerado(String nombre,
                               String paisOrigen,
                               GregorianCalendar fechaEnvasado,
                               String organismoSupervision,
                               int temperaturaRecomendada) {
        super(nombre, paisOrigen, fechaEnvasado);
        this.organismoSupervision = organismoSupervision;
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    public String getOrganismoSupervision() {
        return organismoSupervision;
    }


    public int getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n\tOrganismo de supervisión: " + organismoSupervision
                + "\n\tTemperatura de mantenimiento recomendada: " + temperaturaRecomendada + "ºC";
    }
}
