package ProgramasPruebas;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
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

    public static String[] menuOpciones(){
        //Devuelve un array para fijar la elección del producto y el precio asociado al mismo.
        String producto;
        int precio = 0;
        ImageIcon icono = new ImageIcon(new ImageIcon("resources/vendingMachine/vending.png")
                .getImage()
                .getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        switch ((producto = (String) JOptionPane.showInputDialog(
                null,
                "Elegir un producto:",
                "GYLLENHAAL'S VENDING MACHINE",
                JOptionPane.INFORMATION_MESSAGE,
                icono,
                new Object[] {"Agua", "Refresco", "Zumo", "Cerveza", "Salir"},
                "Agua"))) {
            case "Agua" -> printChoice(precio = 50, producto);
            case "Refresco" -> printChoice(precio = 75, producto);
            case "Zumo" -> printChoice(precio = 95, producto);
            case "Cerveza" -> printChoice(precio = 130, producto);
            case "Salir" -> JOptionPane.showMessageDialog(
                    null,
                    "VUELVA PRONTO\nLE ESPERAMOS",
                    "FINALIZANDO",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        return new String[]{producto, String.valueOf(precio)};
    }

    public static int imprimirPrecios(int precio){
        int cents = 0;
        ImageIcon icono = new ImageIcon(new ImageIcon("resources/vendingMachine/coins.png")
                .getImage()
                .getScaledInstance(150, 141, Image.SCALE_DEFAULT));
        StringBuilder mensajeMonedas = new StringBuilder("Introduce monedas:\n");
        switch (((String) JOptionPane.showInputDialog(
                null,
                mensajeMonedas.append("Precio: ")
                        .append(precio < 99 ? precio : String.format("%.2f", precio/100.0))
                        .append((precio > 99 ? precio == 100 ? " euro" : " euros" : " céntimos")),
                "PAGO",
                JOptionPane.INFORMATION_MESSAGE,
                icono,
                new Object[] {"2€", "1€", "50 cts", "20 cts", "10 cts", "5 cts"}, "2€"))) {
            case "2€" -> cents += 200;
            case "1€" -> cents += 100;
            case "50 cts" -> cents += 50;
            case "20 cts" -> cents += 20;
            case "10 cts" -> cents += 10;
            case "5 cts" -> cents += 5;
        }
        return cents;
    }

    public static int calculoPrecios(int precio, int[] cantidad, int[] monedas) {
        //Imprime el menú de precios y devuelve la opción elegida.
        int cents, whileCents = 0, contadorCambio = 0;
        int[] contadorIntroducidas = new int[6];
        boolean contadorCambioBool = false, flag = true, ultimaMoneda = false;

        for(int i = 0; i < cantidad.length-2; i++) {
            if(cantidad[i] < 1) contadorCambio += 1;
            if(cantidad[i] == 1) ultimaMoneda = true;
        }

        if (cantidad[5] < 1 || contadorCambio >= 2 ||
                (contadorCambio == 1 && ultimaMoneda)) contadorCambioBool = true;

        do{
            cents = imprimirPrecios(precio);

            whileCents += cents;

            if(whileCents == precio) {
                //Precio justo
                flag = false;
                calderilla(cents, cantidad, monedas, contadorIntroducidas, true);
            }

            if(cents > precio && contadorCambioBool){
                //No hay para dar cambio
                JOptionPane.showMessageDialog(null, """
                                LA MÁQUINA NO DISPONE DE CAMBIO EN ESTOS MOMENTOS
                                ¡INTRODUZCA IMPORTE EXACTO!""",
                        "¡ATENCIÓN¡", JOptionPane.ERROR_MESSAGE);
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
                    retardoJOptionPane(3);
                    JOptionPane.showMessageDialog(
                            null,
                            "La devolución se ha completado con éxito\nIntroduzca el precio de nuevo.",
                            "INFORMACIÓN",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }while(flag);
        return whileCents;
    }

    public static void calderilla(int calderilla, int[] cantidad, int[] monedas,
                                  int[] contadorIntroducidas, boolean sumar){
        //Hace el recuento de monedas y las redistribuye en el array de cantidad
        //tanto si es para sumar como si es para restarlas en caso de error.
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
        JDialog dialog = new JDialog();
        dialog.setTitle("INFORMACIÓN");
        dialog.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
        dialog.setContentPane(new JOptionPane(
                String.format("\n\tEl precio de"+
                        (producto.equalsIgnoreCase("Cerveza") ? " la " : "l ")+
                        "%s es %.2f€\n\n", producto.toLowerCase(), precio/100.0),
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null,
                new Object[]{},
                null));
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setSize(300,150);
        dialog.setLocationRelativeTo(null);
        retardoJOptionPane(3);
        dialog.setVisible(true);
    }

    public static void returnChange(int cambio, int[] monedas, int[] cantidad){
        //Devuelve el cambio.
        double euros;
        StringBuilder acumulador = new StringBuilder();
        for(int i = 0; i < monedas.length; i++){
            euros = monedas[i]/100.0;
            if(monedas[i] > 99){
                if(cambio >= monedas[i]){
                    acumulador.append(String.format("Monedas de "
                            +(euros%1==0.0
                            ? (int)euros
                            : String.format("%.2f", euros))
                            +" euro: "+cambio/monedas[i]+"\n"));
                    cambio%=monedas[i];
                    cantidad[i]-=1;
                }
            }else if (cambio >= monedas[i]){
                acumulador.append(String.format("Monedas de %d céntimos: %d\n", monedas[i], (cambio/monedas[i])));
                cambio%=monedas[i];
                cantidad[i]-=1;
            }
        }
        retardoJOptionPane(3);
        JOptionPane.showMessageDialog(null, acumulador, "CAMBIO", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void cierreMaquina(int[] cantidad, int[] monedas){
        //Formatea e imprime los datos económicos de la máquina.
        double[] beneficios = new double[6];
        double euros, total = 0;
        StringBuilder acumulador = new StringBuilder("La máquina tiene:\n");
        for(int i = 0; i < beneficios.length; i++) {
            euros = monedas[i]/100.0;
            beneficios[i] = new BigDecimal(cantidad[i]*euros)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            acumulador.append(String.format((beneficios[i]%1==0.0
                        ? (int)beneficios[i] : String.format("%.2f", beneficios[i]))
                    +(beneficios[i] == 1 ? " euro en " : " euros en ")
                    +(cantidad[i] == 1 ? cantidad[i]+" moneda de " : cantidad[i]+" monedas de ")
                    +(euros < 1 ? (int)(euros*100)+" céntimos\n" : (euros%1==0.0
                        ? (int)euros : Double.toString(euros))+((monedas[i] == 200)
                        ? " euros\n" : " euro\n"))));
            total += beneficios[i];
        }
        JOptionPane.showMessageDialog(
                null,
                acumulador,
                "DESGLOSE DE VENTAS",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(
                null,
                String.format("Los beneficios totales del día han sido:\n %.2f€", total),
                "BENEFICIOS DEL DÍA",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static int insufficientCoins(boolean insuficiente, int precio, int whileCents) {
        //Devuelve el mensaje de dinero insuficiente y pone los céntimos a 0.
        if(insuficiente){
            retardoJOptionPane(1.5);
            JOptionPane.showMessageDialog(
                    null,
                    String.format("\n\tDINERO INSUFICIENTE\nPor favor, introduzca los %.2f euros faltantes.\n",
                            Math.abs(((precio - whileCents) / 100.0))),
                    "DINERO INSUFICIENTE",
                    JOptionPane.ERROR_MESSAGE);
            return 0;
        }else{
            retardoJOptionPane(4);
            JOptionPane.showMessageDialog(
                    null,
                    String.format("""
                                    La máquina no dispone de cambio.
                                    No se pueden devolver %.2f euros.
                                    Iniciando proceso de devolución.
                                    Espere...""",
                            Math.abs(((precio - whileCents) / 100.0))),
                    "PROCEDIENDO A LA DEVOLUCIÓN",
                    JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }

    public static void expendedor(String producto, int cambio){
        retardoJOptionPane(2);
        JOptionPane.showMessageDialog(
                null,
                String.format("\nExpendiendo producto y cambio\n\tProducto: %s.\n\tCambio: %.2f€\n",
                        producto.toUpperCase(), cambio/100.0),
                "EXPENDIENDO",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void retardoJOptionPane(double tiempoEnSecs){
        Thread temporizador = new Thread(() -> {
            try {
                Thread.sleep((long) (tiempoEnSecs*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            JOptionPane.getRootFrame().dispose();
        });
        temporizador.start();
    }

    public static double limitPrecision(String doubleAsString, int maxDigitsAfterDecimal, boolean print) {
        int multiplier = (int) Math.pow(10, maxDigitsAfterDecimal);
        double truncated = (double) ((long) ((Double.parseDouble(doubleAsString)) * multiplier)) / multiplier;
        if (print) System.out.println(doubleAsString + " ==> " + truncated);
        return truncated;
    }

    public static void cls() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
