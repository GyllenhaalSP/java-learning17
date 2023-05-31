package EV3.examenteorico;

import java.util.Iterator;
import java.util.LinkedList;

public class MainEJ1 {
    public static void main(String[] args) {
        LinkedList<String> listaCadenas = new LinkedList<>();

        listaCadenas.add("coche");
        listaCadenas.add("zapato");
        listaCadenas.add("albaricoque");
        listaCadenas.add("botella");

        Iterator<String> iterator = listaCadenas.iterator();

        while(iterator.hasNext()){
            String cadenaLista = iterator.next();
            if(cadenaLista.charAt(0) == 'z'){
                iterator.remove();
            }
        }

        System.out.println("Lista:");
        for(String cadenaLista : listaCadenas){
            System.out.println(cadenaLista);
        }
    }
}
