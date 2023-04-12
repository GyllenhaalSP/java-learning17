package EV2.OOP.C_20230411.P_11_4.edificiovecinos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vecino vecino1 = new Vecino("Juan", 16, "V0001", "Vivienda 1", "Finca 1");
        Scanner sc = new Scanner(System.in);
        do{
            if (!vecino1.esValidoDNI(vecino1.getDni())){
                System.out.println("Se ha de introducir un DNI válido.");
            }
            System.out.print("Introduce el DNI: ");
            vecino1.setDni(sc.nextLine());
            System.out.println();
        }while(!vecino1.esValidoDNI(vecino1.getDni()));

        if (!vecino1.esMayorDeEdad(vecino1.getEdad())){
            vecino1.setEdad(18);
        }

        Administrador administrador1 = new Administrador("Pepe", 16, "50432500D", "A0001", "F1", 15, 250f);

        if(!administrador1.esMayorDeEdad(administrador1.getEdad())){
            administrador1.setEdad(18);
        }

        if(administrador1.getSalario() > administrador1.salarioMaximo((float) Vecino.getCuota())){
            administrador1.setSalario((float) administrador1.salarioMaximo((float) Vecino.getCuota()));
        }

        System.out.println(vecino1);
        System.out.println();
        System.out.println(administrador1);

    }
}
