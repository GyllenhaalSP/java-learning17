package EV3.examenteorico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainEj2 {
    static final String RUTA_FICHERO = "input.txt";
    public static void main(String[] args) {

        String linea;
        try(BufferedReader lectorBuffer = new BufferedReader(new FileReader(RUTA_FICHERO))){
            int contadorLineas = 1;
            while((linea = lectorBuffer.readLine()) != null){
                System.out.println("Linea " + contadorLineas++ + ": '" + linea + "'");
            }
        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException capturada: " + e.getMessage());
        }catch (IOException e){
            System.out.println("IOException capturada: " + e.getMessage());
        }
    }
}
