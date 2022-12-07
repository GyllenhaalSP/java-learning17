package PROG.P_4.P_4_4;

public class P_4_4_4 {
    public static void main(String[] args) {
        int cont = 0;
        String combinacion = "";
        while (cont != 6) {
            int random = (int)(Math.random()*100);
            if ((random >= 1 && random <= 49) && !combinacion.contains(String.valueOf(random))) {
                combinacion = combinacion.concat(random + " ");
                cont++;
            }
        }
        System.out.println("La combinación es: "+ combinacion);
    }
}
