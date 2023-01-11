package EV1.P_4.P_4_2;

import java.util.Scanner;

public class P_4_2_3_concatenacionNombre {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos por teclado y por separado el nombre del alumno de clase y sus
    apellidos (3 identificadores). Queremos como resultado final que todo esté en
    una única cadena. (concat(String))
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pos1, pos2, pos3, resultado ="";

        System.out.print("Introduce el primer nombre: ");
        pos1 = sc.nextLine();
        System.out.print("Introduce el segundo nombre: ");
        pos2 = sc.nextLine();
        System.out.print("Introduce el tercer nombre: ");
        pos3 = sc.nextLine();

        resultado = resultado.concat(pos1+" ").concat(pos2+" ").concat(pos3+" ");

        System.out.println(resultado);
    }
}
