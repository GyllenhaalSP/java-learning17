package EV2.OOP.C_230125;

public class Ej_230125_CuentaBancaria {
    public static void main(String[] args) {
        CuentaBancaria cuentaNomina = new CuentaBancaria("ES580297895430011990", "Daniel Alonso Lázaro", 1500, "€");
        CuentaBancaria cuentaAhorro = new CuentaBancaria("ES580297895430011991", "Daniel Alonso Lázaro", 5000, "€");

        cuentaNomina.consultarCuenta();
        cuentaAhorro.consultarCuenta();

        cuentaNomina.retirarDinero(500);
        cuentaNomina.hacerTransferencia(cuentaAhorro, 700);

        cuentaNomina.retirarDinero(500);
        cuentaNomina.depositarDinero(300);
        cuentaNomina.retirarDinero(500);

        cuentaNomina.consultarCuenta();
        cuentaAhorro.consultarCuenta();

    }
}
