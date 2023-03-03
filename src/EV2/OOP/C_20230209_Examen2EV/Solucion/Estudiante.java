package EV2.OOP.C_20230209_Examen2EV.Solucion;

class Estudiante {
  String nombre;
  String apellidos;
  String nia;
  public static int NIA_MAX_LENGTH = 5;

  public Estudiante(String nombre, String apellidos, String nia) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.nia = nia;
  }

  /* 
   * Método toString autogenerado por VSCode
  @Override
  public String toString() {
    return "Estudiante [nombre=" + nombre + ", apellidos=" + apellidos + ", nia=" + nia + "]";
  }
  */
  
  @Override
  public String toString() {
    return String.format("%-5s", nia) + " (" + nombre + " " + apellidos + ")";
  }
}