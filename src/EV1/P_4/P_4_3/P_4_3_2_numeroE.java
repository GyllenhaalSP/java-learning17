package EV1.P_4.P_4_3;

import java.util.Scanner;

public class P_4_3_2_numeroE {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos un número por teclado y queremos saber el valor de E elevado a ese número. (E^número)
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        double exp, num ;
        do{
            System.out.print("Introduce un número: ");
            exp = sc.nextDouble();
            sc.nextLine();
            num = Math.pow(Math.E, exp);

            String expShow = exp % 1 == 0 ? String.valueOf((int)exp) : String.valueOf(exp);

            System.out.println("El número E = "+Math.E+" elevado a "+expShow+" es "+num);

            System.out.print("\n¿Quieres continuar? (S/N) ");
            respuesta = sc.nextLine().toUpperCase();
        }while(respuesta.equals("S"));
    }
}