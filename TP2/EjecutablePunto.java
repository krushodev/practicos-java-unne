import java.util.Scanner;

/**
 * Clase ejecutable para probar la funcionalidad de la clase Punto.
 * Solicita las coordenadas de un punto por teclado, lo crea, 
 * lo desplaza y muestra sus coordenadas de dos formas.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class EjecutablePunto
{
    /**
     * Método principal que inicia la ejecución.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingrese el valor de X: ");
        double x = teclado.nextDouble();
        System.out.println("Ingrese el valor de Y: ");
        double y = teclado.nextDouble();
        
        Punto punto = new Punto(x, y);
        
        System.out.println("Desplazamos a 5 a X y con 2 a Y: ");
        punto.desplazar(5, 2);
        
        System.out.println(punto.coordenadas());
        punto.mostrar();
    }
}
