package PROG.P_5.P_5_1;

import javax.swing.*;

public class P_5_1_5 {
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
