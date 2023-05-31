package EV3.examenteorico;

import EV3.examenteorico.Ej12.Animal;
import EV3.examenteorico.Ej12.Gato;
import EV3.examenteorico.Ej12.Perro;

public class MainEj12 {
    public static void main(String[] args) {
        Animal animal;
        animal = new Perro("milu", "grand fox terrier");
        System.out.println(animal);
        animal = new Gato("garfield", "naranja");
        System.out.println(animal);
    }
}
