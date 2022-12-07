package PROG.P_5.P_5_1;

import java.util.Random;

public class P_5_1_3 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rand = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(101);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.println("El index "+i+" contiene: "+array[i]);
            }
        }
    }
}
