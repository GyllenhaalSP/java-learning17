package EV2.OOP.C_20230317.EmpresaAlquilerVehiculos.programacion.negocios.empresaalquilervehiculos;

public class Turismo extends AbstractVehiculoAlquiler {
  int numeroPuertas;
  boolean cambioAutomatico;

  public Turismo(String matricula, String fabricante, String modelo, float tarifaDiaria, int numeroPuertas,
      boolean cambioAutomatico) {
    super(matricula, fabricante, modelo, tarifaDiaria);
    this.numeroPuertas = numeroPuertas;
    this.cambioAutomatico = cambioAutomatico;
  }

  @Override
  public String toString() {
    return String.format("%8s %-15s %.2f€/día (%d puertas, cambio %s) ",
        matricula, (fabricante + "-" + modelo), tarifaDiaria, numeroPuertas,
        (cambioAutomatico ? "automático" : "manual"));
  }
}