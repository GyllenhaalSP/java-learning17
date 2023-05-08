package EV3.C_20230411.P_11_2.empresaagroalimentaria.productos;

import java.time.LocalDate;

public class ProductoFresco extends Producto {

    public static final String CSV_HEADER = "Nombre"+ SEPARADOR
            +"Lote"+ SEPARADOR
            +"País de origen"+ SEPARADOR
            +"Fecha de envasado"+ SEPARADOR
            +"Fecha de caducidad";
    public static final String CSV_NAME = "ProductoFresco.csv";

    // Constructor
    public ProductoFresco(String nombre, String paisOrigen, LocalDate fechaEnvasado) {
        super(nombre, paisOrigen, fechaEnvasado);
    }

    @Override
    public String classToCSV() {
        return this.getNombre() + SEPARADOR
                + this.getLote() + SEPARADOR
                + this.getPaisOrigen() + SEPARADOR
                + this.getFechaEnvasado() + SEPARADOR
                + this.getFechaCaducidad()+"\n";
    }


}
