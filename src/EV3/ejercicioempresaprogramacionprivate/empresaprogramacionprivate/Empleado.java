package EV3.ejercicioempresaprogramacionprivate.empresaprogramacionprivate;

import EV3.ejercicioempresaprogramacionprivate.empresaprogramacionprivate.excepciones.ParametroInvalidoException;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Empleado implements Comparable<Empleado>{

  private String dniEmpleado;
  private String nombre;
  private Double sueldo;
  private TipoEmpleado tipo;
  private LocalDate fechaContratacion;
  static final String SEPARADOR_CSV = ",";
  static final String REGEX_DNI = "^\\d{8}[A-Z]$";
  static final Integer MODULO_DNI = 23;
  static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
  static final int SUBSTRING_MIN = 0;
  static final int SUBSTRING_MAX = 8;
  static final String ESPACIO = " ";
  static final Comparator<Empleado> COMPARATOR_SUELDO = new Comparator<Empleado>() {
    @Override
    public int compare(Empleado o1, Empleado o2) {
      return o1.getSueldo().compareTo(o2.getSueldo());
    }
  };

  public Empleado(String dniEmpleado, String nombre, Double sueldo, TipoEmpleado tipo, LocalDate fechaContratacion) throws ParametroInvalidoException {
    if (!dniEmpleado.matches(REGEX_DNI)) {
      throw new ParametroInvalidoException("El DNI '"+dniEmpleado+"' no está bien formado. Debe tener 8 dígitos y una letra mayúscula al final.");
    }

    if(!checkDNI(dniEmpleado)) {
      throw new ParametroInvalidoException("El DNI '"+dniEmpleado+"' no es válido. La letra no coincide con el número.");
    }

    if (nombre == null || nombre.length() < 2) {
      throw new ParametroInvalidoException("El nombre '"+nombre+"' no es válido, debe tener al menos 2 caracteres");
    }

    if (sueldo < 0) {
      throw new ParametroInvalidoException("El sueldo introducido: '"+sueldo+"' no es válido. Debe ser mayor que 0.");
    }

    this.dniEmpleado = dniEmpleado;
    this.nombre = nombre;
    this.sueldo = sueldo;
    this.tipo = tipo;
    this.fechaContratacion = fechaContratacion;
  }

  public abstract String toCsvLine();

  public String getDniEmpleado() {
    return dniEmpleado;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Double getSueldo() {
    return sueldo;
  }

  public void setSueldo(Double sueldo) {
    this.sueldo = sueldo;
  }

  public TipoEmpleado getTipo() {
    return tipo;
  }

  public LocalDate getFechaContratacion() {
    return fechaContratacion;
  }

  private boolean checkDNI(String dni) {
    char letra = dni.charAt(dni.length() - 1);
    return letra == LETRAS_DNI.charAt(Integer.parseInt(dni.substring(SUBSTRING_MIN, SUBSTRING_MAX)) % MODULO_DNI);
  }

  @Override
  public String toString() {
    return dniEmpleado + ESPACIO + nombre + ESPACIO + sueldo;
  }

  @Override
  public int compareTo(Empleado o) {
    return nombre.compareTo(o.nombre);
  }
}
