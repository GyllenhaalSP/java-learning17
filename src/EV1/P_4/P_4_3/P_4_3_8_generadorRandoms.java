package EV1.P_4.P_4_3;

import java.util.Scanner;

public class P_4_3_8_generadorRandoms {
    // Daniel Alonso Lázaro - 2022
    /*
    Genera 10 números aleatorios comprendidos entre 0 y 999.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        double random;
        do{
            for(int i = 0; i < 10; i++){
                random = Math.random()*1000;
                System.out.println("Número aleatorio: "+(int)random);
//                if((int)random == 0){
//                    System.out.println("El número es 0");
//                }else if((int)random == 1000){
//                    System.out.println("El número es 1000");
//                }else if((int)random == 999) {
//                    System.out.println("El número es 999");
//                }
            }
            System.out.print("¿Quieres continuar? (S/N) ");
            respuesta = sc.nextLine().toUpperCase();
        }while(respuesta.equals("S"));
    }
}
