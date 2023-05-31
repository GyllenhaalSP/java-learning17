package EV3.examenconvocatoriaordinaria.programacion.examenordinario;

public class Motocicleta extends Vehiculo{

  private Integer cilindrada;
  static final String CILINDRADA_ERRONEA = "Motocicleta: argumento cilindrada inválido, debe ser mayor o igual que 50";
  static final String LITERAL_CILINDRADA = " cc";

  public Motocicleta(String marca, String modelo, Integer anioFabricacion, String matricula, Integer cilindrada) throws ParametroInvalidoException {
    super(marca, modelo, anioFabricacion, matricula, TipoVehiculo.MOTOCICLETA);
    if (cilindrada < 50){
      throw new ParametroInvalidoException(CILINDRADA_ERRONEA);
    }
    this.cilindrada = cilindrada;
  }

  public Integer getCilindrada() {
    return cilindrada;
  }

  public void setCilindrada(Integer cilindrada) {
    this.cilindrada = cilindrada;
  }

  @Override
  public String toString() {
    return super.toString()+Vehiculo.COMA+cilindrada+LITERAL_CILINDRADA;
  }

  @Override
  public String toCsvLine(String CSV_SEPARATOR) {
    return super.toString()+CSV_SEPARATOR+cilindrada;
  }
}
