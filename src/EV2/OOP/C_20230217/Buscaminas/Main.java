package EV2.OOP.C_20230217.Buscaminas;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException, InterruptedException {
        int fila;
        int columna;
        bienvenida();
        cuadriculaJuego cuadriculaJuego = new cuadriculaJuego(10, 10, 10);
        cuadriculaJuego.inicializarCeldas();
        long tiempoTranscurrido = System.currentTimeMillis();
        do{
            cls();
            System.out.println();
            //System.out.println(cuadriculaJuego.toString("tablero"));
            //System.out.println(cuadriculaJuego.toString("pista"));
            //System.out.println("-----------------------------------------\n");
            cuadriculaJuego.imprimirTablero();
            //System.out.println(cuadriculaJuego.getRecuentoCeldas());
            System.out.println("\n¿Qué posición quieres destapar?");
            System.out.println("Fila espacio Columna o Fila enter Columna");
            fila = Integer.parseInt(sc.next()) - 1;
            columna = Integer.parseInt(sc.next()) - 1;
            cuadriculaJuego.actualizarTablero(fila, columna);
        }while(!cuadriculaJuego.isPerdido() && !cuadriculaJuego.isGanado());
        cls();
        tiempoTranscurrido -= System.currentTimeMillis();
        System.out.println(cuadriculaJuego.isPerdido()
                ? "\t¡Has perdido!\n"
                : "\t¡HAS GANADO! ¡Enhorabuena!\n"
        );
        cuadriculaJuego.actualizarTablero(fila, columna);
        cuadriculaJuego.imprimirTablero();
        System.out.printf("%nHas tardado: %02d minutos y %02d segundos.%n",
                Math.abs(TimeUnit.MILLISECONDS.toMinutes(tiempoTranscurrido)),
                Math.abs(
                        TimeUnit.MILLISECONDS.toSeconds(tiempoTranscurrido) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(tiempoTranscurrido)
                        )
                )
        );
    }

    /**
     * Imprime el menú de bienvenida al juego.
     * @throws IOException lanza IOException
     * @throws InterruptedException lanza InterruptedException
     */
    public static void bienvenida() throws IOException, InterruptedException {
        cls();
        System.out.println("¡Bienvenido al Buscaminas!\n");
        System.out.println("¿Qué quieres hacer?");
        System.out.println("\t1. Jugar");
        System.out.println("\t2. Ayuda");
        System.out.println("\t3. Opciones");
        System.out.println("\t4. Salir");
        System.out.print("Escribe la opción que quieras: ");
        String opt = sc.nextLine().toLowerCase();
        switch (opt) {
            case "jugar", "1" -> System.out.println("\n¡Vamos a jugar!\n");
            case "ayuda", "2" -> {
                System.out.println("\nEl menú de ayuda aún no está disponible\n");
                bienvenida();
            }
            case "opciones", "3" -> {
                System.out.println("\nEl menú de opciones aún no está disponible\n");
                bienvenida();
            }
            case "salir", "4" -> System.exit(0);
            default -> {
                System.out.println("\nOpción no válida\n");
                bienvenida();
            }
        }
    }

    /**
     * Limpia la consola.
     * @throws IOException lanza IOException
     * @throws InterruptedException lanza InterruptedException
     */
    public static void cls() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
