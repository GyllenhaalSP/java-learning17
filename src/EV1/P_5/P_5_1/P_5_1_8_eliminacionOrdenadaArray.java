package EV1.P_5.P_5_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static ProgramasPruebas.Metodos.cargarArray;
import static ProgramasPruebas.Metodos.mostrarArray;

public class P_5_1_8_eliminacionOrdenadaArray {
    // Daniel Alonso Lázaro - 2022
    /*
    Realizar programa Java que permita cargar por teclado un vector numérico TB_NUM[100], posteriormente,
    introducir por teclado una posición, elimine del vector numérico el elemento que se encuentre en dicha posición
    y visualice el vector sin ese elemento.
    Nota: Eliminar un elemento de un vector supone desplazar una posición hacia la izquierda
    el resto de elementos posteriores.
    */
    public static void main(String[] args) {
            int pos;
            Scanner sc = new Scanner(System.in);
            Random rand = new Random();
            Object[] TB_NUM = new Object[100];
            cargarArray(TB_NUM, 101, "int");
            Arrays.sort(TB_NUM);
            mostrarArray("Array Ordenado: ", TB_NUM, 10);

            do{
                System.out.print("Introduce una posición: ");
                pos = sc.nextInt();
                if(pos < 0 || pos > (TB_NUM.length-1)){
                    System.out.println("Introduce un número entre 0 y 99\n");
                }
            }while(pos < 0 || pos > (TB_NUM.length-1));

            pos--;
            for(int i = 0; i < TB_NUM.length; i++) {
                if(i >= pos) TB_NUM[i] = (i == TB_NUM.length - 1 ? TB_NUM[TB_NUM.length - 1] = rand.nextInt(100) :
                        TB_NUM[i + 1]);
            }
            mostrarArray("Número Introducido: ", TB_NUM, 10);
    }
}
