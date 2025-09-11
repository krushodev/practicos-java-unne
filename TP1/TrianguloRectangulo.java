/**
 * Clase que determina si un triángulo es rectángulo dadas las longitudes de sus
 * tres lados.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class TrianguloRectangulo
{
    /**
     * Método principal del programa.
     * Recibe la longitud de la hipotenusa y los dos catetos como argumentos
     * de la línea de comandos. Aplica el Teorema de Pitágoras para verificar si
     * el cuadrado de la hipotenusa es igual a la suma de los cuadrados de los catetos.
     *
     * @param args Array de strings. Se espera que args[0] sea la hipotenusa,
     * args[1] el primer cateto y args[2] el segundo cateto.
     */
    public static void main(String args[]) {
        double h = Double.valueOf(args[0]);
        double cateto1 = Double.valueOf(args[1]);
        double cateto2 = Double.valueOf(args[2]);
        
        boolean esRectangulo = Math.pow(h,2) == ((Math.pow(cateto1, 2) + (Math.pow(cateto2, 2))));
        
        if (esRectangulo) {
            System.out.println("EL TRIÁNGULO ES RECTÁNGULO");
        } else {
            System.out.println("EL TRIÁNGULO NO ES RECTÁNGULO");
        }
        
    }
}