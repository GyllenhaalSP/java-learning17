package EV3.C_20230217.Buscaminas.BuscaminasGUI;

/**
 * Clase que simula una celda del Buscaminas.
 *
 * @author Daniel Alonso Lázaro - 2023
 * @version 2.0
 */
public class Celda {
    // Atributos
    static final private String BOMBA = "resources/buscaminas/BOMBA.png";
    static final private String BOMBA_EXPLOTADA = "resources/buscaminas/BOMBA_EXPLOTADA.png";
    static final private String BANDERA = "resources/buscaminas/BANDERA.png";
    static final private String NO_BOMBA = "resources/buscaminas/NO_BOMBA.png";
    static final private String VACIA = "resources/buscaminas/VACIA.png";
    static final private String[] DIGITOS_CELDAS = {"resources/buscaminas/VACIA.png", "resources/buscaminas/UNO.png", "resources/buscaminas/DOS.png", "resources/buscaminas/TRES.png", "resources/buscaminas/CUATRO.png", "resources/buscaminas/CINCO.png", "resources/buscaminas/SEIS.png", "resources/buscaminas/SIETE.png", "resources/buscaminas/OCHO.png"};
    private int numeroMinasAlrededor;
    private boolean mina;
    private boolean vacia;
    private boolean bandera;
    private boolean descubierta;
    private String imagen;

    // Constructor
    public Celda() {
        this.imagen = VACIA;
        this.vacia = true;
    }

    // Getters y setters
    public int getNumeroMinasAlrededor() {
        return numeroMinasAlrededor;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }

    public void setVacia(boolean vacia) {
        this.vacia = vacia;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getBOMBA() {
        return BOMBA;
    }

    public String getBOMBA_EXPLOTADA() {
        return BOMBA_EXPLOTADA;
    }

    public String getBANDERA() {
        return BANDERA;
    }

    public String getNO_BOMBA() {
        return NO_BOMBA;
    }

    public String[] getDIGITOS_CELDAS() {
        return DIGITOS_CELDAS;
    }

    //Métodos

    /**
     * Método que incrementa el número de minas cercanas de las celdas vecinas.
     */
    public void incrementarVecinos() {
        this.numeroMinasAlrededor++;
    }
}