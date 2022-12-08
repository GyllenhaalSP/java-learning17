package PROG.P_3.P_3_4;

import java.util.Scanner;

public class P_3_4_2_constantes {
//    Queremos calcular la longitud de una circunferencia, el área de un círculo
//    y volumen de una esfera, a partir del radio que se introducirá por teclado.
//    Define PI como constante y prueba durante el programa a cambiar su valor.
//    Después de ejecutarse el proceso anterior, pregunta al usuario si quiere
//    continuar con otro caso (S/N). El programa terminará cuando el usuario
//    responda N.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r, L, A, V;
        String userInput;
        final double PI = 3.1415926535897932;
        do {
            System.out.print("Introduce el radio: ");
            r = sc.nextDouble();
            sc.nextLine();
            L = 2*PI*r;
            A = 4*PI*Math.pow(r, 2);
            V = (4d/3d)*PI*Math.pow(r, 3);
            System.out.printf("""
                    %nPara un radio %s:\s
                     - La longitud de una circunferencia es %.2f.
                     - El área de un círculo es %.2f.
                     - El volumen de una esfera es %.2f.%n
                    """, r, L, A, V);

            System.out.print("¿Quieres continuar? S/N ");
            userInput = sc.nextLine();
            if ("s".equalsIgnoreCase(userInput))
                System.out.println();
        }while(!"n".equalsIgnoreCase(userInput));
    }
}
