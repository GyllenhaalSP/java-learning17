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
public class CuadriculaJuego {

    // Atributos
    public final int CELDAS_VECINAS = 8;
    private final int FILAS;
    private final int COLUMNAS;
    private final int MINAS;
    private Celda[][] celdas;
    private boolean perdido = false;
    static private int RECUENTO_CELDAS;

    // Constructor
    public CuadriculaJuego(int FILAS, int COLUMNAS, int MINAS) {
        this.FILAS = FILAS;
        this.COLUMNAS = COLUMNAS;
        this.MINAS = MINAS;
        RECUENTO_CELDAS = FILAS * COLUMNAS - MINAS;
    }

    // Getters
    public boolean isPerdido() {
        return perdido;
    }

    public boolean isGanado() {
        return RECUENTO_CELDAS == 0;
    }

    public Celda[][] getCeldas() {
        return celdas;
    }

    // Métodos
    /**
     * Método que inicializa las celdas del campo de juego.
     */
    public void inicializarCeldas() {
        celdas = new Celda[this.FILAS][this.COLUMNAS];
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
                celdas[posTempX][posTempY].setVacia(false);
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
            int fila = filaX;
            int columna = columnaY;
            switch (i) {
                case 0 -> { // Arriba izquierda
                    fila--;
                    columna--;
                }
                case 1 -> fila--; // Izquierda
                case 2 -> { // Abajo izquierda
                    fila--;
                    columna++;
                }
                case 3 -> columna--; // Arriba
                case 4 -> columna++; // Abajo
                case 5 -> { // Arriba derecha
                    fila++;
                    columna--;
                }
                case 6 -> fila++; // Derecha
                case 7 -> { // Abajo derecha
                    fila++;
                    columna++;
                }
            }
            if (fila >= 0 && fila < this.celdas.length && columna >= 0 && columna < this.celdas[0].length) {
                if (!this.celdas[fila][columna].isMina()) {
                    listaCeldasVecinas.add(this.celdas[fila][columna]);
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
        if (celdas[posX][posY].isMina()){
            perdido = true;
            loopSeteoFinDeJuego();
            celdas[posX][posY].setEmoji(celdas[posX][posY].getEMOJI_BOMBA_EXPLOTADA());
        }else if (!celdas[posX][posY].isDescubierta()){
            abrirEnCascada(posX, posY);
        }else if(isGanado()){
            loopSeteoFinDeJuego();
        }
    }

    /**
     * Método sobrecargado que actualiza la posición introducida por el usuario según la opción seleccionada en
     * el menú de juego. Si la opción es 2, se pone una bandera en la celda y se setea su Emoji.
     * Si la opción es 3, se quita la bandera y se restaura el Emoji original. Imprime un mensaje de error si al poner
     * la bandera la celda ya está descubierta o si al quitarla la celda no tiene bandera.
     * @param posX - Fila de la celda seleccionada.
     * @param posY - Columna de la celda seleccionada.
     * @param opt - Opción seleccionada en el menú de juego.
     * @throws InterruptedException - lanza InterruptedException.
     */
    public void actualizarTablero(int posX, int posY, int opt) throws InterruptedException {
        if (opt == 2 && celdas[posX][posY].isDescubierta()) {
            System.out.println("No puedes poner una bandera en una celda ya descubierta.");
            Thread.sleep(2500);
            return;
        }else if(opt == 3 && !celdas[posX][posY].isBandera()){
            System.out.println("No puedes quitar una bandera de una celda que no tiene bandera.");
            Thread.sleep(2500);
            return;
        }

        if (opt == 2 && !celdas[posX][posY].isDescubierta()
                && (celdas[posX][posY].isVacia() || celdas[posX][posY].isMina())){
            celdas[posX][posY].setEmoji(celdas[posX][posY].getEMOJI_BANDERA());
            celdas[posX][posY].setBandera(true);
        }else if (opt == 3 && celdas[posX][posY].isBandera()){
            if(celdas[posX][posY].isVacia()){
                celdas[posX][posY].setEmoji(celdas[posX][posY].getEMOJI_CELDA_VACIA());
            }else{
                celdas[posX][posY].setEmoji(celdas[posX][posY].getEMOJI_BOMBA());
            }
            celdas[posX][posY].setBandera(false);
        }
    }

    /**
     * Itera sobre las celdas, si son minas, las descubre y setea el emoji de bomba.
     * Si es una celda vacía y tiene una bandera, setea el emoji de no bomba.
     */
    public void loopSeteoFinDeJuego(){
        for (Celda[] celda : celdas) {
            for (Celda valor : celda) {
                if (valor.isMina()){
                    valor.setDescubierta(true);
                    valor.setEmoji(valor.getEMOJI_BOMBA());
                }
                if (valor.isVacia() && valor.isBandera() && !valor.isMina()){
                    valor.setEmoji(valor.getEMOJI_NO_BOMBA());
                }
            }
        }
    }

    /**
     * Método que imprime el tablero por pantalla.
     */
    public void imprimirTablero() {
        System.out.print("   \u2009");
        // Imprime los números de las columnas
        for (int i = 0; i < celdas.length; i++){
            imprimirDigitosCeldas(i);
        }
        System.out.println();
        for (int i = 0; i < celdas.length; i++) {
            imprimirDigitosCeldas(i);
            for (int j = 0; j < celdas[i].length; j++) {
                if (celdas[i][j].isDescubierta()){
                    if (celdas[i][j].isBandera()){
                        if (celdas[i][j].isMina()) {
                            System.out.print(celdas[i][j].getEmoji());
                        }else{
                            System.out.print(celdas[i][j].getEMOJI_CELDA_VACIA());
                        }
                    }else{
                        if (celdas[i][j].isMina()){
                            System.out.print(celdas[i][j].getEmoji());
                        }else {
                            System.out.print(celdas[i][j].getEMOJIS_DIGITOS_CELDAS()[celdas[i][j].getNumeroMinasAlrededor()]);
                        }
                    }
                }else{
                    if(celdas[i][j].isBandera()) {
                        System.out.print(celdas[i][j].getEmoji());
                    }else{
                        System.out.print(celdas[i][j].getEMOJI_CELDA_VACIA());
                    }
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
        if ((posX < 0 || posX >= celdas.length) || (posY < 0 || posY >= celdas[0].length)) return;
        else if (celdas[posX][posY].isMina()) return;
        else if (celdas[posX][posY].isDescubierta()) return;
        else if (celdas[posX][posY].getNumeroMinasAlrededor() >= 1) {
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
     * Método que imprime los números de las columnas y filas.
     * @param i Posición de la fila o columna elegida.
     */
    private void imprimirDigitosCeldas(int i){
        System.out.printf("%s", celdas[i/celdas.length][i%celdas.length].getEMOJIS_DIGITOS_CELDAS()[i+1]);
    }

    /**
     * Método que imprime de forma básica el campo de juego para debugging según la opción elegida:
     *      <p style = "margin-top: 0em; text-indent: 1cm;">- "tablero" imprime el tablero con las posiciones vacías y las minas.</p>
     *      <p style = "margin-top: 0em; text-indent: 1cm;">- "pistas" imprime el tablero con las pistas de las casillas adyacentes a las minas.</p>
     *
     * @return String con el campo de juego.
     */
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (Celda[] celda : celdas) {
            for (Celda valor : celda) {
                resultado.append((valor.isMina() ? "☒ " : "☐ "));
            }
            resultado.append(" \n");
        }
        return resultado.toString();
    }
}