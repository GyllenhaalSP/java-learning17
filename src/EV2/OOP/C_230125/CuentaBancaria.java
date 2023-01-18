package EV2.OOP.C_230125;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CuentaBancaria {
    // Daniel Alonso Lázaro - 2023
    // Atributos
    private final String numeroCuenta;
    private final String titular;
    private final String moneda;
    private double saldo;

    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldo, String moneda) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.moneda = moneda;
    }

    // Getters y Setters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Métodos
    public void depositarDinero(double cantidad) {
        depositarDinero(cantidad, false, this);
    }

    public void depositarDinero(double cantidad, boolean transferencia, CuentaBancaria cuenta) {
        this.saldo += cantidad;
        if(transferencia) {
            System.out.println("Se han transferido "
                    + cantidad
                    + getMoneda()
                    + " a la cuenta "
                    + this.numeroCuenta
                    + " desde la cuenta "
                    + cuenta.getNumeroCuenta() + ".\n");
        }else{
            System.out.println("Se han ingresado "
                    + cantidad
                    + getMoneda()
                    + " en la cuenta "
                    + this.numeroCuenta
                    + ".\n");
        }
    }

    public boolean retirarDinero(double cantidad){
        if (this.saldo >= cantidad){
            this.saldo -= cantidad;
            System.out.println("Se han retirado " + cantidad + "€ de la cuenta " + this.numeroCuenta + ".\n");
            return true;
        } else {
            System.out.println("No se pueden retirar " + cantidad + "€ de la cuenta " + this.numeroCuenta + ".\n");
            return false;
        }
    }

    public boolean retirarDinero(double cantidad, boolean transferencia){
        if (this.saldo >= cantidad && transferencia) {
            this.saldo -= cantidad;
            return true;
        }else if (this.saldo >= cantidad) {
            return retirarDinero(cantidad);
        }else {
            return retirarDinero(cantidad);
        }
    }

    public void hacerTransferencia(CuentaBancaria cuentaDestino, double cantidad){
        if (this.retirarDinero(cantidad, true)){
            cuentaDestino.depositarDinero(cantidad, true, this);
        }
    }

    public void consultarCuenta(){
        System.out.println("Número de cuenta: " + this.getNumeroCuenta());
        System.out.println("Titular: " + this.getTitular());
        System.out.println("Saldo: "
                + (this.getSaldo() % 1 == 0.0
                    ? (int)this.getSaldo()
                    :redondeoMonetario(this.getSaldo())
                + this.getMoneda()+"\n"));
    }

    public static double redondeoMonetario(double cantidad){
        //Redondea un double a 2 decimales con precisión monetaria.
        return new BigDecimal(cantidad)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}