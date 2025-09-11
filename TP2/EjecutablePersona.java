/**
 * Clase ejecutable para probar la funcionalidad de la clase Persona.
 * Crea una instancia de Persona y muestra sus datos.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class EjecutablePersona
{
    /**
     * Método principal que inicia la ejecución.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String args[]) {
        Persona persona = new Persona(35123456, "Juan", "Perez", 2003);
        persona.mostrar();
    }
}
