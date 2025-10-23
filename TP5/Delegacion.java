import java.util.HashSet;
import java.util.Calendar;

/**
 * Representa una delegación o grupo de visitantes.
 * Extiende la clase Visitante y gestiona una colección de objetos Individuo
 * que componen el grupo.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Delegacion extends Visitante
{
    private HashSet<Individuo> integrantes= new HashSet<>();

    /**
     * Constructor para instanciar una Delegacion con una lista de integrantes inicial.
     *
     * @param p_nombre      Nombre identificatorio de la delegación.
     * @param p_fechaVisita Fecha en la que el grupo realiza la visita.
     * @param p_integrantes Colección HashSet de objetos Individuo que componen el grupo.
     */
    public Delegacion(String p_nombre, Calendar p_fechaVisita, HashSet<Individuo> p_integrantes)
    {
        super(p_nombre,p_fechaVisita);
        this.setIntegrantes(p_integrantes);
    }
    
    /**
     * Constructor para instanciar una Delegacion con un nombre y fecha,
     * inicializando la lista de integrantes vacía.
     *
     * @param p_nombre      Nombre identificatorio de la delegación.
     * @param p_fechaVisita Fecha en la que el grupo realiza la visita.
     */
    public Delegacion(String p_nombre, Calendar p_fechaVisita)
    {
        super(p_nombre,p_fechaVisita);
    }
    
    /** Asigna la colección de integrantes. @param p_integrantes La colección a asignar. */
    private void setIntegrantes(HashSet<Individuo> p_integrantes){
        this.integrantes=p_integrantes;
    }
    
    /**
     * Devuelve la colección de individuos que integran la delegación.
     *
     * @return Un HashSet con los integrantes.
     */
    public HashSet<Individuo> getIntegrantes(){return integrantes;}
    
    /**
     * Devuelve el tipo de visitante.
     *
     * @return Una cadena de texto que identifica al visitante como "Delegacion".
     */
    public String tipoVisitante(){return "Delegacion";}
    
    /**
     * Agrega un nuevo individuo a la colección de integrantes de la delegación.
     *
     * @param p_individuo El objeto Individuo a inscribir.
     */
    public void inscribirIndividuo(Individuo p_individuo){
        this.getIntegrantes().add(p_individuo);
    }
    
    /**
     * Remueve un individuo de la colección de integrantes de la delegación.
     *
     * @param p_individuo El objeto Individuo a quitar.
     * @return `true` si el individuo fue removido exitosamente, `false` en caso contrario.
     */
    public boolean quitarIndividuo(Individuo p_individuo){
        return this.getIntegrantes().remove(p_individuo);
    }
    
    /**
     * Devuelve el número total de integrantes en la delegación.
     *
     * @return La cantidad de integrantes.
     */
    public int catidadIntegrantes(){
        return this.getIntegrantes().size();
    }
    
    /**
     * Imprime en consola los detalles de la delegación, incluyendo el nombre
     * del grupo y un listado de todos sus integrantes.
     */
    public void mostrar(){
        System.out.println("--------------------------------------------------------");
        System.out.println("Delegacion: " + this.getNombre());
        System.out.println("Integrantes:");
        for(Individuo unIndividuo: integrantes){
            unIndividuo.mostrar();
        }
        System.out.println("cantidad de integrantes: " + this.catidadIntegrantes());
    }
    
    /**
     * Calcula el costo total de la entrada para la delegación, aplicando un
     * descuento del 10% sobre el total.
     *
     * @return El costo final de la entrada para el grupo.
     */
    public double entrada(){return (this.catidadIntegrantes()*10)*0.9;}
    
    /**
     * Verifica si la visita corresponde a la fecha y tipo especificados, y si es así,
     * imprime los detalles de la delegación en consola.
     *
     * @param p_fecha      Fecha para la cual se listarán las visitas.
     * @param p_visitante  Tipo de visitante a filtrar (ej. "Delegacion").
     */
    public void listaPorFecha(Calendar p_fecha, String p_visitante){
        if(this.getFechaVisita().equals(p_fecha) &&
            this.tipoVisitante().equalsIgnoreCase(p_visitante)) {
                this.mostrar();
            }
    }
    
    /**
     * Recopila y devuelve una colección con todos los objetos Persona de los
     * individuos que integran la delegación.
     *
     * @return Un HashSet que contiene todos los objetos Persona de los integrantes.
     */
    public HashSet<Persona> listaPersona(){
        HashSet<Persona> lista = new HashSet<>();
        for(Individuo unIndividuo: integrantes){
            lista.add(unIndividuo.getPersona());
        }
        return lista;
    }
}

