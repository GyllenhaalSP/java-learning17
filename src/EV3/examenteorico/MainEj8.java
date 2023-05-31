package EV3.examenteorico;

import java.util.TreeSet;

public class MainEj8 {
    public static void main(String[] args) {
        TreeSet<String> conjuntoCadenas = new TreeSet<>();

        conjuntoCadenas.add("Pedro");
        conjuntoCadenas.add("Laura");
        conjuntoCadenas.add("Mar");
        conjuntoCadenas.add("Bea");
        conjuntoCadenas.add("Jorge");
        conjuntoCadenas.add("Laura");
        conjuntoCadenas.add("Fer");

        System.out.println("Conjunto: ");
        for (String cadenaConjunto: conjuntoCadenas){
            System.out.println(cadenaConjunto);
        }
    }
}
