package EV3.PreparacionExamen3EV.POOII.mascotas;

import java.time.LocalDate;

public class Canario extends Aves{
    String color;
    boolean canta;

    public Canario(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, boolean pico, boolean vuela, String color, boolean canta) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.color = color;
        this.canta = canta;
    }
}
