package EV3.examen3evaluacion;

import EV3.examen3evaluacion.ej2.Animal;
import EV3.examen3evaluacion.ej2.Ave;
import EV3.examen3evaluacion.ej2.Mamifero;
import EV3.examen3evaluacion.ej2.Zoo;

public class MainEjercicio2 {
  public static void main(String[] args) {

    Zoo zoo = new Zoo("Zoo del Juan de la Cierva");

    Animal referencia;

    referencia = new Mamifero("cabra", 5, 8.5f, 4);
    zoo.addAnimal(referencia);

    referencia = new Mamifero("ballena", 50, 35200f, 0);
    zoo.addAnimal(referencia);

    referencia = new Ave("flamenco", 5, 6.3f, true);
    zoo.addAnimal(referencia);

    referencia = new Ave("pingüino", 2, 9.5f, false);
    zoo.addAnimal(referencia);

    referencia = new Ave("", 2, 9.5f, false);
    zoo.addAnimal(referencia);

    referencia = new Ave("gorrión", -1, 9.5f, true);
    zoo.addAnimal(referencia);

    referencia = new Mamifero("perro", 1, 0f, 4);
    zoo.addAnimal(referencia);

    referencia = new Mamifero("gato", 2, 4f, -2);
    zoo.addAnimal(referencia);

    System.out.println();
    System.out.println(zoo);

    System.out.println(zoo.toStringMamiferos());
    System.out.println(zoo.toStringAves());
    System.out.println(zoo.toStringOrdenEdad());
    System.out.println(zoo.toStringOrdenPeso());
    System.out.println(zoo.toStringOrdenNatural());

    System.out.println();
    System.out.println(zoo);
  }
}
