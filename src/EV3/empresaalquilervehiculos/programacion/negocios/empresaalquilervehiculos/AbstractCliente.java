package EV3.empresaalquilervehiculos.programacion.negocios.empresaalquilervehiculos;

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
