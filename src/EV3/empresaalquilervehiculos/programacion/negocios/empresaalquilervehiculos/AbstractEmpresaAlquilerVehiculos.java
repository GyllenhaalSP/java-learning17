package EV3.empresaalquilervehiculos.programacion.negocios.empresaalquilervehiculos;

import java.util.ArrayList;

abstract public class AbstractEmpresaAlquilerVehiculos {
  String nombre;
  String nif;
  ArrayList<AbstractCliente> clientes;
  ArrayList<AbstractVehiculoAlquiler> vehiculos;
  ArrayList<AbstractAlquiler> alquileres;

  public AbstractEmpresaAlquilerVehiculos(String nombre, String nif) {
    this.nombre = nombre;
    this.nif = nif;
    clientes = new ArrayList<>();
    vehiculos = new ArrayList<>();
    alquileres = new ArrayList<>();
  }

  @Override
  abstract public String toString();

}