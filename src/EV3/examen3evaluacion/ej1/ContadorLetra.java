package EV3.examen3evaluacion.ej1;

public class ContadorLetra implements Comparable<ContadorLetra> {
  Character letra;
  Integer contador;

  public ContadorLetra(Character letra, int contador) {
    this.letra = letra;
    this.contador = contador;
  }

  public Character getLetra() {
    return letra;
  }

  public Integer getContador() {
    return contador;
  }

  @Override
  public int compareTo(ContadorLetra o) {
    return 0;
  }
}
