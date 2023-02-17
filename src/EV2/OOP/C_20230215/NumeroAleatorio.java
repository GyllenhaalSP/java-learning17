package EV2.OOP.C_20230215;

import java.util.Random;
import java.util.Scanner;

/**.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class NumeroAleatorio {
    public static void main(String[] args) {
        Random rand = new Random();
        final int MAX_VALOR_RANDOM = 999;
        final int MIN_VALOR_RANDOM = 0;
        final int MAX_INTENTOS = 10;
        int numeroRandom = rand.nextInt(MAX_VALOR_RANDOM);
        int intentos = 10;
        System.out.println(numeroRandom);
        System.out.println("¡Adivina el número!");
        int numeroUsuario = getUserNumber(intentos);

        do{
            if (intentos == 9) {
                System.out.println("¡Última oportunidad!\n");
            }

            if (numeroUsuario < MIN_VALOR_RANDOM || numeroUsuario > MAX_VALOR_RANDOM) {
                System.out.println("El número debe estar entre 0 y 999");
                break;
            }

            if (numeroUsuario > numeroRandom) {
                System.out.println("\nEl número es menor.");
                checkUserNumber(numeroUsuario, numeroRandom, intentos);
            } else {
                System.out.println("\nEl número es mayor.");
                checkUserNumber(numeroUsuario, numeroRandom, intentos);
            }
            numeroUsuario = getUserNumber(intentos);
            intentos--;
        }while(numeroRandom != numeroUsuario && intentos < MAX_INTENTOS);

        if (numeroRandom == numeroUsuario){
            System.out.println("¡Has acertado!");
        }else{
            System.out.println("¡Has fallado!");
            System.out.println("El número era: "+numeroRandom);
        }
    }

    public static void checkUserNumber(int numeroUsuario, int numeroRandom, int intentos){
        int num = Math.abs(numeroUsuario - numeroRandom);
        if (num <= 10) {
            System.out.println("¡Casi lo tienes, ±10 números!");
        } else if (num <= 50){
            System.out.println("¡Estás cerca, ±50 números!");
        } else if (num <= 100){
            System.out.println("¡Estás lejos, ±100 números!");
        } else if (num <= 300){
            System.out.println("¡Estás muy lejos, ±300 números!");
        } else if (num <= 500){
            System.out.println("¡Estás lejísimos!, ±500 números!");
        } else {
            System.out.println("Pppfft, introduce otro número, anda.");
        }

        if (intentos >= 0 && intentos < 9) {
            System.out.println("¡Prueba otra vez! te quedan: "+intentos+"\n");
        }
    }

    public static int getUserNumber(int intentos){
        Scanner sc = new Scanner(System.in);
        if(intentos == 0){
            System.out.print("Introduce un número: ");
        }else{
            System.out.print("Introduce otro número: ");
        }
        return sc.nextInt();
    }
}
