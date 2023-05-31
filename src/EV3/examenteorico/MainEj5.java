package EV3.examenteorico;

import EV3.examenteorico.Ej5.Animal;
import EV3.examenteorico.Ej5.Gato;
import EV3.examenteorico.Ej5.Perro;

public class MainEj5 {
    public static void main(String[] args) {
        Animal animal;
        animal = new Perro("milu", "grand fox terrier");
        System.out.println(animal);
        animal = new Gato("garfield", "naranja");
        System.out.println(animal);
    }
}
