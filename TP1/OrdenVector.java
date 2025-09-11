import java.util.Scanner;

/**
 * Clase que maneja un vector de números de tipo double.
 * Lee una cantidad fija de elementos, encuentra el menor de ellos,
 * ordena el vector de menor a mayor y muestra los resultados.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class OrdenVector
{
    /**
     * Método principal del programa.
     * Primero, solicita al usuario 4 elementos numéricos, los almacena en un
     * array y encuentra el menor valor durante la entrada.
     * Después, utiliza el algoritmo de ordenamiento de burbuja (Bubble Sort)
     * para ordenar el array. Finalmente, imprime el menor elemento encontrado
     * y el array ya ordenado.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        int cantElementos = 4;
        double [] elementos = new double[cantElementos];
        double menorElem = 999999999;
        double elem = 0.0;
        
        
        // Fase de lectura y búsqueda del menor elemento
        for(int i = 0; i < cantElementos; i++) {
            System.out.println("INGRESA EL ELEMENTO: ");
            elem = teclado.nextDouble();
            elementos[i] = elem;
            if (elem < menorElem) {
                menorElem = elem;
            }
        }
        
        // Fase de ordenamiento usando Bubble Sort
        for(int i = 0; i < cantElementos; i++) {
            for (int j = 0; j < cantElementos - i - 1; j++) {
                if (elementos[j] > elementos[j + 1]) {
                    double aux = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = aux;
                }
            }
        }
    
        System.out.println("MENOR ELEMENTO REGISTRADO: " + menorElem);
        System.out.println("ELEMENTOS ORDENANOS:\t" + elementos[0] + "\t" + elementos[1] + "\t" + elementos[2] + "\t" + elementos[3]);
        
        
    }
}