package EV2.OOP.C_230125;

import java.util.Random;

/**
 * Clase CuentaBancaria
 * Contiene los atributos y métodos de la clase CuentaBancaria.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
@SuppressWarnings("FieldCanBeLocal")
public class CuentaBancaria {
    /**
     * Atributos de la clase CuentaBancaria:
     * LONGITUD_IBAN: Longitud del IBAN.
     * IBAN: Código IBAN.
     * numeroCuenta: Número de cuenta bancaria.
     * titular: Nombre del titular de la cuenta bancaria.
     * moneda: Moneda de la cuenta bancaria.
     * saldo: Saldo de la cuenta bancaria.
     * ventajasNomina: Indica si la cuenta bancaria tiene ventajas por ser  cuenta nómina.
     */
    private final byte LONGITUD_IBAN = 26;
    private final String IBAN = "ES";
    private final String numeroCuenta;
    private final String titular;
    private final String moneda;
    private double saldo;
    private final boolean ventajasNomina;

    /**
     * Constructor de la clase CuentaBancaria:
     * @param titular  String Nombre del titular de la cuenta bancaria.
     * @param saldo Saldo de la cuenta bancaria.
     * @param moneda Moneda de la cuenta bancaria.
     * @param ventajasNomina Indica si la cuenta bancaria tiene ventajas por ser una cuenta de tipo nómina.
     */
    public CuentaBancaria(String titular, double saldo, String moneda, boolean ventajasNomina) {
        this.numeroCuenta = generadorIBAN();
        this.titular = titular;
        this.saldo = saldo;
        this.moneda = moneda;
        this.ventajasNomina = ventajasNomina;
    }

    /**
     * @return Devuelve el IBAN de la cuenta bancaria.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @return Devuelve el titular de la cuenta bancaria.
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @return Devuelve el saldo de la cuenta bancaria.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @return Devuelve la moneda de la cuenta bancaria.
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @return Devuelve true si la cuenta bancaria tiene ventajas por ser una cuenta de tipo nómina.
     */
    public boolean getVentajasNomina() {
        return ventajasNomina;
    }

    /**
     * Deposita la cantidad indicada en la cuenta bancaria e imprime un mensaje con información.
     * @param cantidad Cantidad a depositar.
     */
    public void depositarDinero(double cantidad) {
        saldo += cantidad;
        System.out.println("Se han ingresado "
                + normalizadorDecimales(cantidad)
                + moneda
                + " en la cuenta "
                + numeroCuenta
                + ".\n");
    }

    /**
     * Retira la cantidad indicada de la cuenta bancaria e imprime un mensaje con información.
     * Si la cantidad no se puede sacar con billetes de 10, 20 o 50 euros, se imprime un mensaje de error.
     * Si la cantidad es mayor que el saldo, se imprime un mensaje de error.
     * @param cantidad Cantidad a retirar.
     */
    public void retirarDinero(double cantidad) {
        if (!esMultiplo(cantidad)) System.out.println("No se pueden retirar "
                + normalizadorDecimales(cantidad)
                + moneda
                + " de la cuenta "
                + numeroCuenta
                + ".\nIntroduzca una cantidad múltiplo de 10.\n");
        else if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println("Se han retirado "
                    + normalizadorDecimales(cantidad)
                    + moneda
                    + " de la cuenta "
                    + numeroCuenta + ".\n");
        } else System.out.println("No se pueden retirar o transferir "
                    + normalizadorDecimales(cantidad)
                    + moneda
                    + " de la cuenta "
                    + numeroCuenta
                    + ". Saldo insuficiente.\n");
    }

    /**
     * @param cantidad La cantidad a transferir.
     * @param transferencia Indica si el método retirarDinero se ha llamado desde el método hacerTransferencia.
     * @return
     * <ul>
     *     <li>true: Si el saldo es mayor que la cantidad y trae el flag de que es una transferencia.</li>
     *     <li>false: Si no es una transferencia o el saldo es menor que la cantidad.</li>
     * </ul>
     */
    public boolean retirarDinero(double cantidad, boolean transferencia) {
        // Devuelve true si la cantidad se ha podido retirar.
        if (saldo >= cantidad && transferencia) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    /**
     * Hace una transferencia de la cantidad indicada a la cuenta indicada e imprime un mensaje con información.
     * @param cuentaDestino Cuenta a la que se va a transferir la cantidad.
     * @param cantidad Cantidad a transferir.
     */
    public void hacerTransferencia(CuentaBancaria cuentaDestino, double cantidad) {
        if (retirarDinero(cantidad, true)) {
            cuentaDestino.saldo += cantidad;
            System.out.println("Se han transferido "
                    + normalizadorDecimales(cantidad)
                    + moneda
                    + " a la cuenta "
                    + cuentaDestino.numeroCuenta
                    + " desde la cuenta "
                    + numeroCuenta + ".\n");
        } else retirarDinero(cantidad);
    }

    /**
     * Cobra un recibo de la cantidad indicada e imprime un mensaje con información.
     * Si la cuenta no tiene ventajas de cuenta nómina y el saldo queda en negativo, se rechaza el cobro.
     * @param cantidad Cantidad a cobrar.
     * @param recibo Nombre del recibo a cobrar.
     */
    public void cobrarRecibo(double cantidad, String recibo) {
        if (ventajasNomina || saldo >= cantidad) {
            saldo -= cantidad;
            estadoRecibo(cantidad, recibo, true);
            if (saldo < 0) numerosRojos();
        } else estadoRecibo(cantidad, recibo, false);
    }

    /**
     * Comprueba si la cantidad es múltiplo de los billetes habituales: 10, 20 o 50 euros.
     * @param cantidad Cantidad a comprobar.
     * @return Devuelve true si la cantidad es múltiplo de 10, 20 o 50.
     */
    public boolean esMultiplo(double cantidad) {
        // Devuelve true si la cantidad no es múltiplo de 10, 20 o 50.
        double[] denominaciones = {50, 20, 10};
        for (double billete : denominaciones) {
            if (cantidad % billete == 0) return true;
        }
        return false;
    }

    /**
     * Devuelve la cantidad con dos decimales si no es un número entero.
     * @param cantidad Cantidad en formato decimal a normalizar.
     * @return Devuelve la cantidad truncada si la parte decimal es 0. Si no, devuelve la cantidad en formato String.
     */
    public static String normalizadorDecimales(double cantidad) {
        return cantidad % 1 == 0.0 ? Integer.toString((int) cantidad) : String.format("%.2f", cantidad);
    }

    /**
     * Genera un IBAN aleatorio con el formato ES00 0000 0000 0000 0000 0000.
     * @return Devuelve el IBAN generado.
     */
    public String generadorIBAN() {
        // Genera un IBAN aleatorio con el formato ES00 0000 0000 0000 0000 0000.
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(IBAN);
        for (int i = 0; i <= LONGITUD_IBAN; i++) {
            if (i == 2 || i == 7 || i == 12 || i == 17 || i == 22) sb.append(" ");
            else sb.append(rand.nextInt(10));
        }
        return String.valueOf(sb);
    }

    /**
     * Imprime un mensaje si la cuenta queda en números rojos.
     */
    public void numerosRojos() {
        System.out.println("La cuenta "
                + numeroCuenta
                + " ha quedado en números rojos.\n");
    }

    /**
     * Imprime un mensaje con información sobre el pago de un recibo.
     * @param cantidad Cantidad a cobrar.
     * @param recibo Nombre del recibo a cobrar.
     * @param estado Indica si el recibo se ha cobrado o se ha devuelto y por qué.
     */
    public void estadoRecibo(double cantidad, String recibo, boolean estado) {
        if (estado) System.out.println("Se ha cobrado el recibo de "
                    + "\"" + recibo + "\""
                    + " con "
                    + normalizadorDecimales(cantidad)
                    + moneda
                    + " desde la cuenta "
                    + numeroCuenta
                    + "." + (saldo < 0 ? "" : "\n"));
        else System.out.println("Se ha devuelto el recibo "
                    + "\"" + recibo + "\""
                    + " con "
                    + normalizadorDecimales(cantidad)
                    + moneda
                    + " de la cuenta "
                    + numeroCuenta
                    + ".\nLa cuenta no tiene ventajas de nómina y no admite saldos negativos, efectúe un ingreso.\n");
    }
}