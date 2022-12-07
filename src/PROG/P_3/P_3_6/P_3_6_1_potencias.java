package PROG.P_3.P_3_6;

public class P_3_6_1_potencias {
    public static void main(String[] args) {
        int i = 0, resultado = 1;
        while(i < 10){
            if (i == 0){
                System.out.println("2"+superindice(Integer.toString(i))+" es 1");
            }else{
                resultado *= 2;
                System.out.println("2"+superindice(Integer.toString(i))+" es "+resultado);
            }
            i++;
        }
    }

    public static String superindice(String exponente) {
        exponente = exponente.replaceAll("0", "⁰");
        exponente = exponente.replaceAll("1", "¹");
        exponente = exponente.replaceAll("2", "²");
        exponente = exponente.replaceAll("3", "³");
        exponente = exponente.replaceAll("4", "⁴");
        exponente = exponente.replaceAll("5", "⁵");
        exponente = exponente.replaceAll("6", "⁶");
        exponente = exponente.replaceAll("7", "⁷");
        exponente = exponente.replaceAll("8", "⁸");
        exponente = exponente.replaceAll("9", "⁹");
        return exponente;
    }
}
