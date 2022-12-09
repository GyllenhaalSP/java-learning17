package ProgramasPruebas;

public class esDNI {
    // Daniel Alonso Lázaro - 2022 - de Wikipedia
    public static boolean esValidoNIF(String nif){
        char letraNIF = nif.charAt(8);
        String letrasControl = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (nif.length()!=9){
            return false;
        }

        nif = nif.toUpperCase();
        String numeroNIF = nif.substring(0, nif.length()-1).replace("X", "0")
                .replace("Y", "1").replace("Z", "2");

        return letraNIF == letrasControl.charAt(Integer.parseInt(numeroNIF) % 23);
    }
}