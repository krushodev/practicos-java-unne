import java.util.Scanner;
import java.util.Random;

/**
 * Clase ejecutable para probar la funcionalidad de las clases Punto y Rectangulo.
 * Solicita las coordenadas de un punto por teclado, crea dos rectángulos,
 * los compara y calcula la distancia entre ellos.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class CreaFigura2
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
        
        Rectangulo rectangulo1 = new Rectangulo(punto, ((new Random()).nextDouble() * 50.0), ((new Random()).nextDouble() * 50.0));
        
        rectangulo1.desplazar(40, -20);
        
        System.out.println("\n");
        
        rectangulo1.caracteristicas();
        
        Rectangulo rectangulo2 = new Rectangulo(new Punto(7.5, 4.5), ((new Random()).nextDouble() * 50.0), ((new Random()).nextDouble() * 50.0));
        
        Rectangulo rectanguloMayor = rectangulo1.elMayor(rectangulo2);
        
        System.out.println("\n");
        
        System.out.println("El rectángulo con mayor superficie es:");
        rectanguloMayor.caracteristicas();
        
        System.out.println("\n");
        
        System.out.println("La distancia entre el rectangulo 1 y el rectangulo 2 es de: " + rectangulo1.distanciaA(rectangulo2));
    }
}
