package EV3.examenteorico.Ej5;

public class Gato extends Animal{
    String color;

    public Gato(String nombre, String color) {
        super(nombre);
        this.color = color;
    }

    @Override
    public void hacerRuido() {
        System.out.println("Miau");
    }
}
