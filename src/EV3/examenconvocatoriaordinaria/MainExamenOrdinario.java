package EV3.examenconvocatoriaordinaria;

import EV3.examenconvocatoriaordinaria.programacion.examenordinario.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MainExamenOrdinario {
  static Scanner scanner = new Scanner(System.in);

  static final String OPCION_0_STRING = "0) Imprimir empresa, con el contenido de sus colecciones";
  static final String OPCION_1_STRING = "1) Crear Turismos, Clientes y Alquileres";
  static final String OPCION_2_STRING = "2) Crear EmpresaAlquilerVehiculos y añadirle turismos, clientes y alquileres";
  static final String OPCION_3_STRING = "3) Lanzamiento y captura de excepciones";
  static final String OPCION_4_STRING = "4) Ordenamiento de colecciones (SE DEBE EJECUTAR LA OPCION 2 ANTES PARA TENER ELEMENTOS EN LAS COLECCIONES A ORDENAR)";
  static final String OPCION_5_STRING = "5) Guardado y lectura en ficheros CSV (SE DEBE EJECUTAR LA OPCION 2 ANTES PARA TENER ELEMENTOS EN LAS COLECCIONES A ORDENAR)";
  static final String OPCION_6_STRING = "6) Ampliaciones Extras";
  static final String OPCION_9_STRING = "9) SALIR";
  static final int OPCION_SALIDA = 9;

  static final String OPCION_INVALIDA = "ERROR: Opción introducida inválida!!";

  static final String DNI_ALAN_TURING = "01234567A";
  static final String NOMBRE_ALAN_TURING = "Alan";
  static final String APELLIDO_ALAN_TURING = "Turing";

  static final String DNI_ABRAHAM_TURING = "89374813A";
  static final String NOMBRE_ABRAHAM_TURING = "Abraham";
  static final String APELLIDO_ABRAHAM_TURING = "Turing";

  static final String DNI_LINUS_TORVALDS = "73048540F";
  static final String NOMBRE_LINUS_TORVALDS = "Linus";
  static final String APELLIDO_LINUS_TORVALDS = "Torvalds";

  static final String MARCA_FORD_FIESTA = "Ford";
  static final String MODELO_FORD_FIESTA = "Fiesta";
  static final Integer ANIO_FABRICACION_FORD_FIESTA = 2002;
  static final String MATRICULA_FORD_FIESTA = "9234BCJ";
  static final Integer NUMERO_PUERTAS_FORD_FIESTA = 3;

  static final String MARCA_KIA_NIRO = "Kia";
  static final String MODELO_KIA_NIRO = "Niro";
  static final Integer ANIO_FABRICACION_KIA_NIRO = 2022;
  static final String MATRICULA_KIA_NIRO = "8953LCC";
  static final Integer NUMERO_PUERTAS_KIA_NIRO = 5;

  static final String MARCA_SUZUKI_BURGMAN = "Suzuki";
  static final String MODELO_SUZUKI_BURGMAN = "Burgman";
  static final Integer ANIO_FABRICACION_SUZUKI_BURGMAN = 2005;
  static final String MATRICULA_SUZUKI_BURGMAN = "3956DCB";
  static final Integer CILINDRADA_SUZUKI_BURGMAN = 125;

  static final String MARCA_HONDA_CBR = "Honda";
  static final String MODELO_HONDA_CBR = "CBR";
  static final Integer ANIO_FABRICACION_HONDA_CBR = 2015;
  static final String MATRICULA_HONDA_CBR = "7920JFK";
  static final Integer CILINDRADA_HONDA_CBR = 500;

  static final String NOMBRE_EMPRESA = "Vehiculos La Cierva";
  static final String NIF_EMPRESA = "57849332A";

  static final String CSV_OUT_CLIENTES = "clientes.out.csv";
  static final String CSV_OUT_TURISMOS = "turismos.out.csv";
  static final String CSV_OUT_MOTOCICLETAS = "motocicletas.out.csv";

  static final String CSV_IN_CLIENTES = "clientes.in.csv";
  static final String CSV_IN_TURISMOS = "turismos.in.csv";
  static final String CSV_IN_MOTOCICLETAS = "motocicletas.in.csv";

  public static void main(String[] args) {
    Integer opcion = 0;
    System.out.println("### Examen Ordinario Programacion");

    // La empresa se crea de forma global, independientemente de la opción de menú
    // elegida, para que se vayan acumulando los clientes, vehiculos y alquileres
    // añadidos o leidos desde ficheros:
    EmpresaAlquilerVehiculos empresa = new EmpresaAlquilerVehiculos(NOMBRE_EMPRESA, NIF_EMPRESA);

    do {
      imprimirMenu();
      try {
        System.out.print("Introduce la opcion deseada: ");
        opcion = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
      } catch (Exception e) {
        System.out.println(OPCION_INVALIDA);
        scanner.nextLine();
        continue;
      }

      switch (opcion) {
        case 0: {
          System.out.println("===> OPCION ELEGIDA: " + OPCION_0_STRING);
          System.out.println(empresa);
          break;
        }
        case 1: {
          System.out.println("===> OPCION ELEGIDA: " + OPCION_1_STRING);

          // PISTA: Descomenta el siguiente bloque para probar si el apartado 1 te
          // funciona:

          // Vamos a crear vehículos:
          Vehiculo vehiculo = null;

          // Creamos Turismo Ford Fiesta:

          try {
            vehiculo = new Turismo(MARCA_FORD_FIESTA, MODELO_FORD_FIESTA,
                ANIO_FABRICACION_FORD_FIESTA, MATRICULA_FORD_FIESTA, NUMERO_PUERTAS_FORD_FIESTA);
            System.out.println("OK: Turismo creado: " + vehiculo);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          // Creamos Motocicleta Suzuki Burgman:
          try {
            vehiculo = new Motocicleta(MARCA_SUZUKI_BURGMAN, MODELO_SUZUKI_BURGMAN,
                ANIO_FABRICACION_SUZUKI_BURGMAN, MARCA_SUZUKI_BURGMAN, CILINDRADA_SUZUKI_BURGMAN);
            System.out.println("OK: Motocicleta creada: " + vehiculo);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          // Creamos Motocicleta Honda CBR:
          try {
            vehiculo = new Motocicleta(MARCA_HONDA_CBR, MODELO_HONDA_CBR,
                ANIO_FABRICACION_HONDA_CBR, MARCA_HONDA_CBR, CILINDRADA_HONDA_CBR);
            System.out.println("OK: Motocicleta creada: " + vehiculo);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          // Creamos Turismo Kia Niro:
          try {
            vehiculo = new Turismo(MARCA_KIA_NIRO, MODELO_KIA_NIRO, ANIO_FABRICACION_KIA_NIRO,
                MATRICULA_KIA_NIRO, NUMERO_PUERTAS_KIA_NIRO);
            System.out.println("OK: Turismo creado: " + vehiculo);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          // Vamos a crear clientes:
          Cliente cliente = null;

          // Creamos cliente Alan Turing
          try {
            cliente = new Cliente(DNI_ALAN_TURING, NOMBRE_ALAN_TURING, APELLIDO_ALAN_TURING);
            System.out.println("OK: Cliente creado: " + cliente);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }
          // Creamos cliente John Turing
          try {
            cliente = new Cliente(DNI_ABRAHAM_TURING, NOMBRE_ABRAHAM_TURING, APELLIDO_ABRAHAM_TURING);
            System.out.println("OK: Cliente creado: " + cliente);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          // Creamos cliente Linus Torvalds
          try {
            cliente = new Cliente(DNI_LINUS_TORVALDS, NOMBRE_LINUS_TORVALDS, APELLIDO_LINUS_TORVALDS);
            System.out.println("OK: Cliente creado: " + cliente);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }
          // Vamos a crear un alquiler:
          Alquiler alquiler = null;
          alquiler = new Alquiler(cliente, vehiculo, LocalDateTime.now());
          System.out.println("OK: Alquiler creado: " + alquiler);

          break;
        }

        case 2: {
          System.out.println("===> OPCION ELEGIDA: " + OPCION_2_STRING);

          // Creamos clientes y los añadimos a la empresa
          Cliente cliente = null;

          try {
            cliente = new Cliente(DNI_ALAN_TURING, NOMBRE_ALAN_TURING, APELLIDO_ALAN_TURING);
            if (empresa.addCliente(cliente)) {
              System.out.println("OK: Cliente agregado: " + cliente);
            } else {
              System.out.println("ERROR: No se pudo agregar el cliente: " + cliente);
            }
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          // Si volvemos a intentar agregar el mismo cliente debería fallar porque
          // tiene el mismo DNI:
          try {
            if (empresa.addCliente(cliente)) {
              System.out.println("OK: Cliente agregado: " + cliente);
            } else {
              System.out.println("ERROR: No se pudo agregar el cliente: " + cliente);
            }
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: " + e.getMessage());
          }

          try {
            cliente = new Cliente(DNI_ABRAHAM_TURING, NOMBRE_ABRAHAM_TURING, APELLIDO_ABRAHAM_TURING);
            if (empresa.addCliente(cliente)) {
              System.out.println("OK: Cliente agregado: " + cliente);
            } else {
              System.out.println("ERROR: No se pudo agregar el cliente: " + cliente);
            }
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          try {
            cliente = new Cliente(DNI_LINUS_TORVALDS, NOMBRE_LINUS_TORVALDS, APELLIDO_LINUS_TORVALDS);
            if (empresa.addCliente(cliente)) {
              System.out.println("OK: Cliente agregado: " + cliente);
            } else {
              System.out.println("ERROR: No se pudo agregar el cliente: " + cliente);
            }
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: " + e.getMessage());
          }

          // Creamos vehiculos y los añadimos a la empresa
          Vehiculo vehiculo = null;
          try {
            vehiculo = new Turismo(MARCA_FORD_FIESTA, MODELO_FORD_FIESTA,
                ANIO_FABRICACION_FORD_FIESTA, MATRICULA_FORD_FIESTA, NUMERO_PUERTAS_FORD_FIESTA);
            if (empresa.addVehiculo(vehiculo)) {
              System.out.println("OK: Turismo agregado: " + vehiculo);
            } else {
              System.out.println("ERROR: No se pudo agregar el turismo: " + vehiculo);
            }
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          // La segunda vez que intentamos agregar el mismo vehículo debería fallar porque
          // tienen la misma matrícula:
          try {
            if (empresa.addVehiculo(vehiculo)) {
              System.out.println("OK: Turismo agregado: " + vehiculo);
            } else {
              System.out.println("ERROR: No se pudo agregar el turismo: " + vehiculo);
            }
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: "+e.getMessage());
          }

          try {
            vehiculo = new Turismo(MARCA_KIA_NIRO, MODELO_KIA_NIRO, ANIO_FABRICACION_KIA_NIRO,
                MATRICULA_KIA_NIRO, NUMERO_PUERTAS_KIA_NIRO);
            if (empresa.addVehiculo(vehiculo)) {
              System.out.println("OK: Turismo agregado: " + vehiculo);
            } else {
              System.out.println("ERROR: No se pudo agregar el turismo: " + vehiculo);
            }
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          try {
            vehiculo = new Motocicleta(MARCA_SUZUKI_BURGMAN, MODELO_SUZUKI_BURGMAN,
                ANIO_FABRICACION_SUZUKI_BURGMAN, MATRICULA_SUZUKI_BURGMAN, CILINDRADA_SUZUKI_BURGMAN);
            if (empresa.addVehiculo(vehiculo)) {
              System.out.println("OK: Motocicleta agregada: " + vehiculo);
            } else {
              System.out.println("ERROR: No se pudo agregar la motocicleta: " + vehiculo);
            }
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          try {
            vehiculo = new Motocicleta(MARCA_HONDA_CBR, MODELO_HONDA_CBR, ANIO_FABRICACION_HONDA_CBR,
                MATRICULA_HONDA_CBR, CILINDRADA_HONDA_CBR);
            if (empresa.addVehiculo(vehiculo)) {
              System.out.println("OK: Motocicleta agregada: " + vehiculo);
            } else {
              System.out.println("ERROR: No se pudo agregar la motocicleta: " + vehiculo);
            }
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          // Creamos un par de alquileres y los añadimos a la empresa
          Alquiler alquiler = null;

          System.out.println("# Iniciando el alquiler del vehiculo con matrícula "
              + MATRICULA_FORD_FIESTA + " con fecha 23 de Mayo de 2023 a las 10h:");
          vehiculo = empresa.getVehiculo(MATRICULA_FORD_FIESTA);
          cliente = empresa.getCliente(DNI_ALAN_TURING);
          alquiler = new Alquiler(cliente, vehiculo, LocalDateTime.parse("2023-05-23T10:00:00"));
          if (empresa.addAlquiler(alquiler)) {
            System.out.println("OK: Alquiler agregado: " + alquiler);
          } else {
            System.out.println("ERROR: AGREGAR UN ELEMENTO A UNA LISTA NUNCA DEVUELVE FALSE, "
                + "ESTO NO SE DEBERIA IMPRIMIR NUNCA!!");
          }

          System.out.println("# Iniciando el alquiler del vehiculo con matrícula "
              + MATRICULA_HONDA_CBR + " con fecha 10 de Mayo de 2023 a las 13h:");
          vehiculo = empresa.getVehiculo(MATRICULA_HONDA_CBR);
          cliente = empresa.getCliente(DNI_LINUS_TORVALDS);
          alquiler = new Alquiler(cliente, vehiculo, LocalDateTime.parse("2023-05-10T13:00:00"));
          if (empresa.addAlquiler(alquiler)) {
            System.out.println("OK: Alquiler agregado: " + alquiler);
          } else {
            System.out.println("ERROR: AGREGAR UN ELEMENTO A UNA LISTA NUNCA DEVUELVE FALSE, "
                + "ESTO NO SE DEBERIA IMPRIMIR NUNCA!!");
          }

          // Imprimimos los alquileres de la empresa antes de finalizar el alquiler de la
          // CBR de Linus:
          System.out.println("\n## empresa.toStringAlquileres():\n" + empresa.toStringAlquileres());

          // Finalizamos el alquiler de la Honda CBR por Linus Torvalds
          System.out.println("# Finalizando el alquiler del vehiculo con matrícula "
              + MATRICULA_HONDA_CBR + " con fecha 20 de Mayo de 2023 a las 17h:");
          if (empresa.finalizarAlquiler(MATRICULA_HONDA_CBR, LocalDateTime.parse("2023-05-20T17:00:00"))) {
            System.out.println("OK: Alquiler vehiculo con matrícula " + MATRICULA_HONDA_CBR + " finalizado.");
          } else {
            System.out.println("ERROR: No se ha podido finalizar el alquiler de vehículo con matrícula "
                + MATRICULA_HONDA_CBR + ".");
          }

          System.out.println("# Si volvemos a intentar finalizar el alquiler del mismo vehiculo con"
              + " matrícula " + MATRICULA_HONDA_CBR + ", el método falla y devuelve false:");
          if (empresa.finalizarAlquiler(MATRICULA_HONDA_CBR, LocalDateTime.parse("2023-05-20T17:00:00"))) {
            System.out.println("OK: Alquiler finalizado con matrícula " + MATRICULA_HONDA_CBR);
          } else {
            System.out.println("ERROR: No se ha podido finalizar el alquiler de vehículo con matrícula "
                + MATRICULA_HONDA_CBR + ".");
          }

          // Imprimimos toda la información del estado final de la empresa:
          System.out.println("\n## empresa.toString():\n" + empresa);

          break;
        }

        case 3: {
          System.out.println("===> OPCION ELEGIDA: " + OPCION_3_STRING);

          // Vamos a llamar a los constructores con todos los casos que deben fallar:

          // **** OJO: Es normal que el IDE muestre un warning porque las variables
          // locales cliente
          // y vehiculo no se usen.

          // Clientes:
          Cliente cliente = null;

          try {
            cliente = new Cliente("", NOMBRE_ALAN_TURING, APELLIDO_ALAN_TURING);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          try {
            cliente = new Cliente(DNI_ALAN_TURING, "", APELLIDO_ALAN_TURING);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          try {
            cliente = new Cliente(DNI_ALAN_TURING, NOMBRE_ALAN_TURING, "");
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          // Turismos:
          Vehiculo vehiculo = null;

          try {
            vehiculo = new Turismo("", MODELO_FORD_FIESTA, ANIO_FABRICACION_FORD_FIESTA,
                MATRICULA_FORD_FIESTA, NUMERO_PUERTAS_FORD_FIESTA);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }
          try {
            vehiculo = new Turismo(MARCA_FORD_FIESTA, "", ANIO_FABRICACION_FORD_FIESTA,
                MATRICULA_FORD_FIESTA, NUMERO_PUERTAS_FORD_FIESTA);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }
          try {
            vehiculo = new Turismo(MARCA_FORD_FIESTA, MODELO_FORD_FIESTA, 1789,
                MATRICULA_FORD_FIESTA, NUMERO_PUERTAS_FORD_FIESTA);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }
          try {
            vehiculo = new Turismo(MARCA_FORD_FIESTA, MODELO_FORD_FIESTA,
                ANIO_FABRICACION_FORD_FIESTA, "", NUMERO_PUERTAS_FORD_FIESTA);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }
          try {
            vehiculo = new Turismo(MARCA_FORD_FIESTA, MODELO_FORD_FIESTA,
                ANIO_FABRICACION_FORD_FIESTA, MATRICULA_FORD_FIESTA, 0);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }
          // Motocicleta:

          try {
            vehiculo = new Motocicleta(MARCA_HONDA_CBR, MODELO_HONDA_CBR,
                ANIO_FABRICACION_HONDA_CBR, MATRICULA_HONDA_CBR, 49);
          } catch (ParametroInvalidoException e) {
            System.out.println("ERROR: ParametroInvalidoException capturada: " + e.getMessage());
          }

          break;
        }

        case 4: {
          System.out.println("===> OPCION ELEGIDA: " + OPCION_4_STRING);

          // Vamos a llamar a los métodos toStringXXX que ordenan por los criterios
          // solicitados:
          System.out.println("## empresa.toStringClientesOrdenNatural() [apellido y nombre]:\n"
              + empresa.toStringClientesOrdenNatural());
          System.out.println("## empresa.toStringClientesOrdenDni() [dni]:\n"
              + empresa.toStringClientesOrdenDni());
          System.out.println("## empresa.toStringVehiculosOrdenNatural() [anio de fabricacion descendente]:\n"
              + empresa.toStringVehiculosOrdenNatural());
          System.out.println("## empresa.toStringAlquileresOrdenNatural() [inicio alquiler]:\n"
              + empresa.toStringAlquileresOrdenNatural());

          break;
        }

        case 5: {
          System.out.println("===> OPCION ELEGIDA: " + OPCION_5_STRING);

          // Vamos a generar los ficheros csv a partir de lo que tengamos cargado en la
          // empresa. Posteriormente crearé una nueva empresa para que no tenga ningún
          // elemento en sus colecciones y cargaremos los ficheros csv.
          // Para diferenciar los ficheros que el programa escribe de los que el programa
          // lee, este código utilizará nombres de ficheros terminados en .in.csv para los
          // ficheros que vamos a leer y terminados en .out.csv para los ficheros que
          // vamos a escribir.

          // NOTA IMPORTANTE: Se debe haber ejecutado la opción 2 del menú para tener
          // clientes, turismos y motocicletas que escribir en los ficheros *.out.csv

          

          System.out.println("## ESCRIBIMOS FICHEROS *.out.csv");
          System.out.println("# empresa.toStringClientes():\n" + empresa.toStringClientes());
          System.out.println("empresa.guardarClientesCsv(" + CSV_OUT_CLIENTES + "):");
          if (empresa.guardarClientesCsv(CSV_OUT_CLIENTES)) {
            System.out.println("OK: Clientes guardados en fichero '" + CSV_OUT_CLIENTES + "'");
          } else {
            System.out.println("ERROR: Se ha producido un error guardando los Clientes "
                + "en el fichero '" + CSV_OUT_CLIENTES + "'");
          }

          System.out.println("# empresa.toStringVehiculos():\n" + empresa.toStringVehiculos());
          System.out.println("empresa.guardarTurismosCsv(" + CSV_OUT_TURISMOS + "):");
          if (empresa.guardarTurismosCsv(CSV_OUT_TURISMOS)) {
            System.out.println("OK: Turismos guardados en fichero '" + CSV_OUT_TURISMOS + "'");
          } else {
            System.out.println("ERROR: Se ha producido un error guardando los Turismos "
                + "en el fichero '" + CSV_OUT_TURISMOS + "'");
          }

          System.out.println("empresa.guardarMotocicletasCsv(" + CSV_OUT_MOTOCICLETAS + "):");
          if (empresa.guardarMotocicletasCsv(CSV_OUT_MOTOCICLETAS)) {
            System.out.println("OK: Motocicletas guardados en fichero '" + CSV_OUT_MOTOCICLETAS + "'");
          } else {
            System.out.println("ERROR: Se ha producido un error guardando las Motocicletas "
                + "en el fichero '" + CSV_OUT_MOTOCICLETAS + "'");
          }

          System.out.println();
          System.out.println("## CARGAMOS FICHEROS *.in.csv");
          System.out.println("empresa.cargarClientesCsv(" + CSV_IN_CLIENTES + "):");
          if (empresa.cargarClientesCsv(CSV_IN_CLIENTES)) {
            System.out.println("OK: Clientes cargados desde el fichero '" + CSV_IN_CLIENTES + "'");
          } else {
            System.out.println("ERROR: Se ha producido un error cargando Clientes "
                + "desde el fichero '" + CSV_IN_CLIENTES + "'");
          }
          System.out.println("# empresa.toStringClientes():\n" + empresa.toStringClientes());

          System.out.println("empresa.cargarTurismosCsv(" + CSV_IN_TURISMOS + "):");
          if (empresa.cargarTurismosCsv(CSV_IN_TURISMOS)) {
            System.out.println("OK: Turismos cargados en fichero '" + CSV_IN_TURISMOS + "'");
          } else {
            System.out.println("ERROR: Se ha producido un error cargando los Turismos "
                + "desde el fichero '" + CSV_IN_TURISMOS + "'");
          }

          System.out.println("empresa.cargarMotocicletasCsv(" + CSV_IN_MOTOCICLETAS + "):");
          if (empresa.cargarMotocicletasCsv(CSV_IN_MOTOCICLETAS)) {
            System.out.println("OK: Motocicletas cargados en fichero '" + CSV_IN_MOTOCICLETAS + "'");
          } else {
            System.out.println("ERROR: Se ha producido un error cargando los Motocicletas "
                + "desde el fichero '" + CSV_IN_MOTOCICLETAS + "'");
          }
          System.out.println("# empresa.toStringVehiculos():\n" + empresa.toStringVehiculos());

          break;
        }

        case 6: {
          System.out.println("===> OPCION ELEGIDA: " + OPCION_6_STRING);

          // TODO: Añadir aquí el código que valide el funcionamiento de las ampliaciones
          // extras implementadas

          break;
        }

        case OPCION_SALIDA: {
          System.out.println("# Has elegido salir...");
          break;
        }

        default: {
          System.out.println(OPCION_INVALIDA);
          break;
        }
      }
      if (opcion != OPCION_SALIDA) {
        System.out.print("\n================================================\n");
      }
    } while (opcion != OPCION_SALIDA);

    System.out.println("### Bye, Bye");

  }

  private static void imprimirMenu() {
    System.out.println("# Menu de opciones:");
    System.out.println(OPCION_0_STRING);
    System.out.println(OPCION_1_STRING);
    System.out.println(OPCION_2_STRING);
    System.out.println(OPCION_3_STRING);
    System.out.println(OPCION_4_STRING);
    System.out.println(OPCION_5_STRING);
    System.out.println(OPCION_6_STRING);
    System.out.println(OPCION_9_STRING);
  }
}
