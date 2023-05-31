package EV3.examenteorico;

import EV3.examenteorico.Ej3.Perro;

public class MainEj3 {
    public static void main(String[] args) {
        Perro perro = new Perro("milu", "grand fox terrier");
        System.out.println("El perro se llama " + perro.getNombre() + "y su raza es " + perro.getRaza());
    }
}
