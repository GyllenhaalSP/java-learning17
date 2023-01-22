package EV2.OOP.C_230125;

import java.util.Scanner;

/**
 * Clase Ej_230125_CuentaBancaria
 * Contiene el método main de la clase CuentaBancaria.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Ej_230125_CuentaBancaria {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("-------------------------------PARTE OBLIGATORIA----------------------------------------");
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

        consultarSaldo(cuentaNomina);
        consultarSaldo(cuentaAhorro);
        cuentaNomina.retirarDinero(500);
        cuentaNomina.hacerTransferencia(cuentaAhorro, 700);
        cuentaNomina.retirarDinero(500);
        cuentaNomina.depositarDinero(300);
        cuentaNomina.retirarDinero(500);
        consultarSaldo(cuentaNomina);
        consultarSaldo(cuentaAhorro);

        System.out.println("------------------------------PARTE OPCIONAL----------------------------------------");
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

    /**
     * Método que abre una cuenta bancaria.
     * @return Cuenta bancaria creada.
     */
    public static CuentaBancaria abrirCuenta() {
        return new CuentaBancaria(getNombreTitular(), getSaldoInicial(), getTipoMoneda(), getVentajasNomina());
    }

    /**
     * Método que pide al usuario por teclado el nombre del titular de la cuenta bancaria.
     * @return Nombre del titular.
     */
    public static String getNombreTitular(){
        String titular;
        do{
            System.out.print("Introduzca el nombre del titular: ");
            titular = sc.nextLine();
        }while(titular.isBlank());
        return titular;
    }

    /**
     * Método que pide al usuario el saldo inicial de la cuenta bancaria.
     * @return Saldo inicial de la cuenta bancaria.
     */
    public static double getSaldoInicial(){
        double saldo;
        do{
            System.out.print("Introduzca el saldo inicial: ");
            saldo = sc.nextDouble();
            sc.nextLine();
        }while(saldo < 0);
        return saldo;
    }

    /**
     * Método que pide al usuario el tipo de moneda de la cuenta bancaria.
     * @return Tipo de moneda de la cuenta bancaria.
     */
    public static String getTipoMoneda(){
        String moneda;
        do{
            System.out.print("Introduzca el tipo de moneda: ");
            moneda = sc.nextLine();
        }while(moneda.equals("€") || moneda.equals("$") || moneda.equals("£"));
        return moneda;
    }

    public static boolean getVentajasNomina(){
        boolean ventajasNomina;
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
        return ventajasNomina;
    }

    /**
     * Método que muestra los datos de un objeto de cuenta bancaria.
     * @param cuenta Cuenta bancaria de la que se quieren consultar los datos.
     */
    public static void consultarSaldo(CuentaBancaria cuenta) {
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Saldo: "
                + CuentaBancaria.normalizadorDecimales(cuenta.getSaldo())
                + cuenta.getMoneda());
        System.out.println("Ventajas cuenta nómina: "
                + (cuenta.getVentajasNomina()
                ? "Si. La cuenta permite saldos negativos."
                : "No. La cuenta no permite saldos negativos.")
                + "\n");
    }
}
