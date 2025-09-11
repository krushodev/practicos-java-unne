import java.util.Scanner;

/**
 * Clase ejecutable para probar la funcionalidad de la clase Empleado.
 * Solicita los datos del empleado por teclado, crea una instancia 
 * y muestra su información de dos formas distintas.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class EjecutableEmpleado
{
    /**
     * Método principal que inicia la ejecución.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingrese un CUIL: ");
        long cuil = teclado.nextLong();
        System.out.println("Ingrese un Apellido: ");
        String apellido = teclado.next();
        System.out.println("Ingrese un Nombre: ");
        String nombre = teclado.next();
        System.out.println("Ingrese un Importe: ");
        double importe = teclado.nextDouble();
        System.out.println("Ingrese un Año de Ingreso: ");
        int anioIngreso = teclado.nextInt();
        
        Empleado empleado = new Empleado(cuil, apellido, nombre, importe, anioIngreso);
                
        empleado.mostrar();
        System.out.println(empleado.mostrarLinea());
    }
}
