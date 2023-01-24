package EV2.OOP.C_230125;

import java.util.Random;

/**
 * Simula el funcionamiento interno de una cuenta bancaria rudimentaria.
 * @author Daniel Alonso Lázaro - 2023
 * @version 1.0
 */
@SuppressWarnings("FieldCanBeLocal")
public class CuentaBancaria {
    /**
     * Constante de la longitud del número IBAN.<p>
     */
    private static final byte LONGITUD_IBAN = 26;

    /**
     * Constante del código IBAN de la cuenta bancaria.<p>
     */
    private static final String IBAN = "ES";

    /**
     * Array con las denominaciones de billetes de euro que se usan en cajeros.<p>
     */
    private static final double[] DENOMINACIONES = {50, 20, 10};

    /**
     * Tasa de cambio EURO/DÓLAR.<p>
     */
    private static final double TASA_CAMBIO = 1.10; // 1€ = 1.10$

    /**
     * Número de cuenta bancaria.<p>
     */
    private final String numeroCuenta;

    /**
     * Nombre del titular de la cuenta bancaria.<p>
     */
    private final String titular;

    /**
     * Tipo de moneda usado en la cuenta bancaria.<p>
     */
    private final String moneda;

    /**
     * Saldo de la cuenta bancaria.<p>
     */
    private double saldo;

    /**
     * Indica si la cuenta bancaria tiene ventajas por ser una cuenta de tipo nómina.<p>
     */
    private final boolean ventajasNomina;

    /**
     * Constructor de la clase CuentaBancaria.
     * @param titular nombre del titular de la cuenta bancaria.
     * @param saldo saldo de la cuenta bancaria.
     * @param moneda tipo de moneda de la cuenta bancaria.
     * @param ventajasNomina indica si la cuenta bancaria tiene ventajas por ser una cuenta de tipo nómina.
     */
    public CuentaBancaria(String titular, double saldo, String moneda, boolean ventajasNomina) {
        this.numeroCuenta = generadorIBAN();
        this.titular = titular;
        this.saldo = saldo;
        this.moneda = moneda;
        this.ventajasNomina = ventajasNomina;
    }

    /**
     * @return devuelve el IBAN de la cuenta bancaria.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @return devuelve el titular de la cuenta bancaria.
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @return devuelve el saldo de la cuenta bancaria.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @return devuelve la moneda de la cuenta bancaria.
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @return devuelve el tipo de cuenta bancaria.
     * <ul>
     *     <li>true: si la cuenta se ha creado como una cuenta de tipo nómina.</li>
     *     <li>false: si la cuenta no se ha creado como cuenta nómina.</li>
     * </ul>
     */
    public boolean getVentajasNomina() {
        return ventajasNomina;
    }

    /**
     * Suma la cantidad indicada al saldo de la cuenta bancaria.
     * @param cantidad cantidad a sumar.
     */
    private void sumarSaldo(double cantidad) {
        saldo += cantidad;
    }

    /**
     * Resta la cantidad indicada al saldo de la cuenta bancaria.
     * @param cantidad cantidad a restar.
     */
    private void sustraerSaldo(double cantidad) {
        saldo -= cantidad;
    }

    /**
     * Deposita la cantidad indicada en la cuenta bancaria e imprime un mensaje con información.
     * @param cantidad cantidad a depositar.
     */
    public void depositarDinero(double cantidad) {
        sumarSaldo(cantidad);
        depositoOk(cantidad);
    }

    /**
     * Retira la cantidad indicada de la cuenta bancaria e imprime un mensaje con información.<p>
     * Si la cantidad no se puede sacar con billetes de 10, 20 o 50 euros, se imprime un mensaje de error.<p>
     * Si la cantidad es mayor que el saldo, se imprime un mensaje de error.
     * @param cantidad cantidad a retirar.
     */
    public void retirarDinero(double cantidad) {
        if (!esMultiplo(cantidad))
            retiradaOk(cantidad, false);
        else if (saldo >= cantidad) {
            sustraerSaldo(cantidad);
            retiradaOk(cantidad, true);
        } else deniegaTransaccion(cantidad, false);
    }

