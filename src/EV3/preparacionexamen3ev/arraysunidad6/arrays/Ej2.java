package EV3.preparacionexamen3ev.arraysunidad6.arrays;

import utilities.StaticUtilities;

public class Ej2 {
    /*2. Crea un programa que pida diez números reales por teclado, los almacene en un array, y
    luego muestre la suma de todos los valores*/
    public static void main(String[] args) {
        float[] numeros = new float[10];
        float suma = 0;
        for(int i = 0; i < numeros.length; i++){
            System.out.print("Introduce un número: ");
            numeros[i] = Float.parseFloat(StaticUtilities.sc.nextLine());
            suma += numeros[i];
        }
        System.out.println("La suma es: "+suma);
        StaticUtilities.sc.close();
    }
}
