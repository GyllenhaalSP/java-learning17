package EV3.ejercicioempresaprogramacionprivate.empresaprogramacionprivate;

import EV3.ejercicioempresaprogramacionprivate.empresaprogramacionprivate.excepciones.ParametroInvalidoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Programador extends Empleado{
  private boolean esJunior;

  public Programador(String dniEmpleado, String nombre, Double sueldo, boolean esJunior, LocalDate fechaContratacion) throws ParametroInvalidoException {
    super(dniEmpleado, nombre, sueldo, TipoEmpleado.PROGRAMADOR, fechaContratacion);
    this.esJunior = esJunior;
  }

  public boolean isEsJunior() {
    return esJunior;
  }

  public void setEsJunior(boolean esJunior) {
    this.esJunior = esJunior;
  }

  @Override
  public String toString() {
    return super.toString() + Empleado.ESPACIO + (esJunior? "Es Junior": "Es Senior") + Empleado.ESPACIO + super.getFechaContratacion().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
  }

  @Override
  public String toCsvLine() {
    return super.getDniEmpleado() + Empleado.SEPARADOR_CSV + super.getNombre() + Empleado.SEPARADOR_CSV + super.getSueldo() + Empleado.SEPARADOR_CSV + esJunior + Empleado.SEPARADOR_CSV + TipoEmpleado.PROGRAMADOR + Empleado.SEPARADOR_CSV + super.getFechaContratacion();
  }
}
