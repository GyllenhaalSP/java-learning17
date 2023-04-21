package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos;

import java.time.LocalDate;

public abstract class ProductoCongelado extends Producto {

    // Atributos
    protected final int temperaturaRecomendada;

    // Constructor
    public ProductoCongelado(String nombre, String paisOrigen, LocalDate fechaEnvasado, int temperaturaRecomendada) {
        super(nombre, paisOrigen, fechaEnvasado);
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    // Métodos
    public abstract int getTemperaturaRecomendada();

    @Override
    public String toString() {
        return super.toString() + " Temperatura de mantenimiento recomendada: " + temperaturaRecomendada + "ºC";
    }
}
