package EV1.P_REF1EV.P_REF_1;

import static utilities.StaticUtilities.sc;

public class P_REF_1_8 {
    // Daniel Alonso Lázaro - 2022
    /*
    Modificamos el primer ejercicio. Queremos introducir 5 números pero
    empleando una estructura repetitiva mientras.
    */
    public static void main(String[] args) {
        int num, cont = 0;
        while (cont < 5) {
            System.out.print("Introduce un número: ");
            num = Integer.parseInt(sc.nextLine());
            if (num % 2 == 0) {
                System.out.println("El número es par\n");
            } else {
                System.out.println("El número es impar\n");
            }
            cont++;
        }
    }
}
