package EV3.examenteorico.Ej4;

public class Perro extends Animal {
    String raza;

    public Perro(String nombre, String raza){
        super(nombre);
        this.raza = raza;
    }

    public void hacerRuido(){
        System.out.println("Guau, guau");
    }
}
