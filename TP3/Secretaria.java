import java.util.Scanner;
import java.util.Random;

/**
 * Clase ejecutable para probar la interacción entre las clases Escuela y Docente.
 * Permite ingresar los datos de un docente por teclado y luego imprime su recibo de sueldo.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Secretaria
{
    /**
     * Método principal que inicia la ejecución.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        
        Escuela escuela = new Escuela("Manuel Belgrano", "Irigoyen 1580", "Leopoldo Juez");
        
        System.out.println("Ingrese el nombre del docente: ");
        String nombreDocente = teclado.next();
        System.out.println("Ingrese el grado del docente: ");
        String gradoDocente = teclado.next();
        System.out.println("Ingrese el sueldo básico del docente: ");
        double sueldoBasico = teclado.nextDouble();
        System.out.println("Ingrese la asignación familiar del docente: ");
        double asignacionFamiliar = teclado.nextDouble();
        
        Docente docente = new Docente(nombreDocente, gradoDocente, sueldoBasico, asignacionFamiliar);
        
        escuela.imprimirRecibo(docente);
    }
}
