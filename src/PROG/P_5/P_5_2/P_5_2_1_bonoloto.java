package PROG.P_5.P_5_2;

import java.util.Arrays;

public class P_5_2_1_bonoloto {
//    Nos piden rellenar 4 boletos de la bonoloto. Debemos controlar que no se pueden
//    repetir los números en una misma apuesta. Visualizar las cuatro apuestas.
    public static void main(String[] args) {
        int numero;
        boolean repetido;
        for(int rep = 0; rep < 4; rep++) {
            int[] bonoloto = new int[6];
            for(int i = 0; i < bonoloto.length; i++) {
                do {
                    numero = (int) (Math.random() * 49 + 1);
                    repetido = false;
                    for(int j = 0; j <= i; j++) {
                        if(numero == bonoloto[j]) {
                            repetido = true;
                            break;
                        }
                    }
                }while(repetido);
                bonoloto[i] = numero;
            }

            for(int i = 0; i < bonoloto.length; i++) {
                Arrays.sort(bonoloto);
                if(i == 0) System.out.print("Boleto "+(rep+1)+":\n\t");
                System.out.printf(" %02d\t", bonoloto[i]);
                if(i == 5) System.out.println();
            }
        }
    }
}
