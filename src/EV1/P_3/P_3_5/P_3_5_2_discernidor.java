package EV1.P_3.P_3_5;

import java.util.Scanner;

public class P_3_5_2_discernidor {
//    Capturamos un carácter y debemos indicar si está en mayúscula, en
//    minúscula, es un dígito o cualquier otro carácter.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce cualquier cosa: ");
        char ch = sc.next().charAt(0);
        if (Character.isDigit(ch)) {
            System.out.println(ch + " es un dígito.");
        } else if (Character.isLetter(ch) & !Character.isDigit(ch)) {
            System.out.println(ch + " es una letra.");
            if (Character.isUpperCase(ch)) {
                System.out.println(ch + " está en mayúsculas.");
            } else {
                System.out.println(ch + " está en minúsculas.");
            }
        }else {
            System.out.println(ch + " es otro tipo de carácter.");
        }
    }
}
