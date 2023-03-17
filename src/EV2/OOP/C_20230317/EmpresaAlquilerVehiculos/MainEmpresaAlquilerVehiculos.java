package EV2.OOP.C_20230317.EmpresaAlquilerVehiculos;


import EV2.OOP.C_20230317.EmpresaAlquilerVehiculos.programacion.negocios.empresaalquilervehiculos.*;

public class MainEmpresaAlquilerVehiculos {
  public static void main(String[] args) {
    EmpresaAlquilerVehiculos empresaAlquiler = new EmpresaAlquilerVehiculos("Sixt rent a car S.L.U.", "B07947591");
    System.out.println(empresaAlquiler + "\n");

    ClienteParticular fer = new ClienteParticular("Fernando Campos", "12345678F","666 666 666", "fcamposdelpozo@educa.madrid.org");
    empresaAlquiler.registrarCliente(fer);
    System.out.println(empresaAlquiler + "\n");

    ClienteParticular alan = new ClienteParticular("Alan Turing", "98765432K", "+44 76589345", "aturing@educa.madrid.org");
    empresaAlquiler.registrarCliente(alan);
    System.out.println(empresaAlquiler + "\n");

    Turismo seatIbiza = new Turismo("1234MBC", "Seat", "Ibiza", 30f, 3, false);
    empresaAlquiler.registrarVehiculo(seatIbiza);
    System.out.println(empresaAlquiler + "\n");

    Turismo kiaCeed = new Turismo("1123", "Kia", "Ceed", 40f, 5, true);
    empresaAlquiler.registrarVehiculo(kiaCeed);
    System.out.println(empresaAlquiler + "\n");

    empresaAlquiler.alquilarVehiculo(fer, seatIbiza);
    System.out.println(empresaAlquiler + "\n");

    empresaAlquiler.alquilarVehiculo(alan, kiaCeed);
    System.out.println(empresaAlquiler + "\n");

    empresaAlquiler.devolverVehiculo(seatIbiza);
    System.out.println(empresaAlquiler + "\n");
  }
}
