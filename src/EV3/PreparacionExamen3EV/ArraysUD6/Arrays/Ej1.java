package EV3.PreparacionExamen3EV.ArraysUD6.Arrays;

import EV3.PreparacionExamen3EV.StaticScanner;

import java.util.Arrays;
import java.util.Scanner;

public class Ej1 {

    /*Crea un programa que pida diez números reales por teclado, los almacene en un array, y
    luego muestre todos sus valores.*/
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++){
            if (i == 0){
                System.out.print("Introduce un número: ");
            }else{
                System.out.print("Introduce el siguiente número: ");
            }
            numeros[i] = Integer.parseInt(StaticScanner.sc.nextLine());
        }
        System.out.println(Arrays.toString(numeros));
        StaticScanner.sc.close();
    }
}
