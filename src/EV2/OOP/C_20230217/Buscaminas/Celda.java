package EV2.OOP.C_20230217.Buscaminas;

/**
 * Clase que simula una celda del Buscaminas.
 *
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Celda {

    // Atributos
    private int numeroMinasAlrededor;
    private boolean mina;
    private boolean vacia;
    private boolean bandera;
    private boolean descubierta;
    private String emoji;
    static final private String EMOJI_BOMBA = "\uD83D\uDCA3 ";
    static final private String EMOJI_BOMBA_EXPLOTADA = "\uD83D\uDCA5 ";
    static final private String EMOJI_BANDERA = "\uD83C\uDFF4\u200D☠️ ";
    static final private String EMOJI_CELDA_VACIA = "\uD83D\uDFE9 ";
    static final private String EMOJI_NO_BOMBA = "❌ ";
    static final private String[] EMOJIS_DIGITOS_CELDAS = {"0️ ", "1️ ", "2️ ", "3️ ", "4️ ", "5️ ",
            "6️ ", "7️ ", "8️ ", "9️ ", "\uD83D\uDD1F "};

    // Constructor
    public Celda() {
        this.emoji = EMOJI_CELDA_VACIA;
        this.vacia = true;
    }

    // Getters

    public int getNumeroMinasAlrededor() {
        return numeroMinasAlrededor;
    }

    public boolean isMina() {
        return mina;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public boolean isVacia() {
        return vacia;
    }

    public boolean isBandera() {
        return bandera;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getEMOJI_BOMBA() {
        return EMOJI_BOMBA;
    }

    public String getEMOJI_BOMBA_EXPLOTADA() {
        return EMOJI_BOMBA_EXPLOTADA;
    }

    public String getEMOJI_BANDERA() {
        return EMOJI_BANDERA;
    }

    public String getEMOJI_CELDA_VACIA() {
        return EMOJI_CELDA_VACIA;
    }

    public String getEMOJI_NO_BOMBA() {
        return EMOJI_NO_BOMBA;
    }

    public String[] getEMOJIS_DIGITOS_CELDAS() {
        return EMOJIS_DIGITOS_CELDAS;
    }

    // Setters

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public void setVacia(boolean vacia) {
        this.vacia = vacia;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    //Métodos

    /**
     * Método que incrementa el número de minas cercanas de las celdas vecinas.
     */
    public void incrementarVecinos() {
        this.numeroMinasAlrededor++;
    }
}