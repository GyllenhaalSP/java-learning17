package EV3.preparacionexamen3ev.funcionesunidad7;

import utilities.StaticUtilities;

public class Ej9 {
    public static void main(String[] args) {
        System.out.print("Introduce el número 1: ");
        int a = Integer.parseInt(StaticUtilities.sc.nextLine());
        System.out.print("Introduce el número 2: ");
        int b = Integer.parseInt(StaticUtilities.sc.nextLine());
        System.out.print("Introduce el número 3: ");
        int c = Integer.parseInt(StaticUtilities.sc.nextLine());

        int max = masElevado(a, b);
        max = masElevado(max, c);
        System.out.println("El mayor número es: " + max);
    }

    public static int masElevado(int a, int b){
        return Math.max(a, b);
    }
}
