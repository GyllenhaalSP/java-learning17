package EV3.preparacionexamen3ev.pooII.mascotas;

import java.time.LocalDate;

public class Gato extends Mascotas{
    String color;
    boolean peloLargo;

    public Gato(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, String color, boolean peloLargo) {
        super(nombre, edad, estado, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }
}
