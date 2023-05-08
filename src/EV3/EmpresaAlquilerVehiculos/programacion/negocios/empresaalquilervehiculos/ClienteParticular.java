package EV3.EmpresaAlquilerVehiculos.programacion.negocios.empresaalquilervehiculos;

public class ClienteParticular extends AbstractCliente {
  String telefono;
  String correoElectronico;

  public ClienteParticular(String nombre, String nif, String telefono, String correoElectronico) {
    super(nombre, nif);
    this.telefono = telefono;
    this.correoElectronico = correoElectronico;
  }

  @Override
  public String toString() {
    String cadena = "";
    cadena += nif + " " + nombre + " (" + telefono + ", " + correoElectronico + ")";
    return cadena;
  }

}
