package PROG.P_5.P_5_1;

public class P_5_1_3_posicionParesArray {
    // Daniel Alonso Lázaro - 2022
    /*
    Realizar un programa Java que inicialice un array numérico de 10 elementos y visualizar los
    elementos que sean par y la posición en que se encuentra.
    */
    public static void main(String[] args) {
        int[] array = new int[10];
        ProgramasPruebas.metodos.cargarArray(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) System.out.println("El index "+i+" contiene: "+array[i]+" que es par.");
        }
    }
}
