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
    String explosion;

    // Constructor
    public Celda(int filaX, int columnaY) {
        this.filaX = filaX;
        this.columnaY = columnaY;
        this.explosion = "";
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

    public String getExplosion() {
        return explosion;
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

    public void setExplosion(String explosion) {
        this.explosion = explosion;
    }

    //Métodos

    /**
     * Método que incrementa el número de minas cercanas de las celdas vecinas.
     */
    public void incrementarVecinos() {
        this.numeroMinasAlrededor++;
    }
}
