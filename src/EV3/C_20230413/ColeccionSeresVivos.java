package EV3.C_20230413;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ColeccionSeresVivos {
    List<SerVivo> listaSeresVivos = new ArrayList<>();
    List<Animal> listaAnimales = new Vector<>();
    List<Planta> listaPlantas = new LinkedList<>();

    public void addSerVivo(SerVivo serVivo){
        listaSeresVivos.add(serVivo);
    }

    public void addAnimal(Animal animal){
        listaAnimales.add(animal);
    }

    public void addPlanta(Planta planta){
        listaPlantas.add(planta);
    }
}
