package EV2.OOP.EjDivEntYMod;

import java.util.Random;
import static ProgramasPruebas.Metodos.mostrarArray;

public class EjDivEntYMod2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[][] matriz = new int[4][7];

        for (int i = 0; i < 4*7; i++) {
            matriz[i%4][i/4] = rand.nextInt(100);
        }

        mostrarArray("El array es: ", matriz, 7);

        int[][] transMatriz = new int[7][4];

        for (int i = 0; i < 4*7; i++){
            transMatriz[i/4][i%4] = matriz[i%4][i/4];
        }

        mostrarArray("El array traspuesto es: ", transMatriz, 4);



    }
}
