package EV3.PreparacionExamen3EV.POOII.mascotas;

import java.time.LocalDate;

public class Perro extends Mascotas{
    String raza;
    boolean pulgas;

    public Perro(String nombre, int edad, boolean estado, LocalDate fechaNacimiento, String raza, boolean pulgas) {
        super(nombre, edad, estado, fechaNacimiento);
        this.raza = raza;
        this.pulgas = pulgas;
    }
}
