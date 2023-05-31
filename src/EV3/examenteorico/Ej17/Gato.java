package EV3.examenteorico.Ej17;

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
        System.out.println("Soy un gato, me llamo " + nombre + ", soy de color " + color + " y hago el siguiente ruido: ");
        hacerRuido();
    }
}
