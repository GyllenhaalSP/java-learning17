package EV3.examen3evaluacion;

import EV3.examen3evaluacion.ej3.ApuestaEuromillones;

public class MainEjercicio3 {
  public static void main(String[] args) {
    System.out.println("Creando apuesta Euromillones...");
    ApuestaEuromillones apuesta = new ApuestaEuromillones();

    int numeroAuxiliar = 0;
    numeroAuxiliar = 50;
    System.out.print("Añadimos el número " + numeroAuxiliar + "... ");
    apuesta.addNumero(numeroAuxiliar);

    numeroAuxiliar = 50;
    System.out.print("Añadimos el número " + numeroAuxiliar + "... ");
    apuesta.addNumero(numeroAuxiliar);

    numeroAuxiliar = 10;
    System.out.print("Añadimos el número " + numeroAuxiliar + "... ");
    apuesta.addNumero(numeroAuxiliar);

    numeroAuxiliar = -5;
    System.out.print("Añadimos el número " + numeroAuxiliar + "... ");
    apuesta.addNumero(numeroAuxiliar);

    numeroAuxiliar = 51;
    System.out.print("Añadimos el número " + numeroAuxiliar + "... ");
    apuesta.addNumero(numeroAuxiliar);

    numeroAuxiliar = 0;
    System.out.print("Añadimos el número " + numeroAuxiliar + "... ");
    apuesta.addNumero(numeroAuxiliar);

    numeroAuxiliar = 7;
    System.out.print("Añadimos el número " + numeroAuxiliar + "... ");
    apuesta.addNumero(numeroAuxiliar);

    numeroAuxiliar = 27;
    System.out.print("Añadimos el número " + numeroAuxiliar + "... ");
    apuesta.addNumero(numeroAuxiliar);

    numeroAuxiliar = 43;
    System.out.print("Añadimos el número " + numeroAuxiliar + "... ");
    apuesta.addNumero(numeroAuxiliar);

    numeroAuxiliar = 38;
    System.out.print("Añadimos el número " + numeroAuxiliar + "... ");
    apuesta.addNumero(numeroAuxiliar);

    numeroAuxiliar = -2;
    System.out.print("Añadimos la estrella " + numeroAuxiliar + "... ");
    apuesta.addEstrella(numeroAuxiliar);

    numeroAuxiliar = 13;
    System.out.print("Añadimos la estrella " + numeroAuxiliar + "... ");
    apuesta.addEstrella(numeroAuxiliar);

    numeroAuxiliar = 12;
    System.out.print("Añadimos la estrella " + numeroAuxiliar + "... ");
    apuesta.addEstrella(numeroAuxiliar);

    numeroAuxiliar = 7;
    System.out.print("Añadimos la estrella " + numeroAuxiliar + "... ");
    apuesta.addEstrella(numeroAuxiliar);

    numeroAuxiliar = 1;
    System.out.print("Añadimos la estrella " + numeroAuxiliar + "... ");
    apuesta.addEstrella(numeroAuxiliar);

    System.out.println();
    System.out.println(apuesta);

    System.out.println("Apuesta Euromillones: " + apuesta);
    apuesta.escribirEnFichero();
  }

}
