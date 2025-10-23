import java.util.Scanner;
import java.util.*;

/**
 * Clase ejecutable que simula una interfaz de consola para la gestión
 * de Empleados, Jefes y Personas dentro de una empresa. Provee un menú
 * para la creación y visualización de registros.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Empresa {
    /**
     * Punto de entrada principal para la aplicación de gestión.
     * Gestiona la interacción con el usuario a través de un menú de opciones
     * para crear y listar objetos de tipo Empleado, Jefe (que es un Empleado) y Persona.
     * * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Empleado> jefes = new ArrayList<>();
        ArrayList<Persona> personas = new ArrayList<>();

        int opcion = 0;

        do {
            System.out.println("\n--- Menú de Gestión de Empleados y Personas ---");
            System.out.println("1. Crear empleado");
            System.out.println("2. Crear persona");
            System.out.println("3. Mostrar personas");
            System.out.println("4. Mostrar empleados");
            System.out.println("5. Mostrar jefes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\n--- Crear Empleado ---");
                    System.out.println("Ingrese el CUIL del empleado: ");
                    long cuilEmpleado = teclado.nextLong();
                    System.out.println("Ingrese el apellido del empleado: ");
                    String apellidoEmpleado = teclado.next();
                    System.out.println("Ingrese el nombre del empleado: ");
                    String nombreEmpleado = teclado.next();
                    System.out.println("Ingrese el sueldo básico del empleado: ");
                    double sueldoBasicoEmpleado = teclado.nextDouble();
                    System.out.println("Ingrese el DNI del empleado: ");
                    int dniEmpleado = teclado.nextInt();
                    System.out.println("Ingrese la fecha de ingreso del empleado: ");
                    System.out.println("\t Día: ");
                    int diaIngresoEmpleado = teclado.nextInt();
                    System.out.println("\t Mes: ");
                    int mesIngresoEmpleado = teclado.nextInt();
                    System.out.println("\t Año: ");
                    int anioIngresoEmpleado = teclado.nextInt();
                    Calendar fechaIngresoEmpleado = new GregorianCalendar(anioIngresoEmpleado, mesIngresoEmpleado,
                            diaIngresoEmpleado);
                    System.out.println("Ingrese la fecha de nacimiento del empleado: ");
                    System.out.println("\t Día: ");
                    int diaNacEmpleado = teclado.nextInt();
                    System.out.println("\t Mes: ");
                    int mesNacEmpleado = teclado.nextInt();
                    System.out.println("\t Año: ");
                    int anioNacEmpleado = teclado.nextInt();
                    Calendar fechaNacEmpleado = new GregorianCalendar(anioNacEmpleado, mesNacEmpleado, diaNacEmpleado);
                    System.out.println("¿El empleado tiene un jefe? (s/n): ");
                    String respuesta = teclado.next();
                    if (respuesta.equals("s")) {
                        if (jefes.size() == 0) {
                            System.out.println("\n--- Crear Jefe ---");
                            System.out.println("Ingrese el CUIL del jefe: ");
                            long cuilJefe = teclado.nextLong();
                            System.out.println("Ingrese el apellido del jefe: ");
                            String apellidoJefe = teclado.next();
                            System.out.println("Ingrese el nombre del jefe: ");
                            String nombreJefe = teclado.next();
                            System.out.println("Ingrese el sueldo básico del jefe: ");
                            double sueldoBasicoJefe = teclado.nextDouble();
                            System.out.println("Ingrese el DNI del jefe: ");
                            int dniJefe = teclado.nextInt();
                            System.out.println("Ingrese la fecha de ingreso del jefe: ");
                            System.out.println("\t Día: ");
                            int diaIngresoJefe = teclado.nextInt();
                            System.out.println("\t Mes: ");
                            int mesIngresoJefe = teclado.nextInt();
                            System.out.println("\t Año: ");
                            int anioIngresoJefe = teclado.nextInt();
                            Calendar fechaIngresoJefe = new GregorianCalendar(anioIngresoJefe,
                                    mesIngresoJefe,
                                    diaIngresoJefe);
                            System.out.println("Ingrese la fecha de nacimiento del jefe: ");
                            System.out.println("\t Día: ");
                            int diaNacJefe = teclado.nextInt();
                            System.out.println("\t Mes: ");
                            int mesNacJefe = teclado.nextInt();
                            System.out.println("\t Año: ");
                            int anioNacJefe = teclado.nextInt();
                            Calendar fechaNacJefe = new GregorianCalendar(anioNacJefe, mesNacJefe,
                                    diaNacJefe);
                            Empleado jefe = new Empleado(cuilJefe, apellidoJefe, nombreJefe, sueldoBasicoJefe,
                                    fechaIngresoJefe, dniJefe, fechaNacJefe);
                            jefes.add(jefe);
                            System.out.println("Jefe creado correctamente: " + jefe.nomYApe());
                            Empleado empleado = new Empleado(cuilEmpleado, apellidoEmpleado, nombreEmpleado,
                                    sueldoBasicoEmpleado, fechaIngresoEmpleado, jefe, dniEmpleado, fechaNacEmpleado);
                            empleados.add(empleado);
                            System.out.println("\nEmpleado creado correctamente: " + empleado.nomYApe());
                            break;
                        } else {
                            System.out.println("Lista de jefes: ");
                            for (int i = 0; i < jefes.size(); i++) {
                                System.out.println(i + 1 + ": ");
                                jefes.get(i).mostrar();
                            }
                            System.out.println("Ingrese el número del jefe: ");
                            int numeroJefe = teclado.nextInt();
                            Empleado jefe = jefes.get(numeroJefe - 1);
                            Empleado empleado = new Empleado(cuilEmpleado, apellidoEmpleado, nombreEmpleado,
                                    sueldoBasicoEmpleado, fechaIngresoEmpleado, jefe, dniEmpleado, fechaNacEmpleado);
                            empleados.add(empleado);
                            System.out.println("Empleado creado correctamente: " + empleado.nomYApe());
                        }
                    } else {
                        Empleado empleado = new Empleado(cuilEmpleado, apellidoEmpleado, nombreEmpleado,
                                sueldoBasicoEmpleado, fechaIngresoEmpleado, dniEmpleado, fechaNacEmpleado);
                        empleados.add(empleado);
                        System.out.println("Empleado creado correctamente: " + empleado.nomYApe());
                    }
                    break;
                case 2:
                    System.out.println("\n--- Crear Persona ---");
                    System.out.println("Ingrese el DNI de la persona: ");
                    int dniPersona = teclado.nextInt();
                    System.out.println("Ingrese el nombre de la persona: ");
                    String nombrePersona = teclado.next();
                    System.out.println("Ingrese el apellido de la persona: ");
                    String apellidoPersona = teclado.next();
                    System.out.println("Ingrese la fecha de nacimiento de la persona: ");
                    System.out.println("\t Día: ");
                    int diaPersona = teclado.nextInt();
                    System.out.println("\t Mes: ");
                    int mesPersona = teclado.nextInt();
                    System.out.println("\t Año: ");
                    int anioPersona = teclado.nextInt();
                    Calendar fechaPersona = new GregorianCalendar(anioPersona, mesPersona, diaPersona);
                    Persona persona = new Persona(dniPersona, nombrePersona, apellidoPersona, fechaPersona);
                    personas.add(persona);
                    System.out.println("Persona creada correctamente: " + persona.nomYApe());
                    break;

                case 3:
                    System.out.println("\n--- Mostrar Personas ---");
                    if (personas.size() == 0) {
                        System.out.println("No hay personas registradas.");
                        break;
                    }
                    for (int i = 0; i < personas.size(); i++) {
                        System.out.println(i + 1 + ": ");
                        personas.get(i).mostrar();
                    }
                    break;

                case 4:
                    System.out.println("\n--- Mostrar Empleados ---");
                    if (empleados.size() == 0) {
                        System.out.println("No hay empleados registrados.");
                        break;
                    }
                    for (int i = 0; i < empleados.size(); i++) {
                        System.out.println(i + 1 + ": ");
                        empleados.get(i).mostrar();
                    }
                    break;

                case 5:
                    System.out.println("\n--- Mostrar Jefes ---");
                    if (jefes.size() == 0) {
                        System.out.println("No hay jefes registrados.");
                        break;
                    }
                    for (int i = 0; i < jefes.size(); i++) {
                        System.out.println(i + 1 + ": ");
                        jefes.get(i).mostrar();
                    }
                    break;

                case 6:
                    System.out.println("Has salido del sistema de gestión de empleados y personas.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);
        teclado.close();
    }
}
