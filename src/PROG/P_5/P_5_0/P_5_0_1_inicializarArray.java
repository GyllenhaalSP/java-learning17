package PROG.P_5.P_5_0;

public class P_5_0_1_inicializarArray {
    // Daniel Alonso Lázaro - 2022
    /*
    Crear la matriz ArrayEjemplo de 10 elementos de tipo entero e inicializar sus elementos con el
    valor de cada índice.
    */
    public static void main(String[] args) {
        int[] ArrayEjemplo = new int[10];
        ArrayEjemplo[0] = 1;
        ArrayEjemplo[1] = 2;
        ArrayEjemplo[2] = 3;
        ArrayEjemplo[3] = 4;
        ArrayEjemplo[4] = 5;
        ArrayEjemplo[5] = 6;
        ArrayEjemplo[6] = 7;
        ArrayEjemplo[7] = 8;
        ArrayEjemplo[8] = 9;
        ArrayEjemplo[9] = 10;

        for (int i = 0; i < ArrayEjemplo.length; i++) {
            System.out.println("ArrayEjemplo contiene el número "+ArrayEjemplo[i]+" en la posición "+i);
        }
    }
}
