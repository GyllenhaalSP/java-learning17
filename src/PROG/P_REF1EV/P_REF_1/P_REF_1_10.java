package PROG.P_REF1EV.P_REF_1;

public class P_REF_1_10 {
    public static void main(String[] args) {
        int num, cont = 0;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        do{
            System.out.print("Introduce un número entero mayor que 1: ");
            num = Integer.parseInt(sc.nextLine());
        }while(num <= 1);

        while (cont < num) {
            cont++;
            if (cont % 2 == 0) {
                System.out.println(cont);
            }
        }
    }
}
