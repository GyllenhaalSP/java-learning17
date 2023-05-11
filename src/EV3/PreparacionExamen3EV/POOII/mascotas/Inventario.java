package EV3.PreparacionExamen3EV.POOII.mascotas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Inventario implements InterfazLoca {

    public static List<Inventario> lista = new ArrayList<>();

    public String holi;

    public Inventario(String h){
        this.holi = h;
    }

    public static void main(String[] args) {
        Inventario i = new Inventario("ñlejsnfñosjenf");
        Inventario j = new Inventario("23rjgh23");
        System.out.println(i);
        System.out.println(i.getHoli());

        LinkedList<Integer> lista2 = new LinkedList();

        int numero = 17;

        lista2.add(numero);

        lista.add(i);
        lista.add(j);

        for(var inventario: lista){
            System.out.println(inventario);
        }

    }

    @Override
    public Dias getHoli() {
        return Dias.LUNES;
    }

    @Override
    public String toString(){
        return holi;
    }
}
