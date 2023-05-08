package EV3.C_20230217.Buscaminas;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal del juego Buscaminas.
 *
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {

        int[] opciones = bienvenida();
        CuadriculaJuego cuadriculaJuego;

        if (opciones == null) {
            final int opcionPorDefectoCuadricula = 10;
            final int opcionPorDefectoMinas = 8;
            cuadriculaJuego = new CuadriculaJuego(opcionPorDefectoCuadricula,
                    opcionPorDefectoCuadricula,
                    opcionPorDefectoMinas);
        } else {
            cuadriculaJuego = new CuadriculaJuego(opciones[0], opciones[1], opciones[2]);
        }

        cuadriculaJuego.inicializarCeldas();
        long tiempoTranscurrido = System.currentTimeMillis();
        start(cuadriculaJuego);
        cls();
        tiempoTranscurrido -= System.currentTimeMillis();
        System.out.println(cuadriculaJuego.isPerdido() ? "\t¡Has perdido!\n" : "\t¡HAS GANADO! ¡Enhorabuena!\n");
        cuadriculaJuego.imprimirTablero();
        System.out.printf("%nHas tardado: %02d minutos y %02d segundos.%n",
                Math.abs(TimeUnit.MILLISECONDS.toMinutes(tiempoTranscurrido)),
                Math.abs(TimeUnit.MILLISECONDS.toSeconds(tiempoTranscurrido)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(tiempoTranscurrido))));
    }

    /**
     * Imprime el menú de bienvenida al juego.
     *
     * @throws IOException          lanza IOException
     * @throws InterruptedException lanza InterruptedException
     */
    public static int[] bienvenida() throws IOException, InterruptedException {
        cls();
        System.out.println("¡Bienvenido al Buscaminas!");
        System.out.println("\n¿Qué quieres hacer?");
        System.out.println("\t1. Jugar");
        System.out.println("\t2. Ayuda");
        System.out.println("\t3. Opciones");
        System.out.println("\t4. Salir");
        System.out.print("\nElige la opción: ");
        switch (sc.nextLine().toLowerCase()) {
            case "jugar", "1" -> {
                System.out.println("\n¡Vamos a jugar!\n");
                Thread.sleep(1000);
                return null;
            }
            case "ayuda", "2" -> ayuda();

            case "opciones", "3" -> {
                boolean minasValidas = false;
                int filas;
                int columnas;
                int minas = 0;

                System.out.println("\n¿De cuántas casillas quieres el tablero?");

                System.out.print("Filas: ");
                filas = getFilaOColumna(true);
                System.out.print("Columnas: ");
                columnas = getFilaOColumna(false);

                System.out.println("\nEl número de filas se ha establecido en "
                        + filas
                        + " y el número de columnas en "
                        + columnas
                        + ".\n");

                final int MINIMO_MINAS = filas - 2;
                final int MAXIMO_MINAS = filas + 2;

                System.out.println("¿Cuántas minas quieres en el tablero?");

                do {
                    try {
                        System.out.println("El número de minas debe estar entre " + MINIMO_MINAS + " y " + MAXIMO_MINAS + ".");
                        System.out.print("Minas: ");
                        minas = Integer.parseInt(sc.nextLine());
                        if (minas >= MINIMO_MINAS && minas <= MAXIMO_MINAS) {
                            minasValidas = true;
                        } else {
                            System.out.println("El número de minas se encuentra fuera del rango permitido.\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("El valor introducido no es un número o es incorrecto.");
                    }
                } while (!minasValidas);

                System.out.println("\nEl número de minas se ha establecido en " + minas + ".\n");

                Thread.sleep(1500);

                return new int[]{filas, columnas, minas};
            }
            case "salir", "4" -> System.exit(0);
            default -> {
                System.out.println("\nLa opción elegida no existe.\n");
                bienvenida();
            }
        }
        return null;
    }

    /**
     * Método que imprime una pequeña guía sobre el juego.
     *
     * @throws IOException          lanza IOException.
     * @throws InterruptedException lanza InterruptedException.
     */
    private static void ayuda() throws IOException, InterruptedException {
        System.out.println("""
                                
                El objetivo del buscaminas es descubrir todo el área de juego.
                Para ello, se deben descubrir todas las casillas que NO contienen minas.
                """);
        limpiarLineas();
        System.out.print("""
                                
                Al introducir la coordenada de una casilla, se descubrirá su contenido.
                Si la celda está vacía, se descubrirán las casillas adyacentes.
                El número que se revela en estas celdas adyacentes indica las minas que
                hay en las ocho casillas inmediatamente adyacentes a la celda descubierta.
                                
                """);
        limpiarLineas();
        System.out.print("""
                                
                Si se descubre una casilla con una mina, se pierde automáticamente
                la partida.
                                
                """);
        limpiarLineas();
        System.out.print("""
                                
                Si se está seguro de que una casilla contiene una mina, se puede marcar
                con una bandera. Para marcar una celda con una bandera, se tiene que
                introducir su coordenada. No se puede poner una bandera en una celda
                que ya esté descubierta ni en una casilla que ya tenga una bandera.
                                
                """);
        limpiarLineas();
        System.out.print("""
                                
                Lo más sencillo es empezar por las esquinas e ir avanzando desde ahí.
                                
                ¡Buena suerte!
                                
                """);
        limpiarLineas();
        bienvenida();
    }

    /**
     * Método que imprime un mensaje, limpia la línea anterior y avanza el texto.
     */
    private static void limpiarLineas() {
        String enterParaContinuar = "Presiona Enter para continuar...";
        System.out.print(enterParaContinuar);
        sc.nextLine();
        System.out.print("\033[A \033[A");
        for (int i = 0; i < enterParaContinuar.length(); i++) {
            System.out.print("\b");
        }
    }

    /**
     * Lanza el bucle principal del juego.
     *
     * @param cuadriculaJuego - Objeto de la clase CuadriculaJuego que contiene el tablero.
     * @throws IOException          - lanza IOException.
     * @throws InterruptedException lanza InterruptedException.
     */
    private static void start(CuadriculaJuego cuadriculaJuego) throws IOException, InterruptedException {
        int[] posiciones = {0, 0, 0};
        do {
            cls();
            System.out.println();
            System.out.println(cuadriculaJuego.toString()); //Debug
            if (posiciones[2] == -1) {
                System.out.println("No puedes destapar una casilla con una bandera.\n");
            }
            cuadriculaJuego.imprimirTablero();
            posiciones = seleccionPosicionOBandera(cuadriculaJuego);
        } while (!cuadriculaJuego.isPerdido() && !cuadriculaJuego.isGanado());
        cuadriculaJuego.actualizarTablero(posiciones[0], posiciones[1]);
    }

    /**
     * Menú principal del juego para elegir la acción a realizar sobre una casilla en concreto.
     *
     * @param cuadriculaJuego Se le pasa una instancia de CuadriculaJuego para poder acceder a sus métodos.
     * @return Devuelve un array de enteros con la fila, la columna y si la casilla tiene una bandera devuelve -1.
     * @throws InterruptedException lanza InterruptedException.
     */
    private static int[] seleccionPosicionOBandera(CuadriculaJuego cuadriculaJuego) throws InterruptedException {
        int fila;
        int columna;
        System.out.println("\n¿Qué quieres hacer?");
        System.out.println("\t1. Destapar casilla");
        System.out.println("\t2. Poner bandera");
        System.out.println("\t3. Quitar bandera");
        System.out.println("\t4. Salir");
        System.out.print("\nElige la opción: ");
        String opcion = sc.nextLine().toLowerCase();
        switch (opcion) {
            case "destapar", "1" -> {
                System.out.println("\nIntroduce la fila y la columna de la casilla que quieras destapar: ");
                System.out.print("Fila: ");
                fila = getFilaOColumna(true, cuadriculaJuego);
                System.out.print("Columna: ");
                columna = getFilaOColumna(false, cuadriculaJuego);
                if (cuadriculaJuego.getCeldas()[fila][columna].isBandera()) {
                    return new int[]{fila, columna, -1};
                } else {
                    cuadriculaJuego.actualizarTablero(fila, columna);
                }
                return new int[]{fila, columna, 0};
            }
            case "ponerbandera", "2" -> {
                System.out.println("\nIntroduce la fila y la columna de la casilla "
                        + "en la que quieras poner una bandera: ");
                System.out.print("Fila: ");
                fila = getFilaOColumna(true, cuadriculaJuego);
                System.out.print("Columna: ");
                columna = getFilaOColumna(false, cuadriculaJuego);
                cuadriculaJuego.actualizarTablero(fila, columna, Integer.parseInt(opcion));
                return new int[]{fila, columna, 0};
            }
            case "quitarbandera", "3" -> {
                System.out.println("\nIntroduce la fila y la columna de la casilla "
                        + "de la que quieras quitar una bandera: ");
                System.out.print("Fila: ");
                fila = getFilaOColumna(true, cuadriculaJuego);
                System.out.print("Columna: ");
                columna = getFilaOColumna(false, cuadriculaJuego);
                cuadriculaJuego.actualizarTablero(fila, columna, Integer.parseInt(opcion));
                return new int[]{fila, columna, 0};
            }
            case "salir", "4" -> System.exit(0);
            default -> {
                System.out.println("\nOpción no válida\n");
                seleccionPosicionOBandera(cuadriculaJuego);
            }
        }
        return new int[]{0, 0, 0};
    }

    /**
     * Pide al usuario el número de filas y de columnas que tendrá el tablero.
     *
     * @return Devuelve el número de la fila o de la columna que ha introducido el usuario.
     */
    private static int getFilaOColumna(boolean esFilaOColumna) {
        final int MINIMO_FILAS_COLUMNAS = 5;
        final int MAXIMO_FILAS_COLUMNAS = 15;
        boolean valorValido = false;
        int filaOColumna = 0;

        do {
            try {
                filaOColumna = Integer.parseInt(sc.nextLine());
                if (filaOColumna >= MINIMO_FILAS_COLUMNAS && filaOColumna <= MAXIMO_FILAS_COLUMNAS) {
                    valorValido = true;
                } else {
                    System.out.println("El número de filas o columnas debe estar entre 5 y 15.");
                    System.out.print((esFilaOColumna
                            ? "Introduce el número de filas: "
                            : "Introduce el número de columnas: "));
                }
            } catch (NumberFormatException e) {
                System.out.println("El valor introducido no es un número o es incorrecto.");
                System.out.println("Introduce un número entre 5 y 15.");
                System.out.print((esFilaOColumna
                        ? "Introduce el número de filas: "
                        : "Introduce el número de columnas: "));
            }
        } while (!valorValido);
        return filaOColumna;
    }

    /**
     * Método sobrecargado que pide al usuario la fila o la columna para abrir una casilla,
     * poner una bandera o quitarla.
     *
     * @return Devuelve el número de la fila o la columna que ha introducido el usuario.
     */
    private static int getFilaOColumna(boolean esFilaOColumna, CuadriculaJuego cuadriculaJuego) {
        final int MINIMO_FILAS_COLUMNAS = 0;
        final int MAXIMO_FILAS_COLUMNAS = cuadriculaJuego.getCeldas().length;
        boolean valorValido = false;
        int filaOColumna = 0;

        do {
            try {
                filaOColumna = Integer.parseInt(sc.nextLine()) - 1;
                if (filaOColumna >= MINIMO_FILAS_COLUMNAS && filaOColumna < MAXIMO_FILAS_COLUMNAS) {
                    valorValido = true;
                } else {
                    System.out.println("El número de filas o columnas debe estar entre 1 y "
                            + MAXIMO_FILAS_COLUMNAS
                            + ".");
                    System.out.print((esFilaOColumna ? "Fila: " : "Columna: "));
                }
            } catch (NumberFormatException e) {
                System.out.println("\nEl valor introducido no es un número o es incorrecto.");
                System.out.println("Introduce un número entre 1 y " + MAXIMO_FILAS_COLUMNAS + ".\n");
                System.out.print((esFilaOColumna ? "Fila: " : "Columna: "));
            }

        } while (!valorValido);

        return filaOColumna;
    }

    /**
     * Limpia el texto de la consola.
     *
     * @throws IOException          lanza IOException.
     * @throws InterruptedException lanza InterruptedException.
     */
    private static void cls() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}