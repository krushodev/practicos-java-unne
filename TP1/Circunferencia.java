/**
 * Clase que calcula el perímetro (longitud) de una circunferencia
 * a partir de un radio proporcionado.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Circunferencia
{
    /**
     * Punto de entrada del programa.
     * Lee el radio de la circunferencia desde los argumentos de la línea de comandos,
     * calcula su perímetro usando la fórmula 2 * PI * radio y muestra
     * el resultado en la consola.
     *
     * @param args Un array de strings que contiene los argumentos de la línea de comandos.
     * Se espera que args[0] contenga el valor del radio como un número entero.
     */
    public static void main(String args[]) {
        int radio = Integer.valueOf(args[0]);
        
        double perimetro = 2 * (Math.PI * radio);
        
        System.out.println("EL PERÍMETRO ES: " + perimetro);
        
    }
}