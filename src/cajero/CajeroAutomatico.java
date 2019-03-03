/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.util.ArrayList;

/**
 *
 * @author infor04
 */
public class CajeroAutomatico {

    private static int ult_id = 1;
    private static ArrayList<Tarjeta> list_tarjeta = new ArrayList<>();
    private int id;
    private int[][] billetes;
    private int total;

    //CONSTRUCTORES
    public CajeroAutomatico() {
        this.id = ult_id++;

    }

    public CajeroAutomatico(int[][] billetes) {
        this.id = ult_id++;
        this.billetes = billetes;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public static ArrayList<Tarjeta> getList_tarjeta() {
        return list_tarjeta;
    }

    //el set Tarjeta sólo añadira a la lista la tarjeta que se le pasa por parámetro
    public static void setList_tarjeta(Tarjeta T) {
        list_tarjeta.add(T);
    }

    public int[][] getBilletes() {
        return billetes;
    }

    public void setBilletes(int[][] carga) {
        this.billetes = carga.clone();
        /*this.billetes = new int[carga.length][2];
        for (int i = 0; i < carga.length; i++) {
            this.billetes[i][0] = carga[i][0];
            this.billetes[i][1] = carga[i][1];
        }*/
        this.setTotal();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = 0;
        for (int i = 0; i < this.billetes.length; i++) {
            total += this.billetes[i][0] * this.billetes[i][1];
        }
    }

    //Métodos
    //muestra el contenido de billetes en el cajero
    public void mostrarCajero() {
        System.out.println("Cajero: " + this.id);
        System.out.println("Carga de billetes:");
        for (int i = 0; i < this.billetes.length; i++) {
            System.out.println(this.billetes[i][1] + " billetes de " + this.billetes[i][0] + "€");
        }
        System.out.println("TOTAL: " + this.total);
        System.out.println("=================================");
    }

    public static int localizarTarjeta(String nif, int pin) {
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < list_tarjeta.size()) {
            if (getList_tarjeta().get(i).getNif().equals(nif)
                    && getList_tarjeta().get(i).getPin() == pin) {
                encontrado = true;
            }
            i++;
        }
        return i - 1;
    }

    /*
    public boolean tieneBilletes(int importe) {
        boolean disponible = false;
        int i = 0;
        int[][] billetes_aux = this.billetes.clone();
        while (importe > 0 && i < billetes_aux.length) {
            if (billetes_aux[i][1] > 0 && importe / billetes_aux[i][0] > 0) {
                if (importe / billetes_aux[i][0] < billetes_aux[i][1]) {
                    System.out.println(importe / billetes_aux[i][0] + " billetes de " + billetes_aux[i][0] + "€");
                    billetes_aux[i][1] = billetes_aux[i][1] - (importe / billetes_aux[i][0]);
                    importe = importe - (billetes_aux[i][0] * (importe / billetes_aux[i][0]));
                } else {
                    System.out.println(billetes_aux[i][1] + " billetes de " + billetes_aux[i][0] + "€");
                    importe = importe - (billetes_aux[i][0] * billetes_aux[i][1]);
                    billetes_aux[i][1] = 0;
                }
            }
            i++;
        }
        if(importe==0){
            disponible = true;
            this.setBilletes(billetes_aux);
        }
        return disponible;
    }
*/
    
    public boolean tieneBilletes(int importe) {
        boolean disponible = false;
        int i = 0;
        while (!disponible && i < this.billetes.length) {
            if (this.billetes[i][1] > 0 && importe / this.billetes[i][0] > 0) {
                if (importe / this.billetes[i][0] <= this.billetes[i][1]) {
                    importe = importe - (this.billetes[i][0] * (importe / this.billetes[i][0]));
                } else {
                    importe = importe - (this.billetes[i][0] * this.billetes[i][1]);
                }
                if (importe == 0) {
                    disponible = true;
                }
            }
            i++;
        }
        return disponible;
    }

    public void sacarBilletes(int importe) {
        int i = 0;
        while (importe > 0 && i < this.billetes.length) {
            if (this.billetes[i][1] > 0 && importe / this.billetes[i][0] > 0) {
                if (importe / this.billetes[i][0] < this.billetes[i][1]) {
                    System.out.println(importe / this.billetes[i][0] + " billetes de " + this.billetes[i][0] + "€");
                    this.billetes[i][1] = this.billetes[i][1] - (importe / this.billetes[i][0]);
                    importe = importe - (this.billetes[i][0] * (importe / this.billetes[i][0]));
                } else {
                    System.out.println(this.billetes[i][1] + " billetes de " + this.billetes[i][0] + "€");
                    importe = importe - (this.billetes[i][0] * this.billetes[i][1]);
                    this.billetes[i][1] = 0;
                }
            }
            i++;

        }
        this.setTotal();
    }
     
}
