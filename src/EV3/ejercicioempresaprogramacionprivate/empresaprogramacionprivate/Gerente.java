package EV3.ejercicioempresaprogramacionprivate.empresaprogramacionprivate;

import EV3.ejercicioempresaprogramacionprivate.empresaprogramacionprivate.excepciones.ParametroInvalidoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gerente extends Empleado{
  private String departamento;

  public Gerente(String dniEmpleado, String nombre, Double sueldo, String departamento, LocalDate fechaContratacion) throws ParametroInvalidoException {
    super(dniEmpleado, nombre, sueldo, TipoEmpleado.GERENTE, fechaContratacion);
    this.departamento = departamento;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  @Override
  public String toString() {
    return super.toString() + Empleado.ESPACIO + departamento + Empleado.ESPACIO + super.getFechaContratacion().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
  }

  @Override
  public String toCsvLine() {
    return super.getDniEmpleado() + Empleado.SEPARADOR_CSV + super.getNombre() + Empleado.SEPARADOR_CSV + super.getSueldo() + Empleado.SEPARADOR_CSV + departamento + Empleado.SEPARADOR_CSV + TipoEmpleado.GERENTE + Empleado.SEPARADOR_CSV + super.getFechaContratacion();
  }
}
