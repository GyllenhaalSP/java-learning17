package EV2.OOP.C_20230317.EmpresaAlquilerVehiculos.programacion.negocios.empresaalquilervehiculos;

import java.util.Date;

abstract class AbstractAlquiler {
  AbstractCliente cliente;
  AbstractVehiculoAlquiler vehiculo;
  Date inicioAlquiler;
  Date finAlquiler;
  Float costeTotal;

  public AbstractAlquiler(AbstractCliente cliente, AbstractVehiculoAlquiler vehiculo) {
    this.cliente = cliente;
    this.vehiculo = vehiculo;
  }

  public Object getVehiculo() {
    return vehiculo;
  }

  abstract void comenzarAlquiler();
  abstract void terminarAlquiler();
  //public abstract boolean calcularCosteTotal();
  //public abstract Float getCosteTotal();

  @Override
  public abstract String toString();
}