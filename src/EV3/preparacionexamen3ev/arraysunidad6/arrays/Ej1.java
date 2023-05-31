package EV3.preparacionexamen3ev.arraysunidad6.arrays;

import java.util.Arrays;

import static utilities.StaticUtilities.sc;

public class Ej1 {

    /*Crea un programa que pida diez números reales por teclado, los almacene en un array, y
    luego muestre todos sus valores.*/
    public static void main(String[] args) {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++){
            if (i == 0){
                System.out.print("Introduce un número: ");
            }else{
                System.out.print("Introduce el siguiente número: ");
            }
            numeros[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println(Arrays.toString(numeros));
        sc.close();
    }
}
