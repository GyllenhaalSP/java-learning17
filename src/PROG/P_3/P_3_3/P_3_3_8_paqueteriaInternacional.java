package PROG.P_3.P_3_3;

import java.util.Scanner;

public class P_3_3_8_paqueteriaInternacional {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double userWeight, price, userInput = -1;
        System.out.print("Introduce el número de Kg: ");
        userWeight = sc.nextDouble();
        sc.nextLine();

        do {
            while(userWeight > 5d) {
                System.out.println("\nEl paquete no será transportado ya que pesa más de 5Kg. ");
                System.out.print("Introduce un número de Kg menor: ");
                userWeight = sc.nextDouble();
                sc.nextLine();
            }
            while (userWeight <= 0d) {
                System.out.println("\nEl número de Kg no puede ser negativo o cero. ");
                System.out.print("Introduce el número de Kg: ");
                userWeight = sc.nextDouble();
                sc.nextLine();
            }
            if (userWeight > 0d & userWeight < 6d) {
                System.out.println("\n1 para América del Norte.");
                System.out.println("2 para América Central.");
                System.out.println("3 para América del Sur.");
                System.out.println("4 para Europa.");
                System.out.println("5 para Asia.");
                System.out.print("Introduce la zona de destino: ");
                userInput = sc.nextDouble();
                sc.nextLine();
            }
        }while(!(userInput > 0d & userInput < 6d) | (userWeight < 1d | userWeight > 5d));

        switch ((int)userInput) {
            case 1 -> {
                price = userWeight * 24;
                System.out.println("\nEl precio por enviar el paquete a América del Norte es de "+(price%1==0.0 ? (int)price : String.format("%.2f", price))+" €");
            }
            case 2 -> {
                price = userWeight * 20;
                System.out.println("\nEl precio por enviar el paquete a América Central es de "+(price%1==0.0 ? (int)price : String.format("%.2f", price))+" €");
            }
            case 3 -> {
                price = userWeight * 21;
                System.out.println("\nEl precio por enviar el paquete a América del Sur es de "+(price%1==0.0 ? (int)price : String.format("%.2f", price))+" €");
            }
            case 4 -> {
                price = userWeight * 10;
                System.out.println("\nEl precio por enviar el paquete a Europa es de "+(price%1==0.0 ? (int)price : String.format("%.2f", price))+" €");
            }
            case 5 -> {
                price = userWeight * 18;
                System.out.println("\nEl precio por enviar el paquete a Asia es de "+(price%1==0.0 ? (int)price : String.format("%.2f", price))+" €");
            }
        }
    }
}
