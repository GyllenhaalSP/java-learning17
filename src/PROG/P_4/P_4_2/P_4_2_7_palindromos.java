package PROG.P_4.P_4_2;

import java.text.Normalizer;
import java.util.Scanner;

public class P_4_2_7_palindromos {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos una frase por teclado y deseamos saber si es un palíndromo. Un
    palíndromo es una palabra, número o frase que se lee igual hacia adelante que
    hacia atrás. Si se trata de un número, se llama capicúa. (charAt)
      Ejemplos: La ruta natural, Se van sus naves. Dábale arroz a la zorra el abad,
      Amo la pacífica paloma, ¿Son mulas o cívicos alumnos? Oirás orar a Rosario. Nada, yo soy Adán.
    */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un palíndromo: ");
        String palindromo = sc.nextLine();
        String invertido = "";

        String normalizado = normalizador(palindromo);

        for(int i = normalizado.length() - 1; i >= 0; i--) {
           invertido = invertido.concat(String.valueOf(normalizado.charAt(i)));
        }

        if(normalizado.equals(invertido)) {
            System.out.println(palindromo + " es un palíndromo.");
        } else {
            System.out.println(palindromo + " no es un palíndromo.");
        }
    }

    public static String normalizador(String str){
        if(str == null || str.trim().isEmpty()) return "";
        String norm = Normalizer.normalize(str.trim(), Normalizer.Form.NFKD);
        return norm.replaceAll("[\\u0300-\\u0302|\\u0304-\\u036F.,;:?!¿¡' ]", "").toLowerCase();
    }
}