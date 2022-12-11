package PROG.P_REF1EV.P_REF_2;

import java.util.Scanner;

import static ProgramasPruebas.metodos.dataIn;
import static ProgramasPruebas.metodos.media;

public class P_REF_2_3 {
    // Daniel Alonso Lázaro - 2022
    /*
    Nos dan los registros de temperaturas del último mes (noviembre de 2020) de la ciudad de Birobidzhan.
    Las temperaturas para cada día son 4 registros de las temperaturas diurnas y 4 de las temperaturas nocturnas.
    Además, pediremos que se introduzca el nombre del responsable que hizo las mediciones cada día.
    En la entrada de datos hay que validar que los valores de las temperaturas estén comprendidos entre 0º y -20º,
    de no ser así se mostrará el correspondiente mensaje por pantalla y se repetirá la petición de esa temperatura.
    Queremos que el programa calcule y muestre:
        a) Para cada día las temperaturas medias diurna y nocturna.
        b) Indicar al final del proceso qué día hemos tenido la temperatura nocturna más baja y
           el responsable de la medición ese día.
        c) Obtener la temperatura diurna media del mes.
    */
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
}
