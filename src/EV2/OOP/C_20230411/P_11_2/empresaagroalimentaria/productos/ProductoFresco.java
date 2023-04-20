package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos;

import java.time.LocalDate;

public class ProductoFresco extends Producto {

    // Constructor
    public ProductoFresco(String nombre, String paisOrigen, LocalDate fechaEnvasado){
        super(nombre, paisOrigen, fechaEnvasado);
    }
}
