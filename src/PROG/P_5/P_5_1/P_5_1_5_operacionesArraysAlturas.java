package PROG.P_5.P_5_1;

import javax.swing.*;

public class P_5_1_5_operacionesArraysAlturas {
    // Daniel Alonso Lázaro - 2022
    /*
    Hacer un programa que realice las siguientes funciones:
        1- Llenar un array con las estaturas de los alumnos de una clase (Previamente habremos pedido que se
           introduzca por teclado en número de alumnos de la clase).
        2- Suma de todas las estaturas de la clase.
        3- Cálculo de la media de estaturas.
        4- Visualizar cuantos son más altos que la media y cuantos más bajos.
    */
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog
                (null, "Introduce de cuántos alumnos se van a guardar alturas: "));
        int[] alturas = new int[n];
        double sumaAlturas = 0, mediaAlturas;
        int contSobreMedia = 0, contBajoMedia = 0, contIgualMedia = 0;

        for(int i = 0; i < alturas.length; i++) {
            alturas[i] = Integer.parseInt(JOptionPane.showInputDialog
                    (null, "Introduce la altura del alumno " + (i + 1) + " en CM: "));
            sumaAlturas += alturas[i];
        }

        mediaAlturas = sumaAlturas/n;

        for(int altura:alturas){
            if(altura == mediaAlturas) contIgualMedia++;
            else if(altura > mediaAlturas) contSobreMedia++;
            else contBajoMedia++;
        }
        System.out.println("La suma de las alturas es: "+(int)Math.round(mediaAlturas)
                +" y la media de las alturas es: " +(int)Math.round(mediaAlturas)
                +".\nAdemás, hay "+contSobreMedia+(contSobreMedia == 1 ? " alumno":" alumnos")
                +" sobre la media y "+contBajoMedia+(contBajoMedia == 1 ? " alumno":" alumnos")
                +" por debajo de la media y "+contIgualMedia+(contIgualMedia == 1 ? " alumno":" alumnos")
                +" en la media.");
    }
}
