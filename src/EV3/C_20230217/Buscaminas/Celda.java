package EV3.C_20230217.Buscaminas;

/**
 * Clase que simula una celda del Buscaminas.
 *
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Celda {

    // Atributos
    static final private String EMOJI_BOMBA = "\uD83D\uDCA3 ";
    static final private String EMOJI_BOMBA_EXPLOTADA = "\uD83D\uDCA5 ";
    static final private String EMOJI_BANDERA = "\uD83C\uDFF4\u200D ";
    static final private String EMOJI_CELDA_VACIA = "\uD83D\uDFE9 ";
    static final private String[] EMOJIS_DIGITOS_CELDAS = {"0️⃣ ", "1️⃣ ", "2️⃣ ", "3️⃣ ", "4️⃣ ", "5️⃣ ", "6️⃣ ", "7️⃣ ",
            "8️⃣ ", "9️⃣ ", "\uD83D\uDD1F "};
    static final private String EMOJI_NO_BOMBA = "❌ ";
    private int numeroMinasAlrededor;
    private boolean mina;
    private boolean vacia;
    private boolean bandera;
    private boolean descubierta;
    private String emoji;

    // Constructor
    public Celda() {
        this.emoji = EMOJI_CELDA_VACIA;
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

    public boolean isVacia() {
        return vacia;
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

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
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

    //Métodos

    /**
     * Método que incrementa el número de minas cercanas de las celdas vecinas.
     */
    public void incrementarVecinos() {
        this.numeroMinasAlrededor++;
    }
}