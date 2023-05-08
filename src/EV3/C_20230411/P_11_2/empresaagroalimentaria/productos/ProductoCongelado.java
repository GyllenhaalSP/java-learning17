package EV3.C_20230411.P_11_2.empresaagroalimentaria.productos;

import java.time.LocalDate;

public abstract class ProductoCongelado extends Producto {

    // Atributos
    protected float temperaturaRecomendada;

    // Constructor
    public ProductoCongelado(String nombre, String paisOrigen, LocalDate fechaEnvasado, int temperaturaRecomendada) {
        super(nombre, paisOrigen, fechaEnvasado);
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    // Métodos
    public abstract float getTemperaturaRecomendada();

    @Override
    public String toString() {
        return super.toString() + " Temperatura de mantenimiento recomendada: " + temperaturaRecomendada + "ºC";
    }
}
