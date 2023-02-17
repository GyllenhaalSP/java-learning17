package EV2.OOP.C_20230209_Examen2EV;

public class Asignatura {

  private final String nombre;
  private final Estudiante[] estudiantes;
  private final double[][] notas;
  private final int numMaxEstudiantes;
  private static int numEstudiante = 0;
  private static final int PESO_PRIMERA_EVALUACION = 20;
  private static final int PESO_SEGUNDA_EVALUACION = 30;
  private static final int PESO_TERCERA_EVALUACION = 50;

  public Asignatura(String nombre, int numMaxEstudiantes) {
    this.nombre = nombre;
    this.numMaxEstudiantes = numMaxEstudiantes;
    this.estudiantes = new Estudiante[numMaxEstudiantes];
    this.notas = new double[numMaxEstudiantes][3];
    numEstudiante++;
  }

  public String getNombre() {
    return nombre;
  }

  public Estudiante[] getEstudiantes() {
    return estudiantes;
  }

  public double[][] getNotas() {
    return notas;
  }

  public int getNumEstudiante() {
    return numEstudiante;
  }

  public void addEstudiante(Estudiante estudiante) {
    for (int i = 0; i < estudiantes.length; i++) {
      if (estudiantes[i] == null) {
        estudiantes[i] = estudiante;
        break;
      }
    }
  }

  public boolean addEstudiante(String nombre, String apellidos, String NIA) {
    if(checkNIA(NIA)){
      for (int i = 0; i < estudiantes.length; i++) {
        if (estudiantes[i] == null) {
          estudiantes[i] = new Estudiante(nombre, apellidos, NIA);
          return true;
        }
      }
    }else{
      System.out.println("El NIA no es válido, vuelva a introducir los datos.");
      return false;
    }
    return false;
  }

  public void addNota(Estudiante estudiante, double nota, int evaluacion) {
    for (int i = 0; i < estudiantes.length; i++) {
      if (estudiantes[i] == estudiante) {
        notas[i][evaluacion] = nota;
        break;
      }
    }
  }

  public double notaMedia(Estudiante estudiante) {
    double notaMedia = 0;
    for (int i = 0; i < estudiantes.length; i++) {
      if (estudiantes[i] == estudiante) {
        notaMedia = (notas[i][0] * PESO_PRIMERA_EVALUACION + notas[i][1] * PESO_SEGUNDA_EVALUACION + notas[i][2] * PESO_TERCERA_EVALUACION) / 100;
        break;
      }
    }
    return notaMedia;
  }

  public boolean checkNIA(String NIA) {
    if (NIA.length() != 5){
      System.out.println("El NIA debe contener 5 caracteres");
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    System.out.print("\n Asignatura: '" + nombre + "'. ");
    System.out.println(estudiantes.length + " estudiantes registrados (máximo " + numMaxEstudiantes + ")");
    System.out.println("1aEV   2aEV  3aEV\t FINAL   |  NIA   (nombre y apellidos)");
    for (int i = 0; i < estudiantes.length; i++) {
      if (estudiantes[i] != null) {
        for (int j = 0; j < notas[i].length; j++) {
          System.out.printf("%5.02f ", notas[i][j]);
        }
        System.out.print(" => ");
        System.out.printf("%5.02f", notaMedia(estudiantes[i]));
        System.out.print("  |  ");
        System.out.print(estudiantes[i].toString());
      }
    }
    return "";
  }
}