import java.util.Calendar;
import java.util.HashSet;

/**
 * Representa un visitante individual del zoológico.
 * Extiende la clase abstracta Visitante, asociando la visita a un
 * objeto Persona específico.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Individuo extends Visitante
{
    private Persona persona;

    /**
     * Constructor para instanciar un visitante de tipo Individuo.
     *
     * @param p_fechaVisita Fecha en la que se realiza la visita.
     * @param p_persona     Objeto Persona asociado al visitante.
     */
    public Individuo(Calendar p_fechaVisita, Persona p_persona)
    {
        super(p_persona.getNombre(),p_fechaVisita);
        this.setPersona(p_persona);
    }
    
    /** Asigna el objeto Persona al visitante. @param p_persona La persona a asignar. */
    private void setPersona(Persona p_persona){this.persona=p_persona;}
    
    /**
     * Devuelve el objeto Persona asociado a este visitante.
     *
     * @return El objeto Persona del visitante.
     */
    public Persona getPersona(){return this.persona;}
    
    /**
     * Devuelve el tipo de visitante.
     *
     * @return Una cadena de texto que identifica al visitante como "Individuo".
     */
    public String tipoVisitante(){return "Individuo";}
    
    /**
     * Verifica si la visita corresponde a la fecha y tipo especificados, y si es así,
     * imprime los detalles del visitante en consola.
     *
     * @param p_fecha      Fecha para la cual se listarán las visitas.
     * @param p_visitante  Tipo de visitante a filtrar (ej. "Individuo").
     */
    public void listaPorFecha(Calendar p_fecha, String p_visitante){
        if(this.getFechaVisita().equals(p_fecha) &&
            this.tipoVisitante().equalsIgnoreCase(p_visitante)) {
                this.mostrar();
            }
    }
    
    /**
     * Imprime en consola los datos del visitante individual, incluyendo nombre
     * completo, DNI y edad.
     */
    public void mostrar(){
        System.out.println("Nombre y Apellido: " + this.getPersona().nomYApe());
        System.out.println("DNI: " + this.getPersona().getDNI() + " Edad: " + 
        this.getPersona().edad() + " años");
    }
    
    /**
     * Calcula el costo de la entrada para un visitante individual.
     *
     * @return El costo fijo de la entrada.
     */
    public double entrada(){
        return 10;
    }
    
    /**
     * Devuelve una colección que contiene la única persona asociada a este visitante.
     *
     * @return Un HashSet que contiene el objeto Persona del visitante.
     */
    public HashSet<Persona> listaPersona(){
        HashSet<Persona> lista = new HashSet<>();
        lista.add(this.getPersona());
        return lista;
    }
}

