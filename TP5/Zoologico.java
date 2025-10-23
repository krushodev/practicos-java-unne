import java.util.Calendar;
import java.util.HashSet;

/**
 * Representa un zoológico que gestiona una colección de visitantes.
 * Permite registrar, eliminar y listar visitantes, así como calcular
 * la recaudación total en un período determinado.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Zoologico
{
    private String nombre;
    private HashSet<Visitante> visitantes = new HashSet<>();

    /**
     * Constructor para instanciar un Zoologico con un nombre y una lista
     * de visitantes inicial.
     *
     * @param p_nombre      Nombre del zoológico.
     * @param p_visitantes  Colección HashSet de visitantes iniciales.
     */
    public Zoologico(String p_nombre, HashSet<Visitante> p_visitantes)
    {
        this.setNombre(p_nombre);
        this.setVisitantes(p_visitantes);
    }

    /**
     * Constructor para instanciar un Zoologico con un nombre, inicializando
     * la lista de visitantes vacía.
     *
     * @param p_nombre Nombre del zoológico.
     */
    public Zoologico(String p_nombre)
    {
        this.setNombre(p_nombre);
    }

    /** Asigna el nombre del zoológico. @param p_nombre El nombre a asignar. */
    private void setNombre(String p_nombre){this.nombre=p_nombre;}
    
    /** Asigna la colección de visitantes. @param p_visitantes La colección a asignar. */
    private void setVisitantes(HashSet<Visitante> p_visitantes){this.visitantes=p_visitantes;}

    /**
     * Devuelve el nombre del zoológico.
     *
     * @return El nombre del zoológico.
     */
    public String getNombre(){return this.nombre;}

    /**
     * Devuelve la colección de todos los visitantes registrados.
     *
     * @return Un HashSet de objetos Visitante.
     */
    public HashSet<Visitante> getVisitantes(){return this.visitantes;}

    /**
     * Agrega un nuevo visitante a la colección del zoológico.
     *
     * @param p_visitante El objeto Visitante a agregar.
     */
    public void nuevoVisitante(Visitante p_visitante){
        this.getVisitantes().add(p_visitante);
    }

    /**
     * Elimina un visitante de la colección del zoológico.
     *
     * @param p_visitante El objeto Visitante a eliminar.
     * @return `true` si el visitante fue eliminado exitosamente, `false` en caso contrario.
     */
    public boolean quitarVisitante(Visitante p_visitante){
        return this.getVisitantes().remove(p_visitante);
    }

    /**
     * Imprime en consola un listado de los visitantes de un tipo específico
     * que asistieron en una fecha determinada.
     *
     * @param p_fecha           Fecha de la visita para filtrar.
     * @param p_tipoVisitantes  Tipo de visitante a listar (ej. "Delegacion", "Individuo").
     */
    public void listarTipoVisitantePorFecha(Calendar p_fecha, String p_tipoVisitantes){
        for (Visitante unVisitante : visitantes) {
            if (unVisitante.getFechaVisita().equals(p_fecha) &&
                unVisitante.tipoVisitante().equalsIgnoreCase(p_tipoVisitantes)) {
                unVisitante.mostrar();
            }
        }
    }

    /**
     * Imprime en consola un listado de todos los visitantes registrados en una fecha específica.
     *
     * @param p_fecha Fecha de la visita para filtrar.
     */
    public void listarVisitantePorFecha(Calendar p_fecha){
        for (Visitante unVisitante : visitantes) {
            if (unVisitante.getFechaVisita().equals(p_fecha)){
                unVisitante.mostrar();
            }
        }
    }

    /**
     * Calcula la recaudación total por concepto de entradas en un rango de fechas.
     *
     * @param p_fechaDesde Fecha inicial del período (inclusiva).
     * @param p_fechaHasta Fecha final del período (inclusiva).
     * @return El monto total recaudado.
     */
    public double recaudacion(Calendar p_fechaDesde, Calendar p_fechaHasta){
        double total=0;
        for (Visitante unVisitante : visitantes) {
            if((unVisitante.getFechaVisita().after(p_fechaDesde) || 
            unVisitante.getFechaVisita().equals(p_fechaDesde)) &&
            (unVisitante.getFechaVisita().before(p_fechaHasta) || 
            unVisitante.getFechaVisita().equals(p_fechaHasta))){
                total+= unVisitante.entrada();
            }
        }
        return total;
    }

    /**
     * Recopila y devuelve una colección de todas las personas únicas que han
     * visitado el zoológico.
     *
     * @return Un HashSet con todos los objetos Persona que han visitado el zoológico.
     */
    public HashSet<Persona> listarPersonaQueVisitaronElZoo(){
        HashSet<Persona> lista = new HashSet<>();
        for (Visitante unVisitante : visitantes) {
            lista.addAll(unVisitante.listaPersona());
        }
        return lista;
    }
}

