package EV1.P_5.P_5_1;

import utilities.Metodos;

import java.util.Arrays;

import static utilities.StaticUtilities.sc;

public class P_5_1_7_insercionOrdenadaArray {
    // Daniel Alonso Lázaro - 2022
    /*
    Realizar un programa Java que permita cargar por teclado un vector numérico TB_NUM[100],
    posteriormente, introducir un valor desde teclado e intercalarlo en su posición correcta dentro
    del vector numérico supuestamente ordenado, y se visualice finalmente el vector con el dato
    intercalado. El valor antiguo que estaba en la posición en la que se inserta se pierde.
    */
    public static void main(String[] args) {
        int num;
        Object[] TB_NUM = new Object[100];
        Metodos.cargarArray(TB_NUM, 101, "int");
        Metodos.mostrarArray("Array cargado: ", TB_NUM, 10);
        Arrays.sort(TB_NUM);
        Metodos.mostrarArray("Array Ordenado: ", TB_NUM, 10);

        do {
            System.out.print("Introduce un número: ");
            num = sc.nextInt();
            if ((int) TB_NUM[0] > num && num > (int) TB_NUM[TB_NUM.length - 1]) {
                System.out.print("Introduce un número entre 1 y 99:  ");
            }
        } while ((int) TB_NUM[0] > num && num > (int) TB_NUM[TB_NUM.length - 1]);

        for (int i = 0, j = 0; i < TB_NUM.length; i++) {
            if ((int) TB_NUM[i] > num && j == 0) {
                TB_NUM[i] = num;
                j++;
            }
        }
        Metodos.mostrarArray("Número Introducido: ", TB_NUM, 10);
    }
}
