package EV3.examen3evaluacion.ej3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class ApuestaEuromillones {
  TreeSet<Integer> numeros;
  TreeSet<Integer> estrellas;

  static final String RUTA_FICHERO = "apuestas.txt";

  public ApuestaEuromillones(){
    numeros = new TreeSet<>();
    estrellas = new TreeSet<>();
  }

  public void addNumero(int numero){
    try{
      comprobarSize();
    }catch(ApuestaEuromillonesException e){
      System.out.println("ERROR: "+ e.getMessage());
      return;
    }

    try {
      if(checkNumero(numero)) {
        throw new ApuestaEuromillonesException("El número '" + numero + "' está fuera del rango permitido [1,50]");
      }
    }catch(ApuestaEuromillonesException e ){
      System.out.println("ERROR: " + e.getMessage());
    }
  }

  public void addEstrella(int estrella) throws ApuestaEuromillonesException{
    try{
      comprobarSize();
    }catch(ApuestaEuromillonesException e){
      System.out.println("ERROR: "+ e.getMessage());
      return;
    }

    try {
      if(checkEstrella(estrella)) {
        throw new ApuestaEuromillonesException("La estrella '" + estrella + "' está fuera del rango permitido [1,12]");
      }
    }catch(ApuestaEuromillonesException e ){
      System.out.println("ERROR: " + e.getMessage());
    }
  }

  void comprobarSize() {
    if (numeros.size() == 5) {
      throw new ApuestaEuromillonesException("La apuesta ya tiene 5 números");
    }
    if(estrellas.size() == 2){
      throw new ApuestaEuromillonesException("La apuesta ya tiene 2 estrellas");
    }
  }

  boolean checkNumero(int numero){
    if (numero >= 1 && numero <= 50){
      if (!numeros.add(numero)) {
        throw new ApuestaEuromillonesException("El número '" + numero + "' ya se ha añadido a la apuesta");
      }else{
        System.out.println("OK");
      }
      return false;
    }else {
      return true;
    }
  }

  boolean checkEstrella(int estrella){
    if (estrella >= 1 && estrella <= 12){
      if (!estrellas.add(estrella)) {
        throw new ApuestaEuromillonesException("El número '" + estrella + "' ya se ha añadido a la apuesta");
      }
      return false;
    }else {
      System.out.println("OK");
      return true;
    }
  }

  @Override
  public String toString() {
    String cadena = "Números: \n";
    for(Integer apuesta:numeros){
      cadena+= apuesta + ", ";
    }
    cadena += "\nEstrellas: \n";
    for(Integer apuesta: estrellas){
      cadena += apuesta + ", ";
    }

    return cadena;
  }

  public void escribirEnFichero() {
    try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_FICHERO))){
      bw.write(this.toString());
    } catch (IOException e){
      System.out.println(e);
    }

  }
}
