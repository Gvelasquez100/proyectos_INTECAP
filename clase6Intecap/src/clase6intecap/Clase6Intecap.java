/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase6intecap;

import java.util.Scanner;

/**
 *
 * @author German Velasquez
 */
public class Clase6Intecap {

    public static void main(String[] args) {
        int[][] matriz = new int[3][5];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa 15 numeros:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("La matriz es:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
