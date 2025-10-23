import java.util.Scanner;
import java.util.*;

/**
 * Clase ejecutable que simula una interfaz de consola para la gestión
 * de Alumnos y Personas en una institución educativa. Provee un menú
 * para la creación y visualización de registros.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Escuela {
    /**
     * Punto de entrada principal para la aplicación de gestión.
     * Gestiona la interacción con el usuario a través de un menú de opciones
     * para crear y listar objetos de tipo Alumno y Persona.
     * * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        ArrayList<Persona> personas = new ArrayList<>();
        ArrayList<Alumno> alumnos = new ArrayList<>();

        int opcion = 0;

        do {
            System.out.println("\n--- Menú de Gestión de Alumnos y Personas ---");
            System.out.println("1. Crear alumno");
            System.out.println("2. Crear persona");
            System.out.println("3. Mostrar personas");
            System.out.println("4. Mostrar alumnos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\n--- Crear Alumno ---");
                    System.out.println("Ingrese el DNI del alumno: ");
                    int dniAlumno = teclado.nextInt();
                    System.out.println("Ingrese el nombre del alumno: ");
                    String nombreAlumno = teclado.next();
                    System.out.println("Ingrese el apellido del alumno: ");
                    String apellidoAlumno = teclado.next();
                    System.out.println("Ingrese la fecha de nacimiento del alumno: ");
                    System.out.println("\t Día: ");
                    int diaAlumno = teclado.nextInt();
                    System.out.println("\t Mes: ");
                    int mesAlumno = teclado.nextInt();
                    System.out.println("\t Año: ");
                    int anioAlumno = teclado.nextInt();
                    Calendar fechaAlumno = new GregorianCalendar(anioAlumno, mesAlumno, diaAlumno);
                    System.out.println("Ingrese la LU del alumno: ");
                    int luAlumno = teclado.nextInt();
                    Alumno alumno = new Alumno(dniAlumno, luAlumno, nombreAlumno, apellidoAlumno, fechaAlumno);
                    System.out.println("Ingrese la primera nota del alumno: ");
                    double nota1Alumno = teclado.nextDouble();
                    alumno.setNota1(nota1Alumno);
                    System.out.println("Ingrese la segunda nota del alumno: ");
                    double nota2Alumno = teclado.nextDouble();
                    alumno.setNota2(nota2Alumno);
                    alumnos.add(alumno);
                    System.out.println("Alumno creado correctamente: " + alumno.nomYApe());
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
                    System.out.println("\n--- Mostrar Alumnos ---");
                    if (alumnos.size() == 0) {
                        System.out.println("No hay alumnos registrados.");
                        break;
                    }
                    for (int i = 0; i < alumnos.size(); i++) {
                        System.out.println(i + 1 + ": ");
                        alumnos.get(i).mostrar();
                    }
                    break;

                case 5:
                    System.out.println("Has salido del sistema de gestión de alumnos y personas.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
        teclado.close();
    }
}
