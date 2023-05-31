package EV3.examenconvocatoriaordinaria.programacion.examenordinario;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class EmpresaAlquilerVehiculos {
  private String nombre;
  private String nif;
  private Map<String, Cliente> mapClientes;
  private Map<String, Vehiculo> mapVehiculos;
  private List<Alquiler> listaAlquileres;
  static final String EXISTE_CLIENTE = "No se pudo agregar el cliente: ";
  static final String EXISTE_VEHICULO = "No se pudo agregar el turismo:  ";
  static final String SALTO_LINEA = "\n";
  static final String CSV_SEPARATOR = "#";

  public EmpresaAlquilerVehiculos(String nombre, String nif) {
    this.nombre = nombre;
    this.nif = nif;
    this.mapClientes = new HashMap<>();
    this.mapVehiculos = new HashMap<>();
    this.listaAlquileres = new ArrayList<>();
  }

  /*
   * Métodos apartado 2:
   */
   public boolean addCliente(Cliente cliente) throws ParametroInvalidoException {
     if(mapClientes.containsKey(cliente.getDni())){
       throw new ParametroInvalidoException(EXISTE_CLIENTE + cliente);
     }
     mapClientes.put(cliente.getDni(), cliente);
     return true;
   }

   public Cliente getCliente(String dni) {
     for(Cliente cliente : mapClientes.values()){
       if(cliente.getDni().equalsIgnoreCase(dni)){
         return cliente;
       }
     }
     return null;
   }

   public boolean addVehiculo(Vehiculo vehiculo) throws ParametroInvalidoException {
     if(mapVehiculos.containsKey(vehiculo.getMatricula())){
       throw new ParametroInvalidoException(EXISTE_VEHICULO + vehiculo);
     }
     mapVehiculos.put(vehiculo.getMatricula(), vehiculo);
     return true;
   }

   public Vehiculo getVehiculo(String matricula) {
     for(Vehiculo vehiculo : mapVehiculos.values()){
       if(vehiculo.getMatricula().equalsIgnoreCase(matricula)){
         return vehiculo;
       }
     }
     return null;
   }

   public boolean addAlquiler(Alquiler alquiler) {
     return listaAlquileres.add(alquiler);
   }

   public boolean finalizarAlquiler(String matricula, LocalDateTime fin) {
     for (Alquiler alquiler : listaAlquileres){
       if (alquiler.getVehiculo().getMatricula().equalsIgnoreCase(matricula) && alquiler.getFin() == null){
         alquiler.setFin(fin);
         return true;
       }
     }
     return false;
   }

  public String toString() {
    String cadena = "";
    cadena += "=== Empresa: " + nombre + ", NIF: " + nif;
    if (mapClientes.isEmpty() == false) {
      cadena += "\n== Clientes:\n";
      cadena += toStringClientes();
    }
    if (mapVehiculos.isEmpty() == false) {
      cadena += "\n== Vehiculos:\n";
      cadena += toStringVehiculos();
    }
    if (listaAlquileres.isEmpty() == false) {
      cadena += "\n== Alquileres:\n";
      cadena += toStringAlquileres();
    }
    return cadena;
  }

   public String toStringClientes() {
    String clientesToString = "";
    for (Cliente cliente : mapClientes.values()){
      clientesToString += cliente.toString() + SALTO_LINEA;
    }
    return clientesToString;
   }

   public String toStringVehiculos() {
    String vehiculosToString = "";
    for(Vehiculo vehiculo: mapVehiculos.values()){
      vehiculosToString += vehiculo.toString() + SALTO_LINEA;
    }
    return vehiculosToString;
   }

   public String toStringAlquileres() {
     String alquileresToString = "";
     for (Alquiler alquiler : listaAlquileres){
       alquileresToString += alquiler.toString() + SALTO_LINEA;
     }
     return alquileresToString;
   }

  /*
   * Métodos apartado 4: Ordenamiento de colecciones 
   */
   public String toStringClientesOrdenNatural() {
     ArrayList<Cliente> listaClientesOrdenNatural = new ArrayList<>(mapClientes.values());
     Collections.sort(listaClientesOrdenNatural);
     String clientesOrdenadosPorOrdenNatural = "";
     for (Cliente cliente : listaClientesOrdenNatural){
       clientesOrdenadosPorOrdenNatural += cliente.toString() + SALTO_LINEA;
     }
     return clientesOrdenadosPorOrdenNatural;
   }

   public String toStringClientesOrdenDni() {
     ArrayList<Cliente> listaClientesOrdenDni = new ArrayList<>(mapClientes.values());
     listaClientesOrdenDni.sort(Cliente.COMPARATOR_DNI);
     String clientesOrdenadorPorOrdenDni = "";
     for(Cliente cliente: listaClientesOrdenDni){
       clientesOrdenadorPorOrdenDni += cliente.toString() + SALTO_LINEA;
     }
     return clientesOrdenadorPorOrdenDni;
   }

   public String toStringVehiculosOrdenNatural() {
     ArrayList<Vehiculo> listaVehiculosOrdenNatural = new ArrayList<>(mapVehiculos.values());
     Collections.sort(listaVehiculosOrdenNatural, Collections.reverseOrder());
     String vehiculosOrdenadosPorOrdenNatural = "";
     for (Vehiculo vehiculo : listaVehiculosOrdenNatural){
       vehiculosOrdenadosPorOrdenNatural += vehiculo.toString() + SALTO_LINEA;
     }
     return vehiculosOrdenadosPorOrdenNatural;
   }

   public String toStringAlquileresOrdenNatural() {
     ArrayList<Alquiler> listaAlquileresOrdenNatural = new ArrayList<>(listaAlquileres);
     String alquileresOrdenadosPorOrdenNatural = "";
     Collections.sort(listaAlquileresOrdenNatural);
     for (Alquiler alquiler : listaAlquileresOrdenNatural){
       alquileresOrdenadosPorOrdenNatural += alquiler.toString() + SALTO_LINEA;
     }
     return alquileresOrdenadosPorOrdenNatural;
   }

  /*
   * Métodos apartado 5: Guardado y lectura en ficheros CSV 
   */
   public boolean guardarClientesCsv(String ruta) {
      try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ruta))){
        for(Cliente cliente : mapClientes.values()){
          bufferedWriter.write(cliente.toCsvLine());
          bufferedWriter.newLine();
        }
        return true;
      }catch(IOException e){
        System.out.println("No se ha podido guardar el archivo " +ruta);
      }
     return false;
   }

   public boolean cargarClientesCsv(String ruta) {
     try(BufferedReader bufferedReader = new BufferedReader(new FileReader(ruta))){
      String linea;
      String[] datosClientes;
      while ((linea = bufferedReader.readLine()) != null){
        datosClientes = linea.split(CSV_SEPARATOR);
        if (datosClientes.length != 3){
          System.out.println("otro algo más");
        }
        addCliente(new Cliente(datosClientes[0], datosClientes[1], datosClientes[2]));
      }
     }catch(IOException e){
       System.out.println("Algo");
     } catch (ParametroInvalidoException e) {
       System.out.println("Otro algo");
     }
     return true;
   }

   public boolean guardarTurismosCsv(String ruta) {
     try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ruta))){
       for(Vehiculo turismo : mapVehiculos.values()){
         if (turismo instanceof Turismo){
           bufferedWriter.write(turismo.toCsvLine(CSV_SEPARATOR));
           bufferedWriter.newLine();
         }
       }
       return true;
     }catch(IOException e){
       System.out.println("No se ha podido guardar el archivo " +ruta);
     }
     return false;
   }

   public boolean cargarTurismosCsv(String ruta) {
     return false;
   }

   public boolean guardarMotocicletasCsv(String ruta) {
     try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ruta))){
       for(Vehiculo motocicleta : mapVehiculos.values()){
         if (motocicleta instanceof Motocicleta){
           bufferedWriter.write(motocicleta.toCsvLine(CSV_SEPARATOR));
           bufferedWriter.newLine();
         }
       }
       return true;
     }catch(IOException e){
       System.out.println("No se ha podido guardar el archivo " +ruta);
     }
     return false;
   }

   public boolean cargarMotocicletasCsv(String ruta) {
     return false;
   }


  /*
   * Métodos apartado Ampliaciones extra, 6.3: Cargar y guardar alquileres en formato CSV 
   */
  // public boolean guardarAlquileresCsv(String ruta) {}
  // public boolean cargarAlquileresCsv(String ruta) {}

}
