package PROG.P_4.P_4_1;

import java.util.Scanner;

public class P_4_1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre, nombre2, nombreMasLargo, nombreMasCorto;

        System.out.print("Introduce un nombre: ");
        nombre = sc.nextLine();

        do {
            System.out.print("Introduce más nombres: ");
            nombre2 = sc.nextLine();

            if (nombre.length() > nombre2.length()){
                nombreMasLargo = nombre;
                nombreMasCorto = nombre2;
            }else{
                nombreMasLargo = nombre2;
                nombreMasCorto = nombre;
            }
            if(!nombre2.equals("")){
                System.out.println("El nombre más largo es "+nombreMasLargo+" y tiene "+nombreMasLargo.length()+
                        " letras y el más corto es "+nombreMasCorto+ " y tiene "+nombreMasCorto.length()+" letras.");
            }
            nombre = nombreMasLargo;

        } while (!nombre2.equals(""));
    }
}
