package EV2.OOP.C_20230217.Buscaminas.BuscaminasGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase GUI.
 * Clase que crea la interfaz gráfica dentro del juego.
 * @author Daniel Alonso Lázaro - 2023
 * @version 2.0
 */
public class GUI extends MouseAdapter implements ActionListener {
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
    private final CuadriculaJuego cuadriculaJuego;
    private final Timer timer;

    public GUI(CuadriculaJuego cuadriculaJuego) {
        this.cuadriculaJuego = cuadriculaJuego;
        timer = new Timer(1000, this);

        frame = new JFrame("Buscaminas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        textPanel = new JPanel();
        textPanel.setVisible(true);
        textPanel.setBackground(Color.BLACK);
        textPanel.setLayout(new GridLayout(1, 3));

        buttonPanel = new JPanel();
        buttonPanel.setVisible(true);
        if(CuadriculaJuego.getDimensionUsuario() != 0) {
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.getDimensionUsuario(),
                    CuadriculaJuego.getDimensionUsuario()));
        }else if(CuadriculaJuego.isFacil()) {
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.DIMENSION_FACIL,
                    CuadriculaJuego.DIMENSION_FACIL));
        }else if(CuadriculaJuego.isMedio()) {
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.DIMENSION_MEDIO,
                    CuadriculaJuego.DIMENSION_MEDIO));
        }else if(CuadriculaJuego.isDificil()) {
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.DIMENSION_DIFICIL,
                    CuadriculaJuego.DIMENSION_DIFICIL));
        }else if(CuadriculaJuego.isPro()){
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.DIMENSION_PRO,
                    CuadriculaJuego.DIMENSION_PRO));
        }else {
            buttonPanel.setLayout(new GridLayout(CuadriculaJuego.DIMENSION_POR_DEFECTO,
                    CuadriculaJuego.DIMENSION_POR_DEFECTO));
        }

        flagCounterField = new JLabel();
        flagCounterField.setHorizontalAlignment(JLabel.CENTER);
        flagCounterField.setFont(new Font("MV Boli", Font.BOLD, 30));
        flagCounterField.setForeground(Color.GREEN);
        flagCounterField.setText(String.valueOf(cuadriculaJuego.getRecuentoBanderas()));

        titleField = new JLabel();
        titleField.setHorizontalAlignment(JLabel.CENTER);
        titleField.setFont(new Font("MV Boli", Font.BOLD, 30));
        titleField.setForeground(Color.GREEN);
        titleField.setText("Buscaminas");

        timeField = new JLabel();
        timeField.setHorizontalAlignment(JLabel.CENTER);
        timeField.setFont(new Font("MV Boli", Font.BOLD, 30));
        timeField.setForeground(Color.GREEN);
        timer.start();

        buttons = new JButton[cuadriculaJuego.getCeldas().length][cuadriculaJuego.getCeldas()[0].length];
        for(int i = 0; i < buttons.length; i++){
            for(int j = 0; j < buttons[i].length; j++){
                buttons[i][j] = new JButton();
                buttons[i][j].setFocusable(false);
                buttons[i][j].setFont(new Font("MV Boli", Font.BOLD, 12));
                buttons[i][j].setBackground(Color.GREEN);
                buttons[i][j].addMouseListener(this);
                buttonPanel.add(buttons[i][j]);
            }
        }

        textPanel.add(flagCounterField);
        textPanel.add(titleField);
        textPanel.add(timeField);
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        frame.setSize(600, 600);

        frame.revalidate();
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == timer){
            segundos++;
            if (segundos == 60){
                segundos = 0;
                minutos++;
            } else if(minutos == 60){
                minutos = 0;
                horas++;
            } else if (horas == 24){
                segundos = 0;
                minutos = 0;
                horas = 0;
            }
            timeField.setText(
                    (horas < 10 ? "0":"")  + horas
                    + ":"
                    + (minutos < 10 ? "0" : "") + minutos
                    + ":"
                    + (segundos < 10 ? "0" : "") + segundos);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i = 0; i < buttons.length; i++){
            for (int j = 0; j < buttons[0].length; j++){
                if(e.getSource() == buttons[i][j]){
                    if(e.getButton() == MouseEvent.BUTTON3){
                        System.out.println("right clicked! " + i + " " + j);
                        System.out.println(cuadriculaJuego.toString());
                        ponerBandera(i, j);
                    }else if (e.getButton() == MouseEvent.BUTTON1){
                        System.out.println("left clicked! " + i + " " + j);
                        System.out.println(cuadriculaJuego.toString());
                        cuadriculaJuego.actualizarTablero(i, j);
                        actualizarGUI();
                        descubrirTodo();
                    }
                }
            }
        }
    }

    public void ponerBandera(int i, int j){
        if (!cuadriculaJuego.getCeldas()[i][j].isDescubierta()
                && cuadriculaJuego.getCeldas()[i][j].isBandera()) {
            // Quitar banderas
            buttons[i][j].setIcon(null);
            buttons[i][j].setText(null);
            buttons[i][j].setBackground(Color.GREEN);
            cuadriculaJuego.getCeldas()[i][j].setBandera(false);
            cuadriculaJuego.setRecuentoBanderas(cuadriculaJuego.getRecuentoBanderas() + 1);
            flagCounterField.setText(String.valueOf(cuadriculaJuego.getRecuentoBanderas()));
        }else if (!cuadriculaJuego.getCeldas()[i][j].isDescubierta()
                && !cuadriculaJuego.getCeldas()[i][j].isBandera()) {
            // Poner banderas
            if (cuadriculaJuego.getRecuentoBanderas() > 0) {
                buttons[i][j].setIcon(new ImageIcon(
                        new ImageIcon(cuadriculaJuego.getCeldas()[i][j].getBANDERA())
                                .getImage()
                                .getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
                buttons[i][j].setText(null);
                buttons[i][j].setBackground(null);
                cuadriculaJuego.setRecuentoBanderas(cuadriculaJuego.getRecuentoBanderas() - 1);
                cuadriculaJuego.getCeldas()[i][j].setBandera(true);
                flagCounterField.setText(String.valueOf(cuadriculaJuego.getRecuentoBanderas()));
            } else {
                JOptionPane.showMessageDialog(frame, "¡No puedes poner más banderas!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cuadriculaJuego.getCeldas()[i][j].isDescubierta()
                || cuadriculaJuego.getCeldas()[i][j].isBandera()){
            JOptionPane.showMessageDialog(frame, "¡No se puede poner una bandera en esa celda!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(frame, "¡No puedes poner !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarGUI(){
        for(int i = 0; i < buttons.length; i++){
            for (int j = 0; j < buttons[0].length; j++){
                if(cuadriculaJuego.getCeldas()[i][j].isDescubierta()
                        && !cuadriculaJuego.getCeldas()[i][j].isMina()){
                    buttons[i][j].setText(null);
                    buttons[i][j].setIcon(new ImageIcon(
                            new ImageIcon(
                                    cuadriculaJuego.getCeldas()[i][j].getDIGITOS_CELDAS()
                                            [cuadriculaJuego.getCeldas()[i][j].getNumeroMinasAlrededor()])
                                    .getImage()
                                    .getScaledInstance(90, 80, Image.SCALE_SMOOTH)));
                } else if (cuadriculaJuego.getCeldas()[i][j].isDescubierta()
                        && cuadriculaJuego.getCeldas()[i][j].isMina()){
                    buttons[i][j].setText(null);
                    buttons[i][j].setIcon(new ImageIcon(
                            new ImageIcon(cuadriculaJuego.getCeldas()[i][j].getBOMBA())
                                    .getImage()
                                    .getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                }
            }
        }
    }

    public void descubrirTodo(){
        if(cuadriculaJuego.isPerdido()){
            for(int i = 0; i < buttons.length; i++){
                for (int j = 0; j < buttons[0].length; j++){
                    buttons[i][j].setBackground(null);
                    buttons[i][j].setText(null);
                    seteoImagenes();
                    buttons[i][j].setIcon(new ImageIcon(
                            new ImageIcon(
                                    cuadriculaJuego.getCeldas()[i][j]
                                            .getImagen())
                                    .getImage()
                                    .getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                }
            }
            timer.stop();
        } else if (cuadriculaJuego.isGanado()){
            for(int i = 0; i < buttons.length; i++){
                for (int j = 0; j < buttons[0].length; j++){
                    buttons[i][j].setBackground(null);
                    buttons[i][j].setText(null);
                    seteoImagenes();
                    buttons[i][j].setIcon(new ImageIcon(
                            new ImageIcon(
                                    cuadriculaJuego.getCeldas()[i][j]
                                            .getImagen())
                                    .getImage()
                                    .getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                }
            }
            timer.stop();
        }
    }

    private void seteoImagenes(){
        for(int i = 0; i < buttons.length; i++){
            for (int j = 0; j < buttons[0].length; j++){
                if (!cuadriculaJuego.getCeldas()[i][j].isMina() && !cuadriculaJuego.getCeldas()[i][j].isBandera()) {
                    cuadriculaJuego.getCeldas()[i][j].setImagen(
                            cuadriculaJuego.getCeldas()[i][j].getDIGITOS_CELDAS()
                                    [cuadriculaJuego.getCeldas()[i][j].getNumeroMinasAlrededor()]);
                }
            }
        }
    }

}
