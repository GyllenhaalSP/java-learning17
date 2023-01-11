package EV1.P_4.P_4_4;

import static ProgramasPruebas.metodos.esVocal;

public class P_4_4_3_discernidorPlus {
    // Daniel Alonso Lázaro - 2022
    /*
    Modificación del anterior para saber dentro de mayúscula y minúscula si
    es una vocal o consonante.
    */
    public static void main(String[] args) {
        System.out.print("Introduce un caracter: ");
        char caracter = new java.util.Scanner(System.in).nextLine().charAt(0);
        if (Character.isDigit(caracter)) {
            System.out.println("Es un dígito");
        }else if (Character.isUpperCase(caracter)) {
            System.out.println(caracter+" es mayúscula y "+esVocal(caracter));
        } else if (Character.isLowerCase(caracter)) {
            System.out.println(caracter+" es minúscula y "+esVocal(caracter));
        } else {
            System.out.println(caracter+" es un caracter especial.");
        }
    }
}
