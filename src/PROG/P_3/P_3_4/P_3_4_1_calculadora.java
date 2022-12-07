package PROG.P_3.P_3_4;

import java.util.Scanner;

public class P_3_4_1_calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int operando, operador, resultado;
        double operandoD, operadorD, resultadoD;
        String userInput, userInputStr;

        do {
            System.out.print("""
                    Introduce el símbolo correspondiente\s
                    a la operación que quieras realizar:
                    + Suma              ^ Potencia
                    - Resta             % Módulo
                    * Multiplicación    // División entera
                    / División          Salir
                    """);
            userInput = sc.nextLine();
            switch (userInput) {
                case "+" -> {
                    System.out.println("\nIntroduce el primer sumando: ");
                    operando = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce el segundo sumando: ");
                    operador = sc.nextInt();
                    sc.nextLine();
                    resultado = operando + operador;
                    do {
                        System.out.println("El resultado de " + operando + userInput + operador + " es " + resultado + ".");
                        System.out.println("\n¿Quieres seguir operando? 'S' para continuar, 'N' para salir, 'C' para cambiar de operación.");
                        userInputStr = sc.nextLine();
                        switch (userInputStr) {
                            case "s" -> {
                                System.out.println("Introduce el siguiente sumando: ");
                                operador = sc.nextInt();
                                sc.nextLine();
                                operando = resultado;
                                resultado += operador;
                            }
                            case "c" -> userInput = " ";
                            case "n" -> userInput = "salir";
                        }
                    } while ("s".equalsIgnoreCase(userInputStr));
                }
                case "-" -> {
                    System.out.println("\nIntroduce el minuendo: ");
                    operando = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce el sustraendo: ");
                    operador = sc.nextInt();
                    sc.nextLine();
                    resultado = operando - operador;
                    do {
                        System.out.println("El resultado de " + operando + userInput + operador + " es " + resultado + ".");
                        System.out.println("\n¿Quieres seguir operando? 'S' para continuar, 'N' para salir, 'C' para cambiar de operación.");
                        userInputStr = sc.nextLine();
                        switch (userInputStr) {
                            case "s" -> {
                                System.out.println("Introduce el siguiente sustraendo: ");
                                operador = sc.nextInt();
                                sc.nextLine();
                                operando = resultado;
                                resultado -= operador;
                            }
                            case "c" -> userInput = " ";
                            case "n" -> userInput = "salir";
                        }
                    } while ("s".equalsIgnoreCase(userInputStr));
                }
                case "*" -> {
                    System.out.println("\nIntroduce el multiplicando: ");
                    operando = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce el multiplicador: ");
                    operador = sc.nextInt();
                    sc.nextLine();
                    resultado = operando * operador;
                    do {
                        System.out.println("El resultado de " + operando + userInput + operador + " es " + resultado + ".");
                        System.out.println("\n¿Quieres seguir operando? 'S' para continuar, 'N' para salir, 'C' para cambiar de operación.");
                        userInputStr = sc.nextLine();
                        switch (userInputStr) {
                            case "s" -> {
                                System.out.println("Introduce el siguiente multiplicador: ");
                                operador = sc.nextInt();
                                sc.nextLine();
                                operando = resultado;
                                resultado *= operador;
                            }
                            case "c" -> userInput = " ";
                            case "n" -> userInput = "salir";
                        }
                    } while ("s".equalsIgnoreCase(userInputStr));
                }
                case "/", "%", "//" -> {
                    System.out.println("\nIntroduce el dividendo: ");
                    operandoD = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce el divisor: ");
                    operadorD = sc.nextDouble();
                    sc.nextLine();

                    do {
                        if (userInput.equals("/")) {
                            resultadoD = operandoD / operadorD;
                            System.out.println("El resultado de " + operandoD + userInput + operadorD + " es " + resultadoD + ".");
                        }else if (userInput.equals("%")){
                            resultadoD = operandoD % operadorD;
                            System.out.println("El resultado de " + operandoD + userInput + operadorD + " es " + resultadoD + ".");
                        }else{
                            resultadoD = operandoD / operadorD;
                            System.out.println("El resultado de " + operandoD + userInput + operadorD + " es " + (int)resultadoD + ".");
                        }
                        System.out.println("\n¿Quieres seguir operando? 'S' para continuar, 'N' para salir, 'C' para cambiar de operación.");
                        userInputStr = sc.nextLine();
                        switch (userInputStr) {
                            case "s" -> {
                                System.out.println("Introduce el siguiente divisor: ");
                                operadorD = sc.nextDouble();
                                sc.nextLine();
                                operandoD = resultadoD;
                                resultadoD /= operadorD;
                            }
                            case "c" -> userInput = " ";
                            case "n" -> userInput = "salir";
                        }
                    } while ("s".equalsIgnoreCase(userInputStr));
                }
                case "^" -> {
                    System.out.println("\nIntroduce la base: ");
                    operando = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce el exponente: ");
                    operador = sc.nextInt();
                    sc.nextLine();
                    do {
                        resultado = (int) Math.pow(operando, operador);
                        System.out.println("El resultado de " + operando + " elevado a " + operador + " es " + resultado + ".");
                        System.out.println("\n¿Quieres seguir operando? 'S' para continuar, 'N' para salir, 'C' para cambiar de operación.");
                        userInputStr = sc.nextLine();
                        switch (userInputStr) {
                            case "s" -> {
                                System.out.println("Introduce una nueva base: ");
                                operando = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Introduce un nuevo exponente: ");
                                operador = sc.nextInt();
                                sc.nextLine();
                            }
                            case "c" -> userInput = " ";
                            case "n" -> userInput = "salir";
                        }
                    } while ("s".equalsIgnoreCase(userInputStr));
                }
            }
            System.out.println();
        }while (!userInput.equalsIgnoreCase("salir"));

        System.out.println("""
                Gracias por usar esta calculadora.
                El programador no se hace responsable resultados inesperados.
                Utilizar con precaución.""");
    }
}