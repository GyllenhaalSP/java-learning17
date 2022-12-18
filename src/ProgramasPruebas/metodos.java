package ProgramasPruebas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Normalizer;
import java.util.Arrays;
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

    public static int returnChange(int cambio, int cantidad){
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

    public static String[] menuPrincipal(){
        //Devuelve un array para fijar el precio y el producto.
        Scanner sc = new Scanner(System.in);
        String producto;
        int precio = 0;
        do{
            System.out.print("""
                            -Agua
                            -Refresco
                            -Zumo
                            -Salir
                            Elegir un producto:\040""");
            switch (producto = sc.nextLine().trim().toLowerCase()) {
                case "agua" -> printChoice(precio = 50, producto);
                case "refresco" -> printChoice(precio = 75, producto);
                case "zumo" -> printChoice(precio = 95, producto);
                case "salir" -> System.out.println("Gracias por usar nuestra Vending Machine de mierda...");
                default -> System.out.println("\nProducto no disponible");
            }
        }while(!producto.equalsIgnoreCase("agua") &&
                !producto.equalsIgnoreCase("refresco") &&
                !producto.equalsIgnoreCase("zumo") &&
                !producto.equalsIgnoreCase("salir"));

        return new String[]{producto, String.valueOf(precio)};
    }

    public static int menuVending(int precio, int[] cantidad, int[] monedas){
        //Imprime el menú del vending y devuelve la opción elegida.
        Scanner sc = new Scanner(System.in);
        int cents = 0, whileCents = 0, contadorCambio = 0;
        int[] contadorIntroducidas = new int[6];
        boolean contadorCambioBool = false, flag = true, ultimaMoneda = false;

        for(int i = 0; i < cantidad.length-2; i++) {
            if(cantidad[i] < 1) contadorCambio += 1;
            if(cantidad[i] == 1) ultimaMoneda = true;
        }

        if (cantidad[5] < 1 || contadorCambio >= 2 ||
                (contadorCambio == 1 && ultimaMoneda)) contadorCambioBool = true;

        do{
            System.out.print("""
                        -2€     -1€     -50cts
                        -20cts  -10cts  -5cts
                        Introducir moneda:\040""");
            switch (sc.nextLine().trim().toLowerCase()) {
                case "2" -> cents += 200;
                case "1" -> cents += 100;
                case "50" -> cents += 50;
                case "20" -> cents += 20;
                case "10" -> cents += 10;
                case "5" -> cents += 5;
                default -> System.out.println("\n\tMoneda no aceptada\n");
            }

            whileCents += cents;

            if(whileCents == precio) {
                //Precio justo
                flag = false;
                calderilla(cents, cantidad, monedas, contadorIntroducidas, true);
            }

            if(cents > precio && contadorCambioBool){
                //No hay para dar cambio
                System.out.println("\n\t¡ATENCIÓN! ¡INTRODUZCA IMPORTE EXACTO!\n");
                cents = 0;
            }

            if(cents > precio){
                //Necesita cambio
                flag = false;
                calderilla(cents, cantidad, monedas, contadorIntroducidas, true);
            }

            if(cents < precio) {
                //Hay que introducir más monedas
                contadorCambioBool = false;
                if((precio - whileCents) / 100.0 > 0) {
                    //Controla que el importe introducido sea distinto de 0
                    calderilla(cents, cantidad, monedas, contadorIntroducidas, true);
                    cents = insufficientCoins(true, precio, whileCents);
                }

                if(whileCents > precio){
                    contadorCambioBool = true;
                    calderilla(cents, cantidad, monedas, contadorIntroducidas, false);
                    whileCents = insufficientCoins(false, precio, whileCents);
                    System.out.println("No hay cambio suficiente, devolviendo el dinero introducido. Introduzca el precio de nuevo: ");
                }
            }
        }while(flag);
        return whileCents;
    }

    public static void calderilla(int calderilla, int[] cantidad, int[] monedas,
                                  int[] contadorIntroducidas, boolean sumar){
        //Hace el recuento de monedas y las redistribuye en el array de cantidad de monedas tanto si es
        //para sumar como si es para restarlas en caso de error.
        if(sumar){
            for (int i = 0; i < cantidad.length; i++) {
                if (calderilla == monedas[i]) {
                    cantidad[i]++;
                    contadorIntroducidas[i]++;
                }
            }
            Arrays.fill(contadorIntroducidas, 0);
        }else{
            for(int i = 0; i < cantidad.length; i++) {
                for(int j = 0; j < contadorIntroducidas[i]; j++) cantidad[i]--;
            }
        }
    }

    public static void printChoice(int precio, String producto) {
        //Imprime los productos disponibles y el precio.
        System.out.printf("\n\tEl precio del %s es %.2f€\n\n", producto, precio/100.0);
    }

    public static void returnChange(int cambio, int[] monedas, int[] cantidad){
        //Devuelve el cambio.
        double euros;
        for(int i = 0; i < monedas.length; i++){
            euros = monedas[i]/100.0;
            if(monedas[i] > 99){
                if(cambio >= monedas[i]){
                    System.out.println("\t\tMonedas de "
                            +(euros%1==0.0
                            ? (int)euros
                            : String.format("%.2f", euros))
                            +" euro: "+cambio/monedas[i]+"\n");
                    cambio%=monedas[i];
                    cantidad[i]-=1;
                }
            }else if (cambio >= monedas[i]){
                System.out.println("\t\tMonedas de "+euros+" céntimos: "+cambio/monedas[i]+"\n");
                cambio%=monedas[i];
                cantidad[i]-=1;
            }
        }
    }

    public static void cierreMaquina(int[] cantidad, int[] monedas){
        //Formatea e imprime los datos económicos de la máquina.
        double[] beneficios = new double[6];
        double euros, total = 0;
        for(int i = 0; i < beneficios.length; i++) {
            euros = monedas[i]/100.0;
            BigDecimal formatoDecimal = new BigDecimal(cantidad[i]*euros).setScale(2, RoundingMode.HALF_UP);
            beneficios[i] = formatoDecimal.doubleValue();
            System.out.println("\nLa máquina tiene "
                    +(beneficios[i]%1==0.0
                    ? (int)beneficios[i] : String.format("%.2f", beneficios[i]))
                    +" euros en "
                    +(cantidad[i] == 1 ? cantidad[i]+" moneda de " : cantidad[i]+" monedas de ")
                    +(euros < 1 ? (int)(euros*100)+" céntimos" : (euros%1==0.0
                    ? (int)euros : Double.toString(euros))+((monedas[i] == 200)
                    ? " euros" : " euro")));
            total += beneficios[i];
        }
        System.out.println("El beneficio total del día ha sido: "+total);
    }

    public static int insufficientCoins(boolean insuficiente, int precio, int whileCents){
        //Devuelve el mensaje de dinero insuficiente y pone los céntimos a 0.
        if(insuficiente){
            System.out.printf("\n\tDinero insuficiente, faltan %.2f euros.\n", Math.abs(((precio - whileCents) / 100.0)));
            return 0;
        }else{
            System.out.printf("\n\tNo se pueden devolver %.2f euros de cambio.\n", Math.abs(((precio - whileCents) / 100.0)));
        }
        return 0;
    }

    public static double limitPrecision(String doubleAsString, int maxDigitsAfterDecimal, boolean print) {
        int multiplier = (int) Math.pow(10, maxDigitsAfterDecimal);
        double truncated = (double) ((long) ((Double.parseDouble(doubleAsString)) * multiplier)) / multiplier;
        if (print) System.out.println(doubleAsString + " ==> " + truncated);
        return truncated;
    }
}
