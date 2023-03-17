package EV2.OOP.C_20230317.EmpresaAlquilerVehiculos.programacion.negocios.empresaalquilervehiculos;

public class EmpresaAlquilerVehiculos extends AbstractEmpresaAlquilerVehiculos
    implements InterfazEmpresaAlquilerVehiculos {

  public EmpresaAlquilerVehiculos(String nombre, String nif) {
    super(nombre, nif);
  }

  @Override
  public boolean alquilarVehiculo(AbstractCliente cliente, AbstractVehiculoAlquiler vehiculo) {
    if (alquileres.contains(new Alquiler(cliente, vehiculo))) {
      return false;
    } else {
      alquileres.add(new Alquiler(cliente, vehiculo));
      return true;
    }
  }

  @Override
  public boolean devolverVehiculo(AbstractVehiculoAlquiler vehiculo) {
    for (AbstractAlquiler alquiler : alquileres) {
      if (alquiler.getVehiculo().equals(vehiculo)) {
        alquiler.terminarAlquiler();
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean registrarCliente(AbstractCliente cliente) {
    if (clientes.contains(cliente)) {
      return false;
    }else{
      clientes.add(cliente);
      return true;
    }
  }

  @Override
  public boolean registrarVehiculo(AbstractVehiculoAlquiler vehiculo) {
    if(vehiculos.contains(vehiculo)) {
      return false;
    }else{
      vehiculos.add(vehiculo);
      return true;
    }
  }

  @Override
  public String toString() {
    final int numberSpecialChars = 5;
    String cadena = "#".repeat(2 * numberSpecialChars) + " Empresa Alquiler de Vehículos '"
        + nombre + "' (" + nif + ") " + "#".repeat(2 * numberSpecialChars);

    cadena += "\n" + "=".repeat(numberSpecialChars) + "> Vehiculos (" + vehiculos.size() + "):";
    cadena += listadoVehiculos();

    cadena += "\n" + "=".repeat(numberSpecialChars) + "> Clientes (" + clientes.size() + "):";
    cadena += listadoClientes();

    cadena += "\n" + "=".repeat(numberSpecialChars) + "> Alquileres (" + alquileres.size() + "):";
    cadena += listadoAlquileres();

    return cadena;
  }

  @Override
  public String listadoAlquileres() {
    String cadena = "";
    int i = 1;
    for (AbstractAlquiler alquiler : alquileres) {
      cadena += "\n" + i + ") " + alquiler;
      i++;
    }
    return cadena;
  }

  @Override
  public String listadoClientes() {
    String cadena = "";
    int i = 1;
    for (AbstractCliente cliente : clientes) {
      cadena += "\n" + i + ") " + cliente;
    }
    return cadena;
  }

  @Override
  public String listadoVehiculos() {
    String cadena = "";
    int i = 1;
    for (AbstractVehiculoAlquiler vehiculoAlquiler : vehiculos) {
      cadena += "\n" + i + ") " + vehiculoAlquiler;
    }
    return cadena;
  }
}
