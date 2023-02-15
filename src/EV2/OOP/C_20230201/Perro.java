package EV2.OOP.C_20230201;

public class Perro {
  // Atributos de la clase
  public String nombre;
  public int edad;
  private String raza;

  public Perro(String nombre, int edad, String raza){
    this.nombre = nombre;
    this.edad = edad;
    this.raza = raza;
  }

  public String toString(){
    return "["+super.toString()+"] nombre=" + nombre + ", raza=" + raza + ", edad=" + edad;
  }
}
