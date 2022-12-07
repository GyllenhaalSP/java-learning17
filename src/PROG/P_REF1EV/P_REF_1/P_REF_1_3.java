package PROG.P_REF1EV.P_REF_1;

import java.util.Scanner;

public class P_REF_1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce euros: ");
        double euros = Double.parseDouble(sc.nextLine());
        int pesetas = (int) (euros * 166.386);
        System.out.println(euros + " euros son " + pesetas + " pesetas");
    }
}
