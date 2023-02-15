package EV2.OOP.VehiculoCliente;

import java.util.Arrays;

public class AgenciaAlquilerVehiculos {
  private final String nombre;
  private final Vehiculo[] vehiculos;
  private final Cliente[] clientes;
  private int numClientes;
  private int numVehiculos;
  
  public AgenciaAlquilerVehiculos(String nombre, int maxClientes, int maxVehiculos) {
    this.nombre = nombre;
    this.vehiculos = new Vehiculo[maxVehiculos];
    this.clientes = new Cliente[maxClientes];
    // podríamos añadir lo siguiente pero no hace falta
    numClientes = 0;
    numVehiculos = 0;
  }
  
  public boolean addCliente(String nombre, String apellido){
    if(numClientes >= clientes.length){
      System.out.println("No hay espacio para más clientes (max=" + clientes.length + ")");
      return false;
    }
    clientes[numClientes] = new Cliente(nombre, apellido);
    numClientes++;
    return true;
  }
  
  public boolean addVehiculo(String marca, String modelo){
    if(numVehiculos >= vehiculos.length){
      System.out.println("No hay espacio para más vehículos (max=" + vehiculos.length + ")");
      return false;
    }
    vehiculos[numVehiculos] = new Vehiculo(marca, modelo);
    numVehiculos++;
    return true;
  }
  
  public boolean alquilarVehiculo(int posCliente, int posVehiculo){
    if(clientes[posCliente].tieneAlquiler()) {
      System.out.println("ERROR: El cliente " + clientes[posCliente] + " ya tiene un vehículo alquilado");
      return false;
    }
    if(vehiculos[posVehiculo].alquilado()) {
      System.out.println("ERROR: El vehiculo " + vehiculos[posVehiculo] + " ya está alquilado");
      return false;
    }
    
    if(!clientes[posCliente].setPosicionVehiculoAlquilado(posVehiculo)){
      return false;
    }

      return vehiculos[posVehiculo].setPosicionClienteAlquiler(posCliente);
  }
  
  /*
  public boolean devolverVehiculo(int posCliente, int posVehiculo){

    clientes[posCliente].posicionVehiculoAlquilado = null;
    vehiculos[posVehiculo].posicionClienteAlquiler = null;
  }
  */
  
  @Override
  public String toString() {
    String cadena;
    cadena = "Agencia '" + nombre + "'"  + " (numClientes=" + numClientes 
    + ", numVehiculos=" + numVehiculos + ")\n";
    cadena += "Lista de clientes:\n";
    for(int i=0; i<numClientes; i++) {
      cadena += "\t" + i + ") " + clientes[i] + "\n";
    }
    cadena += "Lista de vehiculos:\n";
    for(int i=0; i<numVehiculos; i++) {
      cadena += "\t" + i + ") " + vehiculos[i];
      if(vehiculos[i].alquilado()){
        cadena += " -> " + clientes[vehiculos[i].getPosicionClienteAlquiler()];
      } 
      cadena += "\n";
    }
    return cadena;
  }
  
  public void imprimir() {
    System.out.println("'" + nombre + "'"  + ", numClientes=" + numClientes 
    + ", numVehiculos=" + numVehiculos 
    + ", vehiculos=" + Arrays.toString(vehiculos) + ", clientes="
    + Arrays.toString(clientes));
  }
}