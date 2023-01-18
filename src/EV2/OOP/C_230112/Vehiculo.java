package EV2.OOP.C_230112;

public class Vehiculo{
    public Vehiculo() {
        this.marca = "Sin marca";
        this.modelo = "Sin modelo";
        this.numPasajeros = 0;
        this.capacidadCombustible = 0;
        this.consumo = 0;
    }

    public Vehiculo(String marca, String modelo, int numPasajeros, int capacidadCombustible, double consumo) {
        this.marca = marca;
        this.modelo = modelo;
        this.numPasajeros = numPasajeros;
        this.capacidadCombustible = capacidadCombustible;
        this.consumo = consumo;
    }

    String marca;
    String modelo;
    int numPasajeros;
    int capacidadCombustible; //expresado en litros
    double consumo; //expresado en litros por cada 100 km

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public int getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(int capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
}
