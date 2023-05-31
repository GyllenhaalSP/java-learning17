package EV3.examenteorico.Ej9;

public class Gato extends Animal{
    String color;

    public Gato(String nombre, String color) {
        super(nombre);
        this.color = color;
    }

    public void hacerRuido(){
        System.out.println("Miau, miau");
    }

    @Override
    public void imprimir() {
        System.out.println("YAAAY");
    }
}
