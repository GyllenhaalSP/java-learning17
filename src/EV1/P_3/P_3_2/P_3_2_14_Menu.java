package EV1.P_3.P_3_2;

import java.util.Scanner;

public class P_3_2_14_Menu {
    //Realizar un ejemplo de menú, donde podemos escoger las distintas opciones hasta que
    //seleccionamos la opción de “Salir”.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInput;

        do {
            System.out.println("Bienvenido al menú de gestión de alumnos.");
            System.out.print("\t1.- Altas Alumnos\n\t2.- Bajas Alumnos\n\t3.- Informes\n\t4.- SALIR\nELIGE LA OPCIÓN ");
            userInput = sc.nextInt();
            switch (userInput) {
                case 1 -> System.out.println("\nALTAS ALUMNOS\n");
                case 2 -> System.out.println("\nBAJAS ALUMNOS\n");
                case 3 -> System.out.println("\nINFORMES\n");
                case 4 -> System.out.println("Adiós.");
                default -> System.out.println("La opción escogida es incorrecta.");
            }
        }while(userInput != 4);
    }
}
