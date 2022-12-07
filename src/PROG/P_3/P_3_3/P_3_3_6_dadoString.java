package PROG.P_3.P_3_3;

import java.util.Scanner;

public class P_3_3_6_dadoString {

    public static int dado() {
        int userInput;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduce una de las seis caras de un dado: ");
            userInput = sc.nextInt();
        }while(userInput < 1 | userInput > 6);
        return userInput;
    }

    public static void main(String[] args) {
        int cara = dado();
        switch (cara){
            case 1: case 6:
                if (cara == 1)
                    System.out.println("En la cara opuesta está el \"seis\".");
                else
                    System.out.println("En la cara opuesta está el \"uno\".");
                break;
            case 2: case 5:
                if (cara == 2)
                    System.out.println("En la cara opuesta está el \"cinco\".");
                else
                    System.out.println("En la cara opuesta está el \"dos\".");
                break;
            default:
                if (cara == 3)
                    System.out.println("En la cara opuesta está el \"cuatro\".");
                else
                    System.out.println("En la cara opuesta está el \"tres\".");
        }
    }
}
