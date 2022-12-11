package PROG.P_3.P_3_6;

import static ProgramasPruebas.metodos.superindice;

public class P_3_6_1_potencias {
//    Escribir las potencias enteras de 2 de 0 a 9. (Usando al menos un while).
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
}