    /**
     * @param cantidad la cantidad a transferir.
     * @param transferencia indica si el método retirarDinero se ha llamado desde el método hacerTransferencia.
     * @return
     * <ul>
     *     <li>true: Si el saldo es mayor que la cantidad y trae el flag de que es una transferencia.</li>
     *     <li>false: Si no es una transferencia o el saldo es menor que la cantidad.</li>
     * </ul>
     * @see CuentaBancaria#retirarDinero(double)
     */
    public boolean retirarDinero(double cantidad, boolean transferencia) {
        if (saldo >= cantidad && transferencia) {
            sustraerSaldo(cantidad);
            return true;
        }else{
            deniegaTransaccion(cantidad, true);
            return false;
        }
    }

    /**
     * Hace una transferencia de la cantidad indicada a la cuenta indicada e imprime un mensaje con información.
     * @param cuentaDestino cuenta a la que se va a transferir la cantidad.
     * @param cantidad cantidad a transferir.
     */
    public void hacerTransferencia(CuentaBancaria cuentaDestino, double cantidad) {
        if (moneda.equals(cuentaDestino.moneda)) {
            if(retirarDinero(cantidad, true)) {
                cuentaDestino.sumarSaldo(cantidad);
                transferenciaOK(cantidad, cuentaDestino);
            }
        } else{
            if(moneda.equals("€")) {
                if(retirarDinero(cantidad, true)) {
                    cuentaDestino.sumarSaldo(eurosADolares(cantidad));
                    transferenciaOK(cantidad, cuentaDestino);
                }
            }else{
                if(retirarDinero(cantidad, true)) {
                    cuentaDestino.sumarSaldo(dolaresAEuros(cantidad));
                    transferenciaOK(cantidad, cuentaDestino);
                }
            }
        }
    }

    /**
     * Cobra un recibo de la cantidad indicada e imprime un mensaje con información.
     * Si la cuenta no tiene ventajas de cuenta nómina y el saldo queda en negativo, se rechaza el cobro.
     * @param cantidad cantidad a cobrar.
     * @param recibo nombre del recibo a cobrar.
     */
    public void cobrarRecibo(double cantidad, String recibo) {
        if (ventajasNomina || saldo >= cantidad) {
            sustraerSaldo(cantidad);
            estadoRecibo(cantidad, recibo, true);
            if (saldo < 0) numerosRojos();
        } else estadoRecibo(cantidad, recibo, false);
    }

    /**
     * Comprueba si la cantidad es múltiplo de los billetes habituales: 10, 20 o 50 euros.
     * @param cantidad cantidad a comprobar.
     * @return
     * <ul>
     *     <li>true: Si la cantidad es múltiplo de 10, 20 o 50.</li>
     *     <li>false: Si la cantidad no es múltiplo de 10, 20 o 50.</li>
     * </ul>
     */
    public boolean esMultiplo(double cantidad) {
        for (double billete : DENOMINACIONES) {
            if (cantidad % billete == 0) return true;
        }
        return false;
    }

    /**
     * Devuelve un String con la cantidad con dos posiciones decimales si no es un número entero.
     * @param cantidad cantidad en formato decimal a normalizar.
     * @return
     * <ul>
     *     <li>Si la parte decimal es 0, devuelve la cantidad truncada.</li>
     *     <li>Si no, devuelve la cantidad en un String.</li>
     * </ul>
     */
    public static String normalizadorDecimales(double cantidad) {
        return cantidad % 1 == 0.0 ? Integer.toString((int) cantidad) : String.format("%.2f", cantidad);
    }

