package PROG.P_3.P_3_5;

import java.util.Scanner;

public class P_3_5_3_listaPares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInput;
        String evenNumbersList = "";

        do{
            System.out.print("Introduce un número mayor que 1: ");
            userInput = sc.nextInt();
            sc.nextLine();
        }while(userInput <= 1);

        for(int i = 1; i <= userInput; i++){
           if (i % 2 == 0){
               evenNumbersList = evenNumbersList.concat(Integer.toString(i).concat(", "));
           }
        }
        int lstLen = evenNumbersList.length();
        StringBuilder evenNumbersListY = new StringBuilder(evenNumbersList);
        System.out.println("La lista de números pares es: "+evenNumbersListY.replace(lstLen-2, lstLen-1, " "));
    }
}
