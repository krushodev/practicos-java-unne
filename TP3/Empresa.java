import java.util.*;

/**
 * Clase ejecutable para gestionar empleados, permitiendo ingresar los datos por teclado
 * y mostrando la información junto a la cantidad de horas que puede retirarse
 * antes según la antigüedad.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Empresa
{
    /**
     * Método principal que inicia la ejecución del programa.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese CUIL:");
        long cuil = teclado.nextLong();

        System.out.println("Ingrese Apellido:");
        String apellido = teclado.next();

        System.out.println("Ingrese Nombre:");
        String nombre = teclado.next();

        System.out.println("Ingrese Sueldo Básico:");
        double sueldoBasico = teclado.nextDouble();

        System.out.println("Ingrese fecha de ingreso:");
        System.out.print("Año (YYYY): ");
        int anio = teclado.nextInt();
        System.out.print("Mes (1-12): ");
        int mes = teclado.nextInt();
        System.out.print("Día: ");
        int dia = teclado.nextInt();

        Calendar fechaIngreso = new GregorianCalendar(anio, mes - 1, dia);

        Empleado empleado = new Empleado(cuil, apellido, nombre, sueldoBasico, fechaIngreso);

        System.out.println("\n--- Datos del Empleado ---\n");
        empleado.mostrar();

        int horasAnticipadas = empleado.antiguedad();
        System.out.println("Puede retirarse " + horasAnticipadas + " hora(s) antes por antigüedad.");

        if (empleado.esAniversario()) {
            System.out.println("¡Hoy es el aniversario de ingreso del empleado!");
        }
    }
}
