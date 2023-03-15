package EV2.OOP.C_20230217.Buscaminas.BuscaminasGUI;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

/**
 * Clase Ayuda.
 * Clase que crea la interfaz de ayuda del juego.
 * @author Daniel Alonso Lázaro - 2023
 * @version 2.0
 */
public class Ayuda extends JFrame {
    JFrame frame;
    JLabel helpHeader;
    JTextPane helpText;
    JButton botonVolver;
    JScrollPane scrollPane;
    public Ayuda() {
        frame = new JFrame("AYUDA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        helpHeader = new JLabel("MENÚ DE AYUDA");
        helpHeader.setHorizontalAlignment(JLabel.CENTER);
        helpHeader.setFont(new Font("Lucida Console", Font.BOLD, 40));
        helpHeader.setOpaque(true);
        helpHeader.setBackground(Color.BLACK);
        helpHeader.setForeground(Color.GREEN);
        helpHeader.setPreferredSize(new Dimension(570, 60));
        frame.add(helpHeader, BorderLayout.NORTH);

        helpText = new JTextPane();
        StyledDocument style = helpText.getStyledDocument();
        SimpleAttributeSet align = new SimpleAttributeSet();
        StyleConstants.setAlignment(align, StyleConstants.ALIGN_JUSTIFIED);
        style.setParagraphAttributes(0, style.getLength(), align, false);
        helpText.setFont(new Font("Lucida Console", Font.BOLD, 20));
        helpText.setOpaque(true);
        helpText.setBackground(Color.BLACK);
        helpText.setForeground(Color.GREEN);
        helpText.setText("""
                El objetivo del buscaminas es descubrir todo el área de juego.
                
                Para ello, se deben descubrir todas las casillas que NO contienen minas.

                Al introducir la coordenada de una casilla, se descubrirá su contenido. Si la celda está vacía, se descubrirán las casillas adyacentes. El número que se revela en estas celdas adyacentes indica las minas que hay en las ocho casillas inmediatamente adyacentes a la celda descubierta.
                
                Si se descubre una casilla con una mina, se pierde automáticamente la partida.

                Si se está seguro de que una casilla contiene una mina, se puede marcar con una bandera. Para marcar una celda con una bandera, se tiene que introducir su coordenada. No se puede poner una bandera en una celda que ya esté descubierta ni en una casilla que ya tenga una bandera.

                Lo más sencillo es empezar por las esquinas e ir avanzando desde ahí.

                ¡Buena suerte!
                """);
        helpText.setMargin(new Insets(10, 10, 10, 10));
        helpText.setEditable(false);
        helpText.setCaretPosition(0);

        scrollPane = new JScrollPane(helpText);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane, BorderLayout.CENTER);

        UIManager.put("Button.select", Color.BLACK );
        botonVolver = new JButton("VOLVER");
        botonVolver.setFocusable(false);
        botonVolver.setOpaque(true);
        botonVolver.setBackground(Color.BLACK);
        botonVolver.setForeground(Color.GREEN);
        botonVolver.setFont(new Font("Lucida Console", Font.BOLD, 30));
        botonVolver.addActionListener(e -> {
            new Bienvenida();
            frame.dispose();
        });
        botonVolver.setPreferredSize(new Dimension(570, 45));
        botonVolver.setBorder(BorderFactory.createEmptyBorder());
        frame.add(botonVolver, BorderLayout.SOUTH);
    }


}
