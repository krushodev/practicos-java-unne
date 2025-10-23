import java.util.Calendar;
import java.util.HashSet;

/**
 * Clase abstracta que modela un visitante del zoológico.
 * Define los atributos y comportamientos comunes para cualquier tipo de visitante,
 * como el nombre y la fecha de visita.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public abstract class Visitante
{

    private String nombre;
    private Calendar fechaVisita;

    /**
     * Constructor para inicializar un objeto Visitante.
     *
     * @param p_nombre      Nombre del visitante o de la delegación.
     * @param p_fechaVisita Fecha de la visita.
     */
    public Visitante(String p_nombre, Calendar p_fechaVisita)
    {
        this.setNombre(p_nombre);
        this.setFechaVisita(p_fechaVisita);
    }
    
    /** Asigna el nombre del visitante. @param p_nombre El nombre a asignar. */
    private void setNombre(String p_nombre){this.nombre=p_nombre;}
    
    /** Asigna la fecha de la visita. @param p_fechaVisita La fecha a asignar. */
    private void setFechaVisita(Calendar p_fechaVisita){this.fechaVisita=p_fechaVisita;}
    
    /**
     * Devuelve el nombre del visitante o de la delegación.
     *
     * @return El nombre del visitante.
     */
    public String getNombre(){return this.nombre;}
    
    /**
     * Devuelve la fecha en que se realizó la visita.
     *
     * @return La fecha de la visita como objeto Calendar.
     */
    public Calendar getFechaVisita(){return this.fechaVisita;}
    
    /**
     * Método abstracto para mostrar la información detallada del visitante.
     * Debe ser implementado por las subclases.
     */
    public abstract void mostrar();
    
    /**
     * Método abstracto para calcular el costo de la entrada.
     * Debe ser implementado por las subclases para definir el cálculo específico.
     *
     * @return El costo de la entrada.
     */
    public abstract double entrada();
    
    /**
     * Método abstracto para listar las visitas que coincidan con una fecha y tipo.
     * Debe ser implementado por las subclases.
     *
     * @param p_fecha      Fecha para filtrar la búsqueda.
     * @param p_visitante  Tipo de visitante a buscar.
     */
    public abstract void listaPorFecha(Calendar p_fecha, String p_visitante);
    
    /**
     * Método abstracto para obtener el tipo de visitante.
     * Debe ser implementado por las subclases para devolver su tipo específico.
     *
     * @return Una cadena de texto con el tipo de visitante (ej. "Individuo").
     */
    public abstract String tipoVisitante();
    
    /**
     * Método abstracto para obtener una lista de las personas asociadas a la visita.
     * Debe ser implementado por las subclases.
     *
     * @return Un HashSet con los objetos Persona asociados.
     */
    public abstract HashSet<Persona> listaPersona();
}

