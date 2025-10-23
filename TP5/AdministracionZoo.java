import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

/**
 * Clase ejecutable para la administración del Zoológico "El Caribú".
 * Simula la creación de visitantes y delegaciones, los registra y genera
 * reportes de visitas y recaudación.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class AdministracionZoo {
    /**
     * Punto de entrada principal de la aplicación del zoológico.
     * Crea instancias de Persona, Individuo y Delegacion, las agrega a un objeto
     * Zoologico y luego imprime varios listados y el total de recaudación.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico("El Caribú");

        Calendar fecha = new GregorianCalendar(2024, Calendar.SEPTEMBER, 22);

        Persona p1 = new Persona(14528796, "María", "Perez", 1986);
        Persona p2 = new Persona(23568963, "Lucía", "Lusteau", 1978);
        Persona p3 = new Persona(24875785, "Carlos", "Lopez", 2002);

        Individuo i1 = new Individuo(fecha, p1);
        Individuo i2 = new Individuo(fecha, p2);
        Individuo i3 = new Individuo(fecha, p3);

        Delegacion pami = new Delegacion("PAMI", fecha);
        pami.inscribirIndividuo(i2);
        pami.inscribirIndividuo(i3);

        zoo.nuevoVisitante(i1);
        zoo.nuevoVisitante(pami);

        System.out.println("==== Visitantes del día ====");
        zoo.listarVisitantePorFecha(fecha);

        System.out.println("\n==== Delegaciones del día ====");
        zoo.listarTipoVisitantePorFecha(fecha, "Delegacion");

        Calendar inicio = new GregorianCalendar(2024, Calendar.SEPTEMBER, 1);
        Calendar fin = new GregorianCalendar(2024, Calendar.SEPTEMBER, 30);
        System.out.println("\nRecaudación total del mes: $" + zoo.recaudacion(inicio, fin));

        System.out.println("\n==== Personas que visitaron el zoo ====");
        HashSet<Persona> personas = zoo.listarPersonaQueVisitaronElZoo();
        for (Persona p : personas) {
            p.mostrar();
            System.out.println("----");
        }
    }
}
