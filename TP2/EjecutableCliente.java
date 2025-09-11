/**
 * Clase ejecutable para probar la funcionalidad de la clase Cliente.
 * Crea un cliente a partir de argumentos de línea de comandos, 
 * realiza operaciones de saldo y muestra los resultados.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class EjecutableCliente
{
    /**
     * Método principal que inicia la ejecución.
     * @param args Argumentos de la línea de comandos. Se esperan 4 argumentos:
     * args[0]: DNI (entero)
     * args[1]: Apellido (texto)
     * args[2]: Nombre (texto)
     * args[3]: Saldo inicial (decimal)
     */
    public static void main(String args[]) {
        Cliente cliente = new Cliente(Integer.valueOf(args[0]), String.valueOf(args[1]), String.valueOf(args[2]), Double.valueOf(args[3]));
        System.out.println("Saldo actual (1): $" + cliente.getSaldo());
        System.out.println("** Modificamos saldo **");
        cliente.nuevoSaldo(10.5);
        System.out.println("Saldo actual (2): $" + cliente.getSaldo());
        System.out.println("** Añadimos saldo **");
        cliente.agregaSaldo(189.5);
        System.out.println("Saldo actual (3): $" + cliente.getSaldo());
        System.out.println("\n");
        cliente.mostrar();
    }
}
