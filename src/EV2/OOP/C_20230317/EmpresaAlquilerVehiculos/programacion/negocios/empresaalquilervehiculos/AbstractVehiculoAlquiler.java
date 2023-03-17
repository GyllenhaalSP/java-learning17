package EV2.OOP.C_20230317.EmpresaAlquilerVehiculos.programacion.negocios.empresaalquilervehiculos;

public abstract class AbstractVehiculoAlquiler {
  protected String matricula;
  protected String fabricante;
  protected String modelo;
  protected float tarifaDiaria;

  public AbstractVehiculoAlquiler(String matricula, String fabricante, String modelo, float tarifaDiaria) {
    this.matricula = matricula;
    this.fabricante = fabricante;
    this.modelo = modelo;
    this.tarifaDiaria = tarifaDiaria;
  }

  @Override
  public abstract String toString();

}
