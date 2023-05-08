package EV3.C_20230217.Buscaminas;

import java.util.Random;

/**
 * Clase que simula el campo de juego del Buscaminas.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Buscaminas {
    public static void main(String[] args) {
        Buscaminas buscaminas = new Buscaminas();
        System.out.println(buscaminas.toString(0));
        System.out.println(buscaminas.toString(1));
    }

    final int MAX_FILAS = 6;
    final int MAX_COLUMNAS = 6;
    final int MAX_MINAS = 3;
    final int MINA = 77;
    int[][] campoDeMinas = new int[MAX_FILAS][MAX_COLUMNAS];
    int[][] campoDeJuego = new int[MAX_FILAS][MAX_COLUMNAS];

    public Buscaminas(){
        boolean mina = false;

        for(int i = 0; i < MAX_FILAS; i++){
            for(int j = 0; j < MAX_COLUMNAS; j++){
                campoDeMinas[i][j] = 0;
                campoDeJuego[i][j] = 0;
            }
        }


        for (int i = 0; i < MAX_MINAS; i++) {
            Random rand = new Random();
            int fila = rand.nextInt(MAX_FILAS);
            int columna = rand.nextInt(MAX_COLUMNAS);
            if(campoDeMinas[fila][columna] == MINA){
                i--;
            }else{
                campoDeMinas[fila][columna] = MINA;
            }
        }
    }

    public void comprobarCoordenadas(int x, int y){
        if(campoDeMinas[x][y] == MINA) {
            campoDeJuego[x][y] = MINA;
            System.out.println("¡Has perdido!");
        }else{
            System.out.println("¡Has ganado!");
        }
    }

    public String toString(int opcion) {
        String resultado = "";
        if (opcion == 0) {
            for (int i = 0; i < MAX_FILAS; i++) {
                for (int j = 0; j < MAX_COLUMNAS; j++) {
                    if (campoDeMinas[i][j] == MINA) {
                        resultado += (char) campoDeMinas[i][j] + " ";
                    } else {
                        resultado += campoDeMinas[i][j] + " ";
                    }
                    if ((j + 1) % MAX_COLUMNAS == 0) {
                        resultado += "\n";
                    }
                }
            }
            return resultado;
        } else if (opcion == 1) {
            for (int i = 0; i < MAX_FILAS; i++) {
                for (int j = 0; j < MAX_COLUMNAS; j++) {
                    resultado += campoDeJuego[i][j] + " ";
                    if ((j + 1) % MAX_COLUMNAS == 0) {
                        resultado += "\n";
                    }
                }
            }
            return resultado;
        }
        return resultado;
    }
}
