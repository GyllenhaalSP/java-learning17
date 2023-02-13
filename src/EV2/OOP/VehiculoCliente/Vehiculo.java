package EV2.OOP.VehiculoCliente;

public class Vehiculo {
  private String marca;
  private String modelo;
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
    if(posicionClienteAlquiler == null) {
      return false;
    }
    return true;
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
