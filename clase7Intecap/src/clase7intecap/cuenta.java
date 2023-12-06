
package clase7intecap;

import java.util.Scanner;

/**
 *
 * @author German Velasquez
 */
public class cuenta {
    double saldo;
    String nombre;
    int n_Cuenta;
Scanner sp = new Scanner(System.in);
    public cuenta(double salado, String nombre, int n_Cuenta) {
        this.saldo = salado;
        this.nombre = nombre;
        this.n_Cuenta = n_Cuenta;
        
    }

   public String abonar (Double saldo) {
       this.saldo += saldo;
       
       return "USTED ABONO A LA CUENTA "+ n_Cuenta +"  Q"+ saldo +" SU SALDO ACTUAL ES " + this.saldo;
}
    public int debitar(double saldo) {
        this.saldo -= saldo;
        System.out.println("USTED DEBITO DE LA CUENTA " +saldo+"SALDO ACTUAL"+this.saldo);
        return (int) this.saldo;
    }
    
     public void mostrar(){  
         System.out.println("Su saldo actual es: "+this.saldo+" PROPIETARIO: "+this.nombre+" No. CUENTA :"+this.n_Cuenta);
     }    
}
    

