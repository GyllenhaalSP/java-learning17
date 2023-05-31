package EV3.examen3evaluacion.ej2;

public class Ave extends Animal{
  boolean puedeVolar;

  public Ave(String nombre, int edad, float peso, boolean puedeVolar) {
    super(nombre, edad, peso, TipoAnimal.AVE);
    this.puedeVolar = puedeVolar;
  }

  @Override
  public String toString() {
    return super.toString() + ", "+ (puedeVolar? "puede volar": "NO puede volar");
  }
}