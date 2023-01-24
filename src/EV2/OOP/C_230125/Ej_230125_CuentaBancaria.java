package EV2.OOP.C_230125;

import java.util.Scanner;

/**
 * Contiene el método main de la clase CuentaBancaria.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
public class Ej_230125_CuentaBancaria {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("-------------------PARTE OBLIGATORIA (Ejecución hardcoded)----------------------------");

        CuentaBancaria cuentaNomina = new CuentaBancaria(
                "Daniel Alonso Lázaro",
                1500,
                "€",
                true);

        CuentaBancaria cuentaAhorro = new CuentaBancaria(
                "Daniel Alonso Lázaro",
                5000,
                "€",
                false);

        CuentaBancaria cuentaDolares = new CuentaBancaria(
                "Daniel Alonso Lázaro",
                0,
                "$",
                false);

//        System.out.println("-------------------PARTE OBLIGATORIA (Ejecución input)----------------------------");
//
//        CuentaBancaria cuentaNomina = abrirCuenta();
//        CuentaBancaria cuentaAhorro = abrirCuenta();
//        CuentaBancaria cuentaDolares = abrirCuenta();

        consultarSaldo(cuentaNomina);
        consultarSaldo(cuentaAhorro);
        cuentaNomina.retirarDinero(500);
        cuentaNomina.hacerTransferencia(cuentaAhorro, 700);
        cuentaNomina.retirarDinero(500);
        cuentaNomina.depositarDinero(300);
        cuentaNomina.retirarDinero(500);
        consultarSaldo(cuentaNomina);
        consultarSaldo(cuentaAhorro);

        System.out.println("----------------------------------PARTE OPCIONAL----------------------------------------");
        // Transferencia denegada por saldo insuficiente.
        cuentaNomina.hacerTransferencia(cuentaAhorro, 300);
        // Retirada denegada por saldo insuficiente.
        cuentaNomina.retirarDinero(300);
        // Depositar con céntimos
        cuentaNomina.depositarDinero(20.76);
        // Retirar con céntimos
        cuentaNomina.retirarDinero(20.76);
        // Cobrar recibo con dinero suficiente en cuenta nómina
        cuentaNomina.cobrarRecibo(100, "Gas Natural");
        // Cobrar recibo con dinero insuficiente en cuenta nómina
        cuentaNomina.cobrarRecibo(279.84, "Iberdrola");
        // Cobrar recibo con dinero insuficiente en cuenta ahorro
        cuentaAhorro.cobrarRecibo(5800, "Hipoteca");
        // Depositar dinero en cuenta ahorro
        cuentaAhorro.depositarDinero(100);
        // Cobrar recibo con dinero suficiente en cuenta ahorro
        cuentaAhorro.cobrarRecibo(5800, "Hipoteca");
        // Intento de retirada con cuenta a 0
        cuentaAhorro.retirarDinero(100);

        consultarSaldo(cuentaNomina);
        consultarSaldo(cuentaAhorro);


        // Depositar dinero en cuenta en dólares
        cuentaDolares.depositarDinero(1000);
        // Retirar dinero en cuenta en dólares
        cuentaDolares.retirarDinero(1000);
        // Consultar saldo cuenta en dólares con saldo 0
        cuentaDolares.retirarDinero(1000);
        // Consultar saldo cuenta en dólares con saldo 0
        consultarSaldo(cuentaDolares);
        // Transferencia en dólares con saldo 0
        cuentaDolares.hacerTransferencia(cuentaNomina, 500);
        // Ingreso en cuenta nómina para quitar el negativo.
        cuentaNomina.depositarDinero(459.08);
        // Estado de las dos cuentas
        consultarSaldo(cuentaDolares);
        consultarSaldo(cuentaNomina);
        // Transferencia de cuenta nómina a cuenta en dólares con cambio de moneda.
        cuentaNomina.hacerTransferencia(cuentaDolares, 100);
        // Transferencia a la inversa, de dolares a euros.
        cuentaDolares.hacerTransferencia(cuentaNomina, 50);
        // Saldos finales
        consultarSaldo(cuentaDolares);
        consultarSaldo(cuentaNomina);
    }

    /**
     * Método que inicializa un objeto cuenta bancaria con datos introducidos por teclado.
     * @return objeto de cuenta bancaria creada.
     */
    public static CuentaBancaria abrirCuenta() {
        return new CuentaBancaria(getInputNombreTitular(),
                getInputSaldoInicial(),
                getInputTipoMoneda(),
                getInputVentajasNomina());
    }

    /**
     * Método que pide al usuario por teclado el nombre del titular de la cuenta bancaria.
     * @return nombre del titular.
     */
    public static String getInputNombreTitular(){
        String titular;
        do{
            System.out.print("Introduzca el nombre del titular: ");
            titular = sc.nextLine();
        }while(titular.isBlank());
        return titular;
    }

    /**
     * Método que pide al usuario el saldo inicial de la cuenta bancaria.
     * @return saldo inicial de la cuenta bancaria.
     */
    public static double getInputSaldoInicial(){
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
     * @return tipo de moneda de la cuenta bancaria.
     */
    public static String getInputTipoMoneda(){
        String moneda;
        do{
            System.out.print("Introduzca el tipo de moneda: ");
            moneda = sc.nextLine();
        }while(!(moneda.equals("€") ^ moneda.equals("$") ^ moneda.equals("£")));
        return moneda;
    }

    /**
     * Método que pide al usuario si la cuenta bancaria es de tipo nómina o no.
     * @return
     * <ul>
     *     <li>true: si la cuenta es de tipo nómina.</li>
     *     <li>false: si la cuenta no es de tipo nómina.</li>
     * </ul>
     */
    public static boolean getInputVentajasNomina(){
        boolean ventajasNomina = false;
        do{

            System.out.print("¿Es una cuenta nómina? (S/N): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("S")) {
                ventajasNomina = true;
                break;
            } else if (input.equalsIgnoreCase("N")){
                break;
            }
            System.out.println("Introduzca si o no (S/N) para indicar si la cuenta es nómina.\n"
                    + input
                    +" no es una opción válida.");
        }while(true);
        System.out.println();
        return ventajasNomina;
    }

    /**
     * Método que muestra los datos de un objeto de cuenta bancaria.
     * @param cuenta cuenta bancaria de la que se quieren consultar los datos.
     */
    public static void consultarSaldo(CuentaBancaria cuenta) {
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Saldo: "
                + CuentaBancaria.normalizadorDecimales(cuenta.getSaldo())
                + cuenta.getMoneda());
        System.out.println("Ventajas cuenta nómina: "
                + (cuenta.getVentajasNomina()
                ? "\n\tSi. La cuenta permite saldos negativos."
                : "\n\tNo. La cuenta no permite saldos negativos.")
                + "\n");
    }
}