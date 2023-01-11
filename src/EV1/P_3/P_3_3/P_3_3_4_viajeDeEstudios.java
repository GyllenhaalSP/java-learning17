package EV1.P_3.P_3_3;

import java.util.Scanner;

public class P_3_3_4_viajeDeEstudios {
//    El director de una escuela está organizando un viaje de estudios, y requiere determinar cuánto
//    debe cobrar a cada alumno y cuánto debe pagar a la compañía de viajes por el servicio.
//    La forma de cobrar es la siguiente:
//        • si son 100 alumnos o más, el costo del viaje por cada alumno es de 65 euros;
//        • de 50 a 99 alumnos, el costo es de 70 euros,
//        • de 30 a 49, de 95 euros,
//        • y si son menos de 30.
//        • Además, el costo de un autobús es de 4000 euros, sin importar el número de alumnos.
//    La capacidad de un autobús es de 60 plazas.
//    Realice un algoritmo que permita determinar el pago a la agencia de viajes y lo que debe
//    pagar cada alumno por el viaje.
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
