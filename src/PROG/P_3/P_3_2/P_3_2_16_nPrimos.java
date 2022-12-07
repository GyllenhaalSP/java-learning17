package PROG.P_3.P_3_2;

import javax.swing.JOptionPane;

public class P_3_2_16_nPrimos {

    public static void main(String[] args) {

        int range, loop=1, counter=0;
        String esPrimo = "";
        range = Integer.parseInt(JOptionPane.showInputDialog("""
                Escribe un número para comprobar\s
                todos los números primos contenidos\s
                entre el rango 0 y tu número:
                """));
        for(int i=2; i<=range; i++){
            while(loop<=i){
                if(i%loop == 0){
                    counter+=1;
                }
                loop+=1;
            }
            if ((counter==2) & (i!=range)) {
                esPrimo = esPrimo.concat(Integer.toString(i).concat(", "));
            } else {
                if ((counter==2) & (i==range)) {
                    esPrimo = esPrimo.concat(Integer.toString(i).concat(", "));
                }
            }
            counter = 0;
            loop = 1;
        }
        System.out.println();
        if (range==0 | range==1) {
            System.out.println(range+" no es un número primo.");
        } else if (range==2) {
            System.out.println("2 es primo.");
        } else {
            esPrimo = esPrimo.substring(0,esPrimo.length()-2);
            StringBuilder esPrimoSB = new StringBuilder(esPrimo);
            if (esPrimo.length() <= 10){
                esPrimoSB.replace(esPrimo.length() - 3, esPrimo.length() - 2, " y" );
            }else if (esPrimo.length() <= 94) {
                esPrimoSB.replace(esPrimo.length() - 4, esPrimo.length() - 2, " y ");
            }else if (esPrimo.length() <= 809) {
                esPrimoSB.replace(esPrimo.length() - 5, esPrimo.length() - 3, " y ");
            }else if (esPrimo.length() <= 7175){
                esPrimoSB.replace(esPrimo.length() - 6, esPrimo.length() - 4, " y " );
            }else {
                esPrimoSB.replace(esPrimo.length() - 7, esPrimo.length() - 5, " y " );
            }
            System.out.println("Los números entre 0 y "+range+" que son primos son: "+esPrimoSB+".");
        }
    }

}
