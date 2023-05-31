package EV1.P_REF1EV.P_REF_1;

import static utilities.StaticUtilities.sc;

public class P_REF_1_9 {
    // Daniel Alonso Lázaro - 2022
    /*
    Modificar el ejercicio anterior para que nos diga al final de la ejecución
    cuantos números han sido pares.
    */
    public static void main(String[] args) {
        int num, cont = 0, par = 0;
        while (cont < 5) {
            System.out.print("Introduce un número: ");
            num = Integer.parseInt(sc.nextLine());
            if (num % 2 == 0) {
                par++;
            }
            cont++;
        }
        System.out.println("Has introducido " + par + (par < 2 ? " número par." : " números pares."));
    }
}
