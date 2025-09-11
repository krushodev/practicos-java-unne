import java.util.Scanner;
import java.util.Random;
import java.util.*;

/**
 * Clase ejecutable que simula la gestión de cuentas bancarias.
 * Permite al usuario crear un titular y operar con una Caja de Ahorro y una Cuenta Corriente
 * a través de un menú interactivo.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Banco
{
    /**
     * Método principal que inicia la simulación bancaria.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        System.out.println("Ingrese el nombre del titular:");
        String nombreTitular = teclado.next();
        System.out.println("Ingrese el apellido del titular:");
        String apellidoTitular = teclado.next();
        System.out.println("Ingrese el DNI del titular:");
        int dniTitular = teclado.nextInt();
        System.out.println("Ingrese el año de nacimiento del titular:");
        int anioNacimientoTitular = teclado.nextInt();
        System.out.println("Ingrese el mes de nacimiento del titular:");
        int mesNacimientoTitular = teclado.nextInt();
        System.out.println("Ingrese el día de nacimiento del titular:");
        int diaNacimientoTitular = teclado.nextInt();
        
        Calendar fechaTitular = new GregorianCalendar(anioNacimientoTitular, mesNacimientoTitular - 1, diaNacimientoTitular);

        Persona titular = new Persona(dniTitular, nombreTitular, apellidoTitular, fechaTitular);

        CuentaCorriente cuentaCorriente = new CuentaCorriente((new Random()).nextInt() * 10000, titular);
        CajaDeAhorro cajaDeAhorro = new CajaDeAhorro((new Random()).nextInt() * 10000, titular);

        if (titular.esCumpleanios()) {
            System.out.println("¡Feliz cumpleaños! " + titular.nomYApe());
        }

        int opcionPrincipal = 0;
        do {
            System.out.println("\n--- Menú Principal ---\n");
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Operar con Caja de Ahorro");
            System.out.println("2. Operar con Cuenta Corriente");
            System.out.println("0. Salir");
            
            opcionPrincipal = teclado.nextInt();

            switch(opcionPrincipal) {
                case 1:
                    int opcionCaja = 0;
                    do {
                        System.out.println("\n--- Menú Caja de Ahorro ---\n");
                        System.out.println("Seleccione una opción: ");
                        System.out.println("1. Mostrar Caja de Ahorro");
                        System.out.println("2. Depositar");
                        System.out.println("3. Extraer");
                        System.out.println("0. Volver al menú principal");
                        
                        opcionCaja = teclado.nextInt();

                        switch(opcionCaja) {
                            case 1:
                                cajaDeAhorro.mostrar();
                                break;
                            case 2:
                                System.out.print("Ingrese el importe a depositar: ");
                                double importeDepositoCA = teclado.nextDouble();
                                cajaDeAhorro.depositar(importeDepositoCA);
                                break;
                            case 3:
                                System.out.print("Ingrese el importe a extraer: ");
                                double importeExtraccionCA = teclado.nextDouble();
                                cajaDeAhorro.extraer(importeExtraccionCA);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                        }
                    } while(opcionCaja != 0);
                    break;
                case 2:
                    int opcionCuenta = 0;
                    do {
                        System.out.println("\n--- Menú Cuenta Corriente ---\n");
                        System.out.println("Seleccione una opción: ");
                        System.out.println("1. Mostrar Cuenta Corriente");
                        System.out.println("2. Depositar");
                        System.out.println("3. Extraer");
                        System.out.println("0. Volver al menú principal");
                        opcionCuenta = teclado.nextInt();

                        switch(opcionCuenta) {
                            case 1:
                                cuentaCorriente.mostrar();
                                break;
                            case 2:
                                System.out.print("Ingrese el importe a depositar: ");
                                double importeDepositoCC = teclado.nextDouble();
                                cuentaCorriente.depositar(importeDepositoCC);
                                break;
                            case 3:
                                System.out.print("Ingrese el importe a extraer: ");
                                double importeExtraccionCC = teclado.nextDouble();
                                cuentaCorriente.extraer(importeExtraccionCC);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                        }
                    } while(opcionCuenta != 0);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while(opcionPrincipal != 0);
    }
}
