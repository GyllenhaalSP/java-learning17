package EV3.PreparacionExamen3EV.ArraysUD6.Arrays;

import EV3.PreparacionExamen3EV.StaticScanner;

public class Ej2 {
    /*2. Crea un programa que pida diez números reales por teclado, los almacene en un array, y
    luego muestre la suma de todos los valores*/
    public static void main(String[] args) {
        float[] numeros = new float[10];
        float suma = 0;
        for(int i = 0; i < numeros.length; i++){
            System.out.print("Introduce un número: ");
            numeros[i] = Float.parseFloat(StaticScanner.sc.nextLine());
            suma += numeros[i];
        }
        System.out.println("La suma es: "+suma);
        StaticScanner.sc.close();
    }
}
