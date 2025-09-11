/**
 * Clase ejecutable para probar la funcionalidad de la clase Punto.
 * Crea un punto a partir de argumentos de línea de comandos, lo desplaza 
 * y muestra sus coordenadas.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class EjecutablePunto
{
    /**
     * Método principal que inicia la ejecución.
     * @param args Argumentos de la línea de comandos. Se espera dos argumentos:
     * args[0]: Valor para la coordenada X (decimal).
     * args[1]: Valor para la coordenada Y (decimal).
     */
    public static void main(String args[]) {
        Punto punto = new Punto(Double.valueOf(args[0]), Double.valueOf(args[1]));
        
        System.out.println("Desplazamos a 5 a X y con 2 a Y: ");
        punto.desplazar(5, 2);
        
        System.out.println(punto.coordenadas());
        punto.mostrar();
    }
}
