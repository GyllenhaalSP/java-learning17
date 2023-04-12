package EV2.OOP.C_20230411.P_11_4.edificiovecinos;

public class Persona {
    String nombre;
    int edad;
    String dni;

    public Persona(){}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean esMayorDeEdad(int edad){
        return edad >= 18;
    }

    public boolean esValidoDNI(String dni){
        if(dni == null)
            return false;

        if (dni.length() < 9) return false;

        char letraDNI = dni.charAt(8);
        String letrasControl = "TRWAGMYFPDXBNJZSQVHLCKE";


        String numeroDNI = dni.toUpperCase().substring(0, dni.length()-1).replace("X", "0")
                .replace("Y", "1").replace("Z", "2");

        return letraDNI == letrasControl.charAt(Integer.parseInt(numeroDNI) % 23);
    }

    public boolean codigoValido(String codigo){
        if (codigo == null){
            System.out.println("El código no puede ser nulo");
            return false;
        }else if (codigo.charAt(0) != 'V' || codigo.charAt(0) != 'A'){
            if (this instanceof Administrador) {
                System.out.println("El código debe empezar por A");
            }else {
                System.out.println("El código debe empezar por V");
            }
            return false;
        }else if (codigo.length() != 5) {
            System.out.println("El código debe tener 5 caracteres");
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "DNI: " + dni + "\n";
    }
}
