/**
 * Clase que demuestra las operaciones aritméticas básicas en Java.
 * Realiza suma, resta, multiplicación, división y resto entre dos números enteros.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Operador
{
    /**
     * El método principal que sirve como punto de entrada para el programa.
     * Declara dos variables enteras, realiza operaciones aritméticas con ellas
     * y muestra los resultados en la consola.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String args[]) {
        int a = 8;
        int b = 3;
        
        System.out.println("OPERACIONES ENTRE " + a + " Y " + b);
        
        System.out.println("SUMA: " + (a + b));
        System.out.println("RESTA: " + (a - b));
        System.out.println("MULTIPLICACIÓN: " + (a * b));
        System.out.println("DIVISIÓN: " + (a / b));
        System.out.println("RESTO: " + (a % b));
    }
}