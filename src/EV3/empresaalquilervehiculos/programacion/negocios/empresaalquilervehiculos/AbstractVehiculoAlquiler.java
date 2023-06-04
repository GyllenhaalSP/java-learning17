package EV3.empresaalquilervehiculos.programacion.negocios.empresaalquilervehiculos;

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
