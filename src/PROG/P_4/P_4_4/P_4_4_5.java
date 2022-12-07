package PROG.P_4.P_4_4;

import java.io.IOException;
import java.util.Scanner;

public class P_4_4_5 {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce las horas: ");
        int hours = sc.nextInt();
        System.out.print("Introduce los minutos: ");
        int minutes = sc.nextInt();
        System.out.print("Introduce los segundos: ");
        int seconds = sc.nextInt();
        String reloj;
        while(true) {
            while (hours < 24) {
                while (minutes < 60) {
                    while (seconds < 60) {
                        reloj = (hours < 10 ? "0" + hours : hours) + ":" +
                                (minutes < 10 ? "0" + minutes : minutes) + ":" +
                                (seconds < 10 ? "0" + seconds : seconds);
                        System.out.println(reloj);
                        Thread.sleep(1020);
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        seconds++;
                    }
                    seconds = 0;
                    minutes++;
                }
                minutes = 0;
                hours++;
            }
            hours = 0;
        }
    }
}
