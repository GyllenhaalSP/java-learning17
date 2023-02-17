package EV2.OOP.C_20230206;

/**
 * Clase que simula un Vehiculo.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Vehiculo {
  private final String marca;
  private final String modelo;
  private Integer posicionClienteAlquiler;

  public Vehiculo(String marca, String modelo) {
    this.marca = marca;
    this.modelo = modelo;
  }

  public boolean setPosicionClienteAlquiler(int pos) {
    if(posicionClienteAlquiler == null) {
      this.posicionClienteAlquiler = pos;
      return true;
    }
    else {
      System.out.println("El vehiculo " + this + " ya está alquilado por el cliente con la posicion "
                          + posicionClienteAlquiler);
      return false;
    }
  }

  public Integer getPosicionClienteAlquiler() {
    return posicionClienteAlquiler;
  }

  public boolean alquilado(){
      return posicionClienteAlquiler != null;
  }

  @Override
  public String toString() {
    String cadena = marca + " " + modelo;
    if (posicionClienteAlquiler != null) {
      cadena += " -> " + posicionClienteAlquiler;
    }
    return cadena;
  }

  

}
