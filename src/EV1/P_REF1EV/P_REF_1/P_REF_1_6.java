package EV1.P_REF1EV.P_REF_1;

import static utilities.StaticUtilities.sc;

public class P_REF_1_6 {
    // Daniel Alonso Lázaro - 2022
    /*
    Captura un número entero por teclado. Queremos que salga en pantalla un
    mensaje diciendo si el número es par.
    */
    public static void main(String[] args) {
        System.out.print("Introduce un número entero: ");
        int num = Integer.parseInt(sc.nextLine());
        if (num % 2 == 0) {
            System.out.println("El número es par");
        } else {
            System.out.println("El número no es par");
        }
    }
}
