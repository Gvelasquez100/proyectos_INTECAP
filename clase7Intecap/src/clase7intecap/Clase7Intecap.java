package clase7intecap;
import clase7intecap.cuenta;
import java.util.Scanner;

/**
 *
 * @author German Velasquez
 */
public class Clase7Intecap {

    cuenta cuenta1 = new cuenta(500.33, "German",123456);
    cuenta cuenta2 = new cuenta(1000, "Juan",654123);

    public void menu() {
        while (true) {
            System.out.println("---Menu de las cuentas---");
            System.out.println("| 1. Mostrar cuenta |");
            System.out.println("| 2. Abonar cuenta  |");
            System.out.println("| 3. Debitar cuenta |");
            System.out.println("| 4. Salir          |");
            Scanner sp = new Scanner(System.in);
            switch (sp.nextInt()) {
                case 1:
                    System.out.println("Deseas cuenta Monetaria o Ahorros? seleccione 1  o 2");
                    System.out.println("|                 1          2   |");
                    if (sp.nextInt() == 1) {
                        cuenta1.mostrar();
                    } else {
                        cuenta2.mostrar();
                    }
                    break;
                case 2:
                   System.out.println("Deseas cuenta Monetaria o Ahorros? seleccione 1  o 2");
                   System.out.println("|                 1          2   |");
                    if (sp.nextInt() == 1) {
                        System.out.println("Ingresa el monto a abonar");
                        System.out.println(cuenta1.abonar(sp.nextDouble()));
                    } else {
                        System.out.println("Ingresa el monto a abonar");
                        System.out.println(cuenta2.abonar(sp.nextDouble()));
                    }
                    break;
                case 3:
                     System.out.println("Deseas cuenta Monetaria o Ahorros? seleccione 1  o 2");
                     System.out.println("|                 1          2   |");
                    if (sp.nextInt() == 1) {
                        System.out.println("Ingresa el monto a debitar");
                        cuenta1.debitar(sp.nextDouble());
                    } else {
                        System.out.println("Ingresa el monto a debitar");
                        cuenta2.debitar(sp.nextDouble());
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Clase7Intecap dato = new Clase7Intecap();
        dato.menu();
    }
}


