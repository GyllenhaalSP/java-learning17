package EV2.OOP.C_20230317.EmpresaAlquilerVehiculos.programacion.negocios.empresaalquilervehiculos;

public abstract class AbstractCliente {
  String nombre;
  String nif;
  
  public AbstractCliente(String nombre, String nif) {
    this.nombre = nombre;
    this.nif = nif;
  }

  @Override
  public abstract String toString();
}
