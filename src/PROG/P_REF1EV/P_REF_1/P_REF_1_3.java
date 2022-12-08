package PROG.P_REF1EV.P_REF_1;

import java.util.Scanner;

public class P_REF_1_3 {
    // Daniel Alonso Lázaro - 2022
    /*
    Se introduce una cantidad numérica por teclado que corresponde a euros y
    deseamos ver el valor de dicha cantidad en pesetas. Recordamos que un euro
    eran 166'386 pesetas.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce euros: ");
        double euros = Double.parseDouble(sc.nextLine());
        int pesetas = (int) (euros * 166.386);
        System.out.println(euros + " euros son " + pesetas + " pesetas");
    }
}
