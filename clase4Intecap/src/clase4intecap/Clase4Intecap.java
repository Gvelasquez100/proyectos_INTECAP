/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase4intecap;

import java.util.Scanner;

/**
 *
 * @author German Velasquez
 */
public class Clase4Intecap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int numero = 3;
        while (numero > 0) {            
            Scanner sp = new Scanner(System.in);
            System.out.println("En que numero estoy pensando"
                    + "del 1 al 10");
            int valor = sp.nextInt();
            
            if (valor == 7) {
                System.out.println("Felicidades Ganaste");
                break;
            }else{
            numero--;
            }
        }
    }
    
}
