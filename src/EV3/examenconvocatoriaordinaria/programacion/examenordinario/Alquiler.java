package EV3.examenconvocatoriaordinaria.programacion.examenordinario;

import java.time.LocalDateTime;

public class Alquiler implements Comparable<Alquiler> {
  Cliente cliente;
  Vehiculo vehiculo;
  LocalDateTime inicio;
  LocalDateTime fin;
  static final String COMA = ", ";
  static final String TUBERIA = " | ";
  static final String INDICADOR_FIN = " -> ";

  public Alquiler(Cliente cliente, Vehiculo vehiculo, LocalDateTime inicio) {
    this.cliente = cliente;
    this.vehiculo = vehiculo;
    this.inicio = inicio;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Vehiculo getVehiculo() {
    return vehiculo;
  }

  public LocalDateTime getInicio() {
    return inicio;
  }

  public LocalDateTime getFin() {
    return fin;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public void setVehiculo(Vehiculo vehiculo) {
    this.vehiculo = vehiculo;
  }

  public void setInicio(LocalDateTime inicio) {
    this.inicio = inicio;
  }

  public void setFin(LocalDateTime fin) {
    this.fin = fin;
  }

  @Override
  public String toString() {
    return cliente.toString() + TUBERIA + vehiculo.toString() + TUBERIA + inicio + INDICADOR_FIN + ((fin == null)?"*":fin);
  }

  @Override
  public int compareTo(Alquiler o) {
    if (inicio.isEqual(o.inicio)){
      return 0;
    }else if (inicio.isAfter(o.inicio)){
      return 1;
    }else{
      return -1;
    }
  }
}
