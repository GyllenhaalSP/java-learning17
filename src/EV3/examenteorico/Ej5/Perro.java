package EV3.examenteorico.Ej5;

public class Perro extends Animal{
    String raza;

    public Perro(String nombre, String raza) {
        super(nombre);
        this.raza = raza;
    }

    @Override
    public void hacerRuido() {
        System.out.println("Guau");
    }
}
