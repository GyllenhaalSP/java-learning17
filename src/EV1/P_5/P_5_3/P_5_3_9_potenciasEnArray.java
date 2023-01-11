package EV1.P_5.P_5_3;

import java.util.Scanner;

public class P_5_3_9_potenciasEnArray {
    //Daniel Alonso Lázaro - 2023
    /*
    Crear una tabla de dos dimensiones, cuyo contenido serán las potencias de 2. La
    primera columna de la tabla nos indicará el exponente (positivo o negativo) y la
    segunda columna su valor.
    El tamaño de la tabla será 20x2.
    Se pedirá que el usuario introduzca los valores de las potencias que quiere visualizar
    hasta que al introducir la potencia se introduzca un -1000.
    */
    public static void main(String[] args) {
        int[][] potencias = new int[2][20];
        int userChoice;
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < potencias.length; i++){
            for(int j = 0; j < potencias[i].length; j++){
                if(i == 0) potencias[i][j] = j;
                if(i == 1) potencias[i][j] = (int) Math.pow(2, j);
            }
        }

        do{
            System.out.print("Introduce la potencia que quieres visualizar (0-19) o -1000 para salir: ");
            userChoice = sc.nextInt();
            for(int i = 0; i < 1; i++)
                for (int j = 0; j < potencias[i].length; j++)
                    if(userChoice == potencias[i][j])
                        System.out.println("2^" + userChoice + " = " + potencias[i + 1][j]);
        }while(userChoice != -1000);
    }
}
