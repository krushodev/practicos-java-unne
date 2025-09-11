import java.util.Scanner;
import java.util.Random;

/**
 * Clase ejecutable para probar la funcionalidad de las clases Punto y Circulo.
 * Solicita las coordenadas de un punto por teclado, crea dos círculos,
 * los compara y calcula la distancia entre ellos.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class CreaFigura
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
        
        Circulo circulo1 = new Circulo(((new Random()).nextDouble() * 100.0), punto);
        
        circulo1.desplazar(-240, -230);
        
        System.out.println("\n");
        
        circulo1.caracteristicas();
        
        Circulo circulo2 = new Circulo(((new Random()).nextDouble() * 100.0), new Punto(5.2, 0.5));
        
        Circulo circuloMayor = circulo1.elMayor(circulo2);
        
        System.out.println("\n");
        
        System.out.println("El círculo con mayor superficie es:");
        circuloMayor.caracteristicas();
        
        System.out.println("\n");
        
        System.out.println("La distancia entre el círculo 1 y el círculo 2 es de: " + circulo1.distanciaA(circulo2));
    }
}
