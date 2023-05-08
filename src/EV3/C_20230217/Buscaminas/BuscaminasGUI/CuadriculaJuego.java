package EV3.C_20230217.Buscaminas.BuscaminasGUI;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Clase que simula el campo de juego del Buscaminas.
 *
 * @author Daniel Alonso Lázaro - 2023
 * @version 2.0
 */
public class CuadriculaJuego {

    // Atributos
    public static final int DIMENSION_POR_DEFECTO = 10;
    public static final int NUMERO_MINAS_POR_DEFECTO = 8;
    public static final int DIMENSION_FACIL = 5;
    public static final int NUMERO_MINAS_FACIL = 3;
    public static final int DIMENSION_MEDIO = 10;
    public static final int NUMERO_MINAS_MEDIO = 8;
    public static final int DIMENSION_DIFICIL = 15;
    public static final int NUMERO_MINAS_DIFICIL = 15;
    public static final int DIMENSION_PRO = 20;
    public static final int NUMERO_MINAS_PRO = 30;
    private static int dimensionUsuario;
    private static int numeroMinasUsuario;
    private static boolean facil;
    private static boolean medio;
    private static boolean dificil;
    private static boolean pro;
    private static int recuentoCeldas;
    private static int recuentoBanderas;
    private final int FILAS;
    private final int COLUMNAS;
    private final int MINAS;
    private Celda[][] celdas;
    private boolean perdido;

    // Constructor
    public CuadriculaJuego(int FILAS, int COLUMNAS, int MINAS) {
        this.FILAS = FILAS;
        this.COLUMNAS = COLUMNAS;
        this.MINAS = MINAS;
        recuentoCeldas = FILAS * COLUMNAS - MINAS;
        recuentoBanderas = MINAS;
        inicializarCeldas();
    }

    // Getters
    public static int getDimensionUsuario() {
        return dimensionUsuario;
    }

    public static void setDimensionUsuario(int dimensionUsuario) {
        CuadriculaJuego.dimensionUsuario = dimensionUsuario;
    }

    public static int getNumeroMinasUsuario() {
        return numeroMinasUsuario;
    }

    public static void setNumeroMinasUsuario(int numeroMinasUsuario) {
        CuadriculaJuego.numeroMinasUsuario = numeroMinasUsuario;
    }

    public static boolean isFacil() {
        return facil;
    }

    public static void setFacil(boolean facil) {
        CuadriculaJuego.facil = facil;
    }

    public static boolean isMedio() {
        return medio;
    }

    public static void setMedio(boolean medio) {
        CuadriculaJuego.medio = medio;
    }

    public static boolean isDificil() {
        return dificil;
    }

    public static void setDificil(boolean dificil) {
        CuadriculaJuego.dificil = dificil;
    }

    public static boolean isPro() {
        return pro;
    }

    public static void setPro(boolean pro) {
        CuadriculaJuego.pro = pro;
    }

    /**
     * Selecciona el modo de juego que se va a jugar según la dificultad seleccionada.
     *
     * @param frame El frame que se va a cerrar.
     * @return CuadriculaJuego El campo de juego.
     */
    public static CuadriculaJuego seleccionModoJuego(JFrame frame) {
        if (CuadriculaJuego.getDimensionUsuario() != 0 && CuadriculaJuego.getNumeroMinasUsuario() != 0) {
            frame.dispose();
            return new CuadriculaJuego(CuadriculaJuego.getDimensionUsuario(), CuadriculaJuego.getDimensionUsuario(), CuadriculaJuego.getNumeroMinasUsuario());
        } else if (CuadriculaJuego.isFacil()) {
            frame.dispose();
            return new CuadriculaJuego(CuadriculaJuego.DIMENSION_FACIL, CuadriculaJuego.DIMENSION_FACIL, CuadriculaJuego.NUMERO_MINAS_FACIL);
        } else if (CuadriculaJuego.isMedio()) {
            frame.dispose();
            return new CuadriculaJuego(CuadriculaJuego.DIMENSION_MEDIO, CuadriculaJuego.DIMENSION_MEDIO, CuadriculaJuego.NUMERO_MINAS_MEDIO);
        } else if (CuadriculaJuego.isDificil()) {
            frame.dispose();
            return new CuadriculaJuego(CuadriculaJuego.DIMENSION_DIFICIL, CuadriculaJuego.DIMENSION_DIFICIL, CuadriculaJuego.NUMERO_MINAS_DIFICIL);
        } else if (CuadriculaJuego.isPro()) {
            frame.dispose();
            return new CuadriculaJuego(CuadriculaJuego.DIMENSION_PRO, CuadriculaJuego.DIMENSION_PRO, CuadriculaJuego.NUMERO_MINAS_PRO);
        } else {
            frame.dispose();
            return new CuadriculaJuego(CuadriculaJuego.DIMENSION_POR_DEFECTO, CuadriculaJuego.DIMENSION_POR_DEFECTO, CuadriculaJuego.NUMERO_MINAS_POR_DEFECTO);
        }
    }

