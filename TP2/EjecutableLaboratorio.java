/**
 * Clase ejecutable para probar la funcionalidad de la clase Laboratorio.
 * Crea una instancia, modifica algunos de sus datos y muestra la información.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class EjecutableLaboratorio
{
    /**
     * Método principal que inicia la ejecución.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Laboratorio laboratorio = new Laboratorio("Colgate S.A", "Junín 5204", "54-11-4239-8447");
        laboratorio.nuevaCompraMinima(2000);
        laboratorio.nuevoDiaEntrega(21);
        
        System.out.println(laboratorio.mostrar());
        
        System.out.println("Nueva compra mínima: " + laboratorio.getCompraMinima());
        System.out.println("Nueva día entrega: " + laboratorio.getDiaEntrega());
    }
}
