package EV2.OOP.C_20230411.P_11_4.edificiovecinos;

public class Vecino extends Persona{
    private String codigoVecino;
    private String codigoVivienda;
    private String finca;
    private static double cuota = 100;

    public Vecino(){}

    public Vecino(String nombre, int edad, String dni, String codigoVecino, String codigoVivienda, String finca) {
        super(nombre, edad, dni);
        this.codigoVecino = codigoVecino;
        this.codigoVivienda = codigoVivienda;
        this.finca = finca;
    }

    public Vecino(String nombre, int edad, String codigoVecino, String codigoVivienda, String finca) {
        super(nombre, edad);
        this.codigoVecino = codigoVecino;
        this.codigoVivienda = codigoVivienda;
        this.finca = finca;
    }

    public String getCodigoVecino() {
        return codigoVecino;
    }

    public void setCodigoVecino(String codigoVecino) {
        this.codigoVecino = codigoVecino;
    }

    public String getCodigoVivienda() {
        return codigoVivienda;
    }

    public void setCodigoVivienda(String codigoVivienda) {
        this.codigoVivienda = codigoVivienda;
    }

    public String getFinca() {
        return finca;
    }

    public void setFinca(String finca) {
        this.finca = finca;
    }

    public static double getCuota() {
        return cuota;
    }

    public static void setCuota(double cuota) {
        Vecino.cuota = cuota;
    }

    public void modifCuota(double cuota){
        setCuota(cuota);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n\tCódigo vecino: " + codigoVecino
                + "\n\tCódigo vivienda: " + codigoVivienda
                + "\n\tFinca: " + finca;
    }
}
