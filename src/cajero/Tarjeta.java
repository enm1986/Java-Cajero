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
public abstract class Tarjeta {

    private String nif;
    private int pin;
    private String nombre;
    private String apellido;

    //Constructores
    public Tarjeta() {
    }

    public Tarjeta(String nif, int pin, String nombre, String apellido) {
        this.nif = nif;
        this.pin = pin;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Tarjeta(Tarjeta T) {
        this.nif = T.nif;
        this.pin = T.pin;
        this.nombre = T.nombre;
        this.apellido = T.apellido;
    }

    //Getters & Setters
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Métodos
    protected void mostrarTarjeta() {
        System.out.println("Nombre: " + this.nombre + " " + this.apellido);
        System.out.println("NIF: " + this.nif);
    }

    abstract int getSaldoTotal();
    abstract void setSaldoTotal(int importe);
}
