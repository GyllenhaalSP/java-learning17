package EV3.PreparacionExamen3EV.ArraysUD6.Arrays;

import EV3.PreparacionExamen3EV.StaticScanner;

public class Ej3 {
    /*
        3. Crea un programa que pida diez números reales por teclado, los almacene en un array, y
        luego lo recorra para averiguar el máximo y mínimo y mostrarlos por pantalla.
    */

    public static void main(String[] args) {
        float[] numeros = new float[10];
        for(int i = 0; i< numeros.length; i++){
            System.out.println("Introduce un número: ");
            numeros[i] = Float.parseFloat(StaticScanner.sc.nextLine());
        }

        float max = numeros[0];
        float min = numeros[0];


        for(int i = 0; i < numeros.length; i++){
            if (numeros[i] == max || numeros[i] == min){
                continue;
            }
            if (numeros[i] > max){
                max = numeros[i];
            }else if(numeros[i] < min){
                min = numeros[i];
            }
        }
        System.out.println("El max es "+max+" y el min es "+min);

        StaticScanner.sc.close();
    }
}
