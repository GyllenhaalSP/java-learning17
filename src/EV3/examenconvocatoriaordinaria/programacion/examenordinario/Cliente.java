package EV3.examenconvocatoriaordinaria.programacion.examenordinario;
//Minuto 06 muestro las extensiones del IDE que se me había olvidado.

import java.util.Comparator;

public class Cliente implements Comparable<Cliente>{
  private String dni;
  private String nombre;
  private String apellidos;
  static final String CSV_SEPARATOR = "#";
  static final String COMA = ", ";
  static final String GUION = " - ";
  static final String CLIENTE = "Cliente: ";
  static final String DNI_VACIO = CLIENTE +"argumento dni vacío";
  static final String NOMBRE_VACIO = CLIENTE +"argumento nombre vacío";
  static final String APELLIDOS_VACIOS = CLIENTE +"argumento apellidos vacío";
  static final Comparator<Cliente> COMPARATOR_DNI = new Comparator<Cliente>() {
    @Override
    public int compare(Cliente o1, Cliente o2) {
      return o1.getDni().compareTo(o2.getDni());
    }
  };

  public Cliente(String dni, String nombre, String apellidos) throws ParametroInvalidoException {
    if(dni.isEmpty()){
      throw new ParametroInvalidoException(DNI_VACIO);
    }
    if(nombre.isEmpty()){
      throw new ParametroInvalidoException(NOMBRE_VACIO);
    }
    if(apellidos.isEmpty()){
      throw new ParametroInvalidoException(APELLIDOS_VACIOS);
    }
    this.dni = dni;
    this.nombre = nombre;
    this.apellidos = apellidos;
  }

  public String getDni() {
    return dni;
  }

  public String toCsvLine(){
    return dni + CSV_SEPARATOR + nombre + CSV_SEPARATOR + apellidos;
  }

  @Override
  public String toString() {
    return dni+ GUION + apellidos + COMA + nombre;
  }

  @Override
  public int compareTo(Cliente o) {
    if (apellidos.compareTo(o.apellidos) == 0){
      return nombre.compareTo(o.nombre);
    }
    return apellidos.compareTo(o.apellidos);
  }
}
