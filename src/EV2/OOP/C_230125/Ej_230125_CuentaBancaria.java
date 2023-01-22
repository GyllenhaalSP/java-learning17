package EV2.OOP.C_230125;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ej_230125_CuentaBancaria {
    public static void main(String[] args) {
        // Daniel Alonso Lázaro - 2023
        // Se crea la cuenta nómina
        CuentaBancaria cuentaNomina = new CuentaBancaria(
                "Daniel Alonso Lázaro",
                1500,
                "€",
                true);

        //  Se crea la cuenta ahorro
        CuentaBancaria cuentaAhorro = new CuentaBancaria(
                "Daniel Alonso Lázaro",
                5000,
                "€",
                false);

//        CuentaBancaria cuentaNomina = abrirCuenta();
//        CuentaBancaria cuentaAhorro = abrirCuenta();

        // Parte obligatoria del ejercicio.
        consultarSaldo(cuentaNomina);
        consultarSaldo(cuentaAhorro);
        cuentaNomina.retirarDinero(500);
        cuentaNomina.hacerTransferencia(cuentaAhorro, 700);
        cuentaNomina.retirarDinero(500);
        cuentaNomina.depositarDinero(300);
        cuentaNomina.retirarDinero(500);
        consultarSaldo(cuentaNomina);
        consultarSaldo(cuentaAhorro);

        System.out.println("----------------------------------------");
        // Retirar con céntimos
        cuentaNomina.retirarDinero(20.76);
        // Depositar con céntimos
        cuentaNomina.depositarDinero(20.76);
        // Cobrar recibo con dinero suficiente en cuenta nómina
        cuentaNomina.cobrarRecibo(100, "Gas Natural");
        // Cobrar recibo sin dinero suficiente en cuenta nómina
        cuentaNomina.cobrarRecibo(279.84, "Iberdrola");
        // Cobrar recibo sin dinero suficiente en cuenta ahorro
        cuentaAhorro.cobrarRecibo(5800, "Hipoteca");
        // Depositar dinero en cuenta ahorro
        cuentaAhorro.depositarDinero(100);
        // Cobrar recibo con dinero suficiente en cuenta ahorro
        cuentaAhorro.cobrarRecibo(5800, "Hipoteca");

        consultarSaldo(cuentaNomina);
        consultarSaldo(cuentaAhorro);
    }

    public static CuentaBancaria abrirCuenta() {
        Scanner sc = new Scanner(System.in);
        String titular, moneda;
        double saldo;
        boolean ventajasNomina;

        do{
            System.out.print("Introduzca el nombre del titular: ");
            titular = sc.nextLine();
        }while(titular.isBlank());

        do{
            System.out.print("Introduzca el saldo inicial: ");
            saldo = sc.nextDouble();
            sc.nextLine();
        }while(saldo < 0);

        do{
            System.out.print("Introduzca la moneda: ");
            moneda = sc.nextLine();
        }while(moneda.isBlank());

        do{
            System.out.print("¿Es una cuenta nómina? (S/N): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("S")) {
                ventajasNomina = true;
                break;
            } else if (input.equalsIgnoreCase("N")){
                ventajasNomina = false;
                break;
            }
        }while(true);

        System.out.println();
        return new CuentaBancaria(titular, saldo, moneda, ventajasNomina);
    }

    public static void consultarSaldo(CuentaBancaria cuenta) {
        // Se muestran los datos de la cuenta y el saldo.
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Saldo: "
                + CuentaBancaria.normalizador(cuenta.getSaldo())
                + cuenta.getMoneda());
        System.out.println("Ventajas cuenta nómina: "
                + (cuenta.getVentajasNomina()
                ? "Si. La cuenta permite saldos negativos."
                : "No. La cuenta no permite saldos negativos.")
                + "\n");
    }
}
