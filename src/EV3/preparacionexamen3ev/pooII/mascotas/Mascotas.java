package EV3.preparacionexamen3ev.pooII.mascotas;

import java.time.LocalDate;

public abstract class Mascotas {
    String nombre;
    int edad;
    boolean estado;
    LocalDate fechaNacimiento;

    public Mascotas(String nombre, int edad, boolean estado, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void muestra(){

    }

    public void cumple(){

    }

    public void morir(){

    }

    public void habla(){

    }
}
