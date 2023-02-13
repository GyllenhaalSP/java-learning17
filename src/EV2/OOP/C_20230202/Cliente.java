package EV2.OOP.C_20230202;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String dir;
    private String tel;

    public Cliente(String nombre, String apellidos, String dir, String tel) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dir = dir;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Cliente: {\nNombre:" + nombre + "\nApellidos:" + apellidos + "\nDirección:" + dir + "\nTeléfono:" + tel + " }";
    }
}
