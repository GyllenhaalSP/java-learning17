package EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.congelados;

import EV2.OOP.C_20230411.P_11_2.empresaagroalimentaria.productos.ProductoCongelado;

import java.time.LocalDate;

public class CongeladoNitrogeno extends ProductoCongelado {

        private String metodoCongelacion;
        private final int tiempoExposicionNitrogeno;

        public CongeladoNitrogeno(String nombre, String paisOrigen, LocalDate fechaEnvasado, int temperaturaRecomendada, String metodoCongelacion, int tiempoExposicionNitrogeno) {
            super(nombre, paisOrigen, fechaEnvasado, temperaturaRecomendada);
            this.metodoCongelacion = metodoCongelacion;
            this.tiempoExposicionNitrogeno = tiempoExposicionNitrogeno;
        }

        public String getMetodoCongelacion() {
            return metodoCongelacion;
        }

        public void setMetodoCongelacion(String metodoCongelacion) {
            this.metodoCongelacion = metodoCongelacion;
        }

        public int getTiempoExposicionNitrogeno() {
            return tiempoExposicionNitrogeno;
        }

    @Override
    public int getTemperaturaRecomendada() {
        return this.temperaturaRecomendada;
    }

    @Override
        public String toString() {
            return super.toString()
                    +"\nMétodo de congelación: " + metodoCongelacion
                    +" Tiempo de exposición al nitrógeno: " + tiempoExposicionNitrogeno + " segundos.";
        }
}
