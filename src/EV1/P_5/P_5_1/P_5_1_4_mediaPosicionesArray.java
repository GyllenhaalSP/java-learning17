package EV1.P_5.P_5_1;

import javax.swing.*;

public class P_5_1_4_mediaPosicionesArray {
    // Daniel Alonso Lázaro - 2022
    /*
    Realizar programa Java que permita cargar un vector numérico de 10 elementos desde teclado
    y, posteriormente visualice la media de los elementos que se encuentran en las posiciones
    pares (0,2,4,...) y la media de los elementos que se encuentran en las posiciones impares
    (1,3,5,...) del vector. La tabla solo debe ser recorrida una vez.
    */
    public static void main(String[] args) {
        int[] nums = new int[10];
        double mediaPares = 0, mediaImpares = 0;
        int contPares = 0, contImpares = 0;

        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "Introduce un número: "));
            if(i % 2 == 0){
                mediaPares += nums[i];
                contPares++;
            } else {
                mediaImpares += nums[i];
                contImpares++;
            }
        }
        System.out.printf("La media de los números en posición par es: %02.2f y la media de los números en posición " +
                "impar es: %02.2f", mediaPares/contPares, mediaImpares/contImpares);
    }
}
