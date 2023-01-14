package ProgramasPruebas;

import java.util.Scanner;

public class Examen1Ev {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ageMedian = 0, sumAgeMedian = 0, countAgeMedian = 0, countDoCelebrateP = 0, countDoCelebrateR = 0,
                countDoCelebrateK = 0, countDoCelebrate = 0, countHasKids = 0, countHasKidsS = 0, countHasKidsN = 0;
        int reyes, papa, ninguna, media, kids;
        char doCelebrate = 0, hasKids = 0;
        String answerDoCelebrate, answerHasKids;

        for(int i = 0; i < 5; i++){
            System.out.println("INTRODUZCA LOS DATOS DE LA CALLE Nº"+(i+1));
            countAgeMedian = 0;
            sumAgeMedian = 0;
            countDoCelebrate = 0;
            countDoCelebrateP = 0;
            countDoCelebrateR = 0;
            countDoCelebrateK = 0;
            countHasKids = 0;
            countHasKidsS = 0;
            countHasKidsN = 0;
            do{
                do{
                    System.out.print("Introduzca la edad media de los habitantes del domicilio: ");
                    ageMedian = sc.nextInt();
                    sc.nextLine();
                    if(ageMedian < 0) System.out.println("Por favor introduzca una edad media mayor que 0: ");
                }while(ageMedian < 0);

                sumAgeMedian += ageMedian;
                System.out.println(sumAgeMedian);
                countAgeMedian++;

                do{
                    if(ageMedian != 0){
                        System.out.print("Introduzca si celebran Papá Noel (P) o Reyes Magos (R): ");
                        answerDoCelebrate = sc.nextLine().toUpperCase();
                        doCelebrate = answerDoCelebrate.charAt(0);
                        if(doCelebrate != 'P' && doCelebrate != 'R' && doCelebrate != 'K')
                            System.out.println("Por favor introduzca el caracter P para Papá Noel o el caracter R para Reyes Magos.");
                        if(doCelebrate == 'P') countDoCelebrateP++;
                        else if(doCelebrate == 'R') countDoCelebrateR++;
                        else if(doCelebrate == 'K') countDoCelebrateK++;
                    }
                }while(doCelebrate != 'K' ^ doCelebrate != 'P' ^ doCelebrate != 'R');

                countDoCelebrate++;

                do{
                    if(ageMedian != 0){
                        System.out.print("Introduzca si hay niños o no en la casa: (S/N) ");
                        answerHasKids = sc.nextLine().toUpperCase();
                        hasKids = answerHasKids.charAt(0);
                        if(hasKids != 'S' && hasKids != 'N') System.out.println("Por favor introduzca S para sí y N para no.");
                        if(hasKids == 'S') countHasKidsS++;
                        else if(hasKids == 'N') countHasKidsN++;
                    }
                }while(hasKids != 'S' && hasKids != 'N');

                countHasKids++;

            }while(ageMedian != 0);

            reyes = Math.round((countDoCelebrateR * 100 / (countDoCelebrate-1)));
            papa = Math.round((countDoCelebrateP * 100 / (countDoCelebrate-1)));
            ninguna = Math.round((countDoCelebrateK * 100 / (countDoCelebrate-1)));

            System.out.println(reyes+"% celebran Reyes Magos");
            System.out.println(papa+"% celebran Papa Noel");
            System.out.println(ninguna+"% no celebran nada");

            media = sumAgeMedian/(countAgeMedian-1);

            System.out.println("Edad media:"+(media)+" años");

            kids = (countHasKidsS * 100 / (countHasKids-1));

            System.out.println(Math.round(kids)+"% de casas con niños");

            if(reyes + papa >= 50) System.out.println("La calle se adornará con DECORACIÓN NAVIDEÑA CONVENCIONAL");

            else if(kids >= 50){
                if(papa > 50) System.out.println("Además, el día de Navidad se situará un PAPA NOEL");
                else if (reyes > 50) System.out.println("Además, el día de Navidad se situará un REY MAGO");
                else if (ninguna > 50) System.out.println("Además, el día de Navidad se situará un TADEO JONES");
            }
        }
    }
}