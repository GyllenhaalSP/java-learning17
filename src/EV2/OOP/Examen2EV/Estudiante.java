package EV2.OOP.Examen2EV;

public class Estudiante {
  private final String nombre;
  private final String apellidos;
  private final String NIA;

  public Estudiante(String nombre, String apellidos, String NIA) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.NIA = NIA;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public String getNIA() {
    return NIA;
  }

  @Override
  public String toString() {
    return NIA+" ("+nombre+" "+apellidos+")\n";
  }

}
