package EV2.OOP.C_20230217.Buscaminas.BuscaminasGUI;

import javax.swing.*;

/**
 * Clase MenuBar.
 * Extiende JMenuBar y crea la barra general de los menús del juego en todas las instancias
 * del frame principal.
 * @author Daniel Alonso Lázaro - 2023
 * @version 2.0
 */
public class MenuBar extends JMenuBar{
    JMenu archivo;
    JMenu opciones;
    JMenu help;
    JMenu setDificultad;
    JMenuItem salir;
    JMenuItem about;
    JMenuItem setFilasYColumnas;
    JMenuItem setMinas;
    JMenuItem facil;
    JMenuItem medio;
    JMenuItem dificil;
    JMenuItem pro;


    public MenuBar(JFrame frame){
        archivo = new JMenu("Archivo");
        salir = new JMenuItem("Salir");
        salir.addActionListener(e -> System.exit(0));
        archivo.add(salir);
        this.add(archivo);

        opciones = new JMenu("Opciones");

        setFilasYColumnas = new JMenuItem("Filas y columnas");
        setFilasYColumnas.addActionListener(e -> {
            while(true) {
                String filas = introduccionDatos(frame, "Introduce el número de filas.\n" +
                        "Este número será también el número de columnas.", "Filas y Columnas");
                if (filas != null) {
                    try {
                        int filasInt = Integer.parseInt(filas);
                        if (filasInt > 0 && filasInt <= 30){
                            CuadriculaJuego.setDimensionUsuario(filasInt);
                            break;
                        } else {
                            errorValidacion(frame, "El número introducido debe ser mayor que 0");
                        }
                    } catch (NumberFormatException ex) {
                        errorValidacion(frame, "El número introducido no es un número " +
                                "o debe ser un número entero");
                    }
                } else{
                    break;
                }
            }
        });

        setMinas = new JMenuItem("Minas");
        setMinas.addActionListener(e -> {
            while(true) {
                String minas = introduccionDatos(frame, "Introduce el número de minas", "Minas");
                if (minas != null) {
                    try {
                        int minasInt = Integer.parseInt(minas);
                        if (minasInt > 0) {
                            CuadriculaJuego.setNumeroMinasUsuario(minasInt);
                            break;
                        } else {
                            errorValidacion(frame, "El número introducido debe ser mayor que 0");
                        }
                    } catch (NumberFormatException ex) {
                        errorValidacion(frame, "El número introducido no es un número " +
                                "o debe ser un número entero");
                    }
                }else{
                    break;
                }
            }
        });
        opciones.add(setFilasYColumnas);
        opciones.add(setMinas);
        setDificultad = new JMenu("Dificultad");
        facil = new JMenuItem("Fácil");
        facil.addActionListener(e -> {
            CuadriculaJuego.setFacil(true);
            CuadriculaJuego.setMedio(false);
            CuadriculaJuego.setDificil(false);
            CuadriculaJuego.setPro(false);
        });
        medio = new JMenuItem("Medio");
        medio.addActionListener(e -> {
            CuadriculaJuego.setFacil(false);
            CuadriculaJuego.setMedio(true);
            CuadriculaJuego.setDificil(false);
            CuadriculaJuego.setPro(false);
        });
        dificil = new JMenuItem("Difícil");
        dificil.addActionListener(e -> {
            CuadriculaJuego.setFacil(false);
            CuadriculaJuego.setMedio(false);
            CuadriculaJuego.setDificil(true);
            CuadriculaJuego.setPro(false);
        });
        pro = new JMenuItem("Pro");
        pro.addActionListener(e -> {
            CuadriculaJuego.setFacil(false);
            CuadriculaJuego.setMedio(false);
            CuadriculaJuego.setDificil(false);
            CuadriculaJuego.setPro(true);
        });
        setDificultad.add(facil);
        setDificultad.add(medio);
        setDificultad.add(dificil);
        setDificultad.add(pro);
        opciones.add(setDificultad);
        this.add(opciones);

        help = new JMenu("?");
        about = new JMenuItem("Sobre mi");
        about.addActionListener(e -> JOptionPane.showMessageDialog(frame, """
                Buscaminas 2.0
                Creado por: Daniel Alonso Lázaro
                IES Juan de la Cierva - DAW1V 2022/2023
                Primera revisión: 15/03/2023""", "Sobre mi", JOptionPane.INFORMATION_MESSAGE));
        help.add(about);
        this.add(help);
    }

    private void errorValidacion(JFrame frame, String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private String introduccionDatos(JFrame frame, String mensaje, String titulo){
        return JOptionPane.showInputDialog(frame, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
    }
}
