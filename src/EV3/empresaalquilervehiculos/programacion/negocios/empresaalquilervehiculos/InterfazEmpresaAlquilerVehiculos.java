package EV3.empresaalquilervehiculos.programacion.negocios.empresaalquilervehiculos;

public interface InterfazEmpresaAlquilerVehiculos {
  boolean alquilarVehiculo(AbstractCliente cliente, AbstractVehiculoAlquiler vehiculo);

  boolean devolverVehiculo(AbstractVehiculoAlquiler vehiculo);

  boolean registrarCliente(AbstractCliente cliente);

  boolean registrarVehiculo(AbstractVehiculoAlquiler vehiculo);

  String listadoVehiculos();

  String listadoClientes();

  String listadoAlquileres();
}
