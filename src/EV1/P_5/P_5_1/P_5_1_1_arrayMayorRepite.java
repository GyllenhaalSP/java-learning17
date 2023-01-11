package EV1.P_5.P_5_1;

import javax.swing.JOptionPane;

public class P_5_1_1_arrayMayorRepite {
    // Daniel Alonso Lázaro - 2022
    /*
    Realizar programa Java que permita cargar un vector numérico de 10 elementos desde teclado
    y, posteriormente visualice el valor del elemento mayor y cuántas veces se repite en el vector
    este valor máximo. Utiliza JOptionPane.
    */
    public static void main(String[] args) {
        int[] nums = new int[10];
        int mayor, igual=0;

        nums[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un número: "));
        mayor = nums[0];
        for(int i = 1; i < nums.length; i++) {
           nums[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un número: "));

           if(nums[i] >= mayor){
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
