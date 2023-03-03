package EV2.OOP.C_20230209_Examen2EV.Solucion;

import java.util.Scanner;

public class MainExamen2aEvaluacion {
  /*
   Creamos un máximo número de estudiantes soportados por la aplicación: MAX_ESTUDIANTES
   No deberíamos soportar una asignatura con más de 100 estudiantes: posibles problemas de
   memoria. ¿Qué ocurre si un usuario introduce como número máximo de estudiantes 10 mil millones?
   Un objeto Estudiante contiene 3 referencias a String y cada una ocupa 4 bytes.
  */
  final static int MAX_ESTUDIANTES = 100;
  public static void main(String[] args) {
    Scanner scan_in = new Scanner(System.in);
    System.out.println("\n===> MainExamen2aEvaluacion\n");

    String nombreAsignatura;
    do {
      System.out.print("Introduce el nombre de la asignatura: ");
      nombreAsignatura = scan_in.nextLine();
    } while (nombreAsignatura.isEmpty());

    int maximoEstudiantes;
    do {
      System.out.print("Introduce el número máximo de estudiantes en la asignatura (2-" + MAX_ESTUDIANTES + "): ");
      maximoEstudiantes = scan_in.nextInt();
      scan_in.nextLine();
    } while (maximoEstudiantes<2 || maximoEstudiantes > MAX_ESTUDIANTES);

    Asignatura asignatura = new Asignatura(nombreAsignatura, maximoEstudiantes);

    // Introduzco a mano estudiantes y notas para tardar menos en hacer las pruebas:
    asignatura.addEstudiante("Alan", "Turing", "123");
    asignatura.addEstudiante("Linus", "Torvalds", "34567");
    asignatura.addNota(0, 0, 4.5f);
    asignatura.addNota(0, 1, 6.5f);
    asignatura.addNota(0, 2, 8f);
    asignatura.addNota(1, 0, 6.5f);
    asignatura.addNota(1, 1, 6.2f);

    int opcion=0;
    do {
      printMenu();
      opcion = scan_in.nextInt();
      scan_in.nextLine();
      switch(opcion) {
        case 1:
          System.out.println("IMPRIMIR ASIGNATURA:");
          System.out.println(asignatura);
          System.out.println();
          break;

        case 2:
          System.out.println("AÑADIR ESTUDIANTE:");
          if(asignatura.cabenEstudiantes() == false){
            System.out.println("ERROR: No caben más estudiantes");
            break;
          }

          String nombre;
          String apellidos;
          String nia;
          System.out.print("Introduce el nombre: ");
          nombre = scan_in.nextLine();
          System.out.print("Introduce los apellidos: ");
          apellidos = scan_in.nextLine();
          System.out.print("Introduce el NIA: ");
          nia = scan_in.nextLine();

          if(asignatura.addEstudiante(nombre, apellidos, nia)) {
            System.out.println("OK: Estudiante añadido");
          } else {
            System.out.println("ERROR: No se pudo añadir el estudiante");
          }
          break;

        case 3:
          System.out.println("AÑADIR NOTA:");

          if(asignatura.getNumeroEstudiantes() < 1) {
            System.out.println("Error: No se pueden añadir notas, no hay ningún estudiante registrado.");
            break;
          }
          System.out.println(asignatura.listaEstudiantesToString());

          int numeroEstudiante = 0;
          do {
            System.out.println("Introduce el número de estudiante (1-" + asignatura.getNumeroEstudiantes() + "): ");
            numeroEstudiante = scan_in.nextInt();
            scan_in.nextLine();
          }while(numeroEstudiante <= 0 || numeroEstudiante > asignatura.getNumeroEstudiantes());

          int posicionEstudiante = numeroEstudiante-1;
          System.out.println(asignatura.notasEstudianteToString(posicionEstudiante));

          int evaluacion = 0;
          float nota = -1;
          while (evaluacion<1 || evaluacion>3) {
            System.out.println("Introduce la evaluación (1, 2 ó 3): ");
            evaluacion = scan_in.nextInt();
            scan_in.nextLine();
          }
          int posicionEvaluacion = evaluacion-1;

          do {
            System.out.println("Introduce la nota (entre 0 y 10): ");
            nota = scan_in.nextFloat();
            System.out.println("#### nota = " + nota);
          } while (nota < 0 || nota > 10);

          if(asignatura.addNota(posicionEstudiante, posicionEvaluacion, nota)) {
            System.out.println("OK: Nota añadida");
          } else {
            System.out.println("ERROR: No se pudo añadir la nota");
          }
          break;

        case 4:
          System.out.println("SALIR:");
          System.out.println(asignatura);
          System.out.println();
          break;

        default:
          System.out.println("OPCIÓN INVÁLIDA!");
          break;
      }

    } while (opcion!=4);

    scan_in.close();
    System.out.println("\n===> Bye, bye\n");
  }

  public static void printMenu(){
    System.out.println("\nMenú gestión asignatura");
    System.out.println("1.- Imprimir los detalles de la asignatura");
    System.out.println("2.- Añadir estudiante");
    System.out.println("3.- Añadir nota");
    System.out.println("4.- Salir");
    System.out.print("Elige una opción: ");
  }
}