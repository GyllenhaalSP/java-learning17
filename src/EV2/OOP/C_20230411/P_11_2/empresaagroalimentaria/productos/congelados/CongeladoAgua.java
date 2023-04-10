package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados;

import java.util.GregorianCalendar;

public class CongeladoAgua extends ProductoCongelado{
    private final float salinidad;

    public CongeladoAgua(String nombre, String paisOrigen, GregorianCalendar fechaEnvasado, int temperaturaRecomendada, float salinidad) {
        super(nombre, paisOrigen, fechaEnvasado, temperaturaRecomendada);
        this.salinidad = salinidad;
    }

    public float getSalinidad() {
        return salinidad;
    }

    @Override
    public int getTemperaturaRecomendada() {
        return this.temperaturaRecomendada;
    }

    @Override
    public String toString() {
        return super.toString()
                +"\n\tSalinidad: " + salinidad + "g/L" + "\n";
    }
}
