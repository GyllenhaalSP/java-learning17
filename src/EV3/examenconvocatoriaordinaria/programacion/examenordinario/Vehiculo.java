package EV3.examenconvocatoriaordinaria.programacion.examenordinario;

public abstract class Vehiculo implements Comparable<Vehiculo>{
  private String marca;
  private String modelo;
  private Integer anioFabricacion;
  private String matricula;
  private TipoVehiculo tipo;
  static final String CSV_SEPARATOR = "#";
  static final String COMA = ", ";
  static final String VEHICULO = "Vehiculo: ";
  static final String MARCA_VACIO = VEHICULO + "argumento marca vacío";
  static final String MODELO_VACIO = VEHICULO + "argumento modelo vacío";
  static final String FABRICACION_VACIO = VEHICULO + "argumento año de fabricación inválido, debe ser mayor a 1867";
  static final String FECHA_ERRONEA = VEHICULO + "La fecha proporcionada es menor a 1867.";

  public Vehiculo(String marca, String modelo, Integer anioFabricacion, String matricula, TipoVehiculo tipo) throws ParametroInvalidoException {
    if (marca.isEmpty()){
      throw new ParametroInvalidoException(MARCA_VACIO);
    }
    if (modelo.isEmpty()){
      throw new ParametroInvalidoException(MODELO_VACIO);
    }
    if (matricula.isEmpty()){
      throw new ParametroInvalidoException(FABRICACION_VACIO);
    }
    if (anioFabricacion < 1867){
      throw new ParametroInvalidoException(FECHA_ERRONEA);
    }
    this.marca = marca;
    this.modelo = modelo;
    this.anioFabricacion = anioFabricacion;
    this.matricula = matricula;
    this.tipo = tipo;
  }

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

  public Integer getAnioFabricacion() {
    return anioFabricacion;
  }

  public String getMatricula() {
    return matricula;
  }

  public TipoVehiculo getTipo() {
    return tipo;
  }

  @Override
  public int compareTo(Vehiculo o) {
    return anioFabricacion.compareTo(o.anioFabricacion);
  }

  @Override
  public String toString() {
    return tipo + ": " + marca + "/" + modelo + ", " + anioFabricacion + ", " + matricula;
  }

  public abstract String toCsvLine(String CSV_SEPARATOR);
}
