package EV1.P_4.P_4_3;

import java.util.Scanner;
import java.util.Locale;

public class P_4_3_7_redondeo {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos números reales por teclado y queremos redondear al entero más próximo.
    */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String respuesta;
        double num;

        do{
            System.out.print("Introduce un número: ");
            num = sc.nextDouble();
            sc.nextLine();
            System.out.println("El entero más próximo es "+
                    (num % 1 <= 0.5 ? (int)Math.floor(num) : (int)Math.ceil(num)));
            System.out.print("¿Quieres continuar? (S/N) ");
            respuesta = sc.nextLine().toUpperCase();
        }while(respuesta.equals("S"));
    }
}
