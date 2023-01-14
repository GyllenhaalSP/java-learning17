package EV1.P_5.P_5_1;

import ProgramasPruebas.Metodos;

import java.util.Scanner;

public class P_5_1_10_comprobacionCapicua {
    // Daniel Alonso Lázaro - 2022
    /*
    Realizar un programa Java que pida un número entero positivo de 10 cifras, y que compruebe si el número es capicúa.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numArray = new int[10];
        int[] numArrayInvertido = new int[10];
        String num;

        do{
            System.out.print("Introduce un número entero positivo de 10 cifras: ");
            num = sc.nextLine();
            if(num.length() != 10)
                System.out.println("El número introducido tiene "+num.length()+" cifras, y debe tener 10.");
            if(Long.parseLong(num) < 0) System.out.print("El número introducido es negativo. " +
                    "Introduzca un número positivo.");
        }while(num.length() != 10 || Long.parseLong(num) < 0);

        for(int i = 0, j = num.length()-1; i < num.length(); i++, j--) {
            numArray[i] = Integer.parseInt(num.substring(i, i + 1));
            numArrayInvertido[j] = numArray[i];
        }

        if(Metodos.capicua(numArray, numArrayInvertido)) System.out.println("El número es capicúa.");
        else System.out.println("El número no es capicúa.");
    }
}
