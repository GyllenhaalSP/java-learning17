package EV3.examenconvocatoriaordinaria.programacion.examenordinario;

public class Turismo extends Vehiculo{

  private int numeroDePuertas;
  static final String PUERTAS_ERRONEAS = "Turismo: argumento numero de puertas inválido, debe ser mayor o igual que 1";
  static final String LITERAL_PUERTAS = " puertas";

  public Turismo(String marca, String modelo, Integer anioFabricacion, String matricula, int numeroDePuertas) throws ParametroInvalidoException {
    super(marca, modelo, anioFabricacion, matricula, TipoVehiculo.TURISMO);
    if (numeroDePuertas < 1){
      throw new ParametroInvalidoException(PUERTAS_ERRONEAS);
    }
    this.numeroDePuertas = numeroDePuertas;
  }

  public int getNumeroDePuertas() {
    return numeroDePuertas;
  }

  public void setNumeroDePuertas(int numeroDePuertas) {
    this.numeroDePuertas = numeroDePuertas;
  }

  @Override
  public String toCsvLine(String CSV_SEPARATOR) {
    return super.getMarca()+Vehiculo.CSV_SEPARATOR+super.getModelo()+CSV_SEPARATOR;
  }

  @Override
  public String toString() {
    return super.toString()+CSV_SEPARATOR+numeroDePuertas+LITERAL_PUERTAS;
  }
}
