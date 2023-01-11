package EV1.P_4.P_4_3;

import java.util.Scanner;

public class P_4_3_1_conversorPositivos {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos números enteros por teclado. Si el usuario teclea un número negativo lo convertimos en positivo.
    Deseamos sabeR cuántos números han sido introducidos y cuántos de ellos han tenido que ser convertidos a positivos.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        int num, cantNum = 0, cantNeg = 0;
        do{
            System.out.print("Introduce un número: ");
            num = sc.nextInt();
            sc.nextLine();

            if (num < 0){
                num = Math.abs(num);
                cantNum++;
                cantNeg++;
                System.out.println("El número es "+num+" y era negativo.");
            } else if (num > 0){
                cantNum++;
                System.out.println("El número es "+num+" y es positivo.");
            } else {
                cantNum++;
                System.out.println("El número es 0.");
            }

            System.out.print("¿Quieres continuar? (S/N) ");
            respuesta = sc.nextLine().toUpperCase();
        }while(respuesta.equals("S"));
        System.out.println("Has introducido "+cantNum+" números, de los cuales "+cantNeg+
                (cantNeg == 1 ? " era negativo." : " eran negativos."));
    }
}
