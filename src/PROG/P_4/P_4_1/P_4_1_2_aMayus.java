package PROG.P_4.P_4_1;

import java.util.Scanner;

public class P_4_1_2_aMayus {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos los nombres de los alumnos de clase y queremos visualizarlos en
    mayúsculas independientemente de cómo han sido introducidos por el usuario
    inicialmente. (toUpperCase())
    */
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
                System.out.println("El nombre más largo es "+nombreMasLargo.toUpperCase()+
                        " y tiene "+nombreMasLargo.length()+" letras y el más corto es "
                        +nombreMasCorto.toUpperCase()+ " y tiene "+nombreMasCorto.length()+" letras.\n");
            }
            nombre = nombreMasCorto;

        } while (!nombre2.equals(""));
    }
}
