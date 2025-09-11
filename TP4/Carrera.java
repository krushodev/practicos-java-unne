import java.util.Scanner;

/**
 * Clase ejecutable para la gestión de un curso académico a través de una
 * interfaz de consola. Permite la creación de un curso, la inscripción de
 * alumnos con sus notas, y la ejecución de operaciones como búsqueda,
 * baja y consulta de la nómina de inscritos.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Carrera {
    /**
     * Punto de entrada principal para la aplicación de gestión de la carrera.
     * Conduce al usuario a través de los pasos para nombrar un curso,
     * inscribir alumnos y realizar operaciones sobre la nómina.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        System.out.print("Ingrese el nombre del curso: ");
        String nombreCurso = teclado.next();
        Curso curso = new Curso(nombreCurso);

        System.out.print("Ingrese la cantidad de alumnos a inscribir: ");
        int cantidadAlumnos = teclado.nextInt();
        

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("\n--- Alumno " + (i + 1) + " ---");
            System.out.print("LU: ");
            int lu = teclado.nextInt();
            System.out.print("\nNombre: ");
            String nombre = teclado.next();
            System.out.print("\nApellido: ");
            String apellido = teclado.next();

            Alumno alumno = new Alumno(lu, nombre, apellido);

            System.out.print("\nNota 1: ");
            double nota1 = teclado.nextDouble();
            alumno.setNota1(nota1);

            System.out.print("\nNota 2: ");
            double nota2 = teclado.nextDouble();
            alumno.setNota2(nota2);

            curso.inscribirAlumno(alumno);
        }

        System.out.println("\nCantidad de alumnos inscriptos: " + curso.cantidadDeAlumnos());
        System.out.println("Lista de alumnos inscriptos:");
        curso.mostrarInscriptos();

        System.out.print("\nIngrese el LU del alumno a dar de baja: ");
        int luBaja = teclado.nextInt();
        Alumno alumnoBaja = curso.quitarAlumno(luBaja);
        if (alumnoBaja != null) {
            System.out.println("Alumno dado de baja: " + alumnoBaja.nomYApe());
        } else {
            System.out.println("No se encontró un alumno con ese LU.");
        }
        System.out.println("¿Está inscripto el alumno con LU " + luBaja + "? " + curso.estaInscripto(luBaja));

        System.out.println("\nLista actualizada de alumnos inscriptos:");
        curso.mostrarInscriptos();
        System.out.println("Cantidad total de alumnos inscriptos: " + curso.cantidadDeAlumnos());

        System.out.print("\nIngrese el LU de un alumno para buscarlo: ");
        int luBuscar = teclado.nextInt();
        Alumno alumnoBuscado = curso.buscarAlumno(luBuscar);
        if (alumnoBuscado != null) {
            System.out.println("Alumno encontrado:");
            alumnoBuscado.mostrar();

            System.out.print("Promedio del alumno: ");
            curso.imprimirPromedioDelAlumno(luBuscar);
        } else {
            System.out.println("No se encontró un alumno con ese LU.");
        }

    }
}

