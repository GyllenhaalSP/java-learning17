package EV2.OOP.C_20230117;

/**
 * Main de la clase MiClase.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Ej_230117 {
    public static void main(String[] args) {
        MiClase objeto1 = new MiClase();
        MiClase objeto2 = new MiClase();

        objeto1.variableEnteraPublica = 10;
        objeto2.variableEnteraPublica = 20;
        //objeto1.nombrePrivado = "Pedro";
        objeto1.setNombrePrivado("Pedro");
        //objeto2.nombrePrivado = "Maria";
        objeto2.setNombrePrivado("Maria");

        System.out.println("En el objeto1 el atributo variableEnteraPublica tiene valor " +
                objeto1.variableEnteraPublica
                + " y el atributo nombrePrivado tiene valor '" + /*objeto1.nombrePrivado*/
                objeto1.getNombrePrivado() + ".'");
        System.out.println("En el objeto2 el atributo variableEnteraPublica tiene valor " +
                objeto2.variableEnteraPublica
                + " y el atributo nombrePrivado tiene valor '" + /*objeto2.nombrePrivado*/
                objeto2.getNombrePrivado() + ".'");
    }
}
