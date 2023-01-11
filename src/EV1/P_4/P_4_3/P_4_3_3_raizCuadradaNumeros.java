package EV1.P_4.P_4_3;

import java.util.Scanner;

public class P_4_3_3_raizCuadradaNumeros {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos números por teclado y deseamos calcular la raíz cuadrada de cada uno de esos números.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        double num;

        do{
            System.out.print("Introduce un número: ");
            num = sc.nextDouble();
            sc.nextLine();

            System.out.println("La raíz cuadrada de "+(num % 1 == 0.0 ? (int)num : String.format("%.3f", num))+" es "
                    +(Math.sqrt(num) % 1 == 0.0 ? (int)Math.sqrt(num) : String.format("%.16f", Math.sqrt(num)))+".");

            System.out.print("¿Quieres continuar? (S/N) ");
            respuesta = sc.nextLine().toUpperCase();
        }while(respuesta.equals("S"));
    }
}
