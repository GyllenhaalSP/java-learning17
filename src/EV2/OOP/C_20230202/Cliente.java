package EV2.OOP.C_20230202;

public class Cliente {
    private final String nombre;
    private final String apellidos;
    private final String dir;
    private final String tel;

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
