/**
 * Clase ejecutable para probar la funcionalidad de las clases Laboratorio y Producto.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */

public class GestionStock
{
    /**
     * Método principal que inicia la ejecución.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
       Laboratorio laboratorio = new Laboratorio("Colgate S.A.", "Scalabrini Ortiz 5524", "54-11 -4239-8447"); 
        
       Producto producto = new Producto(123, "Perfumería", "Jabón Deluxe", 5.25, laboratorio);
       
       producto.ajuste(500);
       producto.mostrar();
       producto.ajuste(-200);
       System.out.println("\n");
       producto.mostrar();
       System.out.println("\n");
       System.out.println(producto.mostrarLinea());
    }
}
