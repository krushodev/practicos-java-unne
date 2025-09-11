/**
 * Clase ejecutable para probar la funcionalidad de la clase Alumno.
 * Crea una instancia de Alumno a partir de argumentos de línea de comandos, 
 * le asigna notas y muestra su información.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class EjecutableAlumno
{
    /**
     * Método principal que inicia la ejecución.
     * @param args Argumentos de la línea de comandos. Se esperan 5 argumentos:
     * args[0]: LU (entero)
     * args[1]: Apellido (texto)
     * args[2]: Nombre (texto)
     * args[3]: Nota 1 (decimal)
     * args[4]: Nota 2 (decimal)
     */
    public static void main(String args[]) {
        Alumno alumno = new Alumno(Integer.valueOf(args[0]), String.valueOf(args[1]), String.valueOf(args[2]));
        
        alumno.setNota1(Double.valueOf(args[3]));
        alumno.setNota2(Double.valueOf(args[4]));
        
        alumno.mostrar();
        System.out.println("\n");
    }
}
