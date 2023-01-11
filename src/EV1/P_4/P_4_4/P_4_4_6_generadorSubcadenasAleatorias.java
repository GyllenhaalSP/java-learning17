package EV1.P_4.P_4_4;

import java.util.Scanner;

public class P_4_4_6_generadorSubcadenasAleatorias {
    // Daniel Alonso Lázaro - 2022
    /*
    Escribimos una frase por teclado y queremos crear subcadenas de esa
    frase. Obtenemos números aleatorios para indicar dónde empieza la
    subcadena y donde termina.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inicio, fin;

        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine();

        do{
            inicio = (int)(Math.random()*frase.length());
            fin = (int)(Math.random()*frase.length());
        }while(fin <= inicio);

        System.out.println(frase.substring(inicio, fin));
    }
}

