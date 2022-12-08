package PROG.P_4.P_4_1;

import java.util.Scanner;

public class P_4_1_1_longitudNombre {
    // Daniel Alonso Lázaro - 2022
    /*
    Vamos a capturar los nombres completos de los alumnos de clase y queremos
    saber: ¿Cuál es el alumno que tiene el nombre más largo y el más corto?
    Debemos visualizar en pantalla cuantos caracteres tiene el nombre más largo y
    el del más corto. (length())
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
                System.out.println("El nombre más largo es "+nombreMasLargo+" y tiene "+nombreMasLargo.length()+
                        " letras y el más corto es "+nombreMasCorto+ " y tiene "+nombreMasCorto.length()+" letras.");
            }
            nombre = nombreMasLargo;

        } while (!nombre2.equals(""));
    }
}
