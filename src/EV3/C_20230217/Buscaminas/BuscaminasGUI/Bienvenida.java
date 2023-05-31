package EV3.C_20230217.Buscaminas.BuscaminasGUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * Clase Bienvenida.
 * Clase que muestra la pantalla de bienvenida del juego y permite acceder a la ayuda y al juego.
 *
 * @author Daniel Alonso Lázaro - 2023
 * @version 2.0
 */
public class Bienvenida {
    // Atributos
    JFrame frame;
    JLabel welcomeText;
    JButton botonJugar;
    JButton botonAyuda;

    // Constructor
    public Bienvenida(int width, int height) {
        frame = new JFrame("MENU PRINCIPAL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        final int ROWS = 3;
        final int COLS = 1;
        frame.setLayout(new GridLayout(ROWS, COLS));
        frame.setVisible(true);

        welcomeText = new JLabel();
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        welcomeText.setText("¡Bienvenido al Buscaminas!");
        welcomeText.setFont(new Font("MV Boli", Font.BOLD, GUI.TITLE_FONT_SIZE));
        welcomeText.setOpaque(true);
        welcomeText.setBackground(Color.BLACK);
        welcomeText.setForeground(Color.GREEN);
        final int FACTOR = 7;
        final int WELCOME_TEXT_HEIGHT = GUI.getHeight() / FACTOR;

        welcomeText.setPreferredSize(new Dimension(width, WELCOME_TEXT_HEIGHT));
        frame.add(welcomeText);

        UIManager.put("Button.select", Color.BLACK);
        botonJugar = new JButton("Jugar");
        botonJugar.setFocusable(false);
        botonJugar.setOpaque(true);
        botonJugar.setBackground(Color.BLACK);
        botonJugar.setForeground(Color.GREEN);
        botonJugar.setFont(new Font("MV Boli", Font.BOLD, GUI.GENERAL_FONT_SIZE));
        botonJugar.addActionListener(e -> new GUI(CuadriculaJuego.seleccionModoJuego(frame)));

        frame.add(botonJugar);

        botonAyuda = new JButton("Ayuda");
        botonAyuda.setFocusable(false);
        botonAyuda.setOpaque(true);
        botonAyuda.setBackground(Color.BLACK);
        botonAyuda.setForeground(Color.GREEN);
        botonAyuda.setFont(new Font("MV Boli", Font.BOLD, GUI.GENERAL_FONT_SIZE));
        botonAyuda.addActionListener(e -> {
            new Ayuda(GUI.getWidth(), GUI.getHeight());
            frame.dispose();
        });

        frame.add(botonAyuda);

        frame.setJMenuBar(new MenuBar(frame));

        frame.revalidate();
        frame.setLocationRelativeTo(null);
    }
}
