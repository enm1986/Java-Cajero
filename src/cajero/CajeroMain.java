/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.util.Scanner;

/**
 *
 * @author infor04
 */
public class CajeroMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[][] carga_billetes = {{500, 10}, {200, 0}, {100, 0}, {50, 27}, {20, 0}, {10, 18}, {5, 25}};
        CajeroAutomatico micajero = new CajeroAutomatico();
        micajero.setBilletes(carga_billetes);
        TarjetaDebito mitarj1 = new TarjetaDebito("33888999m", 1111, "Jorge", "Lorenzo", 20000);
        TarjetaCredito mitarj2 = new TarjetaCredito("34888999m", 2222, "Rafa", "Nadal", 1000, 5000);
        CajeroAutomatico.setList_tarjeta(mitarj1);//añade una tarjeta a la lista de tarjetas
        CajeroAutomatico.setList_tarjeta(mitarj2);

        boolean salir = false;
        while (!salir) {
            micajero.mostrarCajero();
            switch (pedirOpcion()) {
                case 1:
                    System.out.println("Sacar dinero");
                    sacarDinero(micajero);
                    break;
                case 2:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    System.out.println("=================================");
            }
        }
    }

    //Muestra el menú y pide opción 
    public static int pedirOpcion() {
        Scanner leer = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println(" 1) Sacar dinero");
        System.out.println(" 2) Salir");
        System.out.println("=============================");
        System.out.println("¿Qué opción quieres?");
        return leer.nextInt();
    }

    public static void sacarDinero(CajeroAutomatico cajero) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce el NIF: ");
        String nif = leer.next();
        System.out.println("Introduce el PIN: ");
        int pin = leer.nextInt();
        int localizador = CajeroAutomatico.localizarTarjeta(nif, pin);
        if (localizador != -1) {
            CajeroAutomatico.getList_tarjeta().get(localizador).mostrarTarjeta();
            System.out.println("¿Cuánto dinero quiere retirar?");
            int importe = leer.nextInt();
            if (importe <= CajeroAutomatico.getList_tarjeta().get(localizador).getSaldoTotal()) {
                if (cajero.tieneBilletes(importe)) {
                    cajero.sacarBilletes(importe);
                    CajeroAutomatico.getList_tarjeta().get(localizador).setSaldoTotal(importe);
                    CajeroAutomatico.getList_tarjeta().get(localizador).mostrarTarjeta();
                } else {
                    System.out.println("No hay billetes suficientes");
                    System.out.println("=================================");
                }

            } else {
                System.out.println("El saldo es insuficiente");
                System.out.println("=================================");
            }
        } else {
            System.out.println("NIF y/o PIN incorrectos");
            System.out.println("=================================");
        }
    }

}
