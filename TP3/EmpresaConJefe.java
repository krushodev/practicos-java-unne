import java.util.*;

/**
 * Clase ejecutable para gestionar empleados que pueden tener un jefe.
 * Permite ingresar por teclado los datos de un empleado y, opcionalmente,
 * los de su jefe, para luego mostrar la información de la jerarquía.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class EmpresaConJefe
{
    /**
     * Método principal que inicia la ejecución del programa.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese los datos del EMPLEADO:");
        System.out.println("CUIL:");
        long cuil = teclado.nextLong();

        System.out.println("Apellido:");
        String apellido = teclado.next();

        System.out.println("Nombre:");
        String nombre = teclado.next();

        System.out.println("Sueldo Básico:");
        double sueldoBasico = teclado.nextDouble();

        System.out.println("Fecha de ingreso:");
        System.out.print("Año (YYYY): ");
        int anio = teclado.nextInt();
        System.out.print("Mes (1-12): ");
        int mes = teclado.nextInt();
        System.out.print("Día: ");
        int dia = teclado.nextInt();

        Calendar fechaIngreso = new GregorianCalendar(anio, mes - 1, dia);

        System.out.print("¿El empleado tiene jefe? (s/n): ");
        String tieneJefe = teclado.next();

        EmpleadoConJefe jefe = null;

        if (tieneJefe.equalsIgnoreCase("s")) {
            System.out.println("\nIngrese los datos del JEFE:");
            System.out.println("CUIL del jefe:");
            long cuilJefe = teclado.nextLong();

            System.out.println("Apellido del jefe:");
            String apellidoJefe = teclado.next();

            System.out.println("Nombre del jefe:");
            String nombreJefe = teclado.next();

            System.out.println("Sueldo Básico del jefe:");
            double sueldoBasicoJefe = teclado.nextDouble();

            System.out.println("Fecha de ingreso del jefe:");
            System.out.print("Año (YYYY): ");
            int anioJefe = teclado.nextInt();
            System.out.print("Mes (1-12): ");
            int mesJefe = teclado.nextInt();
            System.out.print("Día: ");
            int diaJefe = teclado.nextInt();

            Calendar fechaIngresoJefe = new GregorianCalendar(anioJefe, mesJefe - 1, diaJefe);

            jefe = new EmpleadoConJefe(cuilJefe, apellidoJefe, nombreJefe, sueldoBasicoJefe, fechaIngresoJefe);
        }

        EmpleadoConJefe empleado = new EmpleadoConJefe(cuil, apellido, nombre, sueldoBasico, fechaIngreso, jefe);

        System.out.println("\n--- Datos del EMPLEADO ---\n");
        empleado.mostrarPantalla();

        int horasAnticipadas = empleado.antiguedad();
        System.out.println("Puede retirarse " + horasAnticipadas + " hora(s) antes por antigüedad.");

        if (empleado.esAniversario()) {
            System.out.println("¡Hoy es el aniversario de ingreso del empleado!");
        }
    }
}
