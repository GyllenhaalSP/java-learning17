package PROG.P_5.P_5_1;

import javax.swing.*;

public class P_5_1_4 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        double mediaPares = 0, mediaImpares = 0;
        int contPares = 0, contImpares = 0;

        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "Introduce un número: "));
            if(i % 2 == 0){
                mediaPares += nums[i];
                contPares++;
            } else {
                mediaImpares += nums[i];
                contImpares++;
            }
        }
        System.out.printf("La media de los números en posición par es: %02.2f y la media de los números en posición impar es: %02.2f", mediaPares/contPares, mediaImpares/contImpares);
    }
}
