package EV3.examenteorico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainEj18 {
    static final String RUTA_FICHERO = "input.txt";

    public static void main(String[] args)  {

        String linea;
        try {
            BufferedReader lectorBuffer = new BufferedReader(new FileReader(RUTA_FICHERO));
            int contadorLineas = 1;
            while ((linea = lectorBuffer.readLine()) != null) {
                System.out.println("Linea " + contadorLineas++ + ": '" + linea + "'");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
