package EV2.ARRAYS_OBLIGATORIOS;

public class EJ1 {
    // Daniel Alonso Lázaro - 2023
    /*
    Define tres arrays de 20 números enteros cada uno, con nombres número, cuadrado
    y cubo. Carga el array número con valores aleatorios entre 0 y 100. En el array
    cuadrado se deben almacenar los cuadrados de los valores que hay en el array
    número. En el array cubo se deben almacenar los cubos de los valores que hay en
    número. A continuación, muestra el contenido de los tres arrays dispuesto en tres
    columnas.
    */
    public static void main(String[] args) {
        int[] numeros = new int[20];
        int[] cuadrados = new int[20];
        int[] cubos = new int[20];

        java.util.Arrays.sort(cargarArray(numeros, 1,  100));

        for (int i = 0; i < numeros.length; i++) {
            cuadrados[i] = (int)Math.pow(numeros[i], 2);
            cubos[i] = (int)Math.pow(numeros[i], 3);
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Número: %7d | Cuadrado: %7d | Cubo: %7d%n", numeros[i], cuadrados[i], cubos[i]);
        }
    }

    public static int[] cargarArray(int[] v, int min, int max){
        //Carga un array de enteros con números aleatorios entre min y max +1.
        return new java.util.Random().ints(v.length, min, max+1).toArray();
    }
}