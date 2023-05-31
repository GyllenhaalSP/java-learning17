package EV3.preparacionexamen3ev.pooII.mascotas;

import java.time.LocalDate;

public class Loro extends Aves{
    String origen;
    boolean habla;

    public Loro(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, boolean pico, boolean vuela, String origen, boolean habla) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.origen = origen;
        this.habla = habla;
    }
}
