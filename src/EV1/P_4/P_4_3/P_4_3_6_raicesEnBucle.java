package EV1.P_4.P_4_3;

import java.util.Scanner;

public class P_4_3_6_raicesEnBucle {
    // Daniel Alonso Lázaro - 2022
    /*
    Deseamos capturar valores por teclado que se corresponde a un
    número y un radical. Calcular la raíz correspondiente.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        double num, radical;
        do{
            System.out.print("Introduce un número: ");
            num = sc.nextDouble();
            System.out.print("Introduce un radical: ");
            radical = sc.nextDouble();
            sc.nextLine();
            System.out.println("La raíz "+radical+" de "+num+" es "+Math.pow(num, 1/radical));
            System.out.print("¿Quieres continuar? (S/N) ");
            respuesta = sc.nextLine().toUpperCase();
        }while(respuesta.equals("S"));
    }
}
