
package tarea2;
import java.util.Scanner;
/**
 *
 * @author German Velasquez
 */
public class Tarea2 {

    public static void main(String[] args) {
        Scanner sp = new Scanner(System.in);
        System.out.println("Ingresa 2 numeros por favor");
        int numero1 = sp.nextInt();
        int numero2 = sp.nextInt();
        
       if ( numero1 == numero2 ) {
           System.out.println("Los numeros ingresados son iguales \n " +numero1);
       } else {
           System.out.println("Los numeros no son iguales");
       }
       
         double numero = 0;
        while (numero > 0) {            
            System.out.println("Ingresar un numero"
                    + "positivo o negativo -1 o 1 ejemplo");
            double valor = sp.nextInt();
            
            if (valor >0) {
                System.out.println("El numero es posotivo");
                break;
            } else if(valor < 0){
                
                System.out.println("El numero es negativo"); 
            }
            else System.out.println("el numero es 0");
        }
    }
    
}
