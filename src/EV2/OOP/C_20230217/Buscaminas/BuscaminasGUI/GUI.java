package EV2.OOP.C_20230217.Buscaminas.BuscaminasGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase GUI.
 * Clase que crea la interfaz gráfica dentro del juego.
 *
 * @author Daniel Alonso Lázaro - 2023
 * @version 2.0
 */
public class GUI extends MouseAdapter implements ActionListener {
    public static final int GENERAL_FONT_SIZE = 30;
    public static final int TITLE_FONT_SIZE = 40;
    public static final int HELP_TEXT_FONT_SIZE = 20;
    public static final float GUI_RESIZING_VALUE = 0.09f;
    public static final String DEFAULT_FONT = "MV Boli";
    protected static int width = 700;
    protected static int height = 700;
    private final CuadriculaJuego cuadriculaJuego;
    private final Timer timer;
    JFrame frame;
    JPanel textPanel;
    JPanel buttonPanel;
    JButton[][] buttons;
    JLabel titleField;
    JLabel flagCounterField;
    JLabel timeField;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;

    // Constructor
    public GUI(CuadriculaJuego cuadriculaJuego) {
        this.cuadriculaJuego = cuadriculaJuego;
        timer = new Timer(1000, this);

        frame = new JFrame("Buscaminas");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        textPanel = new JPanel();
        textPanel.setVisible(true);
        textPanel.setBackground(Color.BLACK);
        int rows = 1;
        int cols = 3;
        textPanel.setLayout(new GridLayout(rows, cols, 0, 0));

        buttonPanel = new JPanel();
        buttonPanel.setVisible(true);

        if (CuadriculaJuego.getDimensionUsuario() != 0) {
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.getDimensionUsuario(), CuadriculaJuego.getDimensionUsuario()));
        } else if (CuadriculaJuego.isFacil()) {
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.DIMENSION_FACIL, CuadriculaJuego.DIMENSION_FACIL));
        } else if (CuadriculaJuego.isMedio()) {
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.DIMENSION_MEDIO, CuadriculaJuego.DIMENSION_MEDIO));
        } else if (CuadriculaJuego.isDificil()) {
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.DIMENSION_DIFICIL, CuadriculaJuego.DIMENSION_DIFICIL));
        } else if (CuadriculaJuego.isPro()) {
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.DIMENSION_PRO, CuadriculaJuego.DIMENSION_PRO));
        } else {
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.DIMENSION_POR_DEFECTO, CuadriculaJuego.DIMENSION_POR_DEFECTO));
        }

        flagCounterField = new JLabel();
        flagCounterField.setHorizontalAlignment(JLabel.CENTER);
        flagCounterField.setFont(new Font(DEFAULT_FONT, Font.BOLD, GENERAL_FONT_SIZE));
        flagCounterField.setForeground(Color.GREEN);
        flagCounterField.setText(String.valueOf(cuadriculaJuego.getRecuentoBanderas()));

        titleField = new JLabel();
        titleField.setHorizontalAlignment(JLabel.CENTER);
        titleField.setFont(new Font(DEFAULT_FONT, Font.BOLD, GENERAL_FONT_SIZE));
        titleField.setForeground(Color.GREEN);
        titleField.setText("BUSCAMINAS");

        timeField = new JLabel();
        timeField.setHorizontalAlignment(JLabel.CENTER);
        timeField.setFont(new Font(DEFAULT_FONT, Font.BOLD, GENERAL_FONT_SIZE));
        timeField.setForeground(Color.GREEN);
        timer.start();

        buttons = new JButton[cuadriculaJuego.getCeldas().length][cuadriculaJuego.getCeldas()[0].length];
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFocusable(false);
                buttons[i][j].addMouseListener(this);
                buttonPanel.add(buttons[i][j]);
            }
        }

        textPanel.add(flagCounterField);
        textPanel.add(titleField);
        textPanel.add(timeField);
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        frame.setJMenuBar(new MenuBar(frame));

        frame.revalidate();
        frame.setLocationRelativeTo(null);
    }

    // Getters
    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            segundos++;
            if (segundos == 60) {
                segundos = 0;
                minutos++;
            } else if (minutos == 60) {
                minutos = 0;
                horas++;
            } else if (horas == 24) {
                segundos = 0;
                minutos = 0;
                horas = 0;
            }
            timeField.setText((horas < 10 ? "0" : "") + horas + ":" + (minutos < 10 ? "0" : "") + minutos + ":" + (segundos < 10 ? "0" : "") + segundos);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                if (e.getSource() == buttons[i][j]) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        //System.out.println("right clicked! " + i + " " + j);
                        //System.out.println(cuadriculaJuego);
                        ponerBanderas(i, j);
                    } else if (e.getButton() == MouseEvent.BUTTON1) {
                        //System.out.println("left clicked! " + i + " " + j);
                        //System.out.println(cuadriculaJuego);
                        cuadriculaJuego.actualizarTablero(i, j);
                        actualizarGUI();
                        actualizarEstadoJuegoGanadoOPerdido(i, j);
                        juegoGanadoOPerdido(i, j);
                    }
                }
            }
        }
    }

    /**
     * Setea los iconos de los botones que componen las celdas de juego.
     *
     * @param object JButton con el botón a cambiar.
     * @param i      Fila de la celda.
     * @param j      Columna de la celda.
     * @param type   Tipo de icono a poner.
     * @param width  Ancho del icono.
     * @param height Alto del icono.
     */
    public void setIcons(JButton object, int i, int j, String type, int width, int height) {
        switch (type) {
            case "BANDERA" ->
                    object.setIcon(new ImageIcon(new ImageIcon(cuadriculaJuego.getCeldas()[i][j].getBANDERA()).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
            case "BOMBA" ->
                    object.setIcon(new ImageIcon(new ImageIcon(cuadriculaJuego.getCeldas()[i][j].getBOMBA()).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
            case "BOMBA_EXPLOTADA" ->
                    object.setIcon(new ImageIcon(new ImageIcon(cuadriculaJuego.getCeldas()[i][j].getBOMBA_EXPLOTADA()).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
            case "NO_BOMBA" ->
                    object.setIcon(new ImageIcon(new ImageIcon(cuadriculaJuego.getCeldas()[i][j].getNO_BOMBA()).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
            case "DIGITOS_CELDAS" ->
                    object.setIcon(new ImageIcon(new ImageIcon(cuadriculaJuego.getCeldas()[i][j].getDIGITOS_CELDAS()[cuadriculaJuego.getCeldas()[i][j].getNumeroMinasAlrededor()]).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
        }
    }

    /**
     * Método para gestionar la lógica de las banderas.
     *
     * @param i Fila de la celda.
     * @param j Columna de la celda.
     */
    public void ponerBanderas(int i, int j) {
        if (!cuadriculaJuego.getCeldas()[i][j].isDescubierta() && cuadriculaJuego.getCeldas()[i][j].isBandera()) {
            // Quitar banderas
            buttons[i][j].setIcon(null);
            buttons[i][j].setText(null);
            buttons[i][j].setBackground(null);
            cuadriculaJuego.getCeldas()[i][j].setBandera(false);
            cuadriculaJuego.setRecuentoBanderas(cuadriculaJuego.getRecuentoBanderas() + 1);
            flagCounterField.setText(String.valueOf(cuadriculaJuego.getRecuentoBanderas()));
        } else if (!cuadriculaJuego.getCeldas()[i][j].isDescubierta() && !cuadriculaJuego.getCeldas()[i][j].isBandera()) {
            // Poner banderas
            if (cuadriculaJuego.getRecuentoBanderas() > 0) {
                setIcons(buttons[i][j], i, j, "BANDERA", 100, 100);
                buttons[i][j].setText(null);
                buttons[i][j].setBackground(null);
                cuadriculaJuego.setRecuentoBanderas(cuadriculaJuego.getRecuentoBanderas() - 1);
                cuadriculaJuego.getCeldas()[i][j].setBandera(true);
                flagCounterField.setText(String.valueOf(cuadriculaJuego.getRecuentoBanderas()));
            } else {
                JOptionPane.showMessageDialog(frame, "¡No puedes poner más banderas!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cuadriculaJuego.getCeldas()[i][j].isDescubierta() || cuadriculaJuego.getCeldas()[i][j].isBandera()) {
            JOptionPane.showMessageDialog(frame, "¡No se puede poner una bandera en esa celda!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para actualizar la GUI.
     */
    public void actualizarGUI() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                if (!cuadriculaJuego.getCeldas()[i][j].isDescubierta() && cuadriculaJuego.getCeldas()[i][j].isMina() && cuadriculaJuego.isGanado()) {
                    buttons[i][j].setText(null);
                    setIcons(buttons[i][j], i, j, "BANDERA", 100, 100);
                }
                if (cuadriculaJuego.getCeldas()[i][j].isDescubierta() && !cuadriculaJuego.getCeldas()[i][j].isMina()) {
                    buttons[i][j].setText(null);
                    setIcons(buttons[i][j], i, j, "DIGITOS_CELDAS", 100, 100);
                } else if (cuadriculaJuego.getCeldas()[i][j].isDescubierta() && cuadriculaJuego.getCeldas()[i][j].isMina()) {
                    buttons[i][j].setText(null);
                    buttons[i][j].setIcon(new ImageIcon(new ImageIcon(cuadriculaJuego.getCeldas()[i][j].getBOMBA()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                } else if (cuadriculaJuego.isPerdido() && cuadriculaJuego.getCeldas()[i][j].isBandera() && !cuadriculaJuego.getCeldas()[i][j].isMina()) {
                    buttons[i][j].setText(null);
                    buttons[i][j].setIcon(new ImageIcon(new ImageIcon(cuadriculaJuego.getCeldas()[i][j].getNO_BOMBA()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                }
            }
        }
    }

    /**
     * Método para lanzar la lógica de juego ganado o perdido y volver a jugar.
     *
     * @param i Fila de la celda.
     * @param j Columna de la celda.
     */
    private void juegoGanadoOPerdido(int i, int j) {
        if (cuadriculaJuego.isGanado()) {
            actualizarEstadoJuegoGanadoOPerdido(i, j);
            volverAJugar();
        } else if (cuadriculaJuego.isPerdido()) {
            actualizarEstadoJuegoGanadoOPerdido(i, j);
            volverAJugar();
        }
    }

    /**
     * Método para gestionar los botones en caso de ganar o perder.
     *
     * @param i Fila de la celda.
     * @param j Columna de la celda.
     */
    private void actualizarEstadoJuegoGanadoOPerdido(int i, int j) {
        buttons[i][j].setBackground(null);
        buttons[i][j].setText(null);
        seteoImagenes(i, j);
        buttons[i][j].setIcon(new ImageIcon(new ImageIcon(cuadriculaJuego.getCeldas()[i][j].getImagen()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        timer.stop();
    }

    /**
     * Método con la lógica para setear las imágenes de las celdas.
     *
     * @param i Fila de la celda.
     * @param j Columna de la celda.
     */
    private void seteoImagenes(int i, int j) {
        if (!cuadriculaJuego.getCeldas()[i][j].isMina() && !cuadriculaJuego.getCeldas()[i][j].isBandera()) {
            cuadriculaJuego.getCeldas()[i][j].setImagen(cuadriculaJuego.getCeldas()[i][j].getDIGITOS_CELDAS()[cuadriculaJuego.getCeldas()[i][j].getNumeroMinasAlrededor()]);
        } else if (!cuadriculaJuego.getCeldas()[i][j].isMina() && cuadriculaJuego.getCeldas()[i][j].isBandera()) {
            cuadriculaJuego.getCeldas()[i][j].setImagen(cuadriculaJuego.getCeldas()[i][j].getNO_BOMBA());
        }
    }

    /**
     * Método que gestiona la parte de la interfaz de usuario que se encarga de recoger
     * la información del usuario para volver a jugar y setear la partida nueva.
     */
    private void volverAJugar() {
        String titulo;
        String accion;
        Object[] opciones = new Object[]{"Sí", "Cambiar opciones"};

        if (cuadriculaJuego.isGanado()) {
            titulo = "Ganaste";
            accion = "¡Has ganado! ¿Quieres volver a jugar?";
        } else {
            titulo = "Perdiste";
            accion = "¡Has perdido! ¿Quieres volver a jugar?";
        }

        if (JOptionPane.showOptionDialog(frame, accion, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, opciones, opciones[0]) == JOptionPane.YES_OPTION) {
            new GUI(CuadriculaJuego.seleccionModoJuego(frame));
            frame.dispose();
        } else {
            String opcion = "";
            try {
                opcion = JOptionPane.showInputDialog(frame, """
                        Elige la dificultad:\s
                        1. Fácil\s
                        2. Intermedio\s
                        3. Difícil\s
                        4. PRO\s
                        """, "Cambiar opciones", JOptionPane.INFORMATION_MESSAGE).toLowerCase();
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(frame, "¡No has elegido ninguna opción!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            switch (opcion) {
                case "1", "fácil", "facil" -> {
                    frame.dispose();
                    CuadriculaJuego.setDificultad(true, false, false, false);
                    new GUI(CuadriculaJuego.seleccionModoJuego(frame));

                }
                case "2", "intermedio", "medio" -> {
                    CuadriculaJuego.setDificultad(false, true, false, false);
                    new GUI(CuadriculaJuego.seleccionModoJuego(frame));
                    frame.dispose();
                }
                case "3", "dificil", "difícil" -> {
                    CuadriculaJuego.setDificultad(false, false, true, false);
                    new GUI(CuadriculaJuego.seleccionModoJuego(frame));
                    frame.dispose();
                }
                case "4", "pro" -> {
                    CuadriculaJuego.setDificultad(false, false, false, true);
                    new GUI(CuadriculaJuego.seleccionModoJuego(frame));
                    frame.dispose();
                }
                default -> {
                    CuadriculaJuego.setDificultad(false, true, false, false);
                    JOptionPane.showMessageDialog(frame, "Opción no válida, " + "se reiniciará el juego con las opciones por defecto");
                    new GUI(CuadriculaJuego.seleccionModoJuego(frame));
                    frame.dispose();
                }
            }
        }
    }
}
