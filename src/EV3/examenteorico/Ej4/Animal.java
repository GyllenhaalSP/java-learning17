package EV3.examenteorico.Ej4;

public abstract class Animal {
    protected String nombre;

    public Animal(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre;
    }

    public abstract void hacerRuido();
}
