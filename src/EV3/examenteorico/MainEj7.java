package EV3.examenteorico;

import java.util.LinkedList;

public class MainEj7 {
    public static void main(String[] args) {
        LinkedList<String> listaCadenas = new LinkedList<>();

        listaCadenas.add("coche");
        listaCadenas.add("zapato");
        listaCadenas.add("albaricoque");
        listaCadenas.add("botella");

        System.out.println("Lista:");
        for(String cadenaLista : listaCadenas){
            System.out.println(cadenaLista);
        }
    }
}
