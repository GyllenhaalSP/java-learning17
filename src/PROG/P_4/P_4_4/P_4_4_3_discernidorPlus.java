package PROG.P_4.P_4_4;

import java.text.Normalizer;

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

    public static String esVocal(char caracter) {
        String str = normalizador(String.valueOf(caracter));
        return (str.equals("a") ||
                str.equals("e") ||
                str.equals("i") ||
                str.equals("o") ||
                str.equals("u")) ? "es vocal." : "es consonante.";
    }

    public static String normalizador(String str){
        if(str == null || str.trim().isEmpty()) return "";
        String norm = Normalizer.normalize(str.trim(), Normalizer.Form.NFKD);
        return norm.replaceAll("[\\u0300-\\u0302|\\u0304-\\u036F.,;:?!¿¡' ]", "").toLowerCase();
    }
}
