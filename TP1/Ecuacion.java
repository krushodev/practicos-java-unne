/**
 * Clase que resuelve una ecuación de segundo grado de la forma ax^2 + bx + c = 0.
 * Utiliza la fórmula cuadrática para encontrar las raíces reales de la ecuación.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Ecuacion
{
    /**
     * Punto de entrada del programa.
     * Recibe los coeficientes 'a', 'b' y 'c' como argumentos de la línea de comandos.
     * Calcula el discriminante para determinar la naturaleza de las raíces.
     * Muestra las raíces si son reales (una o dos) o un mensaje si son complejas.
     *
     * @param args Array de strings. Se espera que args[0], args[1] y args[2] contengan
     * los valores numéricos para los coeficientes a, b y c, respectivamente.
     */
    public static void main(String args[]) {
        double a = Double.valueOf(args[0]);
        double b = Double.valueOf(args[1]);
        double c = Double.valueOf(args[2]);
        
        // Se calcula el discriminante directamente con la raíz cuadrada.
        double discriminante = Math.sqrt((Math.pow(b,2) - (4 * a * c)));
        
        if (discriminante > 0) {
            double x1 = ((-b) + discriminante) / (2 * a);
            double x2 = ((-b) - discriminante) / (2 * a);
            
            System.out.println("LA ECUACIÓN TIENE 2 RAÍCES REALES: ");
            System.out.println("x1 = " + x1 + " y x2 = " + x2);
        } else if (discriminante == 0) {
            double x1 = (-b) / (2 * a);
        
            System.out.println("LA ECUACIÓN TIENE 1 RAÍZ REAL: ");
            System.out.println("x1 y x2 = " + x1);
        } else {
            // Este caso se ejecuta si el discriminante es negativo.
            System.out.println("LA ECUACIÓN NO TIENE RAICES REALES (SOLUCIÓN COMPLEJA)");
        }
        
    }
}