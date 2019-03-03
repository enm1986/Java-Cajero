/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

/**
 *
 * @author infor04
 */
final public class TarjetaCredito extends Tarjeta {

    private int saldo;
    private int credito;

    //Constructores
    public TarjetaCredito() {
    }

    public TarjetaCredito(int saldo, int credito) {
        this.saldo = saldo;
        this.credito = credito;
    }

    public TarjetaCredito(String nif, int pin, String nombre, String apellido, int saldo, int credito) {
        super(nif, pin, nombre, apellido);
        this.saldo = saldo;
        this.credito = credito;
    }

    public TarjetaCredito(TarjetaCredito T) {
        super(T);
        this.saldo = T.saldo;
        this.credito = T.credito;
    }

    //Getters & Setters
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    //Métodos
    @Override
    public void mostrarTarjeta() {
        super.mostrarTarjeta();
        System.out.println("Tarjeta de Crédito:");
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Crédito: " + this.credito);
        System.out.println("=================================");
    }

    @Override
    public int getSaldoTotal() {
        return this.getSaldo() + this.getCredito();
    }

    @Override
    public void setSaldoTotal(int importe) {
        if (this.getCredito() > importe) {
            this.setCredito(this.getCredito()-importe);
        } else {            
            this.setSaldo(this.getSaldo()+this.getCredito()-importe);
            this.setCredito(0);
        }
    }
}
