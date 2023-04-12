package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados;

import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoCongelado;

import java.util.GregorianCalendar;

public class CongeladoAire extends ProductoCongelado {

    private final float porcentajeNitrogeno;
    private final float porcentajeOxigeno;
    private final float porcentajeDioxidoCarbono;
    private final float porcentajeVaporAgua;

    public CongeladoAire(String nombre, String paisOrigen, GregorianCalendar fechaEnvasado, int temperaturaRecomendada, float porcentajeNitrogeno, float porcentajeOxigeno, float porcentajeDioxidoCarbono, float porcentajeVaporAgua) {
        super(nombre, paisOrigen, fechaEnvasado, temperaturaRecomendada);
        this.porcentajeNitrogeno = porcentajeNitrogeno;
        this.porcentajeOxigeno = porcentajeOxigeno;
        this.porcentajeDioxidoCarbono = porcentajeDioxidoCarbono;
        this.porcentajeVaporAgua = porcentajeVaporAgua;
    }

    public float getPorcentajeNitrogeno() {
        return porcentajeNitrogeno;
    }

    public float getPorcentajeOxigeno() {
        return porcentajeOxigeno;
    }

    public float getPorcentajeDioxidoCarbono() {
        return porcentajeDioxidoCarbono;
    }

    public float getPorcentajeVaporAgua() {
        return porcentajeVaporAgua;
    }

    @Override
    public int getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n\tNitrógeno: " + porcentajeNitrogeno + "%"
                + "\n\tOxigeno: " + porcentajeOxigeno + "%"
                + "\n\tDióxido de Carbono: " + porcentajeDioxidoCarbono + "%"
                + "\n\tVapor de Agua: " + porcentajeVaporAgua + "%";
    }
}