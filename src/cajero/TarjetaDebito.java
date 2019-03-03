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
final public class TarjetaDebito extends Tarjeta {

    private int saldo;

    //Constructores
    public TarjetaDebito() {
    }

    public TarjetaDebito(int saldo) {
        this.saldo = saldo;
    }

    public TarjetaDebito(String nif, int pin, String nombre, String apellido, int saldo) {
        super(nif, pin, nombre, apellido);
        this.saldo = saldo;
    }

    public TarjetaDebito(TarjetaDebito T) {
        super(T);
        this.saldo = T.saldo;
    }

    //Getters & Setters
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    //Métodos
    @Override
    public void mostrarTarjeta() {
        super.mostrarTarjeta();
        System.out.println("Tarjeta de Débito:");
        System.out.println("Saldo: " + this.saldo);
        System.out.println("=================================");
    }

    @Override
    int getSaldoTotal() {
        return this.getSaldo();
    }

    @Override
    public void setSaldoTotal(int importe) {
        this.setSaldo(this.getSaldo()-importe);
    }
}
