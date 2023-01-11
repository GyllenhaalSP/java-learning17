package EV1.P_3.P_3_8;

import java.util.Scanner;

import static ProgramasPruebas.metodos.base;

public class P_3_8_2_cambioBase {
//    Se introduce un número en base decimal y deseamos ver su representación en binario, octal
//    y base cinco. Debemos elegir la representación de ese número entre las tres posibles. Una
//    vez realizada la primera nos saldrá un mensaje indicando si queremos continuar.
    public static void main(String[] args) {
        String continuar;
        int numero, base;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Introduce un número: ");
            numero = sc.nextInt();
            System.out.print("Introduce la base: ");
            base = sc.nextInt();
            sc.nextLine();
            switch (base) {
                case 2 -> System.out.println("El número en binario es " + base(numero, base)+".");
                case 5 -> System.out.println("El número en base 5 es " + base(numero, base)+".");
                case 8 -> System.out.println("El número en octal es " + base(numero, base)+".");
                case 16 -> System.out.println("El número en hexadecimal es " + base(numero, base)+".");
                default -> System.out.println("La base introducida es incorrecta.");
            }
            System.out.println("¿Continuar? s/n");
            continuar = sc.nextLine();
            System.out.println();
        }while(!continuar.equalsIgnoreCase("n"));
    }
}
