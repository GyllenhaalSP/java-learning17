package EV3.C_20230217.Buscaminas.BuscaminasGUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Clase MenuBar.
 * Extiende JMenuBar y crea la barra general de los menús del juego en todas las instancias
 * del frame principal.
 *
 * @author Daniel Alonso Lázaro - 2023
 * @version 2.0
 */
public class MenuBar extends JMenuBar {
    JMenu archivo;
    JMenu opciones;
    JMenu help;
    JMenu setDificultad;
    JMenu personalizado;
    JMenuItem nuevoJuego;
    JMenuItem reiniciar;
    JMenuItem salir;
    JMenuItem sobreMi;
    JMenuItem setFilasYColumnas;
    JMenuItem setMinas;
    JMenuItem facil;
    JMenuItem medio;
    JMenuItem dificil;
    JMenuItem pro;

    // Constructor
    public MenuBar(JFrame frame) {
        archivo = new JMenu("Archivo");
        nuevoJuego = new JMenuItem("Nuevo juego");
        nuevoJuego.addActionListener(e -> {
            frame.dispose();
            new Bienvenida(GUI.getWidth(), GUI.getHeight());
        });
        reiniciar = new JMenuItem("Reiniciar");
        reiniciar.addActionListener(e -> {
            frame.dispose();
            new GUI(CuadriculaJuego.seleccionModoJuego(frame));
        });
        salir = new JMenuItem("Salir");
        salir.addActionListener(e -> System.exit(0));
        archivo.add(nuevoJuego);
        archivo.add(reiniciar);
        archivo.add(salir);
        this.add(archivo);

        opciones = new JMenu("Opciones");

        personalizado = new JMenu("Personalizado");
        setFilasYColumnas = new JMenuItem("Filas y columnas");
        setFilasYColumnas.addActionListener(e -> {
            while (true) {
                String filas = introduccionDatos(frame, "Introduce el número de filas.\n" + "Este número será también el número de columnas.", "Filas y Columnas");
                if (filas != null) {
                    try {
                        int filasInt = Integer.parseInt(filas);
                        if (filasInt > 0 && filasInt <= 31) {
                            CuadriculaJuego.setDimensionUsuario(filasInt);
                            break;
                        } else {
                            errorValidacion(frame, "El número introducido debe ser mayor que 0 y menor que 30");
                        }
                    } catch (NumberFormatException ex) {
                        errorValidacion(frame, "El número introducido no es un número " + "o debe ser un número entero");
                    }
                } else {
                    break;
                }
            }
        });

        setMinas = new JMenuItem("Minas");
        setMinas.addActionListener(e -> {
            while (true) {
                String minas = introduccionDatos(frame, "Introduce el número de minas", "Minas");
                if (minas != null) {
                    try {
                        int minasInt = Integer.parseInt(minas);
                        double minasMax = Math.ceil(CuadriculaJuego.getDimensionUsuario() * 1.15f);
                        if (CuadriculaJuego.getDimensionUsuario() > 0) {
                            if (minasInt > 0 && minasInt < minasMax) {
                                CuadriculaJuego.setNumeroMinasUsuario(minasInt);
                                break;
                            } else {
                                errorValidacion(frame, "El número introducido debe ser mayor que 0 y menor que " + (int) minasMax);
                            }
                        } else {
                            errorValidacion(frame, "Debes introducir primero el número de filas y columnas.");
                            break;
                        }
                    } catch (NumberFormatException ex) {
                        errorValidacion(frame, "El número introducido no es un número " + "o debe ser un número entero");
                    }
                } else {
                    break;
                }
            }
        });

        personalizado.add(setFilasYColumnas);
        personalizado.add(setMinas);
        opciones.add(personalizado);

        setDificultad = new JMenu("Dificultad");

        facil = new JMenuItem("Fácil");
        facil.addActionListener(e -> CuadriculaJuego.setDificultad(true, false, false, false));
        medio = new JMenuItem("Medio");
        medio.addActionListener(e -> CuadriculaJuego.setDificultad(false, true, false, false));
        dificil = new JMenuItem("Difícil");
        dificil.addActionListener(e -> CuadriculaJuego.setDificultad(false, false, true, false));
        pro = new JMenuItem("Pro");
        pro.addActionListener(e -> CuadriculaJuego.setDificultad(false, false, false, true));
        setDificultad.add(facil);
        setDificultad.add(medio);
        setDificultad.add(dificil);
        setDificultad.add(pro);
        opciones.add(setDificultad);
        this.add(opciones);

        help = new JMenu("?");
        sobreMi = new JMenuItem("Sobre mi");
        sobreMi.addActionListener(e -> JOptionPane.showMessageDialog(frame, """
                Buscaminas 2.0
                Creado por: Daniel Alonso Lázaro
                IES Juan de la Cierva - DAW1V 2022/2023
                Primera revisión: 15/03/2023
                Última revisión: 26/03/2023""", "Sobre mi", JOptionPane.INFORMATION_MESSAGE));
        help.add(sobreMi);
        this.add(help);
    }

    /**
     * Muestra un mensaje de error en un JOptionPane.
     *
     * @param frame   frame en el que se mostrará el mensaje.
     * @param mensaje mensaje que se mostrará.
     */
    private void errorValidacion(JFrame frame, String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un JOptionPane para introducir datos.
     *
     * @param frame   frame en el que se mostrará el JOptionPane.
     * @param mensaje mensaje que se mostrará.
     * @param titulo  título del JOptionPane.
     * @return String con el texto introducido.
     */
    private String introduccionDatos(JFrame frame, String mensaje, String titulo) {
        return JOptionPane.showInputDialog(frame, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
    }

}
