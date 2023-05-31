package EV3.examen3evaluacion.ej2;

public class Mamifero extends Animal{
  int numeroPatas;

  public Mamifero(String nombre, int edad, float peso, int numeroPatas) {
    super(nombre, edad, peso, TipoAnimal.MAMIFERO);
    this.numeroPatas = numeroPatas;
  }

  public boolean comprobarNumeroPatas() throws ParametroInvalidoException{
    if (numeroPatas < 0){
      throw new ParametroInvalidoException("Numero de patas inválido: "+numeroPatas);
    }else{
      return true;
    }
  }

  @Override
  public String toString() {
    return super.toString() + ", " + numeroPatas +" patas";
  }
}