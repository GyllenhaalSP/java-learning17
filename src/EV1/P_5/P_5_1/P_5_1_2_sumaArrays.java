package EV1.P_5.P_5_1;

public class P_5_1_2_sumaArrays {
    // Daniel Alonso Lázaro - 2022
    /*
    A partir de dos vectores numéricos de 15 elementos, denominados vector1 y vector2,
    respectivamente, obtener un tercer vector, vector3 cuyos elementos sean la suma de los
    elementos de los vectores anteriores. Completar los vectores con números comprendidos entre
    0 y 100, generados aleatoriamente. (Sumar arrays o vectores es sumar elemento a elemento y
    colocar el resultado en la misma posición del vector resultado).
    */
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
