package EV3.examenteorico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainEj10 {
    static final String RUTA_FICHERO = "input.txt";

    public static void main(String[] args) {
        try{
            leerFichero();
        }catch (FileNotFoundException e){
            System.out.println("Hemos capturado FileNotFoundException: " + e.getMessage());
        }catch (IOException e){
            System.out.println("Hemos capturado IOException: " + e.getMessage());
        }
    }

    static void leerFichero() throws IOException{
        String linea;
        BufferedReader lectorBuffer;
        lectorBuffer = new BufferedReader(new FileReader(RUTA_FICHERO));

        int contadorLineas = 1;
        while ((linea = lectorBuffer.readLine()) != null){
            System.out.println("Linea " + contadorLineas++ + ": '" + linea + "'");
        }
    }
}
