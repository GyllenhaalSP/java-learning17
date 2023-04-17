package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos;

import java.util.GregorianCalendar;
import java.util.Random;

public abstract class Producto {

    // Atributos
    private String nombre;
    private String lote;
    private String paisOrigen;
    private final GregorianCalendar fechaEnvasado;
    private final GregorianCalendar fechaCaducidad;
    static private final int DIAS_CADUCIDAD_FRESCO = 7;
    static private final int DIAS_CADUCIDAD_REFRIGERADO = 20;
    static private final int DIAS_CADUCIDAD_CONGELADO = 90;

    // Constructor
    public Producto(String nombre,
                    String paisOrigen,
                    GregorianCalendar fechaEnvasado) {
        this.nombre = nombre;
        this.lote = generarLote();
        this.paisOrigen = paisOrigen;
        this.fechaEnvasado = fechaEnvasado;

        if (this instanceof ProductoFresco) {
            this.fechaCaducidad = calcularFechaCaducidad(fechaEnvasado, DIAS_CADUCIDAD_FRESCO);
        } else if (this instanceof ProductoRefrigerado) {
            this.fechaCaducidad = calcularFechaCaducidad(fechaEnvasado, DIAS_CADUCIDAD_REFRIGERADO);
        } else if (this instanceof ProductoCongelado) {
            this.fechaCaducidad = calcularFechaCaducidad(fechaEnvasado, DIAS_CADUCIDAD_CONGELADO);
        } else {
            this.fechaCaducidad = null;
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }


    public String getLote() {
        return lote;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }


    public GregorianCalendar getFechaEnvasado() {
        return fechaEnvasado;
    }

    public GregorianCalendar getFechaCaducidad() {
        return fechaCaducidad;
    }

    // Métodos

    public String generarLote() {
        int longitud = 10;
        Random rand = new Random();
        StringBuilder lote = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int numero = rand.nextInt(0, 10);
            lote.append(numero);
        }
        return lote.toString();
    }

    public GregorianCalendar calcularFechaCaducidad(GregorianCalendar fechaEnvasado, int diasCaducidad) {
        GregorianCalendar fechaCaducidad = new GregorianCalendar();
        fechaCaducidad.setTime(fechaEnvasado.getTime());
        fechaCaducidad.add(GregorianCalendar.DAY_OF_MONTH, diasCaducidad);
        return fechaCaducidad;
    }

    @Override
    public String toString() {
        return "\nProducto: " + nombre
                + "\n\tLote: " + lote
                + "\n\tPaís de origen: " + paisOrigen
                + "\n\tFecha de envasado: " + fechaEnvasado.getTime()
                + "\n\tFecha de caducidad: " + fechaCaducidad.getTime();
    }
}
