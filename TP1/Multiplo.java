/**
 * Clase diseñada para encontrar e imprimir los múltiplos de un número específico
 * dentro de un rango determinado.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Multiplo
{
    /**
     * El método principal del programa.
     * Itera a través de un rango de números (del 42 al 150) y comprueba si cada
     * número es múltiplo de 4. Si lo es, lo imprime en la consola.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String args[]) {
        int i;
        
        System.out.println("MÚLTIPLOS DE 4, DESDE EL 42 AL 150: ");
        
        for (i = 42; i <= 150; i++){
            if ((i % 4) == 0) {
                System.out.println(i);
            }
        }
    }
}