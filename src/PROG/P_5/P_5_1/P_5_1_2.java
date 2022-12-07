package PROG.P_5.P_5_1;

public class P_5_1_2 {
    public static void main(String[] args) {
        int[] vector1 = new int[15];
        int[] vector2 = new int[15];
        int[] vector3 = new int[15];

        for(int i = 0; i < vector1.length; i++){
            vector1[i] = (int) (Math.random() * 100);
            vector2[i] = (int) (Math.random() * 100);
            vector3[i] = vector1[i] + vector2[i];
        }

        for(int i = 0; i < vector1.length; i++){
            System.out.println(vector1[i]+" + "+vector2[i]+" = "+vector3[i]);
        }
    }
}
