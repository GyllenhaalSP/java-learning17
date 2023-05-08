package EV3.PreparacionExamen3EV.POOII.mascotas;

import java.time.LocalDate;

public abstract class Aves extends Mascotas {
    boolean pico;
    boolean vuela;

    public Aves(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, boolean pico, boolean vuela) {
        super(nombre, edad, estado, fechaNacimiento);
        this.pico = pico;
        this.vuela = vuela;
    }
}
