package EV1.P_4.P_4_4;

public class P_4_4_2_discernidor {
    // Daniel Alonso Lázaro - 2022
    /*
    Capturamos un carácter y debemos indicar si está en mayúscula, en
    minúscula, es un dígito o cualquier otro carácter.
    */
    public static void main(String[] args) {
        System.out.print("Introduce un caracter: ");
        char caracter = new java.util.Scanner(System.in).nextLine().charAt(0);
        if (Character.isDigit(caracter)) {
            System.out.println("Es un dígito");
        }else if (Character.isUpperCase(caracter)) {
            System.out.println(caracter+" es mayúscula.");
        } else if (Character.isLowerCase(caracter)) {
            System.out.println(caracter+" es minúscula.");
        } else {
            System.out.println(caracter+" es un caracter especial.");
        }
    }

}
