package EV2.OOP.C_20230202;

/**
 * Clase que simula una persona.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Persona {
    // Atributos o Variables de clase
    private final String nombre;
    protected int alturaCm;
    protected int pesoKg;
    private final int edad;

    // Constructor
    public Persona(String nombre, int alturaCm, int pesoKg, int edad) {
        this.nombre = nombre;
        this.alturaCm = alturaCm;
        this.pesoKg = pesoKg;
        this.edad = edad;
    }

    // Métodos
    public void correr(){
        System.out.println("Me llamo "+nombre+", tengo "+edad+" años y estoy corriendo!");
    }

    public void comer(){
        System.out.println("Me llamo "+nombre+", peso "+pesoKg+" kilos y no debería comer tanto.");
    }

    public void dormir(){
        System.out.println("Me llamo "+nombre+", mido "+(alturaCm/100.0)+" metros y no quepo en la cama!");
    }
}
