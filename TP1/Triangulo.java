/**
 * Clase para calcular el área de un triángulo utilizando la fórmula de Herón,
 * dadas las longitudes de sus tres lados.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Triangulo
{
    /**
     * Método principal que ejecuta el cálculo.
     * Recibe las longitudes de los tres lados del triángulo como argumentos
     * de la línea de comandos. Calcula primero el semiperímetro y luego
     * utiliza la fórmula de Herón para encontrar el área.
     * Imprime tanto el semiperímetro como el área en la consola.
     *
     * @param args Un array de strings que contiene los argumentos de la línea de comandos.
     * Se espera que args[0], args[1] y args[2] contengan las longitudes
     * de los lados a, b y c, respectivamente.
     */
    public static void main(String args[]) {
        double a = Double.valueOf(args[0]);
        double b = Double.valueOf(args[1]);
        double c = Double.valueOf(args[2]);
        
        
        double semiperimetro = (a+b+c) / 2;
        double area = Math.sqrt(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c));
        
        System.out.println("SEMIPERÍMETRO: " + semiperimetro);
        System.out.println("ÁREA: " + area);
    }
}