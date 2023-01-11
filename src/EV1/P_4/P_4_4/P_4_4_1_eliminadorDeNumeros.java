package EV1.P_4.P_4_4;

import java.util.Scanner;

public class P_4_4_1_eliminadorDeNumeros {
    // Daniel Alonso Lázaro - 2022
    /*
    Generamos un número aleatorio que tenga 6 cifras (obligatoriamente tiene que tener ese número de cifras).
    Además, se captura un dígito con valor entre 0 a 9. Queremos eliminar dicho dígito del número de 6 cifras,
    suprimiendo del número la posición correspondiente. Visualizar el nuevo número.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        String strRandom = String.valueOf((int)(Math.random()*(999999-100000+1)+100000));
        StringBuilder newStr = new StringBuilder();

        do{
            System.out.print("Introduce un número del 0 al 9: ");
            num = sc.nextInt();
            sc.nextLine();
        }while(num < 0 || num > 9);

        System.out.println(strRandom);

        for(int i = 0; i < strRandom.length(); i++){
            if(!String.valueOf(strRandom.charAt(i)).equals(String.valueOf(num))){
                newStr.append(strRandom.charAt(i));
            }
        }
        System.out.println(newStr);
    }
}
