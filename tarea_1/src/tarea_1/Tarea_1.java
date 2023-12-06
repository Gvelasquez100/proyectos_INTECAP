package tarea_1;

import java.util.Scanner;
import java.math.MathContext;

/**
 *
 * @author German Velasquez
 */
public class Tarea_1 {
   int numero1, numero2 ;
   String nombre;
    public static void main(String[] args) {
     Scanner sp = new Scanner(System.in);
        System.out.println("INGRESE 2 NUMEROS  POR FAVOR");
        String numero1 = sp.nextLine();
        String numero2 = sp.nextLine();
        System.out.println("Primer numero:" +numero1);
        System.out.println("Segundo numero:" +numero2);
        System.out.println("Por favor ingrese su nombre");
         String nombre = sp.nextLine();
         System.out.println("Buenos dias Bienvenido: "+nombre);
         System.out.println("Ingrese un numero entero por favor:");
         int numero = sp.nextInt();
         int doble = numero * 2;
          int triple = numero * 3; 
          System.out.println("Este seria el doble de su numero:" +numero + " es: " + doble);
          System.out.println("Este seria el triple de su numero:" +numero + " es: " + triple);
          System.out.println("Ingrese los grados centigrados a los que estamos ahora");
          double c = sp.nextDouble();
          double f = (c= 9*c/5)+32;
          System.out.println("Los grados celsius ingresados son equivalen a: " +f + " grados Fahrenheit ");
    }
    
}
