package EV3.C_20230215;

import static utilities.Metodos.mostrarArray;
import static utilities.StaticUtilities.rand;

/**.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class EjDivEntYMod2 {
    public static void main(String[] args) {
        final int FILAS = 4;
        final int COLUMNAS = 7;
        final int MAX_VALOR_RANDOM = 100;
        int[][] matriz = new int[FILAS][COLUMNAS];

        for (int i = 0; i < FILAS*COLUMNAS; i++) {
            matriz[i%FILAS][i/FILAS] = rand.nextInt(MAX_VALOR_RANDOM);
        }

        mostrarArray("El array es: ", matriz, COLUMNAS);

        int[][] transMatriz = new int[COLUMNAS][FILAS];

        for (int i = 0; i < FILAS*COLUMNAS; i++){
            transMatriz[i/FILAS][i%FILAS] = matriz[i%FILAS][i/FILAS];
        }

        mostrarArray("El array traspuesto es: ", transMatriz, FILAS);
    }
}
