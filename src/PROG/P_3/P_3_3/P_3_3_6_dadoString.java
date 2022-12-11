package PROG.P_3.P_3_3;

import static ProgramasPruebas.metodos.dado;

public class P_3_3_6_dadoString {
//    Realiza un programa que pida por teclado el resultado (dato entero) obtenido al lanzar un dado
//    de seis caras y muestre por pantalla el número en letras (dato cadena) de la cara opuesta al
//    resultado obtenido.
//        • Nota 1: En las caras opuestas de un dado de seis caras están los números: 1-6, 2-5 y 3-4.
//        • Nota 2: Si el número del dado introducido es menor que 1 o mayor que 6, se mostrará el mensaje:
//        “ERROR: número incorrecto.”.
//    Ejemplo:
//        Introduzca número del dado: 5
//        En la cara opuesta está el "dos".

    public static void main(String[] args) {
        int cara = dado();
        switch (cara){
            case 1: case 6:
                if (cara == 1)
                    System.out.println("En la cara opuesta está el \"seis\".");
                else
                    System.out.println("En la cara opuesta está el \"uno\".");
                break;
            case 2: case 5:
                if (cara == 2)
                    System.out.println("En la cara opuesta está el \"cinco\".");
                else
                    System.out.println("En la cara opuesta está el \"dos\".");
                break;
            default:
                if (cara == 3)
                    System.out.println("En la cara opuesta está el \"cuatro\".");
                else
                    System.out.println("En la cara opuesta está el \"tres\".");
        }
    }
}
