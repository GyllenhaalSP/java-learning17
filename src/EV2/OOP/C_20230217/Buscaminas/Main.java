package EV2.OOP.C_20230217.Buscaminas;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal del juego.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcionPorDefectoCuadricula = 10;
        int opcionPorDefectoMinas = 5;
        int[] opciones = bienvenida();
        CuadriculaJuego cuadriculaJuego;
        if (opciones == null) {
            cuadriculaJuego = new CuadriculaJuego(opcionPorDefectoCuadricula,
                    opcionPorDefectoCuadricula, opcionPorDefectoMinas);
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
     * @throws IOException lanza IOException
     * @throws InterruptedException lanza InterruptedException
     */
    public static int[] bienvenida() throws IOException, InterruptedException {
        cls();
        System.out.println("¡Bienvenido al Buscaminas!\n");
        System.out.println("¿Qué quieres hacer?");
        System.out.println("\t1. Jugar");
        System.out.println("\t2. Ayuda");
        System.out.println("\t3. Opciones");
        System.out.println("\t4. Salir");
        System.out.print("Escribe la opción que quieras: ");
        switch (sc.nextLine().toLowerCase()) {
            case "jugar", "1" -> {
                System.out.println("\n¡Vamos a jugar!\n");
                Thread.sleep(1000);
                return null;
            }
            case "ayuda", "2" -> {
                System.out.println("\nEl menú de ayuda aún no está disponible\n");
                bienvenida();
            }
            case "opciones", "3" -> {
                System.out.println("¿De cuántas casillas quieres el tablero?");
                System.out.print("Filas: ");
                int filas = Integer.parseInt(sc.nextLine());
                System.out.print("Columnas: ");
                int columnas = Integer.parseInt(sc.nextLine());
                System.out.println("¿Cuántas minas quieres en el tablero?");
                System.out.print("Minas: ");
                int minas = Integer.parseInt(sc.nextLine());

                return new int[]{filas, columnas, minas};
            }
            case "salir", "4" -> System.exit(0);
            default -> {
                System.out.println("\nOpción no válida\n");
                bienvenida();
            }
        }
        return null;
    }

    /**
     * Lanza el bucle principal del juego.
     * @param cuadriculaJuego - Objeto de la clase CuadriculaJuego que contiene el tablero.
     * @throws IOException - lanza IOException.
     * @throws InterruptedException - lanza InterruptedException.
     */
    public static void start(CuadriculaJuego cuadriculaJuego) throws IOException, InterruptedException {
        int[] posiciones = {0, 0, 0};
        do{
            cls();
            System.out.println();
            System.out.println(cuadriculaJuego.toString()); //Debug
            if(posiciones[2] == -1){
                System.out.println("No puedes destapar una casilla con una bandera.\n");
            }
            cuadriculaJuego.imprimirTablero();
            posiciones = seleccionPosicionOBandera(cuadriculaJuego);
        }while(!cuadriculaJuego.isPerdido() && !cuadriculaJuego.isGanado());
        cuadriculaJuego.actualizarTablero(posiciones[0], posiciones[1]);
    }

    /**
     * Menú principal del juego para elegir la acción a realizar sobre una casilla en concreto.
     * @param cuadriculaJuego Se le pasa una instancia de CuadriculaJuego para poder acceder a sus métodos.
     * @return Devuelve un array de enteros con la fila, la columna y si la casilla tiene una bandera devuelve -1.
     * @throws InterruptedException - lanza InterruptedException.
     */
    public static int[] seleccionPosicionOBandera(CuadriculaJuego cuadriculaJuego) throws InterruptedException {
        int fila;
        int columna;
        System.out.println("¿Qué quieres hacer?");
        System.out.println("\t1. Destapar casilla");
        System.out.println("\t2. Poner bandera");
        System.out.println("\t3. Quitar bandera");
        System.out.println("\t4. Salir");
        System.out.print("Escribe la opción que quieras: ");
        String opcion = sc.nextLine().toLowerCase();
        switch (opcion) {
            case "destapar", "1" -> {
                System.out.println("Introduce la fila y la columna de la casilla que quieras destapar: ");
                fila = getFila();
                columna = getColumna();
                if (cuadriculaJuego.getCeldas()[fila][columna].isBandera()){
                    return new int[]{fila, columna, -1};
                }else{
                    cuadriculaJuego.actualizarTablero(fila, columna);
                }
                return new int[]{fila, columna, 0};
            }
            case "ponerbandera", "2" -> {
                System.out.println("Introduce la fila y la columna de la casilla " +
                        "en la que quieras poner una bandera: ");
                fila = getFila();
                columna = getColumna();
                cuadriculaJuego.actualizarTablero(fila, columna, Integer.parseInt(opcion));
                return new int[]{fila, columna, 0};
            }
            case "quitarbandera", "3" -> {
                System.out.println("Introduce la fila y la columna de la casilla " +
                        "de la que quieras quitar una bandera: ");
                fila = getFila();
                columna = getColumna();
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
     * Pide al usuario la fila de la casilla que quiere destapar.
     * @return Devuelve el número de la fila que ha introducido el usuario.
     */
    public static int getFila(){
        int fila = Integer.parseInt(sc.next()) - 1;
        sc.nextLine();
        return fila;
    }

    /**
     * Pide al usuario la columna de la casilla que quiere destapar.
     * @return Devuelve el número de la columna que ha introducido el usuario.
     */
    public static int getColumna(){
        int columna = Integer.parseInt(sc.next()) - 1;
        sc.nextLine();
        return columna;
    }

    /**
     * Limpia el texto de la consola.
     * @throws IOException lanza IOException.
     * @throws InterruptedException lanza InterruptedException.
     */
    public static void cls() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}