    /**
     * Setea la dificultad de todas las variables que controlan la dificultad.
     */
    public static void setDificultad(boolean... dificultades) {
        CuadriculaJuego.setFacil(dificultades[0]);
        CuadriculaJuego.setMedio(dificultades[1]);
        CuadriculaJuego.setDificil(dificultades[2]);
        CuadriculaJuego.setPro(dificultades[3]);
    }

    public boolean isGanado() {
        return recuentoCeldas == 0;
    }

    public boolean isPerdido() {
        return perdido;
    }

    // Setters

    public int getRecuentoBanderas() {
        return recuentoBanderas;
    }

    public void setRecuentoBanderas(int recuento) {
        recuentoBanderas = recuento;
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
                celdas[i][j] = new Celda();
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
                celdas[posTempX][posTempY].setImagen(celdas[posTempX][posTempY].getBOMBA());
                minasGeneradas++;
            }
        }
        actualizarVecinos();
    }

    /**
     * Método que actualiza el número de minas alrededor de las ocho celdas adyacentes a la que contiene una mina.
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
     * Método que devuelve una lista de objetos de tipo Celda con las celdas vecinas a la celda que se le pasa
     * como parámetro.
     *
     * @param filaX    Fila de la celda.
     * @param columnaY Columna de la celda.
     * @return Lista con las celdas vecinas.
     */
    private List<Celda> getCeldasVecinas(int filaX, int columnaY) {
        List<Celda> listaCeldasVecinas = new LinkedList<>();
        int CELDAS_VECINAS = 8;
        for (int i = 0; i < CELDAS_VECINAS; i++) {
            int fila = filaX;
            int columna = columnaY;
            switch (i) {
                case 0 -> {
                    fila--; // Izquierda
                    columna--; // Arriba
                }
                case 1 -> fila--; // Izquierda
                case 2 -> {
                    fila--; // Izquierda
                    columna++; // Abajo
                }
                case 3 -> columna--; // Arriba
                case 4 -> columna++; // Abajo
                case 5 -> {
                    fila++; // Derecha
                    columna--; // Arriba
                }
                case 6 -> fila++; // Derecha
                case 7 -> {
                    fila++; // Derecha
                    columna++; // Abajo
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
     * Si es una mina, setea el atributo perdido a true, descubre todas las minas y setea el emoji de la celda
     * seleccionada al emoji de mina explotada.
     * Si no es una mina, llama al método abrirEnCascada().
     * Si isGanado() es true, llama al método loopSeteoFinDeJuego() y el juego acaba.
     *
     * @param posX Fila de la celda seleccionada.
     * @param posY Columna de la celda seleccionada.
     */
    public void actualizarTablero(int posX, int posY) {
        if (celdas[posX][posY].isMina()) {
            perdido = true;
            loopSeteoFinDeJuego();
            celdas[posX][posY].setImagen(celdas[posX][posY].getBOMBA_EXPLOTADA());
        } else if (!celdas[posX][posY].isDescubierta()) {
            abrirEnCascada(posX, posY);
        } else if (isGanado()) {
            loopSeteoFinDeJuego();
        }
    }

    /**
     * Método que abre casillas a 0 automáticamente y se detiene en las casillas con un 1 o mayor.
     *
     * @param posX Posición de la fila seleccionada
     * @param posY Posición de la columna seleccionada
     */
    public void abrirEnCascada(int posX, int posY) {
        if ((posX < 0 || posX >= celdas.length) || (posY < 0 || posY >= celdas[0].length)) return;
        else if (celdas[posX][posY].isMina()) return;
        else if (celdas[posX][posY].isDescubierta()) return;
        else if (celdas[posX][posY].getNumeroMinasAlrededor() >= 1) {
            celdas[posX][posY].setDescubierta(true);
            recuentoCeldas--;
            return;
        } else if (celdas[posX][posY].getNumeroMinasAlrededor() == 0) {
            celdas[posX][posY].setDescubierta(true);
            recuentoCeldas--;
            abrirEnCascada(posX + 1, posY);
            abrirEnCascada(posX - 1, posY);
            abrirEnCascada(posX + 1, posY + 1);
            abrirEnCascada(posX + 1, posY - 1);
            abrirEnCascada(posX, posY + 1);
            abrirEnCascada(posX, posY - 1);
            abrirEnCascada(posX - 1, posY - 1);
            abrirEnCascada(posX - 1, posY + 1);
        }
        return;
    }

    /**
     * Itera sobre las celdas, si son minas, las descubre y setea la imagen BOMBA.
     * Si es una celda vacía y tiene una bandera, setea la imagen NO_BOMBA.
     */
    public void loopSeteoFinDeJuego() {
        for (Celda[] celda : celdas) {
            for (Celda valor : celda) {
                if (valor.isMina()) {
                    valor.setDescubierta(true);
                    valor.setImagen(valor.getBOMBA());
                }
                if (!valor.isDescubierta() && valor.isBandera() && !valor.isMina()) {
                    valor.setImagen(valor.getNO_BOMBA());
                }
                if (valor.isMina() && !valor.isDescubierta()) {
                    valor.setImagen(valor.getBANDERA());
                }
            }
        }
    }

    /**
     * Método que imprime de forma básica el campo de juego con la posición de las bombas para debugging.
     *
     * @return String con el campo de juego.
     */
    @Override
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
