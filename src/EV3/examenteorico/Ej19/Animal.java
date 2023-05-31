package EV3.examenteorico.Ej19;

public abstract class Animal {
    protected String nombre;

    public Animal(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre;
    }
}
