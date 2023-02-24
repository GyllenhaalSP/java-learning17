package EV2.OOP.C_20230217.Buscaminas;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Clase que simula el campo de juego del Buscaminas.
 *
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class cuadriculaJuego {

    // Atributos
    public final int CELDAS_VECINAS = 8;
    private final int FILA_X;
    private final int COLUMNA_Y;
    private final int MINAS;
    private Celda[][] celdas;
    private boolean haPerdido = false;
    static private int RECUENTO_CELDAS;

    // Constructor
    public cuadriculaJuego(int FILA_X, int COLUMNA_Y, int MINAS) {
        this.FILA_X = FILA_X;
        this.COLUMNA_Y = COLUMNA_Y;
        this.MINAS = MINAS;
        RECUENTO_CELDAS = FILA_X * COLUMNA_Y - MINAS;
    }

    // Getters
    public boolean isPerdido() {
        return haPerdido;
    }

    public boolean isGanado() {
        return RECUENTO_CELDAS == 0;
    }

    public int getRecuentoCeldas() {
        return RECUENTO_CELDAS;
    }

    // Métodos
    /**
     * Método que inicializa las celdas del campo de juego.
     */
    public void inicializarCeldas() {
        celdas = new Celda[this.FILA_X][this.COLUMNA_Y];
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                celdas[i][j] = new Celda(i, j);
            }
        }
        generarMinas();
    }

    /**
     * Método que genera las minas en el campo de juego.
     */
    private void generarMinas() {
        int minasGeneradas = 0;
        Random rand = new Random();
        while (minasGeneradas < MINAS) {
            int posTempX = rand.nextInt(celdas.length);
            int posTempY = rand.nextInt(celdas[0].length);
            if (!celdas[posTempX][posTempY].isMina()) {
                celdas[posTempX][posTempY].setMina(true);
                celdas[posTempX][posTempY].setEmoji(celdas[posTempX][posTempY].getEMOJI_BOMBA());
                minasGeneradas++;
            }
        }
        actualizarVecinos();
    }

    /**
     * Método que actualiza el número de minas alrededor de cada celda que contiene una mina.
     */
    private void actualizarVecinos() {
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                if (celdas[i][j].isMina()) {
                    List<Celda> celdasVecinas = getCeldasVecinas(i, j);
                    for (Celda celda : celdasVecinas) {
                        celda.incrementarVecinos();
                    }
                }
            }
        }
    }

    /**
     * Método que devuelve una lista con las celdas vecinas a la celda que se le pasa como parámetro.
     *
     * @param filaX    Fila de la celda.
     * @param columnaY Columna de la celda.
     * @return Lista con las celdas vecinas.
     */
    private List<Celda> getCeldasVecinas(int filaX, int columnaY) {
        List<Celda> listaCeldasVecinas = new LinkedList<>();
        for (int i = 0; i < CELDAS_VECINAS; i++) {
            int tempX = filaX;
            int tempY = columnaY;
            switch (i) {
                case 0 -> { // Arriba izquierda
                    tempX--;
                    tempY--;
                }
                case 1 -> tempX--; // Izquierda
                case 2 -> { // Abajo izquierda
                    tempX--;
                    tempY++;
                }
                case 3 -> tempY--; // Arriba
                case 4 -> tempY++; // Abajo
                case 5 -> { // Arriba derecha
                    tempX++;
                    tempY--;
                }
                case 6 -> tempX++; // Derecha
                case 7 -> { // Abajo derecha
                    tempX++;
                    tempY++;
                }
            }
            if (tempX >= 0 && tempX < this.celdas.length && tempY >= 0 && tempY < this.celdas[0].length) {
                if (!this.celdas[tempX][tempY].isMina()) {
                    listaCeldasVecinas.add(this.celdas[tempX][tempY]);
                }
            }
        }
        return listaCeldasVecinas;
    }

    /**
     * Método que actualiza la posición introducida por el usuario y comprueba si es una mina o no.
     * Si es una mina, setea el atributo juegoTerminado a true y descubre todas las minas.
     * Si no es una mina, setea la celda a descubierta.
     * @param posX Fila de la celda seleccionada.
     * @param posY Columna de la celda seleccionada.
     */
    public void actualizarTablero(int posX, int posY) {
        if (celdas[posX][posY].isMina()) {
            haPerdido = true;
            celdas[posX][posY].setEmoji(celdas[posX][posY].getEMOJI_BOMBA_EXPLOTADA());
            for (Celda[] celda : celdas) {
                for (Celda valor : celda) {
                    if (valor.isMina()) {
                        valor.setDescubierta(true);
                    }
                }
            }
        }else if (!celdas[posX][posY].isDescubierta()){
            abrirEnCascada(posX, posY);
        }
    }

    /**
     * Método que imprime el tablero por pantalla.
     */
    public void imprimirTablero() {
        System.out.print("    ");
        // Imprime los números de las columnas con el array de emojis de dígitos
        for (int i = 0; i < celdas.length; i++){
            System.out.printf("%s", celdas[i/celdas.length][i%celdas.length].getEMOJIS_DIGITOS_CELDAS()[i+1]);
        }
        System.out.println();
        for (int i = 0; i < celdas.length; i++) {
            System.out.printf((i == 9?"%1d| ":"%2d| "), i+1); // Imprime los números de las filas
            for (int j = 0; j < celdas[i].length; j++) {
                //Si está descubierta y es una mina
                if(celdas[i][j].isDescubierta() && celdas[i][j].isMina()) {
                    // Si el emoji es una bomba, imprime el emoji bomba, si no, imprime el emoji explosión
                    if (celdas[i][j].getEmoji().equals(celdas[i][j].getEMOJI_BOMBA())) {
                        System.out.print(celdas[i][j].getEmoji());
                    }else {
                        System.out.print(celdas[i][j].getEmoji());
                    }
                /*Si está descubierta y no es una mina, imprime el emoji con el número de minas alrededor
                si no, imprime el emoji de la celda vacía.*/
                }else if(celdas[i][j].isDescubierta() && !celdas[i][j].isMina()) {
                        System.out.print(celdas[i][j]
                                .getEMOJIS_DIGITOS_CELDAS()[celdas[i][j]
                                .getNumeroMinasAlrededor()]);
                }else {
                    System.out.print(celdas[i][j].getEMOJI_CELDA_VACIA());
                }
            }
            System.out.println(" ");
        }
    }

    /**
     * Método que abre casillas a 0 automáticamente y se detiene en las casillas con un 1.
     * @param posX Posición de la fila elegida
     * @param posY Posición de la columna elegida
     */
    public void abrirEnCascada(int posX, int posY){
        if (posX < 0 || posX >= celdas.length || posY < 0 || posY >= celdas[0].length) return;
        else if (celdas[posX][posY].isMina()) return;
        else if (celdas[posX][posY].isDescubierta()) return;
        else if (celdas[posX][posY].getNumeroMinasAlrededor() > 0) {
            celdas[posX][posY].setDescubierta(true);
            RECUENTO_CELDAS--;
            return;
        }else if (celdas[posX][posY].getNumeroMinasAlrededor() == 0){
            celdas[posX][posY].setDescubierta(true);
            RECUENTO_CELDAS--;
            abrirEnCascada(posX + 1, posY);
            abrirEnCascada(posX - 1, posY);
            abrirEnCascada(posX, posY + 1);
            abrirEnCascada(posX, posY - 1);
        }
        return;
    }

    /**
     * Método que imprime de forma básica el campo de juego para debugging según la opción elegida:
     *      <p style = "margin-top: 0em; text-indent: 1cm;">- "tablero" imprime el tablero con las posiciones vacías y las minas.</p>
     *      <p style = "margin-top: 0em; text-indent: 1cm;">- "pistas" imprime el tablero con las pistas de las casillas adyacentes a las minas.</p>
     *
     * @param opt Opción para formatear y mostrar diferentes estados del campo de juego.
     * @return String con el campo de juego.
     */
    public String toString(String opt) {
        StringBuilder resultado = new StringBuilder();
        switch (opt.toLowerCase()) {
            case "tablero" -> {
                for (int i = 0; i < celdas.length; i++) {
                    for (int j = 0; j < celdas[i].length; j++) {
                        resultado.append((celdas[i][j].isMina() ? "☒ " : "☐ "));
                    }
                    resultado.append(" \n");
                }
            }
            case "pista" -> {
                for (int i = 0; i < celdas.length; i++) {
                    for (int j = 0; j < celdas[i].length; j++) {
                        resultado.append(celdas[i][j].getNumeroMinasAlrededor());
                        resultado.append(" ");
                    }
                    resultado.append(" \n");
                }
            }
        }
        return resultado.toString();
    }
}
