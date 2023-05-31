package EV1.P_REF1EV.P_REF_1;

import static utilities.StaticUtilities.sc;

public class P_REF_1_7 {
    // Daniel Alonso Lázaro - 2022
    /*
    Modificar el ejercicio anterior, pero ahora nos debe indicar si el número es par o impar.
    */
    public static void main(String[] args) {
        System.out.print("Introduce un número entero: ");
        int num = Integer.parseInt(sc.nextLine());
        if (num % 2 == 0) {
            System.out.println("El número es par");
        } else {
            System.out.println("El número es impar");
        }
    }
}
