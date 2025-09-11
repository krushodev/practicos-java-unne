import java.util.Scanner;

/**
 * Clase que realiza operaciones básicas sobre un vector (array) de notas de alumnos.
 * Permite ingresar un número fijo de notas, y luego calcula el promedio y
 * encuentra la nota más alta.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class OperarVector
{
    /**
     * Método principal que gestiona la entrada de datos y los cálculos.
     * El programa solicita al usuario que ingrese 5 notas. Mientras las ingresa,
     * calcula la suma total y determina la mayor nota. Finalmente, muestra
     * todas las notas, el promedio y la mayor nota registrada.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        int cantNotas = 5;
        int [] notas = new int[cantNotas];
        int i;
        int nota = 0;
        int mayorNota = 0;
        int acum = 0;
        
        
        for(i = 0; i < cantNotas; i++) {
            System.out.println("INGRESA LA NOTA DE UN ALUMNO: ");
            nota = teclado.nextInt();
            notas[i] = nota;
            if (nota > mayorNota) {
                mayorNota = nota;
            }
            acum += nota;
        }
    
        System.out.println("ELEMENTOS INGRESADOS:\t" + notas[0] + "\t" + notas[1] + "\t" + notas[2] + "\t" + notas[3] + "\t" + notas[4]); 
        // Nota: El cálculo del promedio usa división entera antes de convertir a Double.
        System.out.println("PROMEDIO: " + (Double.valueOf(acum / cantNotas)));
        System.out.println("MAYOR NOTA REGISTRADA: " + mayorNota);
        
    }
}