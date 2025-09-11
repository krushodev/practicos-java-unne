import java.util.*;
import java.util.Scanner;

/**
 * Clase ejecutable para la gestión de una colección de objetos Punto.
 * El programa solicita al usuario la entrada de coordenadas para un
 * conjunto predefinido de puntos, los almacena en un array y, posteriormente,
 * itera sobre la colección para mostrar información detallada de cada punto
 * y la distancia euclidiana entre puntos consecutivos.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class ArrayDePuntos
{
    /**
     * Punto de entrada principal de la aplicación.
     * Gestiona la interacción con el usuario para la creación de los puntos
     * y la presentación de los resultados.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        
        double x = 0.0;
        double y = 0.0;
        
        Punto puntos[] = new Punto[6];
        
        System.out.println("------ Colecciones de Puntos ------");
        
        // Bucle para solicitar y crear cada punto
        for (int i = 0; i < 6; i++) {
            System.out.println("# Punto " + (i + 1));
            System.out.println("Ingresa la coordenada para el eje X: ");
            x = teclado.nextDouble();
        
            System.out.println("Ingresa la coordenada para el eje Y: ");
            y = teclado.nextDouble();
        
            Punto nuevoPunto = new Punto(x, y);
            
            puntos[i] = nuevoPunto;
        }
        
        // Bucle para mostrar la información de los puntos y las distancias
        for (int i = 0; i < puntos.length; i++) {
            System.out.println("Información del punto: " + (i + 1));
                System.out.println(" - Coordenadas: " + puntos[i].coordenadas());
            
            if ((i + 1) != puntos.length) {
                System.out.println (" - Distancia al próximo punto" + " ("+ puntos[i + 1].coordenadas() + "): " + puntos[i].distanciaA(puntos[i + 1]));
            }           
        }
    }
}

