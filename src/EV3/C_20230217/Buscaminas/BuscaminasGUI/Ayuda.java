package EV3.C_20230217.Buscaminas.BuscaminasGUI;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

/**
 * Clase Ayuda.
 * Clase que crea la interfaz de ayuda del juego.
 *
 * @author Daniel Alonso Lázaro - 2023
 * @version 2.0
 */
public class Ayuda extends JFrame {
    // Atributos
    JFrame frame;
    JLabel helpHeader;
    JTextPane helpText;
    JButton botonVolver;
    JScrollPane scrollPane;

    // Constructor
    public Ayuda(int width, int height) {
        frame = new JFrame("AYUDA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        helpHeader = new JLabel("MENÚ DE AYUDA");
        helpHeader.setHorizontalAlignment(JLabel.CENTER);
        helpHeader.setFont(new Font("Lucida Console", Font.BOLD, GUI.TITLE_FONT_SIZE));
        helpHeader.setOpaque(true);
        helpHeader.setBackground(Color.BLACK);
        helpHeader.setForeground(Color.GREEN);
        helpHeader.setPreferredSize(new Dimension(width, (int) (height * GUI.GUI_RESIZING_VALUE)));
        frame.add(helpHeader, BorderLayout.NORTH);

        helpText = new JTextPane();
        StyledDocument style = helpText.getStyledDocument();
        SimpleAttributeSet align = new SimpleAttributeSet();
        StyleConstants.setAlignment(align, StyleConstants.ALIGN_JUSTIFIED);
        style.setParagraphAttributes(0, style.getLength(), align, false);
        helpText.setFont(new Font("Lucida Console", Font.BOLD, GUI.HELP_TEXT_FONT_SIZE));
        helpText.setOpaque(true);
        helpText.setBackground(Color.BLACK);
        helpText.setForeground(Color.GREEN);
        helpText.setText("""
                El objetivo del buscaminas es descubrir todo el área de juego.
                                
                Para ello, se deben descubrir todas las casillas que NO contienen minas.

                Al introducir la coordenada de una casilla, se descubrirá su contenido.
                                
                Si la celda está vacía, se descubrirán las casillas adyacentes. El número que se revela en estas celdas adyacentes indica las minas que hay en las ocho casillas inmediatamente adyacentes a la celda descubierta.
                                
                Si se descubre una casilla con una mina, se pierde automáticamente la partida.

                Si se está seguro de que una casilla contiene una mina, se puede marcar con una bandera. Para marcar una celda con una bandera, se tiene que introducir su coordenada. No se puede poner una bandera en una celda que ya esté descubierta ni en una casilla que ya tenga una bandera.

                Lo más sencillo es empezar por las esquinas e ir avanzando desde ahí.

                ¡Buena suerte!
                """);
        helpText.setMargin(new Insets(15, 30, 15, 15));
        helpText.setEditable(false);
        helpText.setCaretPosition(0);

        scrollPane = new JScrollPane(helpText);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane, BorderLayout.CENTER);

        UIManager.put("Button.select", Color.BLACK);
        botonVolver = new JButton("VOLVER");
        botonVolver.setFocusable(false);
        botonVolver.setOpaque(true);
        botonVolver.setBackground(Color.BLACK);
        botonVolver.setForeground(Color.GREEN);
        botonVolver.setFont(new Font("Lucida Console", Font.BOLD, GUI.GENERAL_FONT_SIZE));
        botonVolver.addActionListener(e -> {
            new Bienvenida(width, height);
            frame.dispose();
        });

        botonVolver.setPreferredSize(new Dimension(width, (int) (height * GUI.GUI_RESIZING_VALUE)));
        botonVolver.setBorder(BorderFactory.createEmptyBorder());
        frame.add(botonVolver, BorderLayout.SOUTH);
        frame.setJMenuBar(new MenuBar(frame));
    }
}
