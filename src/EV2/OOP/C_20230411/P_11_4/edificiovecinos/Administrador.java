package EV2.OOP.C_20230411.P_11_4.edificiovecinos;

public class Administrador extends Persona {
    String codigoAdminist;
    String finca;
    int numVecinos;
    float salario;

    public Administrador() {
    }

    public Administrador(String nombre, int edad, String dni, String codigoAdminist, String finca, int numVecinos, float salario) {
        super(nombre, edad, dni);
        this.codigoAdminist = codigoAdminist;
        this.finca = finca;
        this.numVecinos = numVecinos;
        this.salario = salario;
    }

    public String getCodigoAdminist() {
        return codigoAdminist;
    }

    public void setCodigoAdminist(String codigoAdminist) {
        this.codigoAdminist = codigoAdminist;
    }

    public String getFinca() {
        return finca;
    }

    public void setFinca(String finca) {
        this.finca = finca;
    }

    public int getNumVecinos() {
        return numVecinos;
    }

    public void setNumVecinos(int numVecinos) {
        this.numVecinos = numVecinos;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public double salarioMaximo(float cuota){
        return cuota * numVecinos;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n\tCódigo administrador: " + codigoAdminist
                + "\n\tFinca: " + finca
                + "\n\tNumero de vecinos: " + numVecinos
                + "\n\tSalario: " + salario + "€";
    }
}
