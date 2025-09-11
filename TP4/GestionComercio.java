import java.util.Scanner;
import java.util.*;

/**
 * Clase ejecutable que implementa una interfaz de consola para la gestión de empleados
 * en un comercio. Provee un menú para realizar operaciones de alta, baja, búsqueda,
 * y consulta de información sobre los empleados.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class GestionComercio {
    /**
     * Punto de entrada principal para la aplicación de gestión comercial.
     * Inicia el sistema y gestiona el bucle de interacción con el menú de opciones.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        Comercio comercio = new Comercio("Avanti SRL");

        int opcion = 0;

        System.out.println("------ BIENVENIDO AL SISTEMA DE GESTIÓN COMERCIAL ------");
        System.out.println("Comercio: " + comercio.getNombre());
        System.out.println("Cantidad de empleados: " + comercio.cantidadDeEmpleados());

        do {
            System.out.println("\n--- Menú de Gestión de Empleados ---");
            System.out.println("1. Dar de alta empleado");
            System.out.println("2. Dar de baja empleado");
            System.out.println("3. Buscar empleado por CUIL");
            System.out.println("4. Consultar sueldo neto de empleado");
            System.out.println("5. Mostrar nómina completa");
            System.out.println("6. Mostrar cantidad de empleados");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Dar de Alta Empleado ---");
                    System.out.print("Ingrese el CUIL del empleado: ");
                    long cuil = teclado.nextLong();

                    if (comercio.esEmpleado(cuil)) {
                        System.out.println("Ya existe un empleado con ese CUIL.");
                        break;
                    }

                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = teclado.next();
                    System.out.print("Ingrese el apellido del empleado: ");
                    String apellido = teclado.next();
                    System.out.print("Ingrese el sueldo básico: ");
                    double sueldoBasico = 0.0;
                    sueldoBasico = teclado.nextDouble();
                    System.out.print("Ingrese la fecha de ingreso: ");

                    System.out.print(" - Día de ingreso: ");
                    int dia = teclado.nextInt();
                    System.out.print(" - Mes de ingreso (1-12): ");
                    int mes = teclado.nextInt();
                    System.out.print(" - Año de ingreso: ");
                    int anio = teclado.nextInt();
                    Calendar fechaIngreso = new GregorianCalendar(anio, mes, dia);

                    Empleado empleado = new Empleado(cuil, apellido, nombre, sueldoBasico, fechaIngreso);
                    comercio.altaEmpleado(empleado);
                    System.out.println("Empleado dado de alta correctamente: " + empleado.nomYApe());
                    break;

                case 2:
                    System.out.println("\n--- Dar de Baja Empleado ---");
                    if (comercio.cantidadDeEmpleados() == 0) {
                        System.out.println("No hay empleados registrados.");
                        break;
                    }

                    System.out.print("Ingrese el CUIL del empleado a dar de baja: ");
                    long cuilBaja = 0;
                    cuilBaja = teclado.nextLong();

                    if (!comercio.esEmpleado(cuilBaja)) {
                        System.out.println("No existe un empleado con ese CUIL.");
                        break;
                    }

                    Empleado empleadoBaja = comercio.buscarEmpleado(cuilBaja);
                    System.out.println("Empleado encontrado: " + empleadoBaja.nomYApe());
                    System.out.print("¿Está seguro de dar de baja a este empleado? (s/n): ");
                    String confirmacion = teclado.next();

                    if (confirmacion.equals("s")) {
                        Empleado empleadoEliminado = comercio.bajaEmpleado(cuilBaja);
                        System.out.println("Empleado dado de baja correctamente: " + empleadoEliminado.nomYApe());
                    } else {
                        System.out.println("Operación cancelada.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Buscar Empleado por CUIL ---");
                    System.out.print("Ingrese el CUIL del empleado a buscar: ");
                    long cuilBuscar = 0;
                    cuilBuscar = teclado.nextLong();

                    if (!comercio.esEmpleado(cuilBuscar)) {
                        System.out.println("No existe un empleado con ese CUIL.");
                    } else {
                        Empleado empleadoEncontrado = comercio.buscarEmpleado(cuilBuscar);
                        System.out.println("\n--- Datos del Empleado ---");
                        empleadoEncontrado.mostrar();
                    }
                    break;

                case 4:
                    System.out.println("\n--- Consultar Sueldo Neto ---");
                    if (comercio.cantidadDeEmpleados() == 0) {
                        System.out.println("No hay empleados registrados.");
                        break;
                    }

                    System.out.print("Ingrese el CUIL del empleado: ");
                    long cuilSueldo = 0;
                    cuilSueldo = teclado.nextLong();

                    if (!comercio.esEmpleado(cuilSueldo)) {
                        System.out.println("No existe un empleado con ese CUIL.");
                    } else {
                        Empleado empleadoSueldo = comercio.buscarEmpleado(cuilSueldo);
                        System.out.println("Empleado: " + empleadoSueldo.nomYApe());
                        System.out.print("Sueldo neto: ");
                        comercio.sueldoNeto(cuilSueldo);
                    }
                    break;

                case 5:
                    System.out.println("\n--- Nómina Completa ---");
                    if (comercio.cantidadDeEmpleados() == 0) {
                        System.out.println("No hay empleados registrados.");
                    } else {
                        comercio.nomina();
                    }
                    break;

                case 6:
                    System.out.println("\n--- Cantidad de Empleados ---");
                    System.out.println(
                            "Total de empleados en " + comercio.getNombre() + ": " + comercio.cantidadDeEmpleados());
                    break;

                case 7:
                    System.out.println("Has salido del sistema de gestión comercial.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 7);
    }
}

