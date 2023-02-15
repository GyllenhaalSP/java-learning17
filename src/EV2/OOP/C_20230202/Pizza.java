package EV2.OOP.C_20230202;

public class Pizza {
    private final String size;
    private final String type;
    private String estado = "pedida";
    private static int numPedidas = 0;
    private static int numServidas = 0;

    public Pizza(String size, String type) {
        this.size = size;
        this.type = type;
        numPedidas++;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
        numServidas++;
    }

    public static int getNumPedidas(){
        return numPedidas;
    }

    public static int getNumServidas(){
        return numServidas;
    }

    public boolean servida() {
        return estado.equals("servida");
    }

    public boolean servirPizza() {
        if (!estado.equals("servida")) {
            estado = "servida";
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pizza: {\nTamaño: " + size + "\nTipo: " + type + "\nEstado: " + estado + " }";
    }


}
