package EV3.examenteorico;

import EV3.examenteorico.Ej17.Gato;
import EV3.examenteorico.Ej17.Perro;

public class MainEj17 {
    public static void main(String[] args) {

        Perro perro = new Perro("milu", "grand fox terrier");
        Gato gato = new Gato("garfield", "naranja");

        perro.imprimir();
        gato.imprimir();
    }
}