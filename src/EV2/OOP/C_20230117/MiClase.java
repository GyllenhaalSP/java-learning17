package EV2.OOP.C_20230117;

/**
 * Clase que muestra el uso de atributos públicos y privados.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class MiClase {
    public int variableEnteraPublica;
    private String nombrePrivado;

    public void setNombrePrivado(String nombrePrivado) {
        this.nombrePrivado = nombrePrivado;
    }

    public String getNombrePrivado() {
        return nombrePrivado;
    }
}
