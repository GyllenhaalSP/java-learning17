package PROG.P_3.P_3_3;

import java.util.Scanner;

public class P_3_3_4_viajeDeEstudios {
    public static void main(String[] args) {
        int numAlumnos;
        double precio;
        String nombreColegio;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de alumnos que van a acudir al viaje: ");
        numAlumnos = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce el nombre del colegio: ");
        nombreColegio = sc.nextLine();
        if (numAlumnos >= 100){
            precio = numAlumnos * 65;
        } else if (50 < numAlumnos & numAlumnos < 99){
            precio = numAlumnos * 70;
        } else if (30 < numAlumnos & numAlumnos < 49){
            precio = numAlumnos * 95;
        } else {
            precio = numAlumnos * 100;
        }

        precio += 4000d / numAlumnos;

        System.out.printf("El viaje para "+numAlumnos+" alumnos del centro "+nombreColegio+" costará: %.2f euros.", precio);
    }
}
