package ProgramasPruebas;

import java.text.Normalizer;
import java.util.Random;
import java.util.Scanner;

public class metodos {
    // Daniel Alonso Lázaro - 2022
    public static boolean bisiesto(int year) {
        //Devuelve true si el año es bisiesto, false si no lo es.
        boolean bisiesto = false;
        if (year % 100 == 0) if (year % 400 == 0) bisiesto = true;
        else if (year % 4 == 0) bisiesto = true;
        return bisiesto;//((year % 100 != 0) | (year % 400 == 0)) & (year % 4 == 0)
    }

    public static long factorial(long num){
        //Devuelve el factorial de un número.
        long resFact = 1;
        for (long i=1; i<=num; i++) {
            resFact *= i;
        }
        return resFact;
    }

    public static int cambio(int cambio, int cantidad){
        //Devuelve el número de monedas de un tipo que se pueden dar como cambio.
        return cambio/cantidad;
    }

    public static int resto(int resto, int cantidad){
        //Devuelve el resto de monedas de un tipo que se pueden dar como cambio.
        return resto % cantidad;
    }

    public static String superindice(String exponente) {
        //Devuelve el exponente en formato superíndice.
        String superindices = "⁰¹²³⁴⁵⁶⁷⁸⁹";
        for(int i = 0; i < 10; i++){
            exponente = exponente.replaceAll(Integer.toString(i), Character.toString(superindices.charAt(i)));
        }
        return exponente;
    }

    public static int fibonacci(int n) {
        //Devuelve el n-ésimo número de la sucesión de Fibonacci.
        if(n==1)
            return 1;
        else if(n==2)
            return 1;
        else
            return (fibonacci(n-1) + fibonacci(n-2));
    }

    public static String base(int num, int rad){
        //Devuelve el número en la base indicada.
        return Integer.toString(num, rad);
    }

    public static String esVocal(char caracter) {
        //Devuelve si el caracter es una vocal.
        String str = normalizador(String.valueOf(caracter));
        return (str.equals("a") ||
                str.equals("e") ||
                str.equals("i") ||
                str.equals("o") ||
                str.equals("u")) ? "es vocal." : "es consonante.";
    }

    public static int dado() {
        //Devuelve un número introducido por el usuario entre 1 y 6.
        int userInput;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduce una de las seis caras de un dado: ");
            userInput = sc.nextInt();
        }while(userInput < 1 | userInput > 6);
        return userInput;
    }

    public static String normalizador(String str){
        //Devuelve la cadena de texto sin acentos, ni caracteres especiales, sin espacios laterales y en minúsculas.
        if(str == null || str.trim().isEmpty()) return "";
        String norm = Normalizer.normalize(str.trim(), Normalizer.Form.NFKD);
        return norm.replaceAll("[\\u0300-\\u0302|\\u0304-\\u036F.,;:?!¿¡' ]", "").toLowerCase();
    }

    public static double media(double num, int div){
        //Devuelve la media de un número.
        return num / div;
    }

    public static int dataIn(){
        //Devuelve temperaturas introducidas por el usuario.
        Scanner sc = new Scanner(System.in);
        int temp;
        do {
            System.out.print("Introduzca la siguiente medición de temperatura: ");
            temp = sc.nextInt();
            sc.nextLine();
        } while(!(temp >= -20 && temp <= 0));
        System.out.println("Temperatura registrada correctamente");
        return temp;
    }

    public static double calculoSalarios(double base, double complementos){
        //Devuelve la suma de la base y los complementos de un trabajador.
        return base + complementos;
    }

    public static void cargarArray(int[] v){
        //Carga un array con números aleatorios entre 0 y 100.
        Random rand = new Random();
        for(int i = 0; i < v.length; i++){
            v[i] = rand.nextInt(101);
        }
    }
    public static void mostrarArray(String mensaje, int[] v){
        //Imprime el array numérico entero que recibe y un mensaje junto con él.
        System.out.println(mensaje);
        for(int i = 0, j = 1; i < v.length; i++, j++){
            System.out.print(v[i]+"\t");
            if(j%10==0)System.out.println();
        }
        System.out.println();
    }

    public static boolean capicua(int[] numArray, int[] numArrayInvertido) {
        //Devuelve true si el número es capicúa o false si no lo es.
        for(int i = 0; i < numArray.length; i++) {
            if (numArray[i] != numArrayInvertido[i]) return false;
        }
        return true;
    }

    public static void printOptions(int precio, String producto) {
        //Imprime los productos disponibles y el precio.
        System.out.printf("El precio del %s es %.2f€\n\n", producto, precio/100.0);
    }

    public static int menuVending(int precio, int contadorCambio){
        //Imprime el menú del vending y devuelve la opción elegida.
        Scanner sc = new Scanner(System.in);
        int dineroCents = 0, newDineroCents = 0;
        do{
            System.out.print("""
                        -2€     -1€     -50cts
                        -20cts  -10cts  -5cts
                        Introducir moneda:\040""");
            switch (sc.nextLine().trim().toLowerCase()) {
                case "2" -> dineroCents += 200;
                case "1" -> dineroCents += 100;
                case "50" -> dineroCents += 50;
                case "20" -> dineroCents += 20;
                case "10" -> dineroCents += 10;
                case "5" -> dineroCents += 5;
                default -> System.out.println("\nMoneda no aceptada");
            }
            if(dineroCents < precio) {
                contadorCambio = 0;
                newDineroCents += dineroCents;
                dineroCents = 0;
                if((precio - newDineroCents) / 100.0 != 0) System.out.printf("Dinero insuficiente, faltan %.2f euros\n", ((precio - newDineroCents) / 100.0));
                if(newDineroCents == precio){
                    dineroCents = newDineroCents;
                    break;
                }else if(newDineroCents > precio){
                    newDineroCents = 0;
                    contadorCambio = 3;
                    System.out.println("No hay cambio suficiente, devolviendo dinero introducido.");
                }
            }
            if(dineroCents > precio && contadorCambio >= 2){
                System.out.println("\n\t¡ATENCIÓN! ¡INTRODUZCA IMPORTE EXACTO!\n");
                dineroCents = 0;
            }
            if(dineroCents > precio) {
                break;
            }
        }while(true);
        return dineroCents;
    }
}