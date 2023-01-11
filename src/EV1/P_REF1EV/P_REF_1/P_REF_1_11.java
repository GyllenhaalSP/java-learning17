package EV1.P_REF1EV.P_REF_1;

public class P_REF_1_11 {
    // Daniel Alonso Lázaro - 2022
    /*
    Diseñar un algoritmo para multiplicar mediante sumas sucesivas. Deben ser
    introducidos dos números por teclado. Los números serán enteros positivos.
    */
    public static void main(String[] args) {
        int cont = 0, resultado = 0;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Introduce un número: ");
        int multiplicando = Integer.parseInt(sc.nextLine());
        System.out.print("Introduce otro número: ");
        int multiplicador = Integer.parseInt(sc.nextLine());

        while (cont < multiplicador) {
            resultado += multiplicando;
            cont++;
        }

        System.out.println("El resultado de la multiplicación es " + resultado);
    }

}