    /**
     * Genera un IBAN aleatorio con el formato ES00 0000 0000 0000 0000 0000.
     * @return devuelve un String con el IBAN generado.<p>
     */
    public String generadorIBAN() {
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
     * Imprime un mensaje si la cuenta se queda en números rojos.<p>
     */
    public void numerosRojos() {
        System.out.println("La cuenta "
                + numeroCuenta
                + " ha quedado en números rojos.\n");
    }

    /**
     * Imprime la denegación de la transferencia o de la retirada de dinero.
     * @param cantidad cantidad a retirar o transferir.
     * @param transferenciaORetirada indica si es una transferencia o una retirada.
     */
    private void deniegaTransaccion(double cantidad, boolean transferenciaORetirada) {
        System.out.println("No se pueden "
                + (transferenciaORetirada
                ? "transferir "
                : "retirar ")
                + normalizadorDecimales(cantidad)
                + moneda
                + " de la cuenta "
                + numeroCuenta
                + ". Saldo insuficiente.\n");
    }

    /**
     * Imprime el mensaje de confirmación del depósito.
     * @param cantidad cantidad depositada.
     */
    private void depositoOk(double cantidad) {
        System.out.println("Se han ingresado "
                + normalizadorDecimales(cantidad)
                + moneda
                + " en la cuenta "
                + numeroCuenta
                + ".\n");
    }

    /**
     * Imprime el mensaje de confirmación de la retirada.
     * @param cantidad cantidad retirada.
     * @param estado indica si la retirada ha sido exitosa o no.
     */
    private void retiradaOk(double cantidad, boolean estado) {
        if (estado) System.out.println("Se han retirado "
                + normalizadorDecimales(cantidad)
                + moneda
                + " de la cuenta "
                + numeroCuenta + ".\n");
        else System.out.println("No se pueden retirar "
                + normalizadorDecimales(cantidad)
                + moneda
                + " de la cuenta "
                + numeroCuenta
                + ".\nIntroduzca una cantidad múltiplo de 10.\n");
    }

    /**
     * Imprime el mensaje de confirmación de la transferencia.
     * @param cantidad cantidad transferida.
     * @param cuentaDestino cuenta hacia la que se ha transferido el dinero.
     */
    public void transferenciaOK(double cantidad, CuentaBancaria cuentaDestino) {
        System.out.println("Se han transferido "
                + normalizadorDecimales(cantidad)
                + moneda
                + " a la cuenta "
                + cuentaDestino.numeroCuenta
                + " desde la cuenta "
                + numeroCuenta + ".\n");
    }

    /**
     * Imprime un mensaje con información sobre el pago de un recibo.
     * @param cantidad cantidad a cobrar.
     * @param recibo nombre del recibo a cobrar.
     * @param estado indica si el recibo se ha cobrado o se ha devuelto y por qué.
     */
    public void estadoRecibo(double cantidad, String recibo, boolean estado) {
        if (estado) System.out.println("Se ha cobrado el recibo de "
                + "\"" + recibo + "\""
                + " por importe de "
                + normalizadorDecimales(cantidad)
                + moneda
                + " desde la cuenta "
                + numeroCuenta
                + (saldo < 0 ? "." : ".\n"));
        else System.out.println("Se ha devuelto el recibo "
                + "\"" + recibo + "\""
                + " por importe de "
                + normalizadorDecimales(cantidad)
                + moneda
                + " de la cuenta "
                + numeroCuenta
                + ".\nLa cuenta no tiene ventajas nómina y no admite saldos negativos, efectúe un ingreso.\n");
    }

    /**
     * Convierte una cantidad de euros a dólares.
     * @param cantidad cantidad en euros.
     * @return cantidad en dólares.
     */
    public double eurosADolares(double cantidad) {
        return cantidad * TASA_CAMBIO;
    }

    /**
     * Convierte una cantidad de dólares a euros.
     * @param cantidad cantidad en dólares.
     * @return cantidad en euros.
     */
    public double dolaresAEuros(double cantidad) {
        return cantidad / TASA_CAMBIO;
    }
}