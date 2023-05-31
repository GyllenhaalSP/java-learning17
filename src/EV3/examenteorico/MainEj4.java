package EV3.examenteorico;

import EV3.examenteorico.Ej4.Gato;
import EV3.examenteorico.Ej4.Perro;

public class MainEj4 {
    public static void main(String[] args) {

        Perro perro = new Perro("milu", "grand fox terrier");
        Gato gato = new Gato("garfield", "naranja");

        perro.hacerRuido();
        gato.hacerRuido();
    }
}
