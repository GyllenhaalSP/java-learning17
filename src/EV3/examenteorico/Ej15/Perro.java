package EV3.examenteorico.Ej15;

public class Perro {
    public String nombre;
    public String raza;

    public Perro(String nombre, String raza) {
        this.nombre = nombre;
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "El perro se llama "+ nombre + " y su raza es " + raza;
    }
}