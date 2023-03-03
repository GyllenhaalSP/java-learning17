package EV2.OOP.C_20230209_Examen2EV.Solucion;

public class Asignatura {
  private String nombre;
  private Estudiante[] estudiantes;
  int numeroEstudiantes;
  private Float[][] notas;

  // El orden en el que se especifican los atributos static y final no es relevante
  public static final Float MIN_NOTA = 0f;
  public static final Float MAX_NOTA = 10f;
  public final static int NUMERO_EVALUACIONES = 3;
  public final static float[] PESOS_NOTAS = new float[] {20f/100, 30f/100, 50f/100};

  public Asignatura(String nombre, int maxEstudiantes) {
    this.nombre = nombre;
    estudiantes = new Estudiante[maxEstudiantes];
    notas = new Float[maxEstudiantes][NUMERO_EVALUACIONES];
    // Los atributos numéricos se inicializan a 0 por defecto, no es necesario inicializar numeroEstudiantes a 0
    numeroEstudiantes = 0;
  }

  public int getNumeroEstudiantes() {
    return numeroEstudiantes;
  }

  public int getMaxEstudiantes() {
    return estudiantes.length;
  }

  public boolean cabenEstudiantes() {
    return getNumeroEstudiantes() < getMaxEstudiantes();
  }

  public boolean addEstudiante(String nombre, String apellidos, String nia) {
    if(cabenEstudiantes() == false) {
      return false;
    }

    // Validación de argumentos: nombre, apellidos y nia
    if(nombre.isEmpty() || apellidos.isEmpty() || nia.isEmpty()) {
      System.out.println("ERROR: Argumentos inválidos, no puede haber ningún campo vacío: "
                         + "nombre='" + nombre + "'', apellidos='" + apellidos
                         + "'', NIA='" + nia + "'");
      return false;
    }

    if(nia.length() > Estudiante.NIA_MAX_LENGTH) {
      System.out.println("ERROR: Argumentos inválidos. El NIA es más largo del máximo ("
                          + Estudiante.NIA_MAX_LENGTH + " dígitos)");
      return false;
    }

    for(int pos=0; pos < nia.length(); pos++) {
      if(Character.isDigit(nia.charAt(pos)) ==  false) {
        System.out.println("ERROR: NIA inválido, el caracter en la posición " + (pos+1)
                      + " no es un dígito. El NIA debe contener un número de hasta "
                      + Estudiante.NIA_MAX_LENGTH + " dígitos. El NIA recibido es '" + nia + "'");
        return false;
      }
    }

    // Una vez validados los argumentos, creamos el nuevo objeto de la clase Estudiante
    // y lo almacenamos en la siguiente posición libre del array
    estudiantes[numeroEstudiantes] = new Estudiante(nombre, apellidos, nia);
    numeroEstudiantes++;
    return true;
  }

  public boolean addNota(int posicionEstudiante, int posicionEvaluacion, float nota) {
    // Validación de argumentos posicionEstudiante, posicionEvaluacion y nota
    if(posicionEstudiante < 0 || posicionEstudiante >= numeroEstudiantes) {
      System.out.println("ERROR: posicionEstudiante inválida (" + posicionEstudiante + ")");
      return false;
    }

    if(posicionEvaluacion < 0 || posicionEvaluacion >= NUMERO_EVALUACIONES) {
      System.out.println("ERROR: posicionEvaluacion inválida (" + posicionEvaluacion + ")");
      return false;
    }

    if(nota < 0 || nota > 10) {
      System.out.println("ERROR: nota inválida (" + nota + "). Debe estar comprendida entre 0 y 10, ambos incluidos.");
      return false;
    }

    // Si la posición en la que vamos a almacenar la nota ya tiene un valor, mostramos
    // un mensaje de aviso
    if(notas[posicionEstudiante][posicionEvaluacion] != null) {
      System.out.println("WARNING: Se está sobreescribiendo la nota "
          + notas[posicionEstudiante][posicionEvaluacion] + " por la nota " + nota);
    }

    // Una vez validados los argumentos, almacenamos la nota proporcionada en la posición
    // correspondiente del array bidemensional
    notas[posicionEstudiante][posicionEvaluacion] = nota;
    return true;
  }

  /*
   * El método notasEstudianteToString(int posicionEstudiante) nos va a facilitar imprimir
   * cada una de las líneas con las notas del estudiante en función de su posición
   */
  public String notasEstudianteToString(int posEstudiante) {
    String cadena = "";

    if(posEstudiante >= numeroEstudiantes) {
      System.out.println("ERROR: posicionEstudiante inválida: " + posEstudiante
                         + ". Hay " + numeroEstudiantes + " estudiantes registrados");
      return cadena;
    }

    float notaFinal = 0;
    boolean imprimirNotaFinal = true;
    for (int posEvaluacion = 0; posEvaluacion < NUMERO_EVALUACIONES; posEvaluacion++) {
      if(notas[posEstudiante][posEvaluacion] == null) {
        cadena += "    * "; // También valdría: String.format("%5s ", "*")
        // Si no tenemos la nota de alguna evaluación, ya no calculamos la nota final ponderada
        imprimirNotaFinal = false;
      } else {
        cadena += String.format("%5.2f ", notas[posEstudiante][posEvaluacion]);
        notaFinal += (notas[posEstudiante][posEvaluacion] * PESOS_NOTAS[posEvaluacion]);
      }
    }

    cadena += " => ";

    if(imprimirNotaFinal) {
      // Si tenemos las notas de todas las evaluaciones y imprimimos la nota final
      cadena += String.format("%5.2f", notaFinal);
    } else {
      // Si no tenemos la nota final, imprimimos un asterisco, pero mantenemos la tabulación
      cadena += String.format("%5s", "*");;
    }

    return cadena;
  }

  /*
   * El método listaEstudiantesToString() imprime el listado numerado de estudiantes registrados.
   * Su sitio más adecuado sería la clase Main porque es parte de la interfaz, no añade
   * funcionalidad a la clase Asignatura. Lo dejo aquí para no cambiar más cosas.
   */
  public String listaEstudiantesToString() {
    String cadena;
    cadena = "Lista de estudiantes:\n";
    for (int posEstudiante=0; posEstudiante<numeroEstudiantes; posEstudiante++) {
      cadena += (posEstudiante+1) + ") " + estudiantes[posEstudiante] + "\n";
    }
    return cadena;
  }

  /*
   * Método toString() que debe imprimir todos los detalles de la asignatura, con las
   * notas de cada evaluación, la nota final y los detalles de cada estudiante.
   */
  @Override
  public String toString() {
    String cadena;
    cadena = "Asignatura " + nombre + ". " + numeroEstudiantes + " estudiantes registrados "
             + "(máximo " + getMaxEstudiantes() + ")\n";

    if(numeroEstudiantes>0) {
      cadena += " 1aEv  2aEv  3aEv     FINAL | NIA   (nombre y apellidos)\n";
    }

    for(int i=0; i<numeroEstudiantes; i++) {
      cadena += notasEstudianteToString(i);
      cadena += " | " + estudiantes[i] + "\n";
    }
    return cadena;
  }

}