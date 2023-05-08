package EV3.PreparacionExamen3EV.FuncionesUD7;

import EV3.PreparacionExamen3EV.StaticScanner;

public class Ej9 {
    public static void main(String[] args) {
        System.out.print("Introduce el número 1: ");
        int a = Integer.parseInt(StaticScanner.sc.nextLine());
        System.out.print("Introduce el número 2: ");
        int b = Integer.parseInt(StaticScanner.sc.nextLine());
        System.out.print("Introduce el número 3: ");
        int c = Integer.parseInt(StaticScanner.sc.nextLine());

        int max = masElevado(a, b);
        max = masElevado(max, c);
        System.out.println("El mayor número es: " + max);
    }

    public static int masElevado(int a, int b){
        return Math.max(a, b);
    }
}
