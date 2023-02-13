package EV2.OOP.VehiculoCliente;

public class MainAgenciaAlquilerVehiculos {
  public static void main(String[] args) {
    String nombreAgencia="sixty";
    int maxClientes = 2;
    int maxVehiculos = 2;
    int posCliente = 0;
    int posVehiculo = 0;

    AgenciaAlquilerVehiculos agencia = new AgenciaAlquilerVehiculos(nombreAgencia, maxClientes, maxVehiculos);

    agencia.addCliente("Fer", "Campos");
    System.out.println(agencia);
    System.out.println(">>> agencia.imprimir():");
    agencia.imprimir();

    agencia.addCliente("Linus", "Torvalds");
    System.out.println(agencia);

    agencia.addCliente("Perico", "Palotes");
    System.out.println(agencia);

    agencia.addVehiculo("Seat", "Ibiza");
    System.out.println(agencia);

    agencia.addVehiculo("Fiat", "Punto");
    System.out.println(agencia);

    agencia.addVehiculo("Kia", "Rio");
    System.out.println(agencia);

    agencia.alquilarVehiculo(0, 0);
    System.out.println(agencia);
    
    agencia.alquilarVehiculo(1, 0);
    System.out.println(agencia);


  }
}
