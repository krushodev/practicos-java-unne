import java.util.Scanner;

/**
 * Clase que calcula repetidamente el perímetro de una circunferencia.
 * El programa solicita al usuario que ingrese un valor para el radio y continúa
 * haciéndolo hasta que el usuario decida cancelar la operación.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Circunferencia2
{
    /**
     * Método principal que interactúa con el usuario.
     * Utiliza un bucle `while` para solicitar radios y calcular perímetros.
     * El bucle se termina cuando el usuario ingresa el valor -1.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        String mensaje = "INGRESA UN VALOR PARA EL RADIO:  (-1 PARA CANCELAR)";
        
        System.out.println(mensaje);
        int radio = teclado.nextInt();
        
        
        while (radio != -1) {
            double perimetro = 2 * (Math.PI * radio);
            System.out.println("INGRESASTE EL RADIO: " + radio + " Y EL PERÍMETRO ES: " + perimetro);
            System.out.println(mensaje);
            radio = teclado.nextInt();
        }
    }
}