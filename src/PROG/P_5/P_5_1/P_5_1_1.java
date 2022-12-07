package PROG.P_5.P_5_1;

import javax.swing.JOptionPane;

public class P_5_1_1 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        int mayor=0, igual=0;

        nums[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un número: "));

        for(int i = 1; i < nums.length; i++) {
           nums[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un número: "));

           if(nums[i] >= nums[0]){
                mayor = nums[i];
           }
        }

        for (int num : nums) {
            if (num == mayor) {
                igual++;
            }
        }

        System.out.println("El número mayor es: " + mayor + " y se repite " + igual + " veces.");
    }
}
