package EV3.preparacionexamen3ev.arraysunidad6.arrays;

import utilities.StaticUtilities;

import java.util.Arrays;

public class Ej7 {
    /*7. Crea un programa que pida dos valores enteros P y Q, luego cree un array que contenga
    todos los valores desde P hasta Q, y lo muestre por pantalla.*/

    public static void main(String[] args) {
        System.out.print("Introduzca P: ");
        int p = Integer.parseInt(StaticUtilities.sc.nextLine());
        System.out.print("Introduzca Q: ");
        int q = Integer.parseInt(StaticUtilities.sc.nextLine());

        int[] valoresEntrePYQ = new int[q-p-1];

        for (int i = 0; i < valoresEntrePYQ.length; i++) {
            valoresEntrePYQ[i] = (q-p)+i+1;
        }

        System.out.println(Arrays.toString(valoresEntrePYQ));



    }
}
