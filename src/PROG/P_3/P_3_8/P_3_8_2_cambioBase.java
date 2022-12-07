package PROG.P_3.P_3_8;

import java.util.Scanner;

public class P_3_8_2_cambioBase {
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

    public static String base(int num, int rad){
        return Integer.toString(num, rad);
    }
}
