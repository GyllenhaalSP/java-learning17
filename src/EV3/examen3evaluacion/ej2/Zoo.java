package EV3.examen3evaluacion.ej2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Zoo {
  String nombre;
  List<Animal> listaAnimales;

  public Zoo(String nombre) {
    this.nombre = nombre;
    listaAnimales = new ArrayList<>();
  }

  public void addAnimal(Animal animal) {
    try{
      if(!animal.comprobarNombre()){
        listaAnimales.add(animal);
        return;
      }else if (!animal.comprobarEdad()){
        listaAnimales.add(animal);
        return;
      }else if (!animal.comprobarPeso()){
        listaAnimales.add(animal);
        return;
      }
      if(animal instanceof Mamifero){
        if (((Mamifero) animal).comprobarNumeroPatas()) {
          if(!listaAnimales.contains(animal)){
            listaAnimales.add(animal);
          }
        }
      }else{
        if(!listaAnimales.contains(animal)){
          listaAnimales.add(animal);
        }
      }
    } catch(ParametroInvalidoException e){
      System.out.println("Excepción capturada creando " + animal.getTipo() + ": "+ e.getMessage());
    }
  }

  @Override
  public String toString() {
    String cadena = "## ZOO: " + nombre + "\n";
    cadena += "# " + listaAnimales.size() + " animales:\n";
    for (Animal animal : listaAnimales) {
      cadena += animal + "\n";
    }
    return cadena;
  }

  public String toStringMamiferos() {
    String cadena = "# Listado de Mamíferos:\n";
    for (Animal animal : listaAnimales) {
      if (animal instanceof Mamifero){
        cadena += animal + "\n";
      }
    }
    return cadena;
  }

  public String toStringAves() {
    String cadena = "# Listado de Aves:\n";
    for (Animal animal : listaAnimales) {
      if (animal instanceof Ave) {
        cadena += animal + "\n";
      }
    }
    return cadena;
  }

  public String toStringOrdenEdad() {
    String cadena = "# Listado de animales por edad:\n";

    ArrayList<Animal> listaAnimalesOrdenEdad = new ArrayList<>(listaAnimales);

    Comparator<Animal> comparatorEdad = new Comparator<>() {
      @Override
      public int compare(Animal o1, Animal o2) {
        int o1Edad = o1.getEdad();
        int o2Edad = o2.getEdad();
        return Integer.compare(o1Edad, o2Edad);
      }
    };

    listaAnimalesOrdenEdad.sort(comparatorEdad);

    for (Animal animal : listaAnimalesOrdenEdad) {
      cadena += animal + "\n";
    }
    return cadena;
  }

  public String toStringOrdenPeso() {
    String cadena = "# Listado de animales por peso:\n";

    ArrayList<Animal> listaAnimalesOrdenPeso = new ArrayList<>(listaAnimales);

    Comparator<Animal> comparatorPeso = new Comparator<>() {
      @Override
      public int compare(Animal o1, Animal o2) {
        float o1Peso = o1.getPeso();
        float o2Peso = o2.getPeso();
        return Float.compare(o1Peso, o2Peso);
      }
    };

    listaAnimalesOrdenPeso.sort(comparatorPeso);

    for (Animal animal : listaAnimalesOrdenPeso) {
      cadena += animal + "\n";
    }
    return cadena;
  }

  public String toStringOrdenNatural() {
    String cadena = "# Listado de animales por su orden natural:\n";

    ArrayList<Animal> listaAnimalesOrdenNatural = new ArrayList<>(listaAnimales);

    Comparator<Animal> comparatorNombre = new Comparator<>() {
      @Override
      public int compare(Animal o1, Animal o2) {
        String o1Nombre = o1.getNombre();
        String o2Nombre = o2.getNombre();
        return o1Nombre.compareTo(o2Nombre);
      }
    };

    listaAnimalesOrdenNatural.sort(comparatorNombre);

    for (Animal animal : listaAnimalesOrdenNatural) {
      cadena += animal + "\n";
    }
    return cadena;
  }

}
