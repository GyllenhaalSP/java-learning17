package PROG.P_REF1EV.P_REF_2;

import java.util.Scanner;

public class P_REF_2_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String responsable, respMin="";
        int cont = 0, temp, dias, minima = 0;
        double TempMedia, mediaMes = 0, AcuTemp;

        do{
            System.out.print("¿De cuántos días se van a introducir temperaturas?: ");
            dias = sc.nextInt();
            sc.nextLine();
        }while(dias < 1);

        do{
            AcuTemp = 0;
            System.out.print("Introduzca el nombre del responsable de las mediciones: ");
            responsable = sc.nextLine();
            System.out.println("\nIntroduzca cuatro temperaturas diurnas:");
            for(int i = 0; i < 4; i++) AcuTemp += dataIn();
            TempMedia = media(AcuTemp, 4);
            System.out.println("La temperatura media diurna es: "+TempMedia+"ºC\n");
            mediaMes += TempMedia;
            AcuTemp = 0;

            System.out.println("\nIntroduzca cuatro temperaturas nocturnas:");
            for(int i = 0; i < 4; i++){
                temp = dataIn();
                if (temp < minima){
                    minima = temp;
                    respMin = responsable;
                }
                AcuTemp += temp;
            }
            System.out.println("La temperatura media nocturna es: "+media(AcuTemp, 4)+"ºC\n");
            cont++;
        }while(cont < dias);

        System.out.println("La temperatura nocturna más baja es: "
                +minima+"ªC y el responsable de la medición es: "+respMin);
        System.out.println("La temperatura media del periodo introducido es de "+media(mediaMes, dias)+"ºC");
    }

    public static double media(double num, int div){
        return num / div;
    }

    public static int dataIn(){
        Scanner sc = new Scanner(System.in);
        int temp;
        do {
            System.out.print("Introduzca la siguiente medición de temperatura: ");
            temp = sc.nextInt();
            sc.nextLine();
        } while(!(temp >= -20 && temp <= 0));
        System.out.println("Temperatura registrada correctamente");
        return temp;
    }
}
