package EV2.OOP.Examen2EV;

import java.util.Scanner;

public class MainAsignatura {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.print("Introduzca el nombre de la asignatura: ");
    String nombreAsignatura = sc.nextLine();
    System.out.print("Introduzca el número de estudiantes: ");
    int numEstudiantes = sc.nextInt();
    sc.nextLine();
    Asignatura asignatura = new Asignatura(nombreAsignatura, numEstudiantes);

    /*Asignatura programacion = new Asignatura("Programación", 5);
    Estudiante estudiante1 = new Estudiante("Daniel", "Alonso Lázaro", "12345");
    Estudiante estudiante2 = new Estudiante("Valentin", "Paun", "56789");
    Estudiante estudiante3 = new Estudiante("Víctor", "Hellín Sáez", "13579");
    Estudiante estudiante4 = new Estudiante("Pablo", "Heredero", "24680");
    Estudiante estudiante5 = new Estudiante("Karla María", "Andino", "97531");

    programacion.addEstudiante(estudiante1);
    programacion.addEstudiante(estudiante2);
    programacion.addEstudiante(estudiante3);
    programacion.addEstudiante(estudiante4);
    programacion.addEstudiante(estudiante5);

    programacion.addNota(estudiante1, 5.5, 0);
    programacion.addNota(estudiante1, 6.75, 1);
    programacion.addNota(estudiante1, 7.25, 2);

    programacion.addNota(estudiante2, 8.75, 0);
    programacion.addNota(estudiante2, 9.25, 1);
    programacion.addNota(estudiante2, 10, 2);

    programacion.addNota(estudiante3, 9.25, 0);
    programacion.addNota(estudiante3, 10, 1);
    programacion.addNota(estudiante3, 9.75, 2);

    programacion.addNota(estudiante4, 8.5, 0);
    programacion.addNota(estudiante4, 9.5, 1);
    programacion.addNota(estudiante4, 9.75, 2);

    programacion.addNota(estudiante5, 8.5, 0);
    programacion.addNota(estudiante5, 7.50, 1);
    programacion.addNota(estudiante5, 9.75, 2);*/

    do {
      switch (menu()) {
        case 1:
          System.out.println(asignatura);
          break;
        case 2:
          sc.nextLine();
          String nombreEstudiante, apellidos, NIA;
          do {
            System.out.print("Introduzca el nombre del estudiante: ");
            nombreEstudiante = sc.nextLine();
            if(nombreEstudiante.equals("")){
              System.out.println("El nombre no puede estar vacío.\n");
              continue;
            }
            System.out.print("Introduzca los apellidos del estudiante: ");
            apellidos = sc.nextLine();
            if(apellidos.equals("")){
              System.out.println("Los apellidos no pueden estar vacíos.\n");
              continue;
            }
            System.out.print("Introduzca el NIA del estudiante: ");
            NIA = sc.nextLine();
            if(asignatura.checkNIA(NIA)){
              asignatura.addEstudiante(nombreEstudiante, apellidos, NIA);
              break;
            }
          }while(true);
          break;
        case 3:
          sc.nextLine();
          double nota1Ev, nota2Ev, nota3Ev;
          do {
            System.out.println("Introduzca el número del estudiante: ");;
            do {
              System.out.println("Introduzca la nota de la 1ª evaluación: ");
            } while (checkNota(nota1Ev = sc.nextDouble()));

            do {
              System.out.println("Introduzca la nota de la 2ª evaluación: ");
            } while (checkNota(nota2Ev = sc.nextDouble()));
            do {
              System.out.println("Introduzca la nota de la 3ª evaluación: ");
            } while (checkNota(nota3Ev = sc.nextDouble()));
          } while (checkNota(nota1Ev) || checkNota(nota2Ev) || checkNota(nota3Ev));

          for(int i = 0; i < asignatura.getNotas().length; i++){
            if(asignatura.getEstudiantes()[i] != null){
              asignatura.addNota(asignatura.getEstudiantes()[i], nota1Ev, 0);
              asignatura.addNota(asignatura.getEstudiantes()[i], nota2Ev, 1);
              asignatura.addNota(asignatura.getEstudiantes()[i], nota3Ev, 2);
            }
          }
          break;
        case 4:
          System.out.println("Saliendo...");
          System.out.println("Gracias por usar nuestro sistema.");
          System.exit(0);
          break;
        default:
          System.out.println("Opción no válida");
          break;
      }
    }while(true);
  }

  public static int menu() {
    System.out.println("\nBienvenido al programa de gestión de notas de asignaturas.");
    System.out.println("----------------------------------------------------------");
    System.out.println("\t1. Imprimir los detalles de la asignatura");
    System.out.println("\t2. Añadir estudiante");
    System.out.println("\t3. Añadir nota estudiante");
    System.out.println("\t4. Salir");
    System.out.print("\nElija una opción: ");
    return sc.nextInt();

  }

  public static boolean checkNota(double nota) {
    if (nota < 0 || nota > 10) {
      System.out.println("La nota debe estar entre 0 y 10.\nVuelva a introducir una nota.");
      return true;
    }
    return false;
  }
}
