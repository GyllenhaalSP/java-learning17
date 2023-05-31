package EV3.ejercicioempresaprogramacionprivate;

import EV3.ejercicioempresaprogramacionprivate.empresaprogramacionprivate.Empleado;
import EV3.ejercicioempresaprogramacionprivate.empresaprogramacionprivate.Empresa;

import java.util.Scanner;

public class MainEmpresaProgramadoresPrivate {

  static Scanner sc = new Scanner(System.in);
  static final String SELECCION_PROGRAMADOR = "programador";
  static final String SELECCION_GERENTE = "gerente";
  static final String SELECCION_EMPLEADO = "empleado";

  public static void main(String[] args) {

    Empresa empresa = new Empresa("Tecnologías Gyllenhaal");
    int opcion;
    Empleado referencia;

   /* try { //CORRECTO
      referencia = new Programador("50549668S", "Daniel Alonso Lázaro", 2310.60, true, LocalDate.parse("2023-05-25"));
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción lanzada por el constructor de Programador: " + e.getMessage());
    }

    try { //CORRECTO
      referencia = new Programador("02765008V", "Víctor Hellín Sáez", 2250.22, true, LocalDate.parse("2023-05-25"));
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción lanzada por el constructor de Programador: " + e.getMessage());
    }

    try { //CORECTO
      referencia = new Gerente("05787459S", "Karla Andino", 3578.43, "Contabilidad", LocalDate.of(2023, 5, 26));
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción lanzada por el constructor de Gerente: " + e.getMessage());
    }

    try { //LETRA DNI INCORRECTA
      referencia = new Gerente("05787459J", "Karla Andino", 3578.43, "Contabilidad", LocalDate.of(2023, 5, 26));
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción lanzada por el constructor de Gerente: " + e.getMessage());
    }

    try { //SIN NOMBRE
      referencia = new Programador("50549668S", "", 2310.60, true, LocalDate.parse("2023-05-25"));
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción lanzada por el constructor de Programador: " + e.getMessage());
    }

    try { //SUELDO NEGATIVO
      referencia = new Programador("50549668S", "Daniel Alonso Lázaro", -2310.60, true, LocalDate.parse("2023-05-25"));
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción lanzada por el constructor de Programador: " + e.getMessage());
    }

    try { //LETRA DNI MINÚSCULA
      referencia = new Gerente("05787459s", "Karla Andino", 3578.43, "Contabilidad", LocalDate.parse("2023-05-25"));
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción lanzada por el constructor de Gerente: " + e.getMessage());
    }*/
//
//    try {
//      referencia = new Programador(parametros);
//      empresa.addEmpleado(referencia);
//    } catch (ParametroInvalidoException e) {
//      throw new RuntimeException(e);
//    }

    do {
      imprimirMenu();
      opcion = Integer.parseInt(sc.nextLine());

      switch (opcion) {
        case 1 ->
          // Imprimir los datos de la empresa y todos sus empleados
                System.out.println(empresa);
        case 2 ->
          // Imprimir solo programadores
                System.out.println(empresa.toStringProgramadores());
        case 3 ->
          // Imprimir empleados(todos) por sueldo de MAYOR A MENOR
                System.out.println(empresa.toStringOrdenSueldo());
        case 4 ->
          // Imprimir empleados(todos) por nombre
                System.out.println(empresa.toStringOrdenNombre());
        case 5 -> {
          // Cargar desde CSV
          System.out.println("Ingrese el nombre del archivo CSV a cargar:");
          empresa.cargarDesdeCSV(sc.nextLine());
        }
        case 6 -> {
          // Guardar programadores en CSV
          empresa.guardarEnCSV(SELECCION_PROGRAMADOR);
        }
        case 7 -> {
          // Guardar gerentes en CSV
          empresa.guardarEnCSV(SELECCION_GERENTE);
        }
        case 8 -> {
          // Guardar todos los empleados en CSV
          empresa.guardarEnCSV(SELECCION_EMPLEADO);
        }
        case 9 -> System.out.println("Saliendo...");
        default -> System.out.println("Opción inválida");
      }

    } while (opcion != 9);
  }

  private static void imprimirMenu() {
    System.out.println("### Menú Empresa ###");
    System.out.println("1. Imprimir todos los empleados");
    System.out.println("2. Imprimir todos los programadores");
    System.out.println("3. Imprimir empleados por sueldo");
    System.out.println("4. Imprimir empleados por nombre");
    System.out.println("5. Cargar desde fichero CSV");
    System.out.println("6. Guardar programadores en CSV");
    System.out.println("7. Guardar gerentes en CSV");
    System.out.println("8. Guardar todos los empleados en CSV");
    System.out.println("9. Salir");
    System.out.print("Introduce una opción: ");
  }
}
