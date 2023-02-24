package EV2.OOP.C_20230217.Buscaminas;

/**
 * Clase que simula una celda del Buscaminas.
 *
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Celda {
    // Atributos
    private int filaX;
    private int columnaY;
    private int numeroMinasAlrededor;
    private boolean mina;
    private boolean descubierta;
    private String emoji;
    static final private String EMOJI_BOMBA = "\uD83D\uDCA3 ";
    static final private String EMOJI_BOMBA_EXPLOTADA = "\uD83D\uDCA5 ";
    static final private String EMOJI_BANDERA = "\uD83D\uDEA9 ";
    static final private String EMOJI_CELDA_VACIA = "\uD83D\uDFE9 ";
    static final private String[] EMOJIS_DIGITOS_CELDAS = {"0️ ", "1️ ", "2️ ", "3️ ", "4️ ", "5️ ",
            "6️ ", "7️ ", "8️ ", "9️ ", "\uD83D\uDD1F "};

    // Constructor
    public Celda(int filaX, int columnaY) {
        this.filaX = filaX;
        this.columnaY = columnaY;
        this.emoji = EMOJI_CELDA_VACIA;
    }

    // Getters

    public int getFilaX() {
        return filaX;
    }

    public int getColumnaY() {
        return columnaY;
    }

    public int getNumeroMinasAlrededor() {
        return numeroMinasAlrededor;
    }

    public boolean isMina() {
        return mina;
    }

    public boolean isDescubierta() {
        return descubierta;
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

    public String[] getEMOJIS_DIGITOS_CELDAS() {
        return EMOJIS_DIGITOS_CELDAS;
    }

    // Setters

    public void setFilaX(int filaX) {
        this.filaX = filaX;
    }

    public void setColumnaY(int columnaY) {
        this.columnaY = columnaY;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
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
