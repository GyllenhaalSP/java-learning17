package EV2.OOP.C_20230217.Buscaminas.BuscaminasGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase Bienvenida.
 * Clase que muestra la pantalla de bienvenida del juego y permite acceder a la ayuda y al juego.
 * @author Daniel Alonso Lázaro - 2023
 * @version 2.0
 */
public class Bienvenida implements ActionListener {
    JFrame frame;
    JLabel welcomeText;
    JButton botonJugar;
    JButton botonAyuda;

    public Bienvenida(){
        frame = new JFrame("MENU PRINCIPAL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(3, 1));
        frame.setVisible(true);

        welcomeText = new JLabel();
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        welcomeText.setText("¡Bienvenido al Buscaminas!");
        welcomeText.setFont(new Font("MV Boli", Font.BOLD, 40));
        welcomeText.setOpaque(true);
        welcomeText.setBackground(Color.BLACK);
        welcomeText.setForeground(Color.GREEN);
        welcomeText.setPreferredSize(new Dimension(570, 100));
        frame.add(welcomeText);

        UIManager.put("Button.select", Color.BLACK );
        botonJugar = new JButton("Jugar");
        botonJugar.setFocusable(false);
        botonJugar.setOpaque(true);
        botonJugar.setBackground(Color.BLACK);
        botonJugar.setForeground(Color.GREEN);
        botonJugar.setFont(new Font("MV Boli", Font.BOLD, 30));
        botonJugar.addActionListener(e -> {
            if (CuadriculaJuego.getDimensionUsuario() != 0 && CuadriculaJuego.getNumeroMinasUsuario() != 0) {
                new GUI(new CuadriculaJuego(CuadriculaJuego.getDimensionUsuario(),
                        CuadriculaJuego.getDimensionUsuario(),
                        CuadriculaJuego.getNumeroMinasUsuario()));
            }else if(CuadriculaJuego.isFacil()) {
                new GUI(new CuadriculaJuego(CuadriculaJuego.DIMENSION_FACIL,
                        CuadriculaJuego.DIMENSION_FACIL,
                        CuadriculaJuego.NUMERO_MINAS_FACIL));
            }else if(CuadriculaJuego.isMedio()) {
                new GUI(new CuadriculaJuego(CuadriculaJuego.DIMENSION_MEDIO,
                        CuadriculaJuego.DIMENSION_MEDIO,
                        CuadriculaJuego.NUMERO_MINAS_MEDIO));
            }else if(CuadriculaJuego.isDificil()) {
                new GUI(new CuadriculaJuego(CuadriculaJuego.DIMENSION_DIFICIL,
                        CuadriculaJuego.DIMENSION_DIFICIL,
                        CuadriculaJuego.NUMERO_MINAS_DIFICIL));
            }else if(CuadriculaJuego.isPro()) {
                new GUI(new CuadriculaJuego(CuadriculaJuego.DIMENSION_PRO,
                        CuadriculaJuego.DIMENSION_PRO,
                        CuadriculaJuego.NUMERO_MINAS_PRO));
            }else {
                new GUI(new CuadriculaJuego(CuadriculaJuego.DIMENSION_POR_DEFECTO,
                        CuadriculaJuego.DIMENSION_POR_DEFECTO,
                        CuadriculaJuego.NUMERO_MINAS_POR_DEFECTO));
                frame.dispose();
            }
        });

        frame.add(botonJugar);

        botonAyuda = new JButton("Ayuda");
        botonAyuda.setFocusable(false);
        botonAyuda.setOpaque(true);
        botonAyuda.setBackground(Color.BLACK);
        botonAyuda.setForeground(Color.GREEN);
        botonAyuda.setFont(new Font("MV Boli", Font.BOLD, 30));
        botonAyuda.addActionListener(e -> {
            new Ayuda();
            frame.dispose();
        });

        frame.add(botonAyuda);

        frame.setJMenuBar(new MenuBar(frame));

        frame.revalidate();
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
