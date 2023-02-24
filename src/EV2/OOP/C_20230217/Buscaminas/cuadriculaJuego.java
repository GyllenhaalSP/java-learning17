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
    Celda[][] celdas;
    int filaX;
    int columnaY;
    final int MINAS;
    boolean juegoTerminado = false;
    final int CELDAS_VECINAS = 8;
    final String[] EMOJIS_DIGITOS_CELDAS = {"0️ ", "1️ ", "2️ ", "3️ ", "4️ ", "5️ ",
            "6️ ", "7️ ", "8️ ", "9️ ", "\uD83D\uDD1F "};

    // Constructor
    public cuadriculaJuego(int filaX, int columnaY, int MINAS) {
        this.filaX = filaX;
        this.columnaY = columnaY;
        this.MINAS = MINAS;
    }

    // Getters
    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    // Métodos
    /**
     * Método que inicializa las celdas del campo de juego.
     */
    public void inicializarCeldas() {
        celdas = new Celda[this.filaX][this.columnaY];
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
        if (this.celdas[posX][posY].isMina()) {
            juegoTerminado = true;
            this.celdas[posX][posY].setExplosion("\uD83D\uDCA5 ");
            for (Celda[] celda : this.celdas) {
                for (Celda valor : celda) {
                    if (valor.isMina()) {
                        valor.setDescubierta(true);
                    }
                }
            }
        }else if (!this.celdas[posX][posY].isDescubierta()){
            abrirEnCascada(posX, posY);
        }
    }

    /**
     * Método que imprime el tablero por pantalla.
     */
    public void imprimirTablero() {
        System.out.print("    ");
        for (int i = 0; i < celdas.length; i++){
            System.out.printf("%s", EMOJIS_DIGITOS_CELDAS[i+1]);
        }
        System.out.println();
        for (int i = 0; i < celdas.length; i++) {
            System.out.printf((i == 9?"%1d| ":"%2d| "), i+1);
            for (int j = 0; j < celdas[i].length; j++) {
                if(celdas[i][j].isDescubierta() && celdas[i][j].isMina()) {
                    if (celdas[i][j].getExplosion().equals("")) { // Si no es una mina explotada
                        System.out.print("\uD83D\uDCA3 ");
                    }else {
                        System.out.print(celdas[i][j].getExplosion());
                    }
                }else if(celdas[i][j].isDescubierta() && !celdas[i][j].isMina()) {
                    System.out.print(EMOJIS_DIGITOS_CELDAS[celdas[i][j].getNumeroMinasAlrededor()]);
                }else {
                    System.out.print("\uD83D\uDFE9 ");
                }
            }
            System.out.println(" ");
        }
    }

    /**
     * Método que abre casillas a 0 automáticamente y se detiene en las casillas con un 1.
     * @param posX - Posición X
     * @param posY - Posición Y
     */
    public void abrirEnCascada(int posX, int posY){
        if (posX < 0 || posX >= celdas.length || posY < 0 || posY >= celdas[0].length) return;
        else if (celdas[posX][posY].isMina()) return;
        else if (celdas[posX][posY].isDescubierta()) return;
        else if (celdas[posX][posY].getNumeroMinasAlrededor() > 0) {
            celdas[posX][posY].setDescubierta(true);
            return;
        }else if (celdas[posX][posY].getNumeroMinasAlrededor() == 0){
            celdas[posX][posY].setDescubierta(true);
            abrirEnCascada(posX + 1, posY);
            abrirEnCascada(posX - 1, posY);
            abrirEnCascada(posX, posY + 1);
            abrirEnCascada(posX, posY - 1);
        }
        return;
    }

    /**
     * Método que imprime el campo de juego según la opción elegida:
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
