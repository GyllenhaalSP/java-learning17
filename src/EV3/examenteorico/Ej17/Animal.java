package EV3.examenteorico.Ej17;

public abstract class Animal implements Imprimible {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre;
    }
}
