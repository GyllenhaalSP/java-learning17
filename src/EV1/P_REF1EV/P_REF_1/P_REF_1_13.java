package EV1.P_REF1EV.P_REF_1;

import java.io.IOException;

public class P_REF_1_13 {
    // Daniel Alonso Lázaro - 2022
    /*
    Cuando por fin adivine el número deberemos indicar el número de intentos
    realizados.
    */
    public static void main(String[] args) throws IOException, InterruptedException {
        int num1, num2, cont = 0;
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Introduce un número de 3 cifras: ");
        num1 = Integer.parseInt(sc.nextLine());
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        do {
            System.out.print("Introduce un número de 3 cifras: ");
            num2 = Integer.parseInt(sc.nextLine());
            if (num1 > num2) {
                System.out.println("El número introducido es menor\n");
            } else if (num1 < num2) {
                System.out.println("El número introducido es mayor\n");
            }
            cont++;
        } while (num1 != num2);
        System.out.println("\n¡Has acertado el número!\nHas necesitado " + cont + " intentos.");
    }
}
