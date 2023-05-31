package EV3.examenteorico.Ej9;

public class Perro extends Animal{
    String raza;

    public Perro(String nombre, String raza) {
        super(nombre);
        this.raza = raza;
    }

    public void hacerRuido(){
        System.out.println("Guau, guau");
    }

    @Override
    public void imprimir() {
        System.out.println("Soy un perro, me llamo " + nombre + ", soy de raza " + raza + " y hago el siguiente ruido: ");
        hacerRuido();
    }
}
