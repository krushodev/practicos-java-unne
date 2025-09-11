import java.util.Scanner;
import java.util.Random;

/**
 * Clase ejecutable para probar la funcionalidad de la clase CuentaBancaria.
 * Permite crear un titular y una cuenta, y luego operar a través de un menú interactivo.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class EjecutableCuentaBancaria
{
    /**
     * Método principal que inicia la ejecución.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre del titular:");
        String nombre = teclado.next();
        System.out.println("Ingrese el apellido del titular:");
        String apellido = teclado.next();
        
        Persona titular = new Persona(3049382, nombre, apellido, 1991);
        
        CuentaBancaria cuenta = new CuentaBancaria(((new Random()).nextInt(1000000000)), titular);
        
        cuenta.mostrar();
        
        String opcionSalida = "s";
        
        while (!opcionSalida.equalsIgnoreCase("n")) {
            System.out.println("\n Por favor, ingrese una de las opciones:");
            System.out.println("1. Depositar\n2. Extraer\n3. Mostrar información de cuenta\n4. Mostrar resumen\n5. Salir");
            short opcionLista = teclado.nextShort();
            
            switch (opcionLista) {
                case 1: {
                    System.out.println("Por favor, ingrese el monto a depositar:");
                    double monto = teclado.nextDouble();
                    double nuevoSaldo = cuenta.depositar(monto);
                    System.out.println("Has depositado: $" + monto);
                    System.out.println("Tu nuevo saldo es: $" + nuevoSaldo);
                    System.out.println("¿Quieres continuar? (S - Sí / N - No):");
                    opcionSalida = teclado.next();
                    break;
                }
                case 2: {
                    System.out.println("Por favor, ingrese el monto a extraer:");
                    double monto = teclado.nextDouble();
                    double nuevoSaldo = cuenta.extraer(monto);
                    System.out.println("Has extraído: $" + monto);
                    System.out.println("Tu nuevo saldo es: $" + nuevoSaldo);
                    System.out.println("¿Quieres continuar? (S - Sí / N - No):");
                    opcionSalida = teclado.next();
                    break;
                }
                case 3: {
                    System.out.println("\n");
                    cuenta.mostrar();
                    System.out.println("¿Quieres continuar? (S - Sí / N - No):");
                    opcionSalida = teclado.next();
                    break;
                }
                case 4: {
                    System.out.println("\n Su resumen de cuenta es:");
                    System.out.println(cuenta.toString());
                    System.out.println("¿Quieres continuar? (S - Sí / N - No):");
                    opcionSalida = teclado.next();
                    break;
                }
                case 5: {
                    opcionSalida = "n";
                    break;
                }
                default: {
                    System.out.println("Opción no válida. Saliendo del menú.");
                    opcionSalida = "n";
                    break;
                }
            }
        }
    }
}
