package EV2.OOP.C_20230206;

/**
 * Clase que simula un Cliente.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Cliente {
  private final String nombre;
  private final String apellido;
  private Integer posicionVehiculoAlquilado;

  
  public Cliente(String nombre, String apellido) {
    this.nombre = nombre;
    this.apellido = apellido;
  }

  public boolean setPosicionVehiculoAlquilado(int pos){
    if(posicionVehiculoAlquilado == null) {
      this.posicionVehiculoAlquilado = pos;
      return true;
    }
    else {
      System.out.println("El cliente " + this + " ya tiene el vehiculo de la posicion " 
                          + posicionVehiculoAlquilado + " alquilado");
      return false;
    }
  }

  public boolean tieneAlquiler() {
      return posicionVehiculoAlquilado != null;
  }

  @Override
  public String toString() {
    String cadena = nombre + " " + apellido;

    return cadena;
  }

  
}
