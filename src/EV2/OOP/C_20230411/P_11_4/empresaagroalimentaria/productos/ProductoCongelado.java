package EV2.OOP.C_20230411.P_11_4.empresaagroalimentaria.productos;

import java.util.GregorianCalendar;

public abstract class ProductoCongelado extends Producto {

    // Atributos
    protected final int temperaturaRecomendada;

    // Constructor
    public ProductoCongelado(String nombre, String paisOrigen, GregorianCalendar fechaEnvasado, int temperaturaRecomendada) {
        super(nombre, paisOrigen, fechaEnvasado);
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    // Getters y Setters
    public abstract int getTemperaturaRecomendada();

    // Métodos
    public abstract String mostrar();

    @Override
    public String toString() {
        return super.toString()
                +"\n\tTemperatura de mantenimiento recomendada: " + temperaturaRecomendada
                + "ºC";
    }
}